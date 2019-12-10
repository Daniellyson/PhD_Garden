<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>

<head>
    <link rel="stylesheet" href="<spring:url value='static/css/home.css' />">
</head>



<div id="category">
    <div id="category-center">
        <core:forEach items="${categories}" var="category">
            <div class="card-body">
                <h5 class="card-title">
                        ${category.getName()}
                </h5>
                <img class="pics" src="static/img/${category.getName()}.jpg" />
            </div>
        </core:forEach>
    </div>
</div>
