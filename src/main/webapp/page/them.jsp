<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String tpath = request.getContextPath();
String tbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+tpath+"/";
String [] them = {"Sunny", "Overcast", "Pepper", "Eggplant", "BlackTie", "Redmond", "Excite"};
int themIndex = 5;// (int)(Math.random()*10)%6;    //主题 序号
%>
<link href="<%=tbasePath%>js/dependency/jquery-ui-1.11.1.custom.<%=them[themIndex] %>/jquery-ui.css" rel="stylesheet">
<script src="<%=tbasePath%>js/dependency/jquery-ui-1.11.1.custom.<%=them[themIndex] %>/external/jquery/jquery.js"></script>
<script src="<%=tbasePath%>js/dependency/jquery-ui-1.11.1.custom.<%=them[themIndex] %>/jquery-ui.js"></script>
<style type="text/css">
	table td {
		font-size:12px;
	}
	table th {
		font-size:14px;
	}
	body{
		background: #DFE9F3;
	}
		table.gridtable th {
			background-color: #DFE9F3;
		}
</style>