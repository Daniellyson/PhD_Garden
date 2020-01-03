<%@ include file="include/importTags.jsp" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<div class="my-5 container">
    <div class="card card-default">
        <div class="card-header"><spring:message code="register.register" /></div>
        <div class="custom-form">
            <form:form
                    method="POST"
                    action=""
                    modelAttribute="userRegister">
                <div class="form-group row">
                    <form:label path="username" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.username" />*</form:label>
                    <div class="col-md-6">
                        <form:input id="username" type="text" class="form-control" path="username" />
                        <form:errors path="username" />
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="email" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.email" />*</form:label>
                    <div class="col-md-6">
                        <form:input id="email" type="text" class="form-control" path="email" />
                        <form:errors path="email" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="password" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.password" />*</label>
                    <div class="col-md-6">
                        <form:input id="password" type="password" class="form-control" path="password" />
                        <form:errors path="password" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="confirmPassword" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.confirmpw" />*</label>
                    <div class="col-md-6">
                        <form:input id="confirmPassword" type="password" class="form-control" path="confirmPassword" />
                        <form:errors path="confirmPassword" />
                    </div>
                </div>

                <hr>

                <div class="form-group row">
                    <label path="firstname" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.firstname" />*</label>
                    <div class="col-md-6">
                        <form:input id="firstname" type="text" class="form-control" path="firstname" />
                        <form:errors path="firstname" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="lastname" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.lastname" />*</label>
                    <div class="col-md-6">
                        <form:input id="lastname" type="text" class="form-control" path="lastname" />
                        <form:errors path="lastname" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="gender" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.gender" />*</label>
                    <div class="col-md-6">
                        <form:input id="gender" type="text" class="form-control" path="gender" />
                        <form:errors path="gender" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="birthdate" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.birthdate" /></label>
                    <div class="col-md-6">
                        <form:input id="birthdate" type="date" class="form-control" path="birthdate" />
                        <form:errors path="birthdate" />
                    </div>
                </div>

                <hr>

                <div class="form-group row">
                    <label path="street" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.street" />*</label>
                    <div class="col-md-6">
                        <form:input id="street" type="text" class="form-control" path="street" />
                        <form:errors path="street" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="house_number" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.house_number" />*</label>
                    <div class="col-md-6">
                        <form:input id="house_number" type="text" class="form-control" path="house_number" />
                        <form:errors path="house_number" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="postalCode" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.postalcode" />*</label>
                    <div class="col-md-6">
                        <form:input id="postalCode" type="number" class="form-control" path="postalCode" />
                        <form:errors path="postalCode" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="locality" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.locality" />*</label>
                    <div class="col-md-6">
                        <form:input id="locality" type="text" class="form-control" path="locality" />
                        <form:errors path="locality" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="phone" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.phone" /></label>
                    <div class="col-md-6">
                        <form:input id="phone" type="text" class="form-control" path="phone" />
                        <form:errors path="phone" />
                    </div>
                </div>

                <div class="form-group row mb-0">
                    <div class="col-md-8 offset-sm-4">
                        <form:button class="btn btn-primary"><spring:message code="register.register" /></form:button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>