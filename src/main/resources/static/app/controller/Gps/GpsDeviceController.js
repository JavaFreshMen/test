Ext.define('Admin.controller.Gps.GpsDeviceController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.gpsdevicecontroller',
    query:function (button) {
        var grid = button.up("gpsdevice");
        var querybar = grid.getComponent('second');
        if (!(querybar.getComponent("startWorkDate").getRawValue()&&querybar.getComponent("endWorkDate").getRawValue())) {
        	alertMsg("车辆状态查询","日期不为空！");
			return;
		}
        var startWorkDate=Ext.Date.format(querybar.getComponent("startWorkDate").getValue(),'Y-m-d')||'';
        var endWorkDate=Ext.Date.format(querybar.getComponent("endWorkDate").getValue(),'Y-m-d')||'';
        var busCode = querybar.getComponent("busCode").getValue()||'';
        var _store = grid.getStore();
        _store.proxy.extraParams={
        		startWorkDate:startWorkDate,
                endWorkDate:endWorkDate,
                busCode:busCode
        };
        _store.load({
            params:{
                start:0
            }
        });
        //_store.sort('offLineTime', 'DESC');
    },
    //查看离线补传分析折线图
    viewGpsDeviceDetail:function (button) {
    	//获取被勾选的记录
        var grid = button.up("gpsdevice"),
        store = grid.getStore(),
        records = grid.getSelectionModel().getSelection();
	    if(records.length < 1){
          alert("请选择记录!");
          return;
	    }
	    var paramArr=[];
	    for(var i=0;i<records.length;i++){
	    	var paramObj={};
	    	paramObj['workDate']=records[i].data.workDateStr;
	    	paramObj['busCode']=records[i].data.busCode;
	    	paramArr.push(paramObj);
	    }
	    var dataStr=JSON.stringify(paramArr).replace(/"/g,'~');
        Ext.create('Admin.view.BaseComponent.BaseWindow',{
        	title: '设备离线掉线明细',
            height: 600,
            width: 1150,
            maximizable: false,
            items: [
            	{
        			xtype:'uxiframe',
        			itemId:"frame",
        			width:880
        		}
            ],
        	listeners:{
        		"beforerender":function(self){
        			log("data"+records);
        			var frame = self.getComponent("frame");
        			frame.id = "device-gps-detail-chart";
        			frame.src = "./device-gps-detail?entry=buslist&data="+dataStr;
        			frame.frameName = "gps-device-detail page";
        		}
        	}
        });

    },
    exportData:function(button){
        var grid = button.up("gpsdevice");
        var querybar = grid.getComponent('second');
        if (!(querybar.getComponent("startWorkDate").getRawValue()&&querybar.getComponent("endWorkDate").getRawValue())) {
        	alertMsg("车辆状态查询","日期不为空！");
			return;
		}
        var startWorkDate=Ext.Date.format(querybar.getComponent("startWorkDate").getValue(),'Y-m-d')||'';
        var endWorkDate=Ext.Date.format(querybar.getComponent("endWorkDate").getValue(),'Y-m-d')||'';
        var busCode = querybar.getComponent("busCode").getValue()||'';
        window.location.href = deviceGps__exportUrl+'?'
    	+'startWorkDate='+startWorkDate
    	+'&endWorkDate='+endWorkDate
    	+'&busCode='+busCode
    },

    //渲染前事件
    beforerender:function(self){
    	setTimeout(function(){
    		 var querybar = self.getComponent('second');
        	 querybar.getComponent('busCode').setStore(viewStoreMgr(GlobalStoreID_BusStore2,['busCode','busBrandNo']));       
    	},2000)
    	

    }
});
