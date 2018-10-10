/**
 * 基础窗口
 * Created by jijia on 2017/3/28.
 */
Ext.define('Admin.view.BaseComponent.BaseWindow',{
    extend: 'Ext.window.Window',
    alias: 'widget.basewindow',

    title: '窗口',
    iconCls: 'fa fa-windows',
    height: 520,  //高度不加则为根据内容自适应
    width: 945,
    padding: '0 5 0 5',
    layout: 'fit',
    autoShow: true,
    border:false,
    maximizable: true,
    draggable: true,
    constrain: true,
    modal: true,
//    constrainHeader: true,
    constrainTo:Ext.getBody(),
    renderTo: Ext.getBody()

});