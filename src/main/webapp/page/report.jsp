<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>移动应用巡检</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="巡检">
  
	
	<script src="<%=basePath%>js/dependency/jquery.ui.datepicker-zh-CN.js"></script>
	
	<link href="<%=basePath%>css/default.css" rel="stylesheet">
	<script type="text/javascript">
		$(function(){
			loadTarget();
		    $( "#insDate" ).datepicker({
		    	dateFormat : "yy-mm-dd",
		    	showAnim : "slideDown",
		    	maxDate: "+0D"
		    })
			.datepicker('setDate', new Date())
			.change(loadReport);

			$("#target").selectmenu({change:loadHost});
			$("#host").selectmenu({change:loadReport});
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
						//var hostType = "";
						if(data.listHost[i].hostType == 1){
							hostType = "主";
						}else if(data.listHost[i].hostType == 0){
							hostType = "备";					
						}
						  $("#host").append("<option  value='" + mobDestHostID + "'>" + mobDestHostIP 
								  //+ " (" + hostType + ")"
								  + "</option>");
					}
				}
				$("#target").selectmenu("refresh");
				$("#host").selectmenu("refresh");
				loadReport();
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
								$("#reports").append("<br />");
								var reportID = data.listReport[i].inspectionReportID;
								//var generateTime = data.listReport[i].generateTime;
								var inspectionTime = data.listReport[i].inspectionTime;
								var maintUser = data.listReport[i].maintUser;
								var inspectionIsException = data.listReport[i].inspectionIsException;
								var inspectionComplete = data.listReport[i].inspectionComplete;
								var hostInfo = $("#target").find("option:selected").text()  + $("#host").find("option:selected").text() ;
								var hostIP = data.listReport[i].mobDestHostIP;
								hostInfo = $("#target").find("option:selected").text() + (hostIP?hostIP:"");
								
								var tabID = "report" + reportID;
								$("#reports").append(
											"<table class='headReport gridtable'><tr><td>主机信息</td><td>" + hostInfo + 
											//"<td>生成时间</td>" + "<td>" + generateTime + "</td>" + 
											"</td><td>运维帐号</td><td>" +  maintUser +   
											"</td><td>是否异常 </td><td>" +  inspectionIsException +  
											"</td><td>巡检完成情况 </td><td>" +  inspectionComplete +  
											"</td><td>巡检时间</td><td>" + inspectionTime + "</td></tr></table>"
										); 
								$("#reports").append(
										"<table class='gridtable' id='" + tabID+ "'>" + 
										"</table>"
									); 
								loadRecord($("#" + tabID), reportID);
							}
							$("#querInfo").html($("#host").find("option:selected").text()  + ",共" + lenOfData + "条巡检报告");
						}else{
							$("#querInfo").html($("#host").find("option:selected").text()  + ",无巡检报告");
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
					if(lenOfData){
						var htmlColName = "<tr>" +
								"<th>类型</th>" + "<th>检查项目</th>" + "<th>检查点</th>" +"<th>操作说明</th>" + "<th>是否正常</th>" +
								"<th>巡检结果</th>" + "<th>操作结果</th>" +
							"</tr>";
						$context.append(htmlColName);
						for(var i=0; i< lenOfData; i++){
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
						}
					}else{
						$context.append("<tr><td colspan=7 align='center'>无巡检项记录</td></tr>");
					}
				});
		}
		function setting(){
			window.location.href = "<%=basePath%>setting/defaults";
		}
		$(function(){
			$( ".cnfBtn" ).button({
			      icons: {
			        primary: "ui-icon-gear"
			      }
			    });
			$( "#query" ).button({
			      icons: {
			        primary: "ui-icon-search"
			      }
			    });
		});
	</script>
	<style type="text/css">
		table.gridtable tr:odd{
		    background-color: #F3F3F3;
		}
	</style>
  </head>
  
  <body>
  		<div class="opos">
			<select id="target"></select>
			<select id="host"></select>
			<input class="mytxt" type="text" id="insDate" size="20">
			<!-- <span id="querInfo"></span> -->
			<div class="ui-state-highlight ui-corner-all" style="padding: .5em .7em;">
				<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
				<span id="querInfo"></span>
			</div>
		</div>
  			<!-- <button onclick="setting()" class="cnfBtn">配置</button> -->
		<div id="reports" class="report" ></div>
  </body>
</html>
