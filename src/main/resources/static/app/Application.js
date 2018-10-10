//配置加载策略
Ext.Loader.setConfig({
	disableCaching:false
});

//主入口
Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	
	name : 'Admin', 	// 定义的命名空间
	appFolder : 'app', 	// 指明应用的根目录
	
	views:[
		//gps设备分析
		'Gps.GpsDevice',
		//公共
		'BaseComponent.BaseFormCombo',
	],

	stores:[
		 'Gps.GpsDevices'
	],

	launch : function() {
		Ext.create('Admin.view.Gps.GpsDevice', {
			  renderTo: 'gpsDeviceContainer'
		});
	}
});
