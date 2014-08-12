<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
{ 
  "total": "12", 
  "page": "1", 
  "records": "12",
  "rows" : [
    <!-- {"id" :"1", "cell" :["cell11", "cell12", "cell13"]}, -->
	<s:iterator value="listTarget" status="tar">
	    {
	    "id" : "<s:property value="targetID" />",
	     "cell" : [ "<s:property value="targetName" />", "<s:property value="targetNote" />",
	     "<s:property value="targetAddTime" />", "<s:property value="targetDelTime" />"]
	     }
	     <s:if test="!#tar.last">,</s:if>
	</s:iterator>
  ]
}