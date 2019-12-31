<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/importTags.jsp"%>


<div id="category">
    <div id="category-center">
        <h2> <spring:message code="category" /></h2>
        <core:forEach items="${categories}" var="category">
            <core:forEach items="${category.getTranslationCategory()}" var="translation">
                <core:if test="${translation.language.code==locale}">
                    <div class="card-body">
                        <h5 class="card-title">
                            <a href="/phD_Garden/products_Category/${category.id}" >${translation.getName()}</a>
                        </h5>
                        <a href="/phD_Garden/products_Category/${category.id}"><img class="pics" src="static/img/${category.getUrlImage()}.jpg" /></a>
                    </div>
                </core:if>
            </core:forEach>
        </core:forEach>
    </div>
</div>