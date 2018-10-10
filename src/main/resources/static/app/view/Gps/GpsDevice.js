Ext.define('Admin.view.Gps.GpsDevice',{
	extend: 'Ext.grid.Panel',
	alias : 'widget.gpsdevice',
	xtype: 'gpsdevice',
    id: 'GpsDevice',
    title:'车辆列表',
    height:window.innerHeight,
    requires:[
        'Admin.controller.Gps.GpsDeviceController'
    ],
	store : 'GpsDevices',
    controller:'gpsdevicecontroller',
    columnLines: true,
	selModel: {
		selType : 'checkboxmodel'
	},
    funclist:null,
	columns : [{
                xtype    : 'rownumberer',
                text     : '序号',
                minWidth    : 70,
                sortable : false
            },
            {
                text     : '营运日期',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'workDateStr',
                flex:1
            },
            {
                text     : '车牌号',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'busBrandNo',
                flex:1
            },
            {
                text     : '车辆编号',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'busCode',
                flex:1
            },
            {
                text     : '线路编号',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'lineCode',
                flex:1
            },
            {
                text     : '离线次数',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'offLineCount',
                flex:1
            },
            {
                text     : '离线时长(s)',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'offLineTime',
                flex:1
            },
            {
                text     : '补传时长(s)',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'additinalDataTime',
                flex:1
            },
            {
                text     : '补传率（%）',
                minWidth    : 150,
                sortable : true,
                dataIndex: 'uploadRate',
                flex:1,
                renderer:function(value, record){
                	var uploadRate=0;
                	var totalOfflinePackCount=record.record.data.totalOfflinePackCount;
                	var additionalDataCount=record.record.data.additionalDataCount;
                	if(totalOfflinePackCount!=0){
                		uploadRate=((additionalDataCount/totalOfflinePackCount)*100).toFixed(2);
                	}
                	return uploadRate;
                }
            }
	],
    dockedItems: [
    	 {
             xtype: 'toolbar',
             dock: 'top',
             itemId:'first',
             items: [
            	 {
                     xtype : 'button',
                     text : '查看图表',
                     handler:'viewGpsDeviceDetail'

                 },
                 {
                     xtype : 'button',
                     text : '导出',
                     handler:'exportData'

                 }
             ]
         },
        {
            xtype: 'toolbar',
            dock: 'top',
            itemId:'second',
            items: [
            	'->',
            	 {
                     xtype : 'datefield',
                     width : 200,
                     itemId:'startWorkDate',
                     format:'Y-m-d',
                     labelWidth :60,
                     fieldLabel:'开始日期'
                 },
                 {
                     xtype : 'datefield',
                     width : 200,
                     format:'Y-m-d',
                     itemId:'endWorkDate',
                     labelWidth : 60,
                     fieldLabel:'结束日期'
                 },
                 {
                     xtype : 'baseformcombo',
                     name: 'busCode',
                     itemId: 'busCode',
                     width : 200,
                     labelWidth : 60,
                     fieldLabel : '车牌号',
                     displayField : 'busBrandNo',
                     valueField : 'busCode'/*,
                     store:global_busStore2*/
                 },
                 /*{
                     xtype : 'textfield',
                     width : 200,
                     itemId:'busCode',
                     labelWidth : 60,
                     fieldLabel:'车牌号'
                 },*/
                 {
                     xtype : 'button',
                     text : '查询',
                     handler:'query'

                 }
            ]
        },
        {
            xtype: 'pagingtoolbar',
            displayInfo : true,
            store: 'GpsDevices',
            displayMsg : '共有{2}条记录',
            emptyMsg : "没有显示信息"
        }
    ],

    listeners:{
        beforerender: 'beforerender'
    }
});
