<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="../include/importTags.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<core:url value="/static/bootstrap/css/bootstrap.min.shopping-cart.css" />">
    <link rel="stylesheet" href="<core:url value="/static/fonts/font-awesome.min.shopping-cart.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/shopping-cart.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/error.css" />">

</head>

<body>
<tiles:insertAttribute name="content" />
</body>
</html>
