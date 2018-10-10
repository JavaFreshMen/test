////////////////////////全局公用store/////////////////////////
var globalStores=[]; //全局公用store

//////////////////////全局数据字典store////////////////////////
var g_mapStore={}; //全局数据字典
var CONST_LINE_TYPE="1005";
var CONST_RUN_TYPE="1010";
var CONST_BUS_TYPE="1015";
var CONST_FEATURE="1020";
var CONST_STATE="1025";
var CONST_JOB_TYPE="1030";
var CONST_FIELD_TYPE="1035";
var CONST_STATION_TYPE="1040";
var CONST_STOPAREA_TYPE="1041";
var CONST_EMPLOYEE_STATE="1045";
var CONST_EMPLOYEE_FEATURE="1050";
var CONST_DRIVING_TYPE="1055";
var CONST_SEX_TYPE="2000";
var CONST_LOG_TYPE="5010";
var CONST_DATE_TYPE="1060";
var CONST_DIRECTION_TYPE="1065";
var CONST_POSITION="1070";
var CONST_CTRL_TYPE="1075";
var CONST_POWER_STATE="1085";
var CONST_SECTTYPE_TYPE="1080";
var CONST_LEAVETYPE_TYPE="1090";
var CONST_EXAMINE_STATE="1095";
var CONST_DISPATCHMODE_TYPE="1096"
var CONST_AD_GROUP="2005";
var CONST_PLAN_TYPE="2015";
var CONST_CANCELTYPE_TYPE="2025";
var CONST_UPGRADE_STATE="2035";
var CONST_DEVICE_TYPE="2040";
var CONST_TURNCLASS_TYPE="2045";
var CONST_CREATETYPE_TYPE="2046";
var CONST_PLANSTATE_TYPE="2060";
var CONST_DATASTATE_TYPE="2065";
var CONST_PLANTYPE_TYPE="2080";
var CONST_CANCELREASON_TYPE="2020";
var CONST_CLASSPLAN_REMARK="2050";
var CONST_BUSSCOPE_TYPE="2085";
var CONST_TRANSACTION_TYPE="2093";
var CONST_TRANSACTION_CARD="2094";
var CONST_TRANSACTION_CARD2="2089";
var CONST_DEVICE_BRAND="2095";
var CONST_BUSDEVICE_TYPE="2100";
var CONST_VIDEO_BRAND="2105";
var CONST_VIDEO_TYPE="2110";
var CONST_LINETIME_FLAG="1046";
// var CONST_EVENT_TYPE="2115";
var CONST_EVENT_TYPE="6003";
var CONST_EVENT_STATE="5020";
var CONST_AD_TYPE="6005";
var CONST_AD_STATE="6006";
var CONST_AUDIT_STATE="2115";
var CONST_SCREEN_TYPE="1036";
var CONST_DRIVER_TYPE="2120";
var CONST_PLATFORM="2122";
var CONST_MSG_TYPE="2123";
var CONST_USER_TYPE="2124";
var CONST_SERVER_TYPE="1026";
var CONST_MERCHANTNO="6100";
var CONST_HOTPOSTYPE="6101";
var CONST_EXCEPTIONSTARTTYPE="6102";
var CONST_TICKET_PRICE_TYPE="6107";
var CONST_TICKET_PRICE_STATE="6109";
var CONST_RUNRANGE_TYPE="6108";
var CONST_ORDER_STATE="6110";
var CONST_ORDER_TYPE="6111";
var CONST_PAY_TYPE="6112";
var CONST_CUSTOMER_TYPE="6120";
var CONST_PASSENGERADVICE_SOURCE="6116";
var CONST_PASSENGERADVICE_MATCH="6117";
var CONST_PASSENGERADVICE_ISBUY="6118";
var CONST_SEAT_TYPE="6121";
var CONST_ORDERTYPE="6113";
var CONST_RUNRANGETYPE="6114";
var CONST_RECMONEYTYPE="6115";
var CONST_TRAFFICBUS_SON="6122";
var CONST_RENTBUS_SON="6123";
var CONST_PASSENGER_SOURCE  ="6124";
var CONST_CANCELTYPE="6002";
var CONST_REFUND_EXAMINE_STATE="6126";
var CONST_REFUND_STATE="6127";
var CONST_REASON_TYPE="6128";
var CONST_REFUND_METHOD="6129";
var CONST_DEAL_TYPE="6130";
var CONST_CONTRACT_STATE="6131";
var CONST_EXCLUDEDATE_TYPE="6132";
var CONST_OPEN_STATE="6134";
var CONST_COMMAND_STATE="6135";
var CONST_ISACCEPT_STATE="6136";
var CONST_REFUND_TYPE="6137";
var CONST_ISDISABLE="6138";
var CONST_APPSOURCE_TYPE="6142";



