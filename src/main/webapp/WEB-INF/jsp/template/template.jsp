<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="../include/importTags.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="<spring:url value='/css/main.css' />"
          rel="Stylesheet">
    <title>${title}</title>
</head>
<body>
    <div><tiles:insertAttribute name="header" /></div>

    <!--<div>
        <tiles:insertAttribute name="main-content" />
    </div>-->

    <div><tiles:insertAttribute name="footer" /></div>
</body>
</html>