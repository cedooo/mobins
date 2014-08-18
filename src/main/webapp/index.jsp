<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<frameset rows="25%,50%,25%">
  <frame src="<%=basePath%>report/default.action" />
  <frame src="<%=basePath%>report/default.action" />
  <frame src="<%=basePath%>report/default.action" />
</frameset>

</html>