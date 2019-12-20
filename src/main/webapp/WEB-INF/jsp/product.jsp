<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>

<head>
    <link rel="stylesheet" src="static/css/product.css" />
</head>

<h3>
    <core:forEach items="${currentCategory.translationCategory}" var="translation">
        <core:if test="${translation.language.code==locale}">${translation.name}</core:if>
    </core:forEach>
</h3>

<core:forEach items="${products}" var="product">
    <core:forEach items="${product.translationProducts}" var="translation">
        <core:if test="${translation.language.code==locale}">
            <div class="product-container">
                <a class="product-index-link" href="/products/${product.id}"><p class="product-name">${translation.name}</p></a>
                <p class="product-price"><spring:message code="price"/> : ${product.price} €</p>
                <core:if test="${product.isAvailable()}">
                    <form class="product-add-form" action="/shopping-cart/add/${product.id}" method="get">
                        <spring:message code="quantity"/> :


                        <input type="number" name="quantity" value="1" required min="1" max="${product.stock}"
                               oninvalid="this.setCustomValidity('${quantityError}')"
                               oninput="this.setCustomValidity('')"/>

                        <input type="hidden" name="origin" value="/categories/${currentCategory.id}"/>
                        <button type="submit"><spring:message code="addToBasket" /></button>
                    </form>
                </core:if>
                <core:if test="${!product.isAvailable()}">
                    <p class="product-sold-out"><spring:message code="soldOut"/></p>
                </core:if>
            </div>
        </core:if>
    </core:forEach>
</core:forEach>