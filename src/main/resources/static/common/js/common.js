
//此处定义一些全局公共的处理方法 比如数据的校验之类
//全局变量
//产品名称
var systemName = "公交智能调度系统";
//客户名称
var guestName = "桂林鼎耀科技股份有限公司";
//当前版本信息
var version = "ITS V4.0.20170203";
//当前的版权信息
var copyright = "Copyright &copy;"; //Copyright &copy; 2016 Nanda Softech. All Rights Reserved.
//保存当前用户
var currentUser = "";
//保存当前用户的csrf token
var csrfToken = "";
//保存当前用户的token信息
var xAuthTokenCookieKey = "xAuthToken";
//主页班次执行明细时间间隔半周期
var runPlanHalf_T = 10;
//错误信息分隔标识
var exceptionSplitFlag="$%$%";
//waitmsg
var wait_msg = "正在处理，请稍候...";
//waittitle
var wait_title = "等待";
//设置上限阈值为10秒钟
var sysLog_maxMillis = 10000;
// //主界面的高度
// var mainview_height = Ext.Element.getViewportHeight() - 110;
//页面高度减去的差异值
var diffHeight = 125;
var diffReportTwoViewHeight = 180;
// //主页面内的子gridpanel页面高度
// var subgridview_height = Ext.Element.getViewportHeight() - 125;
//常量url
//var dashboardUrl = "http://112.25.235.135:18080/chart/gl/dashboard.action";
//var dashboardUrl = "http://192.168.17.103:14331/webchart/gl/dashboard.action";
// var dashboardUrl = "http://localhost:8080/webchart/gl/dashboard.action";
//流水审核URL
//var dispatchPlanCheckUrl = "http://localhost:14337/dashboardController/checkDispatchPlans/";
var dispatchPlanCheckUrl = "http://192.168.17.103:14337/dashboardController/checkDispatchPlans/";

//全局表单校验正则定义
var formValidators = {
    number:/^[\d]{1,}$/,
    numberText: '输入数字无效',
    notNull0:/[\S]*[\S]{1,}$/,
    notNull:/^[\S]{1,}$/,
    notNullText: '输入不能为空',
    intege:/^-?[1-9]\d*$/,                 //整数
    integeText: '请输入整数',
    intege1:/^[1-9]\d*$/,                  //正整数
    intege1Text: '请输入正整数',
    intege2:/^-[1-9]\d*$/,                 //负整数
    intege2Text: '请输入正整数',
    num:/^([+-]?)\d*\.?\d+$/,            //数字
    numText: '请输入数字',
    num1:/^[1-9]\d*|0$/,                   //正数（正整数 + 0）
    num1Text: '请输入正数',
    num2:/^-[1-9]\d*|0$/,                  //负数（负整数 + 0）
    num2Text: '请输入负数',
    decmal:/^([+-]?)\d*\.\d+$/,          //浮点数
    decmalText: '请输入浮点数',
    decmal1:/^[1-9]\d*.\d*|0.\d*[1-9]\d*$/,　　   //正浮点数
    decmal1Text: '请输入正浮点数',
    decmal2:/^-([1-9]\d*.\d*|0.\d*[1-9]\d*)$/,　  //负浮点数
    decmal2Text: '请输入负浮点数',
    decmal3:/^-?([1-9]\d*.\d*|0.\d*[1-9]\d*|0?.0+|0)$/,　 //浮点数
    decmal3Text: '请输入浮点数',
    decmal4:/^[1-9]\d*.\d*|0.\d*[1-9]\d*|0?.0+|0$/,　　 //非负浮点数（正浮点数 + 0）
    decmal4Text: '请输入非负浮点数',
    decmal5:/^(-([1-9]\d*.\d*|0.\d*[1-9]\d*))|0?.0+|0$/,　　//非正浮点数（负浮点数 + 0）
    decmal5Text: '请输入非正浮点数',
    email:/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/, //邮件
    emailText: '请输入邮件地址',
    color:/^[a-fA-F0-9]{6}$/,               //颜色
    colorText: '请输入颜色',
    url:/^http[s]?:\/\/([\w-]+\.)+[\w-]+([\w-./?%&=]*)?$/,    //url
    urlText: '请输入url地址',
    chinese:/^[\u4E00-\u9FA5\uF900-\uFA2D]+$/,                  //仅中文
    chineseText: '请输入中文',
    ascii:/^[\x00-\xFF]+$/,               //仅ACSII字符
    asciiText: '请输入ACSII字符',
    zipcode:/^\d{6}$/,                     //邮编
    zipcodeText: '请输入邮编',
    mobile:/^13[0-9]{9}|15[012356789][0-9]{8}|18[0256789][0-9]{8}|147[0-9]{8}$/,                //手机
    mobileText: '请输入手机号码',
    ip4:/^(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)\.(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)\.(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)\.(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)$/,  //ip地址
    ip4Text: '请输入ip地址',
    notempty:/^\S+$/,                      //非空
    notemptyText: '请输入不能为空',
    picture:/(.*)\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$/,   //图片
    pictureText: '请输入图片',
    rar:/(.*)\.(rar|zip|7zip|tgz)$/,                               //压缩文件
    rarText: '请输入压缩文件',
    date:/^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/,                 //日期
    dateText: '请输入日期',
    qq:/^[1-9]*[1-9][0-9]*$/,               //QQ号码
    qqText: '请输入QQ号码',
    tel:/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/,   //电话号码的函数(包括验证国内区号,国际区号,分机号)
    telText: '请输入电话号码',
    username:/^\w+$/,                      //用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
    usernameText: '请输入数字、26个英文字母或者下划线',
    letter:/^[A-Za-z]+$/,                   //字母
    letterText: '请输入字母',
    letter_u:/^[A-Z]+$/,                    //大写字母
    letter_uText: '请输入大写字母',
    letter_l:/^[a-z]+$/,                    //小写字母
    letter_lText: '请输入小写字母',
    // idcard:/^[1-9]([0-9]{14}|[0-9]{17})$/,   //身份证
    // idcardText: '请输入身份证',
    lngLat: /^\d+\.\d{1,8}$/,
    lngLatText:'经纬度格式有误'
};

