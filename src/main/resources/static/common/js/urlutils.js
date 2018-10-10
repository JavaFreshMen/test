
//此处定义项目所用的url

//测试发布阶段
 var baseUrl = "";

//测试Url
var testExportUrl = baseUrl+"test/tableUserInfoListByTbl.action";
//store destroy url占位符
var storeDestroyCommonUrl = baseUrl+"notAAction/destory.action";
//用户登录
var loginUrl = baseUrl+"login/login.action";
var logoutUrl = baseUrl+"login/logout.action";
var sessionValidUrl = baseUrl+"login/sessionValidation.action";
var loadResourceInfoUrl = baseUrl+"login/viewResourceInfo.action";
var changePasswordUrl = baseUrl+"login/changePasswordLogin.action";
//操作资源
var resourceInfos_readUrl = baseUrl+"resourceInfo/viewtree.action";
var resourceInfos_createAndUpdateUrl = baseUrl+"resourceInfo/createtree.action";
var resourceInfos_deleteUrl = baseUrl+"resourceInfo/deleteByResourceCodes.action";
var resourceInfos_global_readUrl = baseUrl+"resourceInfo/viewComboResourceInfos.action";
//角色资源权限分配
var resourceInfoCheckedTrees_readUrl = baseUrl+"roleResource/viewcheckedtree.action";
var resourceInfoCheckedTrees_saveAndUpdateUrl = baseUrl+"roleResource/createRoleResource.action";
//角色管理
var roleInfos_readUrl = baseUrl+"roleInfo/view.action";
var roleInfos_createUrl = baseUrl+"roleInfo/create.action";
var roleInfos_updateUrl = baseUrl+"roleInfo/update.action";
var roleInfos_deleteUrl = baseUrl+"roleInfo/delete.action";
//用户管理
var userInfos_readUrl = baseUrl+"userInfo/view.action";
var userInfos_createUrl = baseUrl+"userInfo/create.action";
var userInfos_updateUrl = baseUrl+"userInfo/update.action";
var userInfos_deleteUrl = baseUrl+"userInfo/delete.action";
//角色用户权限分配
var userInfoCheckeds_readUrl = baseUrl+"roleUser/view.action";
var userInfoCheckeds_createAndUpdateUrl = baseUrl+"roleUser/createRoleUser.action";
var roleInfoUserCheckeds_readUrl = baseUrl+"roleUser/viewByRoleCode.action";
var roleInfoUserCheckeds_createAndUpdateUrl = baseUrl+"roleUser/createRoleUserByRoleCode.action";
//数据字典
var ddInfos_readUrl = baseUrl+"ddInfo/view.action";
var ddInfos_createUrl = baseUrl+"ddInfo/create.action";
var ddInfos_updateUrl = baseUrl+"ddInfo/update.action";
var ddInfos_deleteUrl = baseUrl+"ddInfo/delete.action";
//数据字典项
var ddItemInfos_readUrl = baseUrl+"ddItemInfo/view.action";
var ddItemInfos_createUrl = baseUrl+"ddItemInfo/create.action";
var ddItemInfos_updateUrl = baseUrl+"ddItemInfo/update.action";
var ddItemInfos_deleteUrl = baseUrl+"ddItemInfo/delete.action";
//操作日志
var sysLog_readUrl = baseUrl+"sysLog/view.action";
var sysLog_createUrl = baseUrl+"sysLog/create.action";
var sysLog_updateUrl = baseUrl+"sysLog/update.action";
var sysLog_deleteUrl = baseUrl+"sysLog/delete.action";
//====================基础信息相关======================
//车辆信息
var bus_readAllUrl = baseUrl+"bus/loadAllBusInfo.action";
var globalBuss_readUrl = baseUrl+"bus/viewGlobal.action";

//=====================数据分析相关=====================
//GPS离线补传分析
var deviceGps_readUrl = baseUrl+"device/analysis/showAnalyticalDataOfBus.action";
var deviceGps_checkExistUrl = baseUrl+"device/analysis/checkFileExits.action";
var deviceGps__exportUrl= baseUrl+"device/analysis/export.action";

