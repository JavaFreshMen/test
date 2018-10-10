<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS</title>
<link rel="stylesheet" href="../common/css/jquery-ui-1.12.1/jquery-ui.min.css"  />
<link rel="stylesheet" type="text/css" href="../common/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../common/css/selectpage.base.css" media="all">
<link rel="stylesheet" type="text/css" href="../common/css/selectpage.css" >
<link rel="stylesheet" type="text/css" href="../common/css/b.dialog.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../common/css/b.dialog.bootstrap3.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../common/css/font-awesome.min.css" />
<link rel="stylesheet" href="../common/css/bootstrap-datetimepicker.min.css" media="screen">

</head>
<body>
	<!-- 工具栏按钮 -->
	<div id="toolBtn" style="width:100%; height: 30px;">
		<button type="button" class="btn btn-default icon-search" data-toggle="tooltip" title="清空图表" onclick="clearCurGraphs('main')"  style='float:right;'>
	  			<span class='fa fa-eraser' aria-hidden='true'></span>
		</button>
		<button type="button" class="btn btn-default " data-toggle="tooltip" title="查询" onclick="openSearchWin()"  style='float:right;'>
			<span class='fa fa-search' aria-hidden='true'></span>
		</button>
	</div>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->	
	<div id="main" style="width: 100%;"></div>
	
	<script  type="text/javascript" src="../common/js/jquery-1.9.1.min.js"></script>
	<script  type="text/javascript" src="./common/js/urlutils.js"></script>
	<script  type="text/javascript" src="./common/js/ajaxutils.js"></script>
	<script  type="text/javascript" src="./common/js/common.js"></script>
	<script  type="text/javascript" src="./common/js/initstore.js"></script>
	<script  type="text/javascript" src="./common/js/globalfunction.js"></script>
	<script  type="text/javascript" src="../common/js/bootstrap.min.js"></script>
	<script  type="text/javascript" src="../common/js/jquery-ui.min.js"></script>
	<script  type="text/javascript" src="../common/js/selectpage.min.js"></script>
	<script  type="text/javascript" src="../common/js/selectpage.js"></script>
	<script  type="text/javascript" src="./echarts/echarts.common.min.js"></script>
	<script  type="text/javascript" src="../common/js/bootbox.min.js"></script>
	<script type="text/javascript" src="../common/js/b.dialog.js" ></script>
	<script  type="text/javascript" src="./common/js/globalfunction.js"></script>
	<script type="text/javascript" src="./common/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="./common/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script  type="text/javascript">
		
		$(function() {
			//store初始化
			if(!global_busStore){
				//initGlobalStore();
			 	ajaxUtils(bus_readAllUrl,{
			        method: 'post',
			        dataType:'json',
			        success:function (data, textStatus) {
			            global_busStore=data.data;
			        },
			        error:function (XMLHttpRequest, textStatus, errorThrown) {
			            log(XMLHttpRequest);
			            log(textStatus);
			        }
			    });
			}
			//入口为车辆列表
			var requestParam=window.location.search;
			if(requestParam.indexOf("entry")!=-1&&requestParam.indexOf("data")!=-1){
				//参数entry
				var entry_start=requestParam.indexOf("entry")+"entry".length+1;
				var entry_end=requestParam.indexOf("&",entry_start);  
				var entry=requestParam.substring(entry_start,entry_end);
				if(entry=='buslist'){
					//隐藏工具按钮
					$('#toolBtn').hide();
				}
				//参数data
				var data_start=requestParam.indexOf("data")+"data".length+1;
			    var data_end=requestParam.indexOf("&",data_start);  
			    var data=null;
			    if (data_end==-1){           
			    	var str=requestParam.substring(data_start);
			    	data=JSON.parse(str.replace(/~/g,'"'));
			     }
			    //请求图表数据并渲染
			    for(var i=0;i< data.length;i++){
			    	var paramObj=data[i];
			    	var startWorkDate=paramObj["workDate"];
			    	var endWorkDate=paramObj["workDate"];
			    	var busCode=paramObj["busCode"];
				    checkIfFileExist(startWorkDate,endWorkDate, busCode);
			    }
			}
		});
		//样式全局变量
		var chartContainerHeight='590px';//图表父容器高度
		var baseInfoListWidth='250px';	 //基础信息列表宽度
		var mainDivId='main';			 //所有图表、列表展示区直接父级div元素
		//用户操作界面窗口
		function openSearchWin(){
			//生成弹窗表单
			var html = "";
			html += "<form id='searchForm'>";
			html += "	<div class='form-group'>";
			html += "		<input type='text' id='startWorkDate' name='startWorkDate' class='form-control' placeholder='请选择营运开始日期'>";
			html += "	</div>";
			html += "	<div class='form-group'>";
			html += "		<input type='text' id='endWorkDate' name='endWorkDate' class='form-control' placeholder='请选择营运结束日期'>";
			html += "	</div>";
			html += "	<div class='form-group'>";
			html += "		<input type='text' id='busCode'  name='busCode' class='form-control'  placeholder='请选择车牌号'>";
			html += "	</div>";
			html += "	<div style='margin: 8 10 0 0;'>";
			html += "		<button type='submit' class='btn btn-primary' style='float: right;'>确定</button>"
			html += "	</div>";
			html += "</form>";
			var msgDialog = openBDialog("GPS设备离线、补传明细查询",html);
			//控件绑定
		    setDatePlugin('startWorkDate');
		    setDatePlugin('endWorkDate');
		    setSelectPagePlugin('busCode','busBrandNo','busCode',global_busStore)
		    
			//表单提交
			$('#searchForm').submit(function(e){
				try{
					//表单数据
					var formDatas = transFormData($(e.currentTarget).serializeArray());
					var busCode = formDatas["busCode"];
					var startWorkDate = formDatas["startWorkDate"];
					var endWorkDate = formDatas["endWorkDate"];
					//参数非空校验
					if(!(busCode&&startWorkDate&&endWorkDate)){
						toastMsg("日期、车牌号不能为空！");
						return false;
					}
					if(new Date(startWorkDate).getTime()>new Date(endWorkDate).getTime()){
						toastMsg("开始日期应该不晚于结束日期！");
						return false;
					}
					//参数有效性校验->拒绝请求||请求结果
					checkIfFileExist(startWorkDate,endWorkDate, busCode);
					//弹出框关闭
					bDialog.close();
				}catch(e){
					console.error(e);
				}
				return false;
			});
		}
		
		
		//校验请求是否合法(相关文件是否存在)->非法拒绝请求||合法返回结果
		function checkIfFileExist(startWorkDate,endWorkDate, busCode){
			ajaxUtils(deviceGps_checkExistUrl,{data : {'startWorkDate' : startWorkDate,'endWorkDate' : endWorkDate,'busCode' :busCode},
				success : function(data, textStatus) {
					if (data.success) {
						getView(startWorkDate,endWorkDate,busCode);
					}
				}
			});
		}
		//调用入口
		function getView(startWorkDate,endWorkDate,busCode) {
			getData(startWorkDate,endWorkDate, busCode);
		}
		//基础数据采集和处理调用
		function getData(startWorkDate,endWorkDate, busCode) {
			var allGraphData=[];
			var baseInfoArr=[];
			ajaxUtils(deviceGps_readUrl,{data : {'startWorkDate' : startWorkDate,'endWorkDate' : endWorkDate,'busCode' : busCode,start:0,limit:100000000},
						success : function(data, textStatus) {
							if (data.success) {
								//数据处理
								for (var a = 0; a < data.data.length; a++) {
									//step1.变量声明
									//图表展示数据
									//基础信息
									var workDate = null; 		  //运营日期
									var busCode = null;			  //车辆编号
									var busCusCode = null;		  //车辆自编号
									var busBrandNo = null; 		  //车牌号
									var lineCode = null;		  //线路编号
									var deviceBrand = null;		  //设备品牌
									var deviceType = null;		  //设备型号
									var useDate=null;			  //使用日期
									var offLineCount = 0; 		  //下线次数
									var offLineTime = 0;		  //下线时长s
									var additionalDataCount=0;	  //补传包数
									var additinalDataTime=0	      //补传次数
									var baseInfoObj={};			  //以上列表明细数据封装集
									var startRunTime=null;		  //开始营运时间
									var endRunTime=null;		  //结束营运时间
									var dispatchPlanRuntimeRange=null;//流水计划运营时间段
									//统计信息
									var xTime = []; 			  //图表横坐标集	   （x轴）
									var allOffLinePoints = []; 	  //图上所有离线纵坐标（y轴）
									var allAdditionalPoints = []; //图上所有补传纵坐标 （y轴）
									var allRuntimePoints = [];    //图上所有流水计划时间段纵坐标 （y轴）
									
									//用于计算、逻辑判断的基础数据
									var firstOffLineTime = null; //首个下线时间
									var lastOffLineTime = null;  //末个下线时间
									var offlineTimeRangeArr = [];//下线时间段
									var offLinePackPerMinMapArr = [];//下线分钟段信息 形如：[15:24:13~15:24:56~14,……],开始时间~结束时间~离线包数
									var additionalPackPerMinMapArr = [];//补传分钟段信息  形如：[15:24:13~15:24:56~14,……],开始时间~结束时间~补传包数
									var uploadRate=0;				//补传率 =补传包数/离线包数
									var totalOfflinePackCount=0;	//离线包数
									//step2.获取待处理数据
									var item = data.data[a];
									workDate = item["workDateStr"];
									busBrandNo = item["busBrandNo"];
									busCode = item["busCode"];
									busCusCode = item["busCusCode"];
									lineCode = item["lineCode"];
									deviceBrand = item["deviceBrand"];
									deviceType = item["deviceType"];
									useDate = item["useDateStr"];
									offLineCount = item["offLineCount"];
									totalOfflinePackCount= item["totalOfflinePackCount"];
									offLineTime = item["offLineTime"];
									additionalDataCount = item["additionalDataCount"];
									additinalDataTime = item["additinalDataTime"];
									offlineCount =  item["offlineCount"];
									offLineTime =  item["offLineTime"];
									additionalDataCount= item["additionalDataCount"];
									additinalDataTime= item["additinalDataTime"];
									var startRunTime=item["startRunTime"];
									var endRunTime=item["endRunTime"];
									var dispatchPlanRuntimeRangeArr=null;
									//流水计划运营时间段
									if(item["dispatchPlanRuntimeRange"]){
										dispatchPlanRuntimeRangeArr=item["dispatchPlanRuntimeRange"].split("||");
									}
									//离线时间明细
									if (item["offlineTimeRange"]) {
										offlineTimeRangeArr = item["offlineTimeRange"].split("||");
									}
									if (item["offLinePackPerMinMap"]) {
										offLinePackPerMinMapArr = item["offLinePackPerMinMap"].split("||");
									}
									//补传时间明细
									if (item["uploadAdditionalsTimeRange"]) {
										uploadAdditionalsTimeRangeArr = item["uploadAdditionalsTimeRange"].split("||");
									}
									if (item["additionalPackPerMinMap"]) {
										additionalPackPerMinMapArr = item["additionalPackPerMinMap"].split("||");
									}
									
									//step2.逻辑处理
									//work1:构造横坐标集
									//确定横坐标开始时间点和结束时间点（确定规则：首次离线时间点的所在分钟点，如17:56:23取17:56:00，最后一次离线时间点所在分钟点的下一分钟点，如18:46:23取18:47:00，）
									if (offlineTimeRangeArr.length > 0) {
										firstOffLineTime = offlineTimeRangeArr[0].split("~")[0];
										lastOffLineTime = offlineTimeRangeArr[offlineTimeRangeArr.length - 1].split("~")[1];
									}
									var startTime = workDate + " "+ firstOffLineTime;
									var endTime = workDate + " " + lastOffLineTime;
									var filledStartRunTime=workDate+" "+startRunTime;
									var filledEndRunTime=workDate+" "+endRunTime;
									var startXTime=null;
									var endXTime = null;
									if(new Date(startTime).getTime()<new Date(filledStartRunTime).getTime()){
										startXTime = Math.floor(new Date(startTime).getTime()/ (1 * 60 * 1000))* (1 * 60 * 1000);
									}else{
										startXTime= Math.floor(new Date(filledStartRunTime).getTime()/ (1 * 60 * 1000))* (1 * 60 * 1000);
									}
									if(new Date(endTime).getTime()>new Date(filledEndRunTime).getTime()){
										endXTime = Math.ceil(new Date(endTime).getTime()/ (1 * 60 * 1000))* (1 * 60 * 1000);
									}else{
										endXTime = Math.ceil(new Date(filledEndRunTime).getTime()/ (1 * 60 * 1000))* (1 * 60 * 1000);
									}
									//构造横坐标集,公差为1min
									for (var i = 0; startXTime <= endXTime; i++) {
										xTime.push(new Date(startXTime).format("hh:mm"));
										startXTime += 1 * 60 * 1000;
									}
									//构造流水计划运营时间
									var allXRuntime=[];
									for(var a=0;a<dispatchPlanRuntimeRangeArr.length;a++){
										var sRuntime=new Date(workDate+" "+dispatchPlanRuntimeRangeArr[a].substring(0, 5)).getTime();
										var eArrivetime=new Date(workDate+" "+dispatchPlanRuntimeRangeArr[a].substring(9, 14)).getTime();
										while (sRuntime <= eArrivetime) {
											allXRuntime.push(new Date(sRuntime).format("hh:mm"));
											sRuntime += 1 * 60 * 1000;
										}
									} 
									allRuntimePoints=constructRuntimeValue(allXRuntime,xTime,5); 
									
									//work2:构造离线、补传指标点的纵坐标集
									allOffLinePoints=constructYAxisSet(offLinePackPerMinMapArr,xTime);
									allAdditionalPoints=constructYAxisSet(additionalPackPerMinMapArr,xTime);
									//根据运营时间段和离线补传时间 计算营运时间补传率
									var runTimeUploadRate=0;
									var runTimeOffLinePackCount=0;
									var runTimeAdditionalPackCount=0;
									for(var b=0;b<allRuntimePoints.length;b++){
										var runMinFlag=allRuntimePoints[b];
										if(runMinFlag!=0){
											runTimeOffLinePackCount+=allOffLinePoints[b];
											runTimeAdditionalPackCount+=allAdditionalPoints[b];
										}else{
											continue;
										}
									}
									if(runTimeOffLinePackCount==0){
										runTimeUploadRate=0;
									}else{
										runTimeUploadRate=(runTimeAdditionalPackCount/runTimeOffLinePackCount*100).toFixed(2);
									}
									//根据运营时间段和离线时间段 计算营运时间离线次数
								    var runTimeOffLineCount=0;//营运时间段离线次数
									var runTimeOffLineTime=0; //营运时间段离线时长
									var offLineTimeRangeMap={};//hh-mm作为key
									for(var e=0;e<offlineTimeRangeArr.length;e++){
										var item=offlineTimeRangeArr[e];
										offLineTimeRangeMap[item.substring(0, 5)]=item;
									}
								    for(var c=0;c<dispatchPlanRuntimeRangeArr.length;c++){
								    	var runTime=dispatchPlanRuntimeRangeArr[c].substring(0, 5);
								    	var arriveTime=dispatchPlanRuntimeRangeArr[c].substring(9, 14);
										var runTimeStamp=new Date(workDate+" "+runTime).getTime();
										var arriveTimeStamp=new Date(workDate+" "+arriveTime).getTime();
										var loopTimeStamp=runTimeStamp;
										while(loopTimeStamp<=arriveTimeStamp){
											var offLinePackPerMin=offLineTimeRangeMap[new Date(loopTimeStamp).format("hh:mm")]
											if(offLinePackPerMin){
												runTimeOffLineCount++;
												var eOffLineTimeStamp=new Date(workDate+" "+offLinePackPerMin.substring(9, 14)).getTime();
												if(eOffLineTimeStamp<=arriveTimeStamp){
													runTimeOffLineTime+=(eOffLineTimeStamp-loopTimeStamp);
												}else{
													runTimeOffLineTime+=(arriveTimeStamp-loopTimeStamp);
												}
											}
											loopTimeStamp+=1*60*1000;
										}
									 }
									
									//work3:封装数据 用于图标渲染
									//(1)图表数据存储
									var graphData={};
									graphData['xTime']=xTime;
									graphData['allOffLinePoints']=allOffLinePoints;
									graphData['allAdditionalPoints']=allAdditionalPoints;
									graphData['allRuntimePoints']=allRuntimePoints;
									graphData['workDate']=workDate
									graphData['busBrandNo']=busBrandNo
									graphData['offlineCount']=offlineCount
									allGraphData.push(graphData);
									//(2)信息列表数据
									//基础信息
									baseInfoObj["workDateStr"]=workDate;
									baseInfoObj["busBrandNo"]= busBrandNo;
									baseInfoObj["busCode"]= busCode;
									baseInfoObj["busCusCode"]= busCusCode;
									baseInfoObj["lineCode"]= lineCode;
									baseInfoObj["deviceBrand"]= deviceBrand;
									baseInfoObj["deviceType"]= deviceType;
									baseInfoObj["useDateStr"]=useDate;
									baseInfoObj["offLineCount"]=offLineCount;
									baseInfoObj["offLineTime"]= offLineTime;
									baseInfoObj["additionalDataCount"]= additionalDataCount;
									baseInfoObj["additinalDataTime"]= additinalDataTime;
									baseInfoObj["runTimeOffLineCount"]= runTimeOffLineCount;
									baseInfoObj["runTimeOffLineTime"]= runTimeOffLineTime/1000;
									//基于以上信息获取的统计信息
									//补传率
									/* for(var j=0;j<allOffLinePoints.length;j++){
										totalOfflinePackCount+=allOffLinePoints[j];
									} */
									if(totalOfflinePackCount>0){
										uploadRate=additionalDataCount/totalOfflinePackCount
									}
									baseInfoObj["uploadRate"]=(uploadRate*100).toFixed(2);
									baseInfoObj["runTimeUploadRate"]=runTimeUploadRate;
									baseInfoArr.push(baseInfoObj);
								}
								//多图表&&列表渲染
								for (var i = 0; i < allGraphData.length; i++) {
									var graphData=allGraphData[i];
									setGraph(graphData['xTime'], graphData['allOffLinePoints'],graphData['allAdditionalPoints'],graphData['allRuntimePoints'], baseInfoArr[i]);

								}
							}
						}
					});

		}
		//==================================数据处理相关函数===================================
	   function constructRuntimeValue(runtimeArr,xTime,yValue){
		   var isExistYAxisSet=[];
		   var isExistAndTimePointObj={};
		   for (var i = 0; i < runtimeArr.length; i++) {
			   curMin=runtimeArr[i];
			   isExistAndTimePointObj[curMin]=yValue
		   }
		   for (var i = 0; i < xTime.length; i++) {
				var xtime = xTime[i];
				if (isExistAndTimePointObj[xtime]) {
					isExistYAxisSet.push(isExistAndTimePointObj[xtime])
				} else {
					isExistYAxisSet.push(0);
				}
			}
		   return isExistYAxisSet;
		}
		/**构造点纵坐标集
		* @param featurePackPerMinMapArr  数组,存放待处理信息 形如：[15:24:13~15:24:56~14,……],开始时间~结束时间~离线包数
		* @param xTime 数组，由时间点（h:mi）字符串组成
		* @return
		*/
		function constructYAxisSet(featurePackPerMinMapArr,xTime){
			//step1:变量声明
			//返回值
			var featureYAxisSet=[];
			//逻辑处理寄存参数
			var featurePackAndTimePointObj={};//分钟段开始分钟点(X轴横坐标)-特征包数(Y轴纵坐标)
			var preFeatureStime = '';//前一个特征（补传、离线）时间,用于合并处于同一分钟段，但时间不连续的多个特征时间的合并
			//step2:点集处理
			//work1:合并处于同一分钟段，但时间不连续的多个特征包数的合并，如[14:23:12,14:23:34]有5个离线包，[14:23:40,14:23:44]有1个离线包，[14:23:50,14:23:58]有3个离线包,三者都合并到[14:23:00,14:24:00),总计9个离线包
			for (var i = 0; i < featurePackPerMinMapArr.length; i++) {
				var featureStimeCurMin = featurePackPerMinMapArr[i].substring(0, 5); //发生事件的某分钟第1秒~59秒的具体开始点（[17:58:00,17:59:00)中发生了离线时间，具体开始时间点是17:58:15）
				var featureEtimeCurMin = featurePackPerMinMapArr[i].substring(9, 14);//发生事件的某分钟第1秒~59秒的具体结束点（[17:58:00,17:59:00)中发生了离线时间，具体开始时间点是17:58:55）
				var featurePackNumCurMin =featurePackPerMinMapArr[i].substring(18); //发生时间段内特征包数（[17:58:15,17:58:55]离线包10个）
				if (preFeatureStime == featureStimeCurMin) {
					featurePackAndTimePointObj[featureStimeCurMin] = featurePackAndTimePointObj[featureStimeCurMin]+ featurePackNumCurMin / 1;//上一个发生时间段内特征包数（[17:58:15,17:58:55]离线包10个<==>[17:58:00,17:59:00)离线包10个）
				} else {
					featurePackAndTimePointObj[featureStimeCurMin] = featurePackNumCurMin / 1;
				}
				preFeatureStime = featureStimeCurMin;

			}
			//work2:根据横坐标,匹配（根据时间点匹配，到分钟）对应的纵坐标,若无匹配的纵坐标,填充纵坐标为0（无特征包）
			for (var i = 0; i < xTime.length; i++) {
				var xtime = xTime[i];
				if (featurePackAndTimePointObj[xtime]) {
					featureYAxisSet.push(featurePackAndTimePointObj[xtime])
				} else {
					featureYAxisSet.push(0);
				}
			}
			//step3:返回处理结果
			return featureYAxisSet;
		}
		//=============================================图表渲染相关函数==============================
			/**
			* @param xTime 数组，由时间点（h:mi）字符串组成
			* @param allOffLinePoints 	  数组，数字组成，存放离线包数
			* @param allAdditionalPoints 数组，数字组成，存放补传包数
			* @param infoObj			 {} ，存放基础信息
			* @return
			*/
			function setGraph(xTime, allOffLinePoints, allAdditionalPoints,allRuntimePoints,infoObj) {
			//step1.构造图表容器
			//构造图表和基础信息列表节点所在父级节点
			var singleViewId=createNewDom(mainDivId,'div','singleView',{width:'100%',border:'1px solid #3399CC','margin\-bottom':'10px'});//-需要转义
			//构造图表所在节点
			var chartId=createNewDom(singleViewId,'div','chart',{width:'calc(100% - '+baseInfoListWidth+')'});
			//step2.echarts图表渲染
			var myChart = echarts.init(document.getElementById(chartId));
			var option = {
				title : {
					left: 'left',
					text : infoObj["workDateStr"] + ' 车牌号:' + infoObj["busBrandNo"],
					subtext : '下线次数:' + infoObj["offLineCount"]
				},
				   tooltip: {
				        trigger: 'axis',
				        axisPointer: {
				            type: 'cross'
				        }
				    },
				 grid:{
				   right:'3%',
				   left:'3%'
                   /*  x:50,
                    y:50,
                    x2:50,
                    y2:50, 
                    borderWidth:1*/
	            },
				color:['#FF6666','#3399CC','#9900FF','#33FF00','#339933','#666666'],
				toolbox : {
					show : true,
					feature : {
			            restore: {show: true},
			            saveAsImage: {show: true},
			            magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						}
					}
				},
			    legend: {
	    	        data:['离线包数','补传包数','计划运营时间']
	    	    },
				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : xTime
				},
				yAxis : {
					type : 'value',
					axisLabel : {
						formatter : '{value}'
					},
					axisPointer : {
						snap : true
					} 
				},
				dataZoom : [ {
					type : 'inside'
				} ],
				series : [ {
					name : '离线包数',
					type : 'line',
					smooth : true,
					data : allOffLinePoints,
					itemStyle : {
						normal : {
							areaStyle : {
								type : 'default'
							}
						}
					}
				}, {
					name : '补传包数',
					type : 'line',
					smooth : true,
					data : allAdditionalPoints,
					itemStyle : {
						normal : {
							areaStyle : {
								type : 'default'
							}
						}
					}
				},{
		            name:'计划运营时间',
		            type:'line',
		            data:allRuntimePoints
		        }
				]
			};
			myChart.setOption(option);
			//step3.构造基础信息列表所在节点&&渲染基础信息列表
			setBaseInfoList(singleViewId,infoObj);
			
		}
		/**基础信息列表渲染
		* @param fatherContainerId 	   列表展示区所在节点依附的父级节点ID
		* @param infoObj			 {} ,存放待展示基础信息
		* @return
		*/
		function setBaseInfoList(fatherContainerId,infoObj){
			var html="<div>"
				+	"<table class='table'>"
				+ 		"<thead><tr><th>信息</th><th>取值</th></tr></thead>"
				+		"<tbody style='100%'>"
				+			" <tr><td>营运日期</td><td>"+infoObj["workDateStr"]+"</td></tr>"
				+			" <tr><td>车辆编号</td><td>"+infoObj["busCode"]+"</td></tr>"
				+			" <tr><td>车辆自编号</td><td>"+infoObj["busCusCode"]+"</td></tr>"
				+			" <tr><td>车牌号</td><td>"+infoObj["busBrandNo"]+"</td></tr>"
				+			" <tr><td>设备品牌</td><td>"+infoObj["deviceBrand"]+"</td></tr>"
				+			" <tr><td>设备型号</td><td>"+infoObj["deviceType"]+"</td></tr>"
				+			" <tr><td>使用日期</td><td>"+infoObj["useDateStr"]+"</td></tr>"
				+			" <tr><td>离线次数</td><td>"+infoObj["offLineCount"]+"</td></tr>"
				+			" <tr><td>离线时长</td><td>"+infoObj["offLineTime"]+"s</td></tr>"
				+			" <tr><td>补传包数</td><td>"+infoObj["additionalDataCount"]+"</td></tr>"
				+			" <tr><td>补传时长</td><td>"+infoObj["additinalDataTime"]+"s</td></tr>"
				+			" <tr><td>补传率</td><td>"+ infoObj["uploadRate"]+"%</td></tr>"
				+			" <tr><td>营运时段离线次数</td><td>"+infoObj["runTimeOffLineCount"]+"</td></tr>"
				+			" <tr><td>营运时段离线时长</td><td>"+infoObj["runTimeOffLineTime"]+"s</td></tr>"
				+			" <tr><td>营运时段补传率</td><td>"+ infoObj["runTimeUploadRate"]+"%</td></tr>"
				+		"</tbody>"
				+	"</table>"
				+'<div>';
			//根据以上html生成节点并设置属性
			var container = document.getElementById(fatherContainerId); 
			var childs=$(html);
			var child=childs[0];
			var listId="list"+"-"+new Date().getTime();
			child.id=listId;
			child.style.width=baseInfoListWidth;
			child.style.height=chartContainerHeight;
			child.style.float='left';
			container.appendChild(child);   
		}
		/**
		* 创建节点
		* @param fatherContainerId   待创建节点依附的父级节点ID
		* @param domName			   待创建节点类型,满足方法 html方法document.createElement(节点类型)的取值即可;
		* @param idSuffix			   待创建节点ID前缀 
		* @param style			  	   待创建节点样式  对象，key-value形式(选填)
		* @return
		*/
		function createNewDom(fatherContainerId,domName,idSuffix,style){
			var container = document.getElementById(fatherContainerId); 
			var newDom = document.createElement(domName);
			//为新创建节点设置属性
			var newDomId=idSuffix+"-"+new Date().getTime();
			newDom.id=newDomId;
		    //设置默认样式
		    newDom.style.width='100%';
		    newDom.style.height=chartContainerHeight;
		    newDom.style.float='left';
		    //用户自定义样式
		    if(style){
		    	 for(var key in style){
		    		 newDom['style'][key]=style[key];
				 }
		    }
		    //拼接节点
		    container.appendChild(newDom);  
		    //返回新建节点ID
		    return newDomId;
		} 
		/**
		* 删除节点 删除某节点下所有子节点
		* @param fatherContainerId   待删除节点依附的父级节点ID
		* @return
		*/
		function clearCurGraphs(fatherContainerId){
			var container = document.getElementById(fatherContainerId);
			//获取待删除节点个数
			var originalLength=container.childNodes.length
			var originalChildDom=[];
			//存储所有待删除节点
			for (var i = 0; i <originalLength ; i++) {
				originalChildDom.push(container.childNodes[i]);
			}
			//删除以上节点
			for (var i = 0; i <originalLength ; i++) {
				container.removeChild(originalChildDom[i]);
			}
		}
	</script>
	
</body>
</html>