/**
 * Created by jijia on 2017/4/1.
 */
Ext.define('Admin.view.BaseComponent.BasePanel',{
    extend: 'Ext.panel.Panel',
    xtype: 'basepanel',
    border:false,
    listeners:{
        beforerender:function (self) {
            self.setHeight(mainViewHeight);
        }
    }
});