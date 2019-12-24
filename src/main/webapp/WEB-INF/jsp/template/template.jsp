<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="../include/importTags.jsp"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <title>${title}</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


    <!--TEMPLATE-->
    <link rel="stylesheet" href="<core:url value="/static/css/template.css" />">
    <!--HEADER-->
    <link rel="stylesheet" href="<core:url value="/static/bootstrap/css/bootstrap.min.header.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/Navigation-with-Button.header.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/styles.header.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/shopping-cart-header.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/header.css" />">
    <!--FOOTER-->
    <link rel="stylesheet" href="<core:url value="/static/bootstrap/css/bootstrap.min.footer.css" />">
    <link rel="stylesheet" href="<core:url value="/static/fonts/ionicons.min.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/Footer-Basic.footer.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/Footer-Dark.footer.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/styles.footer.css" />">
    <!--HOME-->
    <link rel="stylesheet" href="<core:url value="/static/css/home.css" />">
    <!--PRODUCT-->
    <link rel="stylesheet" href="<core:url value="/static/css/product.css" />">
    <!--SHOPPING-CART-->
    <link rel="stylesheet" href="<core:url value="/static/bootstrap/css/bootstrap.min.shopping-cart.css" />">
    <link rel="stylesheet" href="<core:url value="/static/fonts/font-awesome.min.shopping-cart.css" />">
    <link rel="stylesheet" href="<core:url value="/static/css/styles.shopping-cart.css" />">

    <!--JS-->
    <link rel="stylesheet" href="<core:url value="/static/js/showMessageSuccess.js" />">

</head>
<body>
    <tiles:insertAttribute name="header" />
    <!--TODO messages success-->
    <div id="messages">
        <core:if test="${message.getOk()}">
            <core:choose>
                <core:when test="${message.getPlus()}">
                    <p class="info-message" style="display:none;"><spring:message code="successAddProduct" /></p>
                </core:when>
                <core:otherwise>
                    <p class="info-message" style="display:none;"><spring:message code="successWithdrawProduct" /></p>
                </core:otherwise>
            </core:choose>
        </core:if>
    </div>

    <div id="main-content">
        <tiles:insertAttribute name="main-content" />
    </div>

    <tiles:insertAttribute name="footer" />
</body>
</html>