//label config
var LABEL_CONFIG = {
    INPUT_WIDTH:200,
    INPUT_WIDTH_1_5s:300,
    INPUT_WIDTH_2s:400,
    SELECT_MIN_WIDTH:100,
    SELECT_BIG_MIN_WIDTH:200,
    SELECT_MAX_WIDTH:180,
    SELECT_150_WIDTH:150,
    SELECT_180_WIDTH:180,
    SELECT_240_WIDTH:240,
    SELECT_500_WIDTH:500,
    SELECT_BIG_MAX_WIDTH:300,
    DATE_MIN_WIDTH:100,
    DATE_MAX_WIDTH:200,
    TEXT_WIDTH:135,
    TIME_WIDTH:90,
    NUMBER_MIN_WIDTH:60,
    NUMBER_MAX_WIDTH:100,
    TWO_WORDS_WIDTH:40,
    FOUR_WORDS_WIDTH:60,
    FIVE_WORDS_WIDTH:75,
    SIX_WORDS_WIDTH:90,
    ONE_CHAR_WIDTH: 20
};

//为了能够跨html文件传递参数 本次采用localStorage方式
function LocalStorageManage(){

    //添加到本地缓存当中  value为一个数组 内部存储{key:value}
    this.set = function(key,value){
        window.localStorage.setItem(key,JSON.stringify(value));
    }

    //获取本地缓存数据
    this.get = function(key){
        return JSON.parse(window.localStorage.getItem(key));
    }
}
var localStorageManage=new LocalStorageManage();
//////////////////////////全局方法定义区//////////////////////////////

//全局函数 log
function log(msg){
    console.log(msg);
}

//全局函数 info
function info(msg){
    console.info(msg);
}
/*
//判断是不是数字非空
function isNumNotNull(num){
    var numReg = /^[\d]{1,}$/;
    return numReg.test(num);
}

//判断非空字符串 匹配包括下划线的任何单词字符。等价于'[A-Za-z0-9_]'。
function isStringNotNull(str){
    var strReg = /^[\S]{1,}$/;
    return strReg.test(str);
}*/
/**
 * 构造id字符串以splitstr为分隔符
 * @param records 记录集合
 * @param idfield  记录中需统计ID的字段名
 * @param splitstr  结果中的分割符
 */
function buttonIds(records,idfield,splitstr) {
    var splitflag = ",";
    // !records 可以直接排除 records为null和undefined的情况
    if(!records || records.length < 1 || !idfield){
        return "";
    }
    if(splitstr){
        splitflag = splitstr;
    }
    var ids = [];
    for(var i=0;i<records.length;i++){
        ids.push(records[i].get([idfield]));
    }
    return ids.join(splitflag);
}

