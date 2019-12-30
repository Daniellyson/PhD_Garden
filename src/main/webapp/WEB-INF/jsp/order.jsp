<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>

<div class="container py-5">

    <div class="row">
        <div class="col-lg-7 mx-auto">
            <div class="bg-white rounded-lg shadow-sm p-5">

                <ul role="tablist" class="nav bg-light nav-pills rounded-pill nav-fill mb-3">

                    <li class="nav-item">
                        <a data-toggle="pill" href="#nav-tab-paypal" class="nav-link active rounded-pill">
                            <i class="fa fa-paypal"></i>
                            Paypal
                        </a>
                    </li>

                </ul>

                <div id="nav-tab-paypal" class="tab-pane fade show active">
                    <p>Paypal is easiest way to pay online</p>

                    <!--TODO Details Here-->




                        <p>
                            <button type="submit" class="btn btn-primary rounded-pill">
                                <i class="fa fa-paypal mr-2"></i> Log into my Paypal
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