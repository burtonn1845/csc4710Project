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
<form action="<c:url value='/UserServletUpdaterev'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	Report ID to Search:<input type="text" name="rid" value="${form.rid }"/>
	<span style="color: red; font-weight: 900">${errors.rid }</span>
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
<form action="<c:url value='/UserServletDeleterev'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	Report ID:<input type="text" name="rid" value="${form.rid }"/>
	<span style="color: red; font-weight: 900">${errors.rid }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
<h1>New Review</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletNewrev'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	Date:<input type="text" name="date" value="${form.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	Comment：<input type="text" name="comment" value="${form.comment }"/>
	<span style="color: red; font-weight: 900">${errors.comment }</span>
	<br/>
	Recommendation：<input type="text" name="recomend" value="${form.recomend }"/>
	<span style="color: red; font-weight: 900">${errors.recomend }</span>
	<br/>
	Paper ID：<input type="text" name="paperid" value="${form.paperid }"/>
	<span style="color: red; font-weight: 900">${errors.paperid }</span>
	<br/>
	Reviewer Email：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
  </body>
</html>