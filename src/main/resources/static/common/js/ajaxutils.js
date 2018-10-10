/**
 * 异步请求管理工具
 * Created by jijia on 2017/1/16.
 */
/*
   $.ajax二次封装 主要便于对异步请求的统一化处理
   参数列表:
     url:url 请求的url (必填)
     dataType:'json'  返回数据类型 默认为json类型 可选值:json  xml  html text(可选)
     method: 'post' 请求的类型 默认为post 可选值：get  post  (可选)
     async:true 是否是异步请求  默认为异步请求  可选值：ture false  (可选)
     data:{} 请求参数 需要是键值对形式  (可选)
     contentType:'application/x-www-form-urlencoded',  (可选)
     success:successfunc 请求成功的处理函数  (必填)
     error:failurefunc  请求失败时的处理函数 (必填)
     complete:completefunc   请求完成时的处理函数  (可选)

     参考示例:
     Demo 1: 带参数的post请求
     ajaxUtils("http://127.0.0.1:8080/njunits/test/testajax.action",{
         data:{"name":"zhangsan","age":30},
         method: 'post',
         dataType:'text',
         success:function (data, textStatus) {
             alert(data);
             log(data);
         },
         error:function (XMLHttpRequest, textStatus, errorThrown) {
             log(XMLHttpRequest);
             log(textStatus);
         }
     });

     Demo 2:不含参数的get请求 返回值为{data:[],success:true,total:100}数据
     ajaxUtils("http://127.0.0.1:8080/njunits/test/testextjs.action",{
         method: 'get',
         success:function (data, textStatus) {
             log(data);
                 if(data.success){
                 log(data.data);
             }else{
                log("failure");
             }
         },
         error:function (XMLHttpRequest, textStatus, errorThrown) {
             log(XMLHttpRequest);
             log(textStatus);
         }
     });
*/

function ajaxUtils(url,parameters) {
    var ajaxParamters = {
        url:url,
        dataType:'json',
        method: 'post',
        async:true,
        data:{},
        contentType:'application/x-www-form-urlencoded',
        success:null,
        error:null,
        complete:null
    };
    $.extend(ajaxParamters,parameters);
    $.ajax({
        url:ajaxParamters.url,
        method: ajaxParamters.method,
        data:ajaxParamters.data,
        dataType:ajaxParamters.dataType,
        contentType:ajaxParamters.contentType,
        async:ajaxParamters.async,
        success:function (data, textStatus) {
            if(data.success && ajaxParamters.success){
                ajaxParamters.success(data,textStatus);
            }else{
                ajaxFailureException(data.message);
            }
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {

        },
        complete:function (XMLHttpRequest, textStatus) {

        }
    });
}