//加载数据字典
function loadStoreDataDict(dd_id) {
  /*  log("loadStoreDataDict: "+dd_id);
    if(g_mapStore[dd_id] == undefined){
        g_mapStore[dd_id] = Ext.create('Ext.data.Store', {
            model : 'Admin.model.System.DdItemInfo',
            pageSize : 2000,
            proxy : {
                type : 'ajax',
                url : ddItemInfos_readUrl,
                method : 'GET',
                reader : {
                    type : 'json',
                    rootProperty : 'data',
                    successProperty : 'success'
                },
                headers:{
                    'x-auth-token':getCookie(xAuthTokenCookieKey)
                }
            },listeners:{
                load : function(store, records, options ){
                    for(var i=0;i<store.getCount();i++){
                        var record =  store.getAt(i);
                        g_mapStore[dd_id][record.get('itemCode')] = record.get('itemName');
                        // g_mapStore[dd_id][record.get('itemCode')] = record;
                    }
                }
            }
        });
        g_mapStore[dd_id].load( {
            params : {
                // group_id : group_id,
                ddCode: dd_id
            }
        });
    }*/
}

////////////////////////全局Store定义区 及 key//////////////////////////////
//store
var global_departmentStore = null;
var global_lineStore = null;
var global_classGroupStore = null;
var global_busStore = null;//selectpage车辆信息store
var global_busStore2 = null;//ext车辆信息store
var global_employeeStore = null;
var global_stopAreaStore = null;
var global_stationStore = null;
var global_fieldStore = null;
var global_versionStore = null;
var global_departmentsWithoutBlankStore = null;
var global_fieldScreenStore = null;
var global_resourceStore = null;
var global_startBusScreenStore = null;
var global_dutyNoGroupStore = null;
var global_hotPosStore = null;
var global_hotPosEdgeStore = null;
var global_customerStore = null;
var global_orderNoStore = null;
var global_seatNumStore = null;
var global_cusLineStore = null;
var global_stationWithSupportPointStore = null;
//key
var GlobalStoreID_DepartmentStore = 1;
var GlobalStoreID_LineStore = 2;
var GlobalStoreID_ClassGroupStore = 3;
var GlobalStoreID_BusStore = 4;
var GlobalStoreID_EmployeeStore = 5;
var GlobalStoreID_StopAreaStore = 6;
var GlobalStoreID_StationStore = 7;
var GlobalStoreID_FieldStore = 8;
var GlobalStoreID_VersionStore = 9;
var GlobalStoreID_departmentsWithoutBlankStore = 10;
var GlobalStoreID_FieldScreenStore = 11;
var GlobalStoreID_ResourceStore = 12;
var GlobalStoreID_StartBusScreenStore = 13;
var GlobalStoreID_DutyNoGroupStore = 14;
var GlobalStoreID_HotPosStore = 15;
var GlobalStoreID_HotPosEdgeStore = 16;
var GlobalStoreID_CustomerStore = 17;
var GlobalStoreID_OrderNoStore = 19;
var GlobalStoreID_SeatNumStore = 18;
var GlobalStoreID_CusLineStore = 20;
var GlobalStoreID_StationWithSupportPointStore = 21;
var GlobalStoreID_BusStore2 = 22;


//部门下拉
var department_deptCodeStore = null;
var line_deptCodeStore = null;
var deviceState_lineStore = null;
var employee_deptCodeStore = null;
var remoteUpdate_busStore=null;
var remoteUpdate_versionStore=null;
var stopAreaAd_stopAreaStore = null;
var dispatchGroup_deptCodeStore = null;
var userInfo_deptCodeStore = null;
var classGroup_deptCodeStore = null;
var stopAreaLedAd_stopAreaStore = null;
var stopAreaVoiceAd_stopAreaStore = null;
var stopAreaLedAd_screenStore = null;

//排班遍历定义区
var g_storeSubBusdriver = null;

