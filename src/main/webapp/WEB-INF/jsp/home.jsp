<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>


<div class="container">
    <div class="row">
        <!-- forEach here categories TODO-->

            <div class="col-12 col-sm-6 col-md-3">
                <div class="card" style="margin: 10px" style="width: 18rem;">
                    <!-- TODO Image category ? -->
                    <div class="card-body">
                        <h5 class="card-title">
                            <spring:message code="category"/>
                        </h5>
                        <p class="card-text">
                            <spring:message code="description"/>
                        </p>
                        <!-- TODO Take the ID category and print all the articles -->
                    </div>
                </div>
            </div>

        <!--end forEach-->
    </div>
</div>