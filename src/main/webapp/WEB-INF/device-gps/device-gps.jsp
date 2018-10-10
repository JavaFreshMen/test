<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/css/jquery-ui-1.12.1/jquery-ui.min.css"  />
<link rel="stylesheet" type="text/css" href="../common/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../common/css/selectpage.base.css" media="all">
<link rel="stylesheet" type="text/css" href="../common/css/selectpage.css" >
<link rel="stylesheet" type="text/css" href="../common/css/b.dialog.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../common/css/b.dialog.bootstrap3.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../common/css/font-awesome.min.css" />
<link rel="stylesheet" href="../common/css/bootstrap-datetimepicker.min.css" media="screen">
<title>GPS</title>
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
    <div id="main" style=width:100%;height:400px;"></div>
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
    <script type="text/javascript">
		$(function() {
			if(!global_busStore){
				initGlobalStore();
			}
		});
		//样式全局变量
		var chartContainerHeight='450px';//图表父容器高度
		var baseInfoListWidth='0px';	 //基础信息列表宽度
		var mainDivId='main';			 //所有图表、列表展示区直接父级div元素
    	
    	function openSearchWin(){
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
			//弹出框
			var msgDialog = openBDialog("GPS设备离线、补传明细查询",html);
			//控件绑定
		    setDatePlugin('startWorkDate');
		    setDatePlugin('endWorkDate');
		    setSelectPagePlugin('busCode','busBrandNo','busCode',global_busStore)
			//提交
			$('#searchForm').submit(function(e){
				try{
					//表单数据
					var formDatas = transFormData($(e.currentTarget).serializeArray());
					var busCode = formDatas["busCode"];
					var startWorkDate = formDatas["startWorkDate"];
					var endWorkDate = formDatas["endWorkDate"];
					//非空校验
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
    		ajaxUtils(deviceGps_readUrl,{
	    		data:{startWorkDate:startWorkDate,endWorkDate:endWorkDate,busCode:busCode},
	    		success:function(data,textStatus){
	                if(data.success){
	                	//step1.变量声明
						//图表展示数据 基础信息
	                	var busBrandNo=null;
	                	var workDateArr=[];
	                    var offlineCountArr=[];
	                    var addtionalCountArr=[];
	                    var baseInfoObj={};//基础信息封装对象
	                    //用于计算、逻辑判断的基础数据
	                   /*  var offlineMax=0;  //离线纵轴最大值		
	                    var addtionalMax=0;//补传纵轴最大值	 */	
	                    //step2.获取待处理数据
	                	for(var i = 0; i < data.data.length; i++){
	                		var item=data.data[i];
	                		busBrandNo=item["busBrandNo"];
	                		workDateArr.push(item["workDateStr"]);
	                		offlineCountArr.push(item["offLineCount"]);
	                		addtionalCountArr.push(item["additionalDataCount"]);
	                		/* //获取离线、补传纵轴最大值		
	                		if(item["offLineCount"]>offlineMax){
	                			offlineMax=item["offLineCount"];
	                		}
	                		if(item["additionalDataCount"]>addtionalMax){
	                			addtionalMax=item["additionalDataCount"];
	                		} */
	                	}
	                    //封装基础信息
	                    baseInfoObj['startWorkDate']=startWorkDate;
	                    baseInfoObj['endWorkDate']=endWorkDate;
	                    baseInfoObj['busBrandNo']=busBrandNo;
	                    //渲染图表
	                	setGraph(baseInfoObj,workDateArr,offlineCountArr,addtionalCountArr);
	                }
	            }
    		});
    		
    	}
		//=============================================图表渲染相关函数==============================
		/**
		* @param baseInfoObj 数组，由时间点（h:mi）字符串组成
		* @param workDateArr 	  数组，数字组成，存放离线包数
		* @param offlineCountArr 数组，数字组成，存放补传包数
		* @param addtionalCountArr			 {} ，存放基础信息
		* @return
		*/
    	function setGraph(baseInfoObj,workDateArr,offlineCountArr,addtionalCountArr){
			//step1.构造图表容器
			//构造图表和基础信息列表节点所在父级节点
    		var singleViewId=createNewDom(mainDivId,'div','singleView',{width:'100%',border:'1px solid #3399CC','margin\-bottom':'10px'});
    		//构造图表所在节点
			var chartId=createNewDom(singleViewId,'div','chart',{width:'calc(100% - '+baseInfoListWidth+')'});
			//step2.echarts图表渲染
    		var myChart = echarts.init(document.getElementById(chartId));
	    	var colors = ['#FF6666','#3399CC','#d14a61','#5793f3','#675bba','#98a445'];
	    	option = {
    			title : {
					left: 'left',
					text :baseInfoObj['startWorkDate']+'~'+baseInfoObj['endWorkDate']+" "+ baseInfoObj['busBrandNo']+' 离线及补传次数'
				},
	    	    color: colors,
	    	    tooltip: {
	    	        trigger: 'axis',
	    	        axisPointer: {
	    	            type: 'cross'
	    	        }
	    	    },
	    	    grid: {
	    	        right: '5%',
	    	        left: '3%'
	    	    },
	            magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
	    	    toolbox: {
	    	        feature: {
	    	            dataView: {show: true, readOnly: false},
	    	            restore: {show: true},
	    	            saveAsImage: {show: true},
			            magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						}
	    	        }
	    	    },
	    	    legend: {
	    	        data:['离线次数','补传次数']
	    	    },
	    	    xAxis: [
	    	        {
	    	            type: 'category',
	    	            axisTick: {
	    	                alignWithLabel: true
	    	            },
	    	            data:workDateArr
	    	        }
	    	    ],
	    	    yAxis: [
	    	        {
	    	            type: 'value',
	    	            name: '离线次数',
	    	            min: 0,
	    	            //max: offlineMax,
	    	            position: 'left',
	    	            axisLine: {
	    	                lineStyle: {
	    	                    color: colors[0]
	    	                }
	    	            },
	    	            axisLabel: {
	    	                formatter: '{value}次'
	    	            }
	    	        },
	    	        {
	    	            type: 'value',
	    	            name: '补传次数',
	    	            min: 0,
	    	            //max: addtionalMax,
	    	            position: 'right',
	    	            offset: 10,
	    	            axisLine: {
	    	                lineStyle: {
	    	                    color: colors[1]
	    	                }
	    	            },
	    	            axisLabel: {
	    	                formatter: '{value} 次'
	    	            }
	    	        }
	    	    ],
	    	    series: [
	    	        {
	    	            name:'离线次数',
	    	            type:'bar',
	    	            data:offlineCountArr
	    	        },
	    	        {
	    	            name:'补传次数',
	    	            type:'bar',
	    	            yAxisIndex: 1,
	    	            data:addtionalCountArr
	    	        },
	    	    ]
	    	};
	    	myChart.setOption(option);
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