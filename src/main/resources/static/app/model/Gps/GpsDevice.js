Ext.define('Admin.model.Gps.GpsDevice', {
    extend: 'Ext.data.Model',
    idProperty:'dispatchPlanId',
    fields: [
        {name:'dispatchPlanId'},
        {name:'workDate'},
        {name:'busBrandNo'},
        {name:'busCode'},
        //{name:'lineCode'}
    ]
});