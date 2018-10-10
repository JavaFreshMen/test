/**
 * 导出数据窗口
 * Created by jijia on 2017/3/28.
 */
Ext.define('Admin.view.BaseComponent.ExportWindow',{
    extend: 'Ext.window.Window',
    alias: 'widget.exportwindow',

    title: '导出数据',
    iconCls: 'fa fa-file-excel-o',
    height: 520,   //高度为空 则表示高度自适应  具体需要设置高度的可在使用处重写
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