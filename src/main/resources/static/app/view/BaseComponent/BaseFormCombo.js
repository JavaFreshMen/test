/**
 * Created by ysNi on 2017/4/26.
 */
Ext.define('Admin.view.BaseComponent.BaseFormCombo',{
    extend: 'Ext.form.field.ComboBox',
    xtype: 'baseformcombo',
    mode : 'local',
    queryMode : 'local',
    editable: true,
    listeners:{
       'focus':function(cb){
            cb.getStore().clearFilter();
        },
        change:function (self,newValue,oldValue) {
            if(null == newValue || newValue == ''){
                self.getStore().clearFilter();
            }
        },
        'beforequery':function(e){
            var com = e.combo;
            if(!e.forceAll){
                var input = e.query;
                // 检索的正则
                var regExp = new RegExp(".*" + input + ".*");
                // 执行检索
                com.store.clearFilter();
                com.store.filterBy(function(record,id){
                    // 得到每个record的项目名称值
                    var text = record.get(com.displayField);
                    return regExp.test(text);
                });
                com.expand();
                return false;
            }
        }
    }
});