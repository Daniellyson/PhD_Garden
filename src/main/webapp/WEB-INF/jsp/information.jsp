<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>

<div class="features-blue">
    <div class="container">
        <div class="intro">
            <h2 class="text-center">PHD GARDEN</h2>
            <p class="text-center"><spring:message code="enterpriseInformationContent" /> </p>
        </div>
        <div class="row features">
            <div class="col-sm-6 col-md-4 item"><i class="fa fa-map-marker icon"></i>
                <h3 class="name"><spring:message code="location" /></h3>
                <p class="description">221B Baker Street</p>
                <p class="description">5000 Namur</p>
                <p class="description"><spring:message code="belgium" /></p>
            </div>
            <div class="col-sm-6 col-md-4 item"><i class="fa fa-leaf icon"></i>
                <h3 class="name"><spring:message code="organic" /></h3>
                <p class="description"><spring:message code="phD_Garden" /></p>
            </div>
            <div class="col-sm-6 col-md-4 item"><i class="fa fa-envelope icon"></i>
                <h3 class="name"><spring:message code="contactUs" /></h3>
                <p class="description">
                    <spring:message code="contactUsContent" />
                    <a  href="mailto:support@phd_garden.com"><i class="fa fa-arrow-right">&nbsp;</i>Mail</a>
                </p>
            </div>
        </div>
    </div>
</div>
<script src="static/js/jquery.min.info.js"></script>
<script src="static/bootstrap/js/bootstrap.min.info.js"></script>