/**
 * 弹窗显示提醒消息
 * @param title 标题
 * @param message 提示信息
 */
function alertMsg(title,message) {
    if(!title || !message){
        return;
    }
    Ext.Msg.alert(title, message);
}

/**
 * 弹窗确认操作消息
 * @param title 标题
 * @param message 消息
 * @param func 消息处理函数 默认参数为option
 */
function confirmMsg(title,message,func) {
    if(!title || !message || !func){
        return;
    }
    Ext.Msg.confirm(title,message,func);
}

/**
 * 消息提醒框：输入数据
 * @param title 窗口标题
 * @param messageTitle 输入数据名称
 * @param func 消息处理函数 默认参数为btn,text
 */
function promptMsg(title,messageTitle,func) {
    if(!title || !messageTitle || !func){
        return;
    }
    Ext.Msg.prompt(title,messageTitle, func);
}

/**
 * 消息提醒框: 吐司提醒
 * @param title 标题
 * @param message 消息内容
 * @param align 显示位置
 * align的参数如下：
 * Possible values:
     br - bottom-right
     bl - bottom-left
     tr - top-right
     tl - top-left
     t - top
     l - left
     b - bottom
     r - right
     Defaults to: "t"
 */
function toastMsg(title,message,align) {
    var t = '';
    var a = 't';
    if(!message){
        return;
    }
    if(title){
        t = title;
    }
    if(align){
        a = align;
    }
    // Ext.toast(message,t,a);
    Ext.create('Ext.window.Toast',{
        title:t,
        minWidth:200,
        html:message,
        align:a
    }).show();
}

/**
 * 删除确认提示
 * @param title
 * @param func
 */
function deleteConfirm(title,func) {
    var message = "确认删除吗？";
    confirmMsg(title,message,function (btn) {
        if (btn === 'yes') {
            func();
        } else if (btn === 'no') {

        }
    })
}

/**
 * 确认提示
 * @param title
 * @param func
 */
function reConfirm(title,message,func) {
    confirmMsg(title,message,function (btn) {
        if (btn === 'yes') {
            func();
        } else if (btn === 'no') {

        }
    })
}
/////////////////////Store 公共处理函数////////////////////////
/**
 * Store代理管理者
 * 页面显示数据store的全局处理函数
 * @param GlobalStoreID 全局公共store的id globalStores[id]=global_lineStore
 * @param fields 需要构造的字段
 */
function viewStoreMgr(GlobalStoreID,fields,validRecordFunc) {
    if(!GlobalStoreID || !globalStores[GlobalStoreID] || !fields){
        return;
    }
    //if the global store is empty then ajax to load data
    if(globalStores[GlobalStoreID].getCount() < 1){
        globalStores[GlobalStoreID].load();
    }
    //create new data store to use
    var newStore = Ext.create('Ext.data.Store');
    globalStores[GlobalStoreID].each(function (record) {
        var newRecord = {};
        for(var i=0;i<fields.length;i++){
        	if(validRecordFunc){
        		if(typeof validRecordFunc === 'function' && validRecordFunc(record)){
        			newRecord[fields[i]] = record.get(fields[i]);
        		}
        	}else{
                newRecord[fields[i]] = record.get(fields[i]);
        	}
        }
        newStore.add(newRecord);
    });
    return newStore;
}

/**
 * 创建下拉store 树型结构store
 * @returns {Ext.data.Store}
 */
function createDepartmentDataStore() {
    var deptCodeStore = Ext.create("Ext.data.Store",{
        storeId:new Date().getTime(),
        fields:['name','value']
    });
    var departs = [];
    findAllTreeNodes(global_departmentStore.root,departs);
    for(var i=1;i< departs.length;i++){
        var depart = departs[i];
        deptCodeStore.add({
            "name":depart.get("deptName").replace(/\;/g,"　"),
            "value":depart.get("deptCode")
        });
    }
    return deptCodeStore;
}

/**
 * 获取分页数据的start和limit数据
 * @param store 数据源
 * @returns {*}
 */
function storePageStartLimit(store) {
    if(!store){
        return {"start":0,"limit":200};
    }
    var pageSize = store.getPageSize();
    var currentPage = store.currentPage;
    var start = (currentPage - 1)*pageSize;
    var limit = pageSize;
    return {"start":start,"limit":limit};
}

