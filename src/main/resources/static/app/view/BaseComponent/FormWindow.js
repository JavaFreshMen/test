/**
 * form表单窗口
 * Created by jijia on 2017/3/28.
 */
Ext.define('Admin.view.BaseComponent.FormWindow',{
    extend: 'Ext.window.Window',
    alias: 'widget.formwindow',

    title: '表单',
    iconCls: 'fa fa-wpforms',
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