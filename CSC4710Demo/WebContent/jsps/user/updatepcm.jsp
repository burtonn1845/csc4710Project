<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Modify PC Members</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Modify PC Members</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	PC Member Name to Search:<input type="text" name="pcmembers" value="${form.pcmembers }"/>
	<span style="color: red; font-weight: 900">${errors.pcmembers }</span>
	<br/>
	PC Member Name Change:<input type="text" name="pcmember" value="${form.pcmember }"/>
	<span style="color: red; font-weight: 900">${errors.pcmember }</span>
	<br/>
	PC Member Email Change：<input type="text" name="pcemail" value="${form.pcemail }"/>
	<span style="color: red; font-weight: 900">${errors.pcemail }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
<h1>Delete PC Members</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	PC Member Name:<input type="text" name="pcmembers" value="${form.pcmembers }"/>
	<span style="color: red; font-weight: 900">${errors.pcmembers }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
  </body>
</html>