
var iframeId = new URLSearchParams(window.location.search).get('id')||Math.random().toString(16).substring(4)

// 等待初始化完毕
document.addEventListener('UniAppJSBridgeReady', function(){
	window.parent.postMessage({
		action: 'onJSBridgeReady',
		data: '',
		iframeId: iframeId
	}, '*');
	uni.postMessage({
		data: {
			action: 'onJSBridgeReady'
		}
	})
})
// window.addEventListener('message', function(event) {

//   // 根据消息内容执行相应的操作或调用函数
//   if (typeof event.data === 'object' && event.data.action === 'callFunctionInIframe') {
//     var data = event.data.data;
//     myFunctionInIframe(data);
//   }
// });


var qr = null
// 绘制二维码。
//https://github.com/soldair/node-qrcode?tab=readme-ov-file#createtext-options
function createQrcode(size, foreground, background, text, logo, logoSize, padding) {
	// let width = window.frameElement.offsetWidth
	// let height = window.frameElement.offsetHeight
	var canvas = document.getElementById("qrcode")
	// canvas.width=width
	// canvas.height=height
	// canvas.style.width=width+'px'
	// canvas.style.height=height+'px'
	canvas.style.display = "block"
	let ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	document.body.style.overflow = "hidden"
	document.body.style.height = "100%"
	size = size || 128;
	padding = padding || 2
	QRCode.toCanvas(canvas, text || 'xui', {
		element: canvas,
		width: size,
		errorCorrectionLevel: 'H',
		margin: padding,
		color: {
			dark: foreground || "black",
			light: background || "white"
		}
	})
	if (logo) {
		let ctx = canvas.getContext("2d");
		let img = new Image();
		logoSize = logoSize || 50
		img.width = logoSize + "px"
		img.height = logoSize + "px"
		img.src = logo
		img.onload = function() {
			let x = (size - logoSize) / 2
			let y = x;
			ctx.drawImage(img, x, y, logoSize, logoSize)
		}
	}

}
//获取二维码图片。
function QrcodeToDateUrl() {
	if (qr) {
		let imgdata = qr.toDataURL();
		uni.postMessage({
			data: {
				action: 'img',
				url: imgdata
			}
		})
	} else {
		uni.postMessage({
			data: {
				action: 'error',
			}
		})
	}
}


var ect = null;

function getchart() {
	if (ect) return ect;
	let dom = document.getElementById('echart');
	return echarts.init(dom);
}

function chart_setSize() {
	let width = window.innerWidth
	let height = window.innerHeight
	let dom = document.getElementById('echart');
	let domhtml = document.getElement
	dom.style.width = width + 'px'
	dom.style.height = height + 'px'
	document.getElementsByTagName('html')[0].style = 'overflow:hidden'
}

// 解码 JSON 字符串（包括深层解码）
function decodeJSON(jsonString) {
    // 如果输入不是字符串，直接返回
    if (typeof jsonString !== 'string') {
        return jsonString;
    }
	
	const obj = JSON.parse(jsonString,function(k,v){
		// 处理常规函数定义，包括多行函数 "key": function(params) { ... }
		var isFunctionStr =
			// 常规函数
			/^\s*function\s*\([^)]*\)\s*\{[\s\S]*\}\s*$/.test(v) ||
			// 箭头函数 - 带花括号
			/^\s*\([^)]*\)\s*=>\s*\{[\s\S]*\}\s*$/.test(v) ||
			// 箭头函数 - 简写形式
			/^\s*\([^)]*\)\s*=>\s*[^{\s][\s\S]*$/.test(v) ||
			// 单参数箭头函数 - 无括号
			/^\s*[a-zA-Z0-9_$]+\s*=>\s*[^{\s][\s\S]*$/.test(v) ||
			// 单参数箭头函数 - 带花括号
			/^\s*[a-zA-Z0-9_$]+\s*=>\s*\{[\s\S]*\}\s*$/.test(v);
		
		
		if(typeof v === 'string' && isFunctionStr){
			v = eval('('+v+')')
		}
	
		return v;
	});

	return obj;
}

function isFuncString(s) {
	var t = s.trim();
	if (t.indexOf('function') === 0) return true;
	var arrowIdx = t.indexOf('=>');
	if (arrowIdx > 0) {
		var after = t.substring(arrowIdx + 2).trim();
		if (after.charAt(0) === '{' || after.charAt(0) === '(' ||
			after.charAt(0) === '[' || after.indexOf('.') > -1 ||
			after.indexOf('+') > -1 || after.indexOf('return') > -1) {
			return true;
		}
	}
	return false;
}

function reviveFunctions(obj) {
	if (typeof obj !== 'object' || obj === null) return;
	var keys = Object.keys(obj);
	for (var i = 0; i < keys.length; i++) {
		var key = keys[i];
		var val = obj[key];
		if (typeof val === 'string') {
			if (isFuncString(val)) {
				try {
					obj[key] = (new Function('return (' + val + ')'))();
				} catch (e) { }
			}
		} else if (Array.isArray(val)) {
			for (var j = 0; j < val.length; j++) {
				if (typeof val[j] === 'string') {
					if (isFuncString(val[j])) {
						try {
							val[j] = (new Function('return (' + val[j] + ')'))();
						} catch (e) { }
					}
				} else if (typeof val[j] === 'object' && val[j] !== null) {
					reviveFunctions(val[j]);
				}
			}
		} else if (typeof val === 'object') {
			reviveFunctions(val);
		}
	}
}

function unCoderOptsStrToJson(str) {
	if (typeof str !== 'string' || str === '') return null;
	var result = null;
	try {
		result = (new Function('return (' + str + ')'))();
	} catch (e) {
		try {
			result = JSON.parse(str);
		} catch (e2) {
			return null;
		}
	}
	if (result !== null && typeof result === 'object') {
		reviveFunctions(result);
	}
	return result;
}



function chart_setOption(str) {
	if(str==''||!str) return;
	try {
		var optionStr = str
		if (!optionStr) return;
		chart_setSize()
		// 基于准备好的dom，初始化echarts实例
		let chart = getchart();
		let option = unCoderOptsStrToJson(optionStr)
		chart.setOption(option)
	} catch (error) {
		alert(error)
	}
}

function chart_call(funName, optionStr, eventsid) {

	chart_setSize()
	let filterevents = ["click"]
	// 基于准备好的dom，初始化echarts实例
	let chart = getchart();

	if (filterevents.includes(funName)) {

		chart['on'](funName, function(params) {
			delete params.event
			window.parent.postMessage({
				action: funName,
				eventId: eventsid,
				data: JSON.stringify(params),
				iframeId: iframeId
			}, '*');

			uni.postMessage({
				data: {
					action: funName,
					eventId: eventsid,
					data: JSON.stringify(params)
				}
			})

		})
	} else {

		try {
			let option = JSON.parse(optionStr)
			chart[funName](option)
		} catch (e) {
			chart[funName]()
		}
	}



}