/**
 * load store，加载过就reload
 * @param store 数据源
 * @returns
 */
function loadStore(store){
    if (store.isLoaded()){
        store.reload();
    }else{
        store.load();
    }
}

/**
 * 根据字段value加载store里的record
 * @param store
 * @param fieldName 字段名
 * @param value 值
 * @returns
 */
function loadRecordByValue(store, fieldName, value){
	if (store == null || !fieldName || !value){
		return null;
	}
	store.each(function(record,index){
		log(record);
		log(index);
		if (value == record.get(fieldName)){
			return record;
		}
	});
	return value;
}
/////////////////////////异步请求公共异常处理///////////////////////////////////////


//Ajax异常处理
function ajaxFailureException(message) {
    try{
    	Ext.Msg.close();
    }catch(err){
    	
    }
    toastMsg(message);
}
function storeException(proxy, response, operation){
    try{
        Ext.JSON.decode(response.responseText);
    }catch(e){
        log("store exception");
        log(e);
        return;
    }
    var data = Ext.JSON.decode(response.responseText);
    log("storeException:data");
    log(data);
    if(!data){
        return;
    }
    if("message" in data){
        Ext.create("Admin.view.BaseComponent.ExceptionWindow",{
            message:data.message
        });
    }else{
        Ext.create("Admin.view.BaseComponent.ExceptionWindow",{
            message:"超时，请重新刷新界面"
        });
    }
}

/////////////////////////End 异步请求公共异常处理//////////////////////////////////

/**
 * 将数据字典或者globalStores中的某个字段转换成另一个字段
 * @param codeField 待转字段
 * @param nameField 转后字段
 * @param storeId 数据源id
 * @param codeValue 待转的值
 * @param isDictionary 是否是数据字典
 * @returns 转后的值
 */
function transCodeToName(codeField,nameField,storeId,codeValue,isDictionary) {
    var store=isDictionary==true?g_mapStore[storeId]:globalStores[storeId];
    var record = null;
    if (!store){
        return "";
    }
    store.each(function (inRecord) {
        if(inRecord.get(codeField) == codeValue){
            record = inRecord;
        }
    });
    return record == null? "":record.get(nameField);
}

//异步发起请求递归删除记录 已不用
function deleteRecords(store,records,index){
    if(index < 0)
        return;
    store.remove(records[index]);
    store.sync({
        success:function(){
            deleteRecords(store,records,index-1);
        }
    });
}

/*
* 递归选中子节点
* currentTreeNode: 当前被选中的树结点
* checkedState: 当前树结点被选择的状态
*/
function checkedChildNodes(currentTreeNode,checkedState){
    if(currentTreeNode.childNodes.length < 1)
        return;
    $.each(currentTreeNode.childNodes,function(index,childNode){
        childNode.set("checked",checkedState);
        checkedChildNodes(childNode,checkedState);
    });
}

/*
* 获取所有的树结点
* currentTreeNode:树的根节点
* nodeLists:存储结点的集合
*/
function findAllTreeNodes(currentTreeNode,nodeLists){
    nodeLists.push(currentTreeNode);
    $.each(currentTreeNode.childNodes,function(index,childNode){
        findAllTreeNodes(childNode,nodeLists);
    });
}

/*
 *  根据首匹配节点展开树的目录
 *  root: 树根节点
 *  parentNodes: 父节点集合
 *  regExp: 正则验证 
 *  text:字段名
 */
function searchTree(root,parentNodes,regExp,text){
    log("current node..");
    log(root);
    //如果是目录则先关闭目录
    root.collapseChildren();
    //此时到达叶节点
    //符合规则
    if(regExp.test(root.get(text))){
        log("开始展开");
        log(parentNodes);
        $.each(parentNodes,function(index,parentNode){
            parentNode.expand();
        });
        return; //符合规则则返回
    }
    parentNodes.push(root);
    $.each(root.childNodes,function(index,childNode){
        searchTree(childNode,parentNodes,regExp,text);
    });
    parentNodes.pop();
}

/*
 *  根据叶节点展开树的目录
 *  root: 树根节点
 *  parentNodes: 父节点集合
 *  regExp: 正则验证 
 *  text:字段名
 */
