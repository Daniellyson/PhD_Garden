<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/importTags.jsp"%>

<div class="container py-5">

    <div class="row">
        <div class="col-lg-7 mx-auto">
            <div class="bg-white rounded-lg shadow-sm p-5">

                <ul role="tablist" class="nav bg-light nav-pills rounded-pill nav-fill mb-3">

                    <li class="nav-item">
                        <a data-toggle="pill" href="#nav-tab-paypal" class="nav-link active rounded-pill"  id="paypal">
                            <i class="fa fa-paypal"></i>
                            Paypal
                        </a>
                    </li>

                </ul>

                <div id="nav-tab-paypal" class="tab-pane fade show active">
                    <p> <spring:message code="paypal"/> </p>

                    <core:set var="itemsTotal" value="${0}" />
                    <core:forEach items="${shoppingCart}" var="product">
                        <core:set var="itemsTotal" value="${itemsTotal + product.value}" />
                    </core:forEach>

                    <p><spring:message code="productAmount"/> : ${itemsTotal}</p>
                    <p><spring:message code="total"/> : ${totalOrder}</p>


                    <p>
                        <button id="button-paypal" type="submit" class="btn btn-primary rounded-pill">
                            <i class="fa fa-paypal mr-2"></i> <spring:message code="myPaypal" />
                        </button>
                    </p>

                </div>

            </div>
        </div>
    </div>
</div>

<script src="static/js/jquery.min.order.js"></script>
<script src="static/bootstrap/js/bootstrap.min.order.js"></script>
<script src="static/js/Bootstrap-4---Payment-Form.js"></script>
<script src="static/js/jquery.min.header.js"></script>
<script src="static/bootstrap/js/bootstrap.min.header.js"></script>