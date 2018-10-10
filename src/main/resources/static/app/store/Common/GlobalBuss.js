Ext.define('Admin.store.Common.GlobalBuss', {
    extend: 'Ext.data.ArrayStore',
    storeId: 'GlobalBuss',
    alias: 'store.globalbuss',
    model: 'Admin.model.BasicInfo.Bus',
    pageSize: 5000,
    autoLoad: false,
    proxy: {
        type: 'ajax',
        noCache:false,
        extraParams:{
            deptCode : '',
            lineCode : '',
            keyWord: ''
        },
        api:{
            read : globalBuss_readUrl,
            destroy:storeDestroyCommonUrl
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success',
            totalProperty: 'total'
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