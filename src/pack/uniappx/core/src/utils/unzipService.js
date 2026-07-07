const fs = require('fs');
const path = require('path');
const url = require('url');
const AdmZip = require('adm-zip');
const fsExtra = require('fs-extra');

// 需要过滤的系统目录/文件
const SYSTEM_ENTRIES = [
    '__MACOSX',
    '_MACOSX',
    '.DS_Store',
    'Thumbs.db'
];

async function unzip(source, destination) {
    let mainFolder = '';
    
    try {
        // 验证源文件
        await validateZipFile(source);
        
        // 确保目标目录存在
        await fsExtra.ensureDir(destination);

        // 读取ZIP文件
        const zip = new AdmZip(source);
        const entries = zip.getEntries();

        // 过滤并处理条目
        for (const entry of entries) {
            if (isSystemEntry(entry)) continue;

            // 获取解压路径
            const entryPath = path.join(destination, entry.entryName);
            
            // 识别主目录（第一个有效目录）
            if (!mainFolder) {
                const segments = entry.entryName.split(/[/\\]/);
                mainFolder = segments.find(seg => !isSystemEntry({ entryName: seg }));
            }

            // 创建目录或解压文件
            if (entry.isDirectory) {
                await fsExtra.ensureDir(entryPath);
            } else {
                await fsExtra.ensureDir(path.dirname(entryPath));
                zip.extractEntryTo(entry, path.dirname(entryPath), false, true);
            }
        }

        return mainFolder;
    } catch (err) {
        await cleanupPartial(destination, mainFolder);
        throw new Error(`Unzip failed: ${err.message}`);
    }
}

// 校验ZIP文件
async function validateZipFile(source) {
    try {
        const stats = await fs.promises.stat(source);
        if (stats.size === 0) throw new Error('Empty ZIP file');
        
        const buffer = Buffer.alloc(4);
        const fd = await fs.promises.open(source, 'r');
        await fd.read(buffer, 0, 4, 0);
        await fd.close();
        
        if (buffer.toString('hex') !== '504b0304') {
            throw new Error('Invalid ZIP header');
        }
    } catch (err) {
        throw new Error(`Invalid ZIP file: ${err.message}`);
    }
}

/**
 * 判断文件是否为有效的ZIP压缩文件
 * @param {string} filePath 文件路径
 * @returns {Promise<boolean>} 是否为有效ZIP文件
 */
async function isCompressedFile(filePath) {
    try {
        // 基础文件校验
        const stats = await fsExtra.stat(filePath);
        if (!stats.isFile()) return false;
        if (stats.size < 22) return false; // ZIP文件最小长度

        // 读取文件头
        const fd = await fsExtra.open(filePath, 'r');
        const buffer = Buffer.alloc(4);
        await fsExtra.read(fd, buffer, 0, 4, 0);
        await fsExtra.close(fd);

        // 检查标准ZIP头
        const isStandardZip = buffer.toString('hex') === '504b0304';
        
        // 检查空ZIP文件（允许特殊情况）
        const isEmptyZip = buffer.toString('hex') === '504b0506';
        
        return isStandardZip || isEmptyZip;
    } catch (error) {
        if (error.code === 'ENOENT') return false; // 文件不存在
        if (error.code === 'EACCES') throw error;  // 权限问题需要特殊处理
        return false;
    }
}

// 判断是否为系统条目
function isSystemEntry(entry) {
    return SYSTEM_ENTRIES.some(sys => {
        // 匹配系统目录及其子内容
        const sysPattern = new RegExp(`^${sys}([/\\\\]|$)`);
        return sysPattern.test(entry.entryName);
    });
}

// 清理残留文件
async function cleanupPartial(destination, mainFolder) {
    if (mainFolder) {
        const target = path.join(destination, mainFolder);
        if (await fsExtra.pathExists(target)) {
            await fsExtra.remove(target);
        }
    }
}

function getFileName (path, withExtension = true) {
	const parsedUrl = url.parse(path);
	
	const pathname = parsedUrl.pathname;
	
	const filenameWithExtension = pathname.match(/\/([^\/]+)$/)[1];
	
	if (withExtension) {
		return filenameWithExtension;
	}
	
	const lastDotIndex = filenameWithExtension.lastIndexOf('.');
	
	const filename = lastDotIndex !== -1 ? filenameWithExtension.slice(0, lastDotIndex) : filenameWithExtension;
	
	return filename ?? '';
}

/**
 * 获取压缩包名称（不含扩展名）
 * @param {string} filePath 压缩包完整路径
 * @param {boolean} [keepExt=false] 是否保留扩展名
 * @returns {string} 压缩包名称
 */
function getArchiveName(filePath, keepExt = false) {
    // 标准化路径处理特殊字符
    const normalized = path.normalize(filePath)
        .replace(/[/\\]+$/, ''); // 移除末尾分隔符
    
    // 获取基础文件名
    const basename = path.basename(normalized);
    
    // 根据参数决定是否保留扩展名
    return keepExt ? basename : removeLastExtension(basename);
}

/**
 * 移除最后一个文件扩展名
 * @param {string} filename 文件名
 * @returns {string} 处理后的文件名
 */
function removeLastExtension(filename) {
    const lastDotIndex = filename.lastIndexOf('.');
    return (lastDotIndex > 0) 
        ? filename.slice(0, lastDotIndex)
        : filename;
}

module.exports = {
    unzip,
	getFileName,
	isCompressedFile,
	getArchiveName
};
