Ext.define('Admin.model.BasicInfo.Bus', {
    extend: 'Ext.data.Model',
    idProperty:'busId',
    fields: [
        {name: 'busId'},
        {name: 'busCode'},
        {name: 'busBrandNo'},
        {name: 'lineCode'},
        {name: 'feature'},
        {name: 'state'},
        {name: 'busType'},
        {name: 'seatNum'},
        {name: 'limitedNum'},
        {name: 'useDate'},
        {name: 'isDisable'},
        {name: 'isInstall'},
        {name: 'deviceBrand'},
        {name: 'deviceType'},
        {name: 'deviceCode'},
        {name: 'deviceSimCardNo'},
        {name: 'videoBrand'},
        {name: 'videoType'},
        {name: 'videoCode'},
        {name: 'videoSimCardNo'},
        {name: 'editor'},
        {name: 'editTime'},
        {name: 'creator'},
        {name: 'createTime'},
        {name: 'busScope'},
        {name: 'busCusCode'},
        {name: 'lineName'},
        {name: 'deptCode'},
        {name: 'deptName'},
        {name: 'flowCode'}
    ]
});