<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/importTags.jsp"%>

<h3>
    <core:forEach items="${currentCategory.translationCategory}" var="translation">
        <core:if test="${translation.language.code==locale}">${translation.name}</core:if>
    </core:forEach>
</h3>

<core:forEach items="${products}" var="product">
    <core:forEach items="${product.translationProducts}" var="translation">
        <core:if test="${translation.language.code==locale}">
            <div class="product-container">
                <div class="product-image">
                    <core:if test="${product.url_image!=null}">
                        <img class="pics" src="<core:url value='/static/img/${product.url_image}.jpg'/>" />
                    </core:if>
                </div>


                <core:set var="stockOut" value="${0}" />
                <core:set var="stockTaken" value="${0}" />
                <core:forEach items="${shoppingCart}" var="productStock">
                    <core:if test="${productStock.key == product}">
                        <core:set var="stockTaken" value="${productStock.value}" />
                        <core:if test="${productStock.value >= product.stock}">
                            <core:set var="stockOut" value="${1}" />
                        </core:if>
                    </core:if>
                </core:forEach>


                <details>
                    <summary class="product-name">${translation.product_name}
                        <core:if test="${stockOut == 0}">
                            (${product.stock - stockTaken})
                        </core:if>
                    </summary>
                    <p class="product-description">${translation.description}</p>
                </details>


                <p class="product-price">
                    <spring:message code="price"/> : ${product.price} €
                    <core:set var="percentageDiscount" value="${null}" />
                    <core:forEach items="${discounts}" var="discount">

                        <core:if test="${product.id == discount.key}">
                            <core:set var="percentageDiscount" value="${discount.value.percentage}" />
                            <span class="discounts"> (${discount.value.percentage}% <spring:message code="discount"></spring:message>) </span>
                        </core:if>
                    </core:forEach>
                </p>

                <core:if test="${stockOut == 0}">
                    <form class="product-add-form" action="/phD_Garden/shopping-cart/add/${product.id}" method="get">
                        <spring:message code="quantity"/> :


                        <input type="number" name="quantity" value="1" required min="1" max="${product.stock - stockTaken}"
                               oninvalid="this.setCustomValidity('<spring:message code="errorQuantity"/>' + ' (${product.stock - stockTaken})')"
                               oninput="this.setCustomValidity('')"/>

                        <input type="hidden" name="origin" value="/products_Category/${currentCategory.id}"/>

                        <input type="hidden" name="percentage" value="${percentageDiscount}"/>

                        <button type="submit"><spring:message code="addToBasket" /></button>
                    </form>
                </core:if>
                <core:if test="${stockOut == 1}">
                    <p class="product-sold-out"><spring:message code="soldOut"/></p>
                </core:if>
            </div>
        </core:if>
    </core:forEach>
</core:forEach>