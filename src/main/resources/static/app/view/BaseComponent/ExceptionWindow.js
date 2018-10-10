/**
 * Created by jia ji on 2017/5/15.
 */
Ext.define("Admin.view.BaseComponent.ExceptionWindow",{
    extend:'Admin.view.BaseComponent.BaseWindow',
    title: '异常提醒',
    width:700,
    height:370,
    border:false,
    //错误提示信息
    message:null,
    layout: 'vbox',
    style:{
        top:"calc(50% - 370px/2)"
    },
    items: [
        {
            title: '异常简介',
            itemId: 'north',
            xtype: 'panel',
            height: 100,
            width: '100%',
            padding: '10 3 0 3',
            html:''
        },
        {
            title: '异常明细',
            itemId: 'center',
            xtype: 'panel',
            collapsible: true,
            // collapsed:true,
            height:230,
            width: '100%',
            padding: '0 3 0 3',
            html:''
        }
    ],
    listeners:{
        beforerender:function (self) {
            var northPanel = self.getComponent("north");
            var centerPanel = self.getComponent("center");
            if(!self.message){
                return;
            }
            if(-1 != self.message.indexOf(exceptionSplitFlag)){
                var msgs = self.message.split(exceptionSplitFlag);
                northPanel.setHtml(msgs[0]);
                centerPanel.setHtml(msgs[1]);
            }else{
                northPanel.setHtml(self.message);
            }
        }
    }
});