function searchTreeNode(root,parentNodes,regExp,text){
    log("current node..");
    log(root);
    //此时到达叶节点
    if(root.childNodes.length < 1){
        //符合规则
        if(regExp.test(root.get(text))){
            log("开始展开");
            log(parentNodes);
            $.each(parentNodes,function(index,parentNode){
                parentNode.expand();
            });
        }
    }else{
        parentNodes.push(root);
        $.each(root.childNodes,function(index,childNode){
            searchTree(childNode,parentNodes,regExp,text);
        });
        parentNodes.pop();
    }
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
    return date.getTime();
}

/**
 * 计算日期之间相差的天数
 * @param afterDate
 * @param beforeDate
 * 如：2017-04-10 - 2017-04-12
 * 返回 3
 */
function dateDiffDays(initValue,afterDate,beforeDate) {
    if(!afterDate || !beforeDate){
        // alertMsg("日期格式异常","请输入开始日期或者结束日期");
        return initValue;
    }
    if(afterDate.getTime() < beforeDate.getTime()){
        alertMsg("日期格式异常","结束日期有误");
        return initValue;
    }
    return (afterDate.getTime() - beforeDate.getTime())/(24*60*60*1000)+1;
}

/**
 * 返回指定年月的第一天
 * @param year 年份
 * @param month 月份
 */
function firstDayOfMonth(year,month) {
    var date = new Date();
    date.setYear(year);
    date.setMonth(month,1);
    return date;
}

/**
 * 返回指定年月的最后一天
 * @param year 年份
 * @param month 月份
 * @returns {Date}
 */
function lastDayOfMonth(year,month) {
    var date = new Date();
    date.setYear(year);
    date.setMonth(month+1,0);
    return date;
}




/**
 * 返回上个月的的26号
 * @param {} year
 * @param {} month
 * @return {}
 */
function firstDayOfOldMonth(year,month) {
    var date = new Date();
    date.setYear(year);
    date.setMonth(month-1,26);
    return date;
}

/**
 * 返回指定当前月的25号
 * @param year 年份
 * @param month 月份
 * @returns {Date}
 */
function lastDayOfNowMonth(year,month) {
    var date = new Date();
    date.setYear(year);
    date.setMonth(month,25);
    return date;
}

/**
 * 返回当前时间的基本信息  包含 年 月 日 小时 分钟 秒
 * @returns {{year: number, month: number, day: number, hours: number, minutes: number, seconds: number}}
 */
function currentDateInfo() {
    var date = new Date();
    return {
        "year":date.getFullYear(),
        "month":date.getMonth(),
        "day":date.getDay(),
        "hours":date.getHours(),
        "minutes":date.getMinutes(),
        "seconds":date.getSeconds()
    };
}

/**
 * 返回当前月的第一天和最后一天的日期
 * @returns {{first, last: Date}}
 */
function firstAndLastDayOfThisMonth() {
    var dateBean = currentDateInfo();
    return {
        "first":firstDayOfMonth(dateBean["year"],dateBean["month"]),
        "last":lastDayOfMonth(dateBean["year"],dateBean["month"])
    }
}

/**
 * 返回上个月的26号和当前月的25号
 * @returns {{first, last: Date}}
 */
function firstOldAndLastNowDayOfMonth() {
    var dateBean = currentDateInfo();
    return {
        "first":firstDayOfOldMonth(dateBean["year"],dateBean["month"]),
        "last":lastDayOfNowMonth(dateBean["year"],dateBean["month"])
    }
}

/**
 * 浮点数保留两位小数 采用四舍五入法
 * @param value 数值
 * @returns {number}
 */
function parseDouble(value){
    if(isNaN(value)){
        return 0;
    }
    return Math.round(value*100)/100;
}

//获取对象的详情
function objDetail(obj,keys){
    var info = "";
    $.each(keys,function (index,key) {
        if(key['name'] in obj)
            info += "<font color='red'>"+key['desc']+":</font>"+obj[key['name']]+"<br>";
    });
    return info;
}

/*
* 如果不涉及到二级子页面 可使用此方法
* 页面button的权限控制
* funclist: 主界面里的funclist属性  含有页面可操作功能的集合
* buttonList:即是操作功能按钮的集合
*/
function buttonValidation(funclist,buttonList){
    $.each(buttonList,function(index,button){
        var flag = false;
        var funcTemp = null;
        $.each(funclist,function(f_index,func){
            if(func.resourceName == button.text){
                flag = true;
                funcTemp = func;
            }
        });
        if(flag){
            button.iconCls = funcTemp.resourceIcon;
        }else{
            // button.disable();
            button.hide();
        }
    });
}

