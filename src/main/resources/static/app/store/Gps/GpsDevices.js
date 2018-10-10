/**
 * Created by jijia on 2017/1/17.
 */
Ext.define('Admin.store.Gps.GpsDevices', {
    extend: 'Ext.data.ArrayStore',
    storeId: 'GpsDevices',
    alias: 'store.gpsdevices',
    model: 'Admin.model.Gps.GpsDevice',
    autoLoad: false,
    pageSize: 30,
    proxy: {
        type: 'ajax',
        noCache:false,
        api:{
            read : deviceGps_readUrl
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success',
            totalProperty: 'total'
        },
        extraParams:{
        	startWorkDate:'',
        	endWorkDate:'',
        	busCode:''
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false
        },
        listeners: {
            exception: storeException
        }
    }
});