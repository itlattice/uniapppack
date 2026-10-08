const vdomPack = require('./pack');
const { output } = require('./utils/output');

async function start(options = {}) {
	const mergedOptions = {
		...options,
		packMode: 'Vapor'
	};
	output.info('当前为 Vapor 蒸汽模式打包入口', mergedOptions.customConsoleLog);
	return await vdomPack.start(mergedOptions);
}

module.exports = {
	start
};
