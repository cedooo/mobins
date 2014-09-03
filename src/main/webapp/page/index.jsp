<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>巡检配置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="巡检配置">
	<!-- JQuery CSS -->
	<%@ include file="/page/them.jsp" %>
	<!-- jqGrid CSS -->
	<link rel="stylesheet" href="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/css/ui.jqgrid.css" type="text/css" /> 
	 
	<!-- The jqGrid language file code-->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/js/i18n/grid.locale-cn.js" ></script>
	<!-- The atual jqGrid code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/js/jquery.jqGrid.min.js" ></script>
	
	<script type="text/javascript">
	
		$(function(){
		    $( "#tabs" ).tabs();
		});
	
	</script>
	<style type="text/css">
		.delBtn{
			color: red;
		}
		.act{
			float:left;
			margin-left:5px;
		}
		.act:hover{
			cursor:pointer;
		}
		body{
			padding:1% 1%;
			font-size: 66%;
		}
		table{
			width: 100%;
		}
	</style>
	
  </head>
  
	<body>
		<!-- 
		<button class="backBtn" onclick="javascript:window.history.go(-1);">返回</button>
		-->
		
		<div id="tabs">
		  <ul>
		    <li><a href="<%=basePath %>setting/targetJSP">巡检目标</a></li>
		    <li><a href="<%=basePath %>setting/strageJSP">巡检策略</a></li>
		    <li><a href="<%=basePath %>setting/strageApplyJSP">策略应用</a></li> 
		    <li><a href="<%=basePath %>report/reportJSP">巡检记录</a></li>
		  </ul>
		  <div id="tabs-4">
		  </div>
		</div>
		
	</body>
</html>
