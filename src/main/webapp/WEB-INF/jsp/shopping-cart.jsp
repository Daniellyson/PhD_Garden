<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>

<div class="shopping-cart-style">
    <div class="px-4 px-lg-0">

        <div class="pb-5">
            <div class="container">


                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">

                        <!-- Shopping cart table -->
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
                                                <td class="border-0 align-middle"><strong>${product.key.price} €</strong></td>
                                                <td class="border-0 align-middle"><strong>${product.value}</strong></td>
                                                <td class="border-0 align-middle"><a href="#" class="text-dark"><i class="fa fa-trash"></i></a></td>
                                            </tr>
                                        </core:if>
                                    </core:forEach>
                                </core:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- End -->
                    </div>
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                        <div class="p-4">
                            <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$390.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping and handling</strong><strong>$10.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                    <h5 class="font-weight-bold">$400.00</h5>
                                </li>
                            </ul><a href="#" class="btn btn-dark rounded-pill py-2 btn-block">Procceed to checkout</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="static/shopping-cart/js/jquery.min.shopping-cart.js"></script>
<script src="static/shopping-cart/bootstrap/js/bootstrap.min.shopping-cart.js"></script>