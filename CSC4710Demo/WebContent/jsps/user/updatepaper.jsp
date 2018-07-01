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
  <h1>Modify Papers</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	Paper Name to Search:<input type="text" name="papern" value="${form.papern }"/>
	<span style="color: red; font-weight: 900">${errors.papern }</span>
	<br/>
	Title Change:<input type="text" name="title" value="${form.title }"/>
	<span style="color: red; font-weight: 900">${errors.title }</span>
	<br/>
	Abstract Change：<input type="text" name="abs" value="${form.abs }"/>
	<span style="color: red; font-weight: 900">${errors.abs }</span>
	<br/>
	PDF Change：<input type="text" name="pdf" value="${form.pdf }"/>
	<span style="color: red; font-weight: 900">${errors.pdf }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
<h1>Delete Paper</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	Paper Name:<input type="text" name="papern" value="${form.papern }"/>
	<span style="color: red; font-weight: 900">${errors.papern }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
  </body>
</html>