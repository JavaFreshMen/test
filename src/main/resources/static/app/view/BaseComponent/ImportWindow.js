/**
 * 导入数据窗口基础对象
 * Created by jijia on 2017/3/28.
 */
Ext.define('Admin.view.BaseComponent.ImportWindow',{
    extend: 'Ext.window.Window',
    alias: 'widget.importwindow',

    title: '导入数据',
    iconCls: 'fa fa-file-excel-o',
    // height: 500,  //高度自适应
    width: 945,
    layout: 'fit',
    border:false,
    autoShow: true,
    maximizable: true,
    draggable: true,
    constrain: true,
    modal: true,
//    constrainHeader: true
     constrainTo:Ext.getBody(),
     renderTo: Ext.getBody()

});