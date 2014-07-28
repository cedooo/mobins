<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>404 Not Found-www.cedoo.tk</TITLE>
<META name="Keywords" content="cedoo 404" />
<META http-equiv=content-type content=text/html;charset=gb2312>
<META http-equiv=refresh content="15;URL = <%=basePath %>">

<link href="<%=basePath %>css/error-404.css" rel="stylesheet" type="text/css">

<SCRIPT type="text/javascript">
<!--
var rc=404;
var millSecond = 1000;
var totalTime = 15*millSecond;
var int=self.setInterval("clock()",millSecond);
function clock(){
	totalTime = totalTime - millSecond;
	var showTime = totalTime/millSecond;
	if(showTime > 0){
		document.getElementById("timeLeft").innerText=showTime;
	}
}
window.onload=function(){
	clock();
};
//-->
</SCRIPT>
<META content="MSHTML 6.00.2900.3199" name=GENERATOR></HEAD>
<BODY text=#000000 bgColor=#ffffff>
<TABLE cellSpacing=0 cellPadding=2 width="100%" border=0>
  <TBODY>
  <TR>
    <TD noWrap width="1%" rowSpan=3><B><FONT face=times color=#0039b6 
      size=10>C</FONT><FONT face=times color=#c41200 size=10>e</FONT><FONT 
      face=times color=#f3c518 size=10>d</FONT>
	  <FONT face=times color=#c41200 size=10>o</FONT>
	  <FONT face=times color=#c41200 size=10>o</FONT>
</B> 
    <TD>&nbsp;</TD></TR>
  <TR>
    <TD bgColor=#3366cc><FONT face=arial,sans-serif color=#ffffff><B>404 
      Error</B></FONT></TD></TR>
  <TR>
    <TD>&nbsp;</TD></TR></TBODY></TABLE>
<BLOCKQUOTE>
  <H1>没有找到您要访问的页面</H1>The requested URL was not found on this server. 
  <br />
  <FONT face=times color=#c41200 size=10 id="timeLeft"></FONT>s后返回首页
  <OL>
    <LI>请检查您输入的网址是否正确。 </LI>
    <LI>有可能我们的页面正在升级或维护。 </LI>
    <LI>您可以尝试访问以下链接。</LI>
	</OL>
	 <UL type="square" >      
		<LI><A href="javascript:window.history.go(-1);">上一页</A></LI>
	</UL>
</BLOCKQUOTE>
<TABLE cellSpacing=0 cellPadding=0 width="100%">
  <TBODY>
  <TR>
    <TD bgColor=#3366cc><IMG height=4 alt="cedoo" width=1></TD></TR></TBODY></TABLE>
</BODY>
</HTML>
