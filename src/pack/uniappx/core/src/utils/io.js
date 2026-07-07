const fs = require('fs');
const fsExtra = require('fs-extra');
const path = require('path');
const glob = require('glob');
const { logger } = require('../../log/logger')
const rimraf = require('rimraf')

const RETRYABLE_DELETE_ERRORS = new Set(['ENOTEMPTY', 'EBUSY', 'EPERM', 'EMFILE']);

function sleepSync(ms) {
	const end = Date.now() + ms;
	while (Date.now() < end) {
		// Xcode 构建缓存目录可能还在释放文件句柄，短暂等待后再重试删除。
	}
}

function removeSyncWithRetry(targetPath, maxRetries = 8, retryDelay = 150) {
	if (!targetPath || !fs.existsSync(targetPath)) {
		return;
	}

	for (let attempt = 0; attempt <= maxRetries; attempt += 1) {
		try {
			if (fs.rmSync) {
				fs.rmSync(targetPath, {
					recursive: true,
					force: true,
					maxRetries,
					retryDelay
				});
			} else {
				rimraf.sync(targetPath, {
					disableGlob: true,
					maxBusyTries: maxRetries
				});
			}
			return;
		} catch (error) {
			if (attempt >= maxRetries || !RETRYABLE_DELETE_ERRORS.has(error.code)) {
				throw error;
			}
			sleepSync(retryDelay * (attempt + 1));
		}
	}
}

function moveAwaySync(targetPath) {
	const parentDir = path.dirname(targetPath);
	const baseName = path.basename(targetPath);
	const renamedPath = path.join(parentDir, `${baseName}.__delete__${Date.now()}`);
	fs.renameSync(targetPath, renamedPath);
	return renamedPath;
}

/**
 * 复制文件
 * @param sourceDir 源目录
 * @param targetDir 目标目录
 * @param pattern 匹配模式
 * @returns {Promise<void>}
 */
async function copyFilesWithGlob(sourceDir, targetDir, pattern) {
    // const files = glob.sync(path.join(sourceDir, pattern));
	const files = glob.sync(glob.escape(sourceDir) + '/' + pattern);
    if (files.length === 0) {
        logger.warn(`No files found with pattern ${pattern} in ${sourceDir}`);
        return;
    }
    // 判断目标目录是否存在，不存在则创建
    if (!fsExtra.pathExistsSync(targetDir)) {
        fsExtra.mkdirsSync(targetDir, { recursive: true })
    }
    // 清空目标目录
    // await fsExtra.emptyDir(targetDir);
    // 复制文件
    for (const file of files) {
        const targetFile = path.join(targetDir, path.basename(file));
        // await fs.copyFile(file, targetFile);
        fsExtra.copySync(file, targetFile);
    }
}

async function deleteFile (path) {
	return new Promise((resolve, reject) => {
		try {
			removeSyncWithRetry(path)
			resolve()
		} catch (error) {
			try {
				// Windows/Electron 下 `.gradle` 目录经常被上一次 Gradle 进程短暂占用。
				// 如果直接递归删除失败，则先把整个目录改名挪走，
				// 让新的生成流程可以继续写入原路径，旧目录再做一次后台清理。
				const movedPath = moveAwaySync(path)
				try {
					removeSyncWithRetry(movedPath)
				} catch (cleanupError) {
					logger.warn(`Deferred cleanup failed for ${movedPath}: ${cleanupError.message}`)
				}
				resolve()
			} catch (moveError) {
				reject(moveError)
			}
		}
	})
}

/**
 * 获取路径中最后一个目录名称
 * @param {string} dirPath 文件路径
 * @returns {string} 最后一个目录名称（根目录返回空字符串）
 */
function getLastDirName(dirPath) {
    // 标准化路径并处理末尾分隔符
    const normalized = path.normalize(dirPath)
        .replace(new RegExp(`${path.sep}+$`), '');

    // 解析路径信息
    const parsed = path.parse(normalized);
    
    // 处理根目录情况
    if (parsed.root === normalized) {
        return '';
    }

    // 提取最后一级目录
    return path.basename(normalized);
}

module.exports = {
    copyFilesWithGlob,
	deleteFile,
	removeSyncWithRetry,
	getLastDirName
}