//全局初始化store
function initGlobalStore(){

    //初始化store
  
    //---------------初始化全局store--------------------------
	//车辆信息  selectpage
	ajaxUtils(bus_readAllUrl,{
        method: 'post',
        dataType:'json',
        success:function (data, textStatus) {
            global_busStore=data.data;
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            log(XMLHttpRequest);
            log(textStatus);
        }
    });
	//车辆信息  ext
	 //---------------初始化全局store--------------------------
    global_busStore2 = Ext.create('Admin.store.Common.GlobalBuss');
    global_busStore2.load();

    //key-value
    globalStores[GlobalStoreID_DepartmentStore] = global_departmentStore;
    globalStores[GlobalStoreID_LineStore] = global_lineStore;
    globalStores[GlobalStoreID_ClassGroupStore] = global_classGroupStore;
    globalStores[GlobalStoreID_BusStore] = global_busStore;
    globalStores[GlobalStoreID_BusStore2] = global_busStore2;
    globalStores[GlobalStoreID_EmployeeStore] = global_employeeStore;
    globalStores[GlobalStoreID_StopAreaStore] = global_stopAreaStore;
    globalStores[GlobalStoreID_StationStore] = global_stationStore;
    globalStores[GlobalStoreID_FieldStore] = global_fieldStore;
    globalStores[GlobalStoreID_VersionStore] = global_versionStore;
    globalStores[GlobalStoreID_departmentsWithoutBlankStore] = global_departmentsWithoutBlankStore;
    globalStores[GlobalStoreID_FieldScreenStore] = global_fieldScreenStore;
    globalStores[GlobalStoreID_ResourceStore] = global_resourceStore;
    globalStores[GlobalStoreID_StartBusScreenStore] = global_startBusScreenStore;
    globalStores[GlobalStoreID_DutyNoGroupStore] = global_dutyNoGroupStore;
    globalStores[GlobalStoreID_HotPosStore] = global_hotPosStore;
    globalStores[GlobalStoreID_HotPosEdgeStore] = global_hotPosEdgeStore;
    globalStores[GlobalStoreID_CustomerStore] = global_customerStore;
    globalStores[GlobalStoreID_OrderNoStore] = global_orderNoStore;
    globalStores[GlobalStoreID_SeatNumStore] = global_seatNumStore;
    globalStores[GlobalStoreID_CusLineStore] = global_cusLineStore;
    globalStores[GlobalStoreID_StationWithSupportPointStore] = global_stationWithSupportPointStore;
    
    ///////////////////////////////////////////////////////////////
   

    //-----------------加载数据字典--------------------------
    loadStoreDataDict(CONST_LINE_TYPE);             //线路类型
    loadStoreDataDict(CONST_RUN_TYPE);              //运行类型
    loadStoreDataDict(CONST_JOB_TYPE);              //岗位类型
    loadStoreDataDict(CONST_LOG_TYPE);              //日志类型
    loadStoreDataDict(CONST_DATE_TYPE);             //日期类型
    loadStoreDataDict(CONST_DIRECTION_TYPE);        //方向类型
    // loadStoreDataDict(CONST_LOG_TYPE);           //日志类型
    loadStoreDataDict(CONST_BUS_TYPE);              //车辆类型
    loadStoreDataDict(CONST_FEATURE);               //车辆性质
    loadStoreDataDict(CONST_STATE);                 //车辆状态
    loadStoreDataDict(CONST_FIELD_TYPE);            //场站类型
    loadStoreDataDict(CONST_STATION_TYPE);          //站点类型
    loadStoreDataDict(CONST_STOPAREA_TYPE);         //站台类型
    loadStoreDataDict(CONST_SEX_TYPE);              //性别
    loadStoreDataDict(CONST_EMPLOYEE_STATE);        //人员状态
    loadStoreDataDict(CONST_EMPLOYEE_FEATURE);      //人员性质
    loadStoreDataDict(CONST_DRIVING_TYPE);          //准驾车型
    loadStoreDataDict(CONST_SECTTYPE_TYPE);         //路段类型
    loadStoreDataDict(CONST_LEAVETYPE_TYPE);        //请假类型
	loadStoreDataDict(CONST_POSITION);              //站台方位
    loadStoreDataDict(CONST_CTRL_TYPE);             //控制类型
    loadStoreDataDict(CONST_POWER_STATE);           //电源状态
    loadStoreDataDict(CONST_EXAMINE_STATE);          //审核状态
    loadStoreDataDict(CONST_AD_GROUP);              //广告群组
    loadStoreDataDict(CONST_PLAN_TYPE);             //计划类型
    loadStoreDataDict(CONST_UPGRADE_STATE);         //升级状态
    loadStoreDataDict(CONST_DEVICE_TYPE);           //设备类型
    loadStoreDataDict(CONST_CANCELREASON_TYPE);     //停驶原因
    loadStoreDataDict(CONST_CANCELTYPE_TYPE);       //停驶类型
    loadStoreDataDict(CONST_TURNCLASS_TYPE);        //轮班类型
    loadStoreDataDict(CONST_PLANSTATE_TYPE);        //计划状态
    loadStoreDataDict(CONST_DATASTATE_TYPE);        //数据状态
    loadStoreDataDict(CONST_PLANTYPE_TYPE);         //营运类型
    loadStoreDataDict(CONST_DISPATCHMODE_TYPE);     //调度模式
    loadStoreDataDict(CONST_CLASSPLAN_REMARK);      //排班的备注
    loadStoreDataDict(CONST_BUSSCOPE_TYPE);         //车辆规模
    loadStoreDataDict(CONST_DEVICE_BRAND);         //调度终端品牌
    loadStoreDataDict(CONST_DEVICE_TYPE);         //调度终端型号
    loadStoreDataDict(CONST_VIDEO_BRAND);         //视频终端品牌
    loadStoreDataDict(CONST_VIDEO_TYPE);         //视频终端型号
    loadStoreDataDict(CONST_LINETIME_FLAG);      //路准时间 标记
    loadStoreDataDict(CONST_EVENT_TYPE);         //事件类型
    loadStoreDataDict(CONST_EVENT_STATE);         //事件状态
    loadStoreDataDict(CONST_AD_TYPE);         //广告类型
    loadStoreDataDict(CONST_AD_STATE);         //广告发布状态
    loadStoreDataDict(CONST_TRANSACTION_TYPE);         //交易类型
    loadStoreDataDict(CONST_TRANSACTION_CARD);         //卡种类
    loadStoreDataDict(CONST_TRANSACTION_CARD2);         //卡类
    loadStoreDataDict(CONST_AUDIT_STATE);         //流水审核状态
    loadStoreDataDict(CONST_SCREEN_TYPE);         //屏幕类型
    loadStoreDataDict(CONST_CREATETYPE_TYPE);     //排班类型
    loadStoreDataDict(CONST_DRIVER_TYPE);         //驾驶员性质
    loadStoreDataDict(CONST_PLATFORM);         //平台
    loadStoreDataDict(CONST_MSG_TYPE);         //消息类型
    loadStoreDataDict(CONST_USER_TYPE);         //用户类型
    loadStoreDataDict(CONST_SERVER_TYPE);         //营运类型
    loadStoreDataDict(CONST_MERCHANTNO);         //商户
    loadStoreDataDict(CONST_HOTPOSTYPE);         //热点类型
    loadStoreDataDict(CONST_EXCEPTIONSTARTTYPE);  //异常发车类型
    loadStoreDataDict(CONST_TICKET_PRICE_TYPE);     //票价类型
    loadStoreDataDict(CONST_TICKET_PRICE_STATE);    //票价状态
    loadStoreDataDict(CONST_RUNRANGE_TYPE);       //营运范围类型
    loadStoreDataDict(CONST_CUSTOMER_TYPE);       //客户类型
    loadStoreDataDict(CONST_ORDER_STATE);     //订单状态
    loadStoreDataDict(CONST_ORDER_TYPE);    //订单类型
    loadStoreDataDict(CONST_PAY_TYPE);       //支付类型
    loadStoreDataDict(CONST_ORDERTYPE);    //订单类型  order表
    loadStoreDataDict(CONST_RUNRANGETYPE);    //行驶范围
    loadStoreDataDict(CONST_RECMONEYTYPE);    //收款方式
    loadStoreDataDict(CONST_PASSENGERADVICE_SOURCE); //发起渠道
    loadStoreDataDict(CONST_PASSENGERADVICE_MATCH); //上下班匹配
    loadStoreDataDict(CONST_PASSENGERADVICE_ISBUY); //是否乘坐
    loadStoreDataDict(CONST_SEAT_TYPE);				//座位类型
    loadStoreDataDict(CONST_TRAFFICBUS_SON);		//交通车子类型
    loadStoreDataDict(CONST_RENTBUS_SON);			//包车子类型
    loadStoreDataDict(CONST_PASSENGER_SOURCE);		//乘客来源
    loadStoreDataDict(CONST_CANCELTYPE);			//取消类型
    loadStoreDataDict(CONST_REFUND_EXAMINE_STATE);	//退款审核状态
    loadStoreDataDict(CONST_REFUND_STATE);			//退款状态
    loadStoreDataDict(CONST_REASON_TYPE);			//退款原因类型

    loadStoreDataDict(CONST_REFUND_METHOD);			//退款方式
    loadStoreDataDict(CONST_DEAL_TYPE);			 //处理类型
    loadStoreDataDict(CONST_CONTRACT_STATE);     //订单合同状态
    loadStoreDataDict(CONST_EXCLUDEDATE_TYPE);   //排他日期类型
    loadStoreDataDict(CONST_OPEN_STATE);         //线路开通状态
    loadStoreDataDict(CONST_COMMAND_STATE);      //需求状态   
    loadStoreDataDict(CONST_ISACCEPT_STATE);     //采纳状态
    loadStoreDataDict(CONST_REFUND_TYPE);        //退票类型
    loadStoreDataDict(CONST_ISDISABLE);     	 //是否启用
    loadStoreDataDict(CONST_APPSOURCE_TYPE);	 //APP资源类型
}