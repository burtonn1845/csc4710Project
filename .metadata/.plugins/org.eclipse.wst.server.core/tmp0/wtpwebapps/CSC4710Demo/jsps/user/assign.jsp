<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Assign Reviewers</title>
    
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
  <h1>Assign Reviewers</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletAssign'/>" method="post">
	<input type="hidden" name="method" value="assign"/>
	Paper Name:<input type="text" name="papername" value="${form.papername }"/>
	<span style="color: red; font-weight: 900">${errors.papername }</span>
	<br/>
	Reviewer #1：<input type="text" name="rev1" value="${form.rev1 }"/>
	<span style="color: red; font-weight: 900">${errors.rev1 }</span>
	<br/>
	Reviewer #2：<input type="text" name="rev2" value="${form.rev2 }"/>
	<span style="color: red; font-weight: 900">${errors.rev2 }</span>
	<br/>
	Reviewer #3：<input type="text" name="rev3" value="${form.rev3 }"/>
	<span style="color: red; font-weight: 900">${errors.rev3 }</span>
	<br/>
	<input type="submit" value="Submit"/>
</form>
  </body>
</html>