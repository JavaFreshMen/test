/*全局公共方法*/

function log(msg){
	console.log(msg);
}
//根据数组指定值删除元素
function removeByValue(arr, val) {
  for(var i=0; i<arr.length; i++) {
    if(arr[i] == val) {
      arr.splice(i, 1);
      break;
    }
  }
}

//吐司信息提醒
function toastMsg(msg,messageType){
	var self = this;
	var _messageType = messageType==null?"error":messageType;
	bDialog.toast(msg,{
	    //窗口类型
	    messageType : _messageType,
	    position : 'topCenter',
	    dialogCloseButton : true,
	    closeTime : 2
	});
}

//构建表单数据
function transFormData(datas){
	var ret = {};
	$.each(datas,function(index,data){
		ret[data.name] = data.value;
	});
	return ret;
}

//时间-格式化timefield的结果
function fullfillTime(timestr){
    if (null==timestr||""==timestr){
        return;
    }
    var values = timestr.split(":");
    var date = new Date();
    date.setHours(parseInt(values[0]));
    date.setMinutes(parseInt(values[1]));
    date.setSeconds(0);
    date.setMilliseconds(0);
    return date.getTime();
}

//时间格式转换
Date.prototype.format = function(format) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
        }
    }
    return format;
};

//string对象添加trim函数
if (!String.prototype.trim) {
  String.prototype.trim = function () {
    return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
  };
}

//将要获取绝对位置的标签传进去，返回一个包含x和y属性的对象
function getPosition(e)
{
	var t=e.offsetTop;
	var l=e.offsetLeft;
	while(e=e.offsetParent)
	{
		t+=e.offsetTop;
		l+=e.offsetLeft;
	}
	var point = eval("({x:"+l+",y:"+t+"})");
	return point;
}

//构建表单数据
function transFormDataToObj(datas){
	var ret = {};
	$.each(datas,function(index,data){
		ret[data.name] = data.value;
	});
	return ret;
};
//数组删除指定元素
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};
//-------------------控件绑定函数---------------------
/**
 *日期控件
 * @param id 			绑定的dom节点ID (必填)
 * @param otherConfig	其他配置项	 {key:value,……} 可以参考bootstrap官网的datetimepicker文档 (选填)
 * @returns
 */
function setDatePlugin(id,otherConfig){
	var defaultConfig={
		format: 'yyyy-mm-dd',
        autoclose: true,
        todayBtn: true,
        startView: 'month',
        minView:'month',
        maxView:'decade',
        language:  'zh-CN'
	}
	if(otherConfig){
		for(var key in otherConfig){
			defaultConfig[key] =otherConfig[key];
		}
	}
	$('#'+id).datetimepicker(defaultConfig);
}
/**
 * 下拉框控件
 * @param id 			绑定的dom节点ID 		(必填)
 * @param showField 	显示字段名称	形如name (必填)
 * @param keyField		取值字段名称   形如id	(必填)
 * @param store			绑定的sotre   形如：[{id:1,name:'张三',sex:'男'},{id:2,name:'李四',sex:'男'}]  (必填)
 * @param otherConfig 	其他配置项	  {key:value,……}可以参考selectPage官网 (选填)
 * @returns
 */
function setSelectPagePlugin(id,showField,keyField,store,otherConfig){
	var defaultConfig={
			pagination : true,
			pageSize:5,
			showField : showField,
			keyField : keyField,
			data : store
	}
	if(otherConfig){
		for(var key in otherConfig){
			defaultConfig[key] =otherConfig[key];
		}
	}
	$('#'+id).selectPage(defaultConfig);
}
/**
 * 弹出框控件
 * @param title  		弹出框标题(必填)
 * @param dom			自定义html(必填)
 * @param otherConfig 	其他配置项	{key:value,……}  可以参考bDialog官网 (选填)
 * @returns
 */
function openBDialog(title,dom,otherConfig){
	var defaultConfig={
			title : title,
		    width : 300,
		    height : 330,
		    dialogMaxButton : false,
		    dom : dom
	}
	if(otherConfig){
		for(var key in otherConfig){
			defaultConfig[key] =otherConfig[key];
		}
	}
	var dialog=bDialog.open(defaultConfig);
	return dialog;
	
}