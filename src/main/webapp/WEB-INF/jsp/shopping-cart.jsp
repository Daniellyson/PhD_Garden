<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/importTags.jsp"%>


<div class="shopping-cart-style">
    <div class="px-4 px-lg-0">

        <div class="pb-5">
            <div class="container">


                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">

                        <core:if test="${shoppingCart.size() == 0}">
                            <div id="empty">
                                <div id="textEmpity" class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">
                                    <spring:message code="cartEmpity"/>
                                </div>
                                <img id="cart-empty" src="<core:url value='/static/img/shopping-cart.png' />" />
                                <a href="<core:url value='/' />" class="btn btn-dark rounded-pill py-2 btn-block">
                                    <spring:message code="continueShopping"/>
                                </a>
                            </div>
                        </core:if>

                        <!-- Shopping cart table -->
                        <core:if test="${shoppingCart.size() != 0}">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="p-2 px-3 text-uppercase"> <spring:message code="product"/> </div>
                                        </th>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase"> <spring:message code="price"/> </div>
                                        </th>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase"> <spring:message code="quantity"/> </div>
                                        </th>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase"> <spring:message code="remove"/> </div>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <core:forEach items="${shoppingCart}" var="product">
                                        <core:forEach items="${product.key.translationProducts}" var="translation">
                                            <core:if test="${translation.language.code==locale}">
                                                <tr>
                                                    <th scope="row" class="border-0">
                                                        <div class="p-2">
                                                            <core:if test="${product.key.url_image!=null}">
                                                                <img src="<core:url value='/static/img/${product.key.url_image}.jpg'/>" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            </core:if>
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">${translation.product_name}</a></h5>

                                                                <core:forEach items="${currentCategory.translationCategory}" var="translation">
                                                                    <h5 class="mb-0">
                                                                        <span class="text-muted font-weight-normal font-italic d-block">
                                                                            Category: <core:if test="${translation.language.code==locale}">${translation.name}</core:if>
                                                                        </span>
                                                                    </h5>
                                                                </core:forEach>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="border-0 align-middle"><strong>${product.key.price}€</strong></td>
                                                    <td class="border-0 align-middle">
                                                        <strong>
                                                                ${product.value}
                                                        </strong>
                                                        <core:if test="${product.value > 1}">
                                                            <a class="text-dark" href="/phD_Garden/shopping-cart/withdraw/${product.key.id}?quantity=1&product_id=${product.key.id}">
                                                                <i class="fa fa-arrow-down"></i>
                                                            </a>
                                                        </core:if>
                                                        <core:if test="${product.value < product.key.stock}">
                                                            <a class="text-dark" href="/phD_Garden/shopping-cart/add/${product.key.id}?quantity=1&origin=/shopping-cart">
                                                                <i class="fa fa-arrow-up"></i>
                                                            </a>
                                                        </core:if>
                                                    </td>
                                                    <td class="border-0 align-middle">
                                                        <a href="/phD_Garden/shopping-cart/withdraw/${product.key.id}" class="text-dark">
                                                            <i class="fa fa-trash"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </core:if>
                                        </core:forEach>
                                        <!--CALCULATION-->
                                    </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </core:if>
                        <!-- End -->
                    </div>


                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">
                            <spring:message code="orderSummary"/>
                        </div>
                        <div class="p-4">
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom">
                                    <strong class="text-muted">
                                        <spring:message code="orderSubtotal"/>
                                    </strong>
                                    <strong>
                                        ${orderSubtotal}
                                    </strong>
                                </li>
                                <li class="d-flex justify-content-between py-3 border-bottom">
                                    <strong class="text-muted">
                                        <spring:message code="discount"/>
                                    </strong>
                                    <strong>
                                        ${discount}
                                    </strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom">
                                    <strong class="text-muted">
                                        <spring:message code="total"/>
                                    </strong>
                                    <h5 class="font-weight-bold">
                                        <core:if test="${totalOrder == '1,00'}">
                                            <spring:message code="symbolic" />
                                        </core:if>
                                        ${totalOrder}
                                    </h5>
                                </li>
                            </ul>
                            <core:if test="${shoppingCart.size() > 0}">
                                <sec:authorize access="isAuthenticated()">
                                    <a href="<core:url value='/order' />" class="btn btn-dark rounded-pill py-2 btn-block">
                                        <spring:message code="procceedToCheckout"/>
                                    </a>
                                </sec:authorize>
                            </core:if>
                            <sec:authorize access="!isAuthenticated()">
                                <spring:message code="pleaseLogin"/>
                            </sec:authorize>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<script src="static/shopping-cart/js/jquery.min.shopping-cart.js"></script>
<script src="static/shopping-cart/bootstrap/js/bootstrap.min.shopping-cart.js"></script>