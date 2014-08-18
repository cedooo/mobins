<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String tpath = request.getContextPath();
String tbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+tpath+"/";
String [] them = {"Sunny", "Overcast", "Pepper"};
int themIndex = 0;    //主题 序号
%>
<link href="<%=tbasePath%>js/dependency/jquery-ui-1.11.1.custom.<%=them[themIndex] %>/jquery-ui.css" rel="stylesheet">
<script src="<%=tbasePath%>js/dependency/jquery-ui-1.11.1.custom.<%=them[themIndex] %>/external/jquery/jquery.js"></script>
<script src="<%=tbasePath%>js/dependency/jquery-ui-1.11.1.custom.<%=them[themIndex] %>/jquery-ui.js"></script>