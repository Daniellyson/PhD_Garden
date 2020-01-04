<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/importTags.jsp"%>

<core:if test="${errorCode == 404}">
    <div class="carousel slide" data-ride="carousel" id="carousel-1">
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active"><img class="w-100 d-block" src="<core:url value='/static/img/404.jpg'/>" alt="Slide Image">
                <a href="<core:url value='/' />" class="btn btn-dark rounded-pill py-2 btn-block">
                    <spring:message code="backHome"/>
                </a>
            </div>
        </div>
    </div>
</core:if>
<core:if test="${errorCode != 404}">
    <div class="carousel slide" data-ride="carousel" id="carousel-1">
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active"><img class="w-100 d-block" src="<core:url value='/static/img/404.jpg'/>" alt="Slide Image">
                <a href="<core:url value='/' />" class="btn btn-dark rounded-pill py-2 btn-block">
                    <spring:message code="backHome"/>
                </a>
            </div>
        </div>
    </div>
</core:if>