/*
* 涉及到二级子页面 可使用此方法 
* 并且此页面的所有button需定义成:1-新增 1-删除....2-新增  2-删除等
* 页面button的权限控制
* funclist: 主界面里的funclist属性  含有页面可操作功能的集合
* buttonList:即是操作功能按钮的集合
*/
function buttonValidationWithSuffix(suffix,funclist,buttonList){
    $.each(buttonList,function(index,button){
        var flag = false;
        var funcTemp = null;
        $.each(funclist,function(f_index,func){
            if(func.resourceName == (suffix+'-'+button.text)){
                flag = true;
                funcTemp = func;
            }
        });
        if(flag){
            button.iconCls = funcTemp.resourceIcon;
        }else{
            // button.disable();
            button.hide();
        }
    });
}


function findAllTreeNodesReplace(currentTreeNode,nodeLists){
    //log("qwerqwer");
    //log(currentTreeNode);
    if (currentTreeNode.id!="root"){
        var name =currentTreeNode.data.deptName;
        var s=name.replace(/\;/g,"　");
        currentTreeNode.data.deptName=s;
    }
    nodeLists.push(currentTreeNode);
    $.each(currentTreeNode.childNodes,function(index,childNode){
        findAllTreeNodesReplace(childNode,nodeLists);
    });
}
/**
 * 判断是否为null或者""
 * @constructor
 */
function isNullOrEmpty(value) {
    if (value!=null&&value!=""){
        return false;
    }
    return true;
}

/**
 * 根据dataIndex查找gridPanel中的column集合
 * @param gridPanel
 * @param dataIndexs
 */
function findColumnByDataIndex(gridPanel,dataIndexs){
    if(!gridPanel){
        log("grid panel 无效");
        return;
    }
    if(!dataIndexs){
        log("无待查询列");
        return;
    }
    var columns = gridPanel.getColumns();
    var retColumns = {};
    for(var i=0;i<columns.length;i++){
        for(var j=0;j<dataIndexs.length;j++){
            if(!retColumns[dataIndexs[j]] && columns[i]["dataIndex"] == dataIndexs[j]){
                retColumns[dataIndexs[j]] = columns[i];
                break;
            }
        }
    }
    log(retColumns);
    return retColumns;
}

/**
 * 修改extjsCombo的显示字段
 * @param extjsCombo
 * @returns
 */
function modifyComboDisplayField(extjsCombo,displayField){
	if(!extjsCombo){
		return;
	}
	extjsCombo.setDisplayField(displayField);
	extjsCombo.setDisplayTpl(false);
}

////////////////////////////公共对象定义区/////////////////////////////////////////
//hashmap对象
function HashMap(){
    //定义长度
    var length = 0;
    //创建一个对象
    var obj = new Object();

    /**
     * 判断Map是否为空
     */
    this.isEmpty = function(){
        return length == 0;
    };

    /**
     * 判断对象中是否包含给定Key
     */
    this.containsKey=function(key){
        return (key in obj);
    };

    /**
     * 判断对象中是否包含给定的Value
     */
    this.containsValue=function(value){
        for(var key in obj){
            if(obj[key] == value){
                return true;
            }
        }
        return false;
    };

    /**
     *向map中添加数据
     */
    this.put=function(key,value){
        if(!this.containsKey(key)){
            length++;
        }
        obj[key] = value;
    };

    /**
     * 根据给定的Key获得Value
     */
    this.get=function(key){
        return this.containsKey(key)?obj[key]:null;
    };

    /**
     * 根据给定的Key删除一个值
     */
    this.remove=function(key){
        if(this.containsKey(key)&&(delete obj[key])){
            length--;
        }
    };

    /**
     * 获得Map中的所有Value
     */
    this.values=function(){
        var _values= new Array();
        for(var key in obj){
            _values.push(obj[key]);
        }
        return _values;
    };

    /**
     * 获得Map中的所有Key
     */
    this.keySet=function(){
        var _keys = new Array();
        for(var key in obj){
            _keys.push(key);
        }
        return _keys;
    };

    /**
     * 获得Map的长度
     */
    this.size = function(){
        return length;
    };

    /**
     * 清空Map
     */
    this.clear = function(){
        length = 0;
        obj = new Object();
    };

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

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";
 
    var uuid = s.join("");
    return uuid;
}