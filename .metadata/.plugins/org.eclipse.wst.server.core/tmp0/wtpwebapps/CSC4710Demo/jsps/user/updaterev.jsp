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
  <h1>Modify Review</h1>
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
	Date Change:<input type="text" name="date" value="${form.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	Comment Change：<input type="text" name="comment" value="${form.comment }"/>
	<span style="color: red; font-weight: 900">${errors.comment }</span>
	<br/>
	Recommendation Change：<input type="text" name="recomend" value="${form.recomend }"/>
	<span style="color: red; font-weight: 900">${errors.recomend }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
<h1>Delete Review</h1>
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