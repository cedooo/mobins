<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>移动应用巡检</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="巡检">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
	<link href="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/jquery-ui.css" rel="stylesheet">
	<script src="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/external/jquery/jquery.js"></script>
	<script src="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/jquery-ui.js"></script>
	<script src="<%=basePath%>js/dependency/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript">
		$(function(){
			loadTarget();
			$("#target").change(loadHost);
			//$.datepicker.setDefaults( $.datepicker.regional[ "zh-CN" ] );
		    $( "#insDate" ).datepicker({
		    	dateFormat : "yy-mm-dd",
		    	showAnim : "slideDown"
		    })
			.datepicker('setDate', new Date());
	     	$("#query")
	     		//.button()
	     		.click(loadReport);
		});
		function loadTarget(){
			$.ajax({
			  url: "<%=basePath%>report/targetList.action",
			  context: document.body
			}).done(function(data ) {
				var lenOfData = data.listTarget.length;
				for(var i=0; i< lenOfData; i++){
					  targetsName =  data.listTarget[i].targetName;
					  targetsID = data.listTarget[i].targetID;
					  $("#target").append("<option value='" + targetsID + "'>" + targetsName + "</option>");
				}
				loadHost();
			});
		}
		function loadHost(){
			$("#host option").remove();
			var targetID = $("#target").val();
			$.ajax({
			  url: "<%=basePath%>report/hostListOfTarget.action?targetID=" + targetID,
			  context: document.body
			}).done(function(data ) {
				var lenOfData = data.listHost.length;
				if(lenOfData){
					for(var i=0; i< lenOfData; i++){
						mobDestHostIP =  data.listHost[i].mobDestHostIP;
						mobDestHostID = data.listHost[i].mobDestHostID;
						var hostType = "";
						if(data.listHost[i].hostType == 1){
							hostType = "主";
						}else if(data.listHost[i].hostType == 0){
							hostType = "备";					
						}
						  $("#host").append("<option value='" + mobDestHostID + "'>" + mobDestHostIP + " (" + hostType + ")</option>");
					}
				}
			});
		}
		function loadReport(){
			var hostID =  $("#host").val();
			var reDate = $("#insDate").val();
			if(hostID>0){
				$.ajax({
					  url: "<%=basePath%>report/reportList.action?hostID=" + hostID + "&formatDate=" + reDate,
					  context: document.body
					}).done(function(data ) {
						var lenOfData = data.listReport.length;
						if(lenOfData){
							$("#reports *").remove();
							
							for(var i=0; i< lenOfData; i++){
								$("#reports").append("<hr />");
								//$("#reports").append("<hr />");
								//{"generateTime":"2014-08-05 18:00:53.61","inspectionIsException":null,
									//"inspectionReportID":"37","inspectionTime":"2014-08-05 18:00:53.61",
									//"maintAccount":"root","maintUser":"root","mobDestHostID":"3"}
								var reportID = data.listReport[i].inspectionReportID;
								var generateTime = data.listReport[i].generateTime;
								var inspectionTime = data.listReport[i].inspectionTime;
								var maintUser = data.listReport[i].maintUser;
								var inspectionIsException = data.listReport[i].inspectionIsException;
								var hostInfo = $("#target").find("option:selected").text()  + 
									$("#host").find("option:selected").text() ;
								
								var tabID = "report" + reportID;
								$("#reports").append(
											"<table class='headReport gridtable'><tr><td>主机信息</td><td>" + hostInfo + 
											//"<td>生成时间</td>" + "<td>" + generateTime + "</td>" + 
											"</td><td>运维帐号</td><td>" +  maintUser +   
											"</td><td>是否异常 </td><td>" +  inspectionIsException +  
											"</td><td>巡检时间</td><td>" + inspectionTime + "</td></tr></table>"
										); 
								$("#reports").append(
										"<table class='gridtable' id='" + tabID+ "'>" + 
										"</table>"
									); 
								loadRecord($("#" + tabID), reportID);
							}
							$("#querInfo").html("共" + lenOfData + "条巡检报告");
						}else{
							$("#querInfo").html("无巡检报告");
						}
					});
			}else{
				$("#querInfo").html("请选择主机");
			}
		}
		function loadRecord($context, reportID){
			$.ajax({
				  url: "<%=basePath%>report/recordListOfReport.action?inspectionReportID=" + reportID,
				  context: document.body
				}).done(function(data ) {
					var lenOfData = data.listRecord.length;
					var htmlColName = "<tr>" +
							"<th>巡检类型</th>" + "<th>检查项目</th>" + "<th>检查点</th>" +"<th>操作说明</th>" + "<th>是否异常</th>" +
							"<th>巡检结果</th>" + "<th>操作结果</th>" +
						"</tr>";
					$context.append(htmlColName);
					if(lenOfData){
						for(var i=0; i< lenOfData; i++){
							/*
addTime: "2014-08-05 18:00:53.617"
checkCode: "DF-H"
checkItem: "硬盘使用情况"
checkNote: "检查可用空间"
checkPoint: "检查存储可用空间(70%以下为正常)"
checkResult: null
dealResult: null
inspectionRecordsID: "21"
inspectionReportID: "37"
inspectionType: "硬件巡检"
isException: null
operNote: "执行df -h命令"
protoData: "Filesystem 
							*/
							var checkItem = data.listRecord[i].checkItem;
							var checkPoint = data.listRecord[i].checkPoint;
							var operNote = data.listRecord[i].operNote;
							var isException = data.listRecord[i].isException;
							var checkResult = data.listRecord[i].checkResult;
							var protoData = data.listRecord[i].protoData;
							var inspectionType = data.listRecord[i].inspectionType;
							
							var trTag = "<tr class='normal'>";
							if(isException=="异常"){
								trTag = "<tr class='highlight'>";
							}else if(isException==null){
								trTag = "<tr class='errors'>";								
							}
							var htmlRecord = trTag + 
								"<td>" + inspectionType + "</td>" + 
								"<td>" + checkItem + "</td>" + 
								"<td>" + checkPoint + "</td>" + 
								"<td>" + operNote + "</td>" + 
								"<td>" + isException + "</td>" + 
								"<td>" + checkResult + "</td>" + 
								"<td>" + protoData + "</td>" + 
								"</tr>";
							$context.append(htmlRecord);
							//$context.append("<pre>" + protoData + "</pre>");
						}
					}else{
						$("#querInfo").html("reportID = " +  reportID + "的巡检无巡检记录");
					}
				});
		}
	</script>
	<style type="text/css">
		body{
			padding: 0;
			margin:0;
		}
		div.opos{
	    	padding: 0 0.5%;
		}
	    .report{
	    	min-height: 15px;
	    	padding: 0 0.5%;
	    }
	    table[id^="report"] {
			width: 100%;
	    }
	    table[id^="report"] *{
	    	padding-top: 5px;
			border: 1px solid;
	    }
	    table[id^="report"] tr.normal{
	    	color: green;
	    }
	    table[id^="report"] tr.highlight{
	    	color: red;
	    }
	    table[id^="report"] tr.errors{
	    	color: gray;
	    }
	    
	    table.headReport{
	    	width:100%;
			border: 0px solid;
			text-align: left;
	    }
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
	</style>
  </head>
  
  <body>
  		<div class="opos">
			<select id="target"></select>
			<select id="host"></select>
			<input type="text" id="insDate" size="30">
			<button id="query">查询</button>
			<span id="querInfo"></span>
		</div>
		<div id="reports" class="report" ></div>
  </body>
</html>
