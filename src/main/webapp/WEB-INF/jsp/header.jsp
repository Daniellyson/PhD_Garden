<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="./include/importTags.jsp"%>

<head>
     <spring:url var="localeFr" value="">
          <spring:param name="locale" value="fr"/>
     </spring:url>
     <spring:url var="localeEn" value="">
          <spring:param name="locale" value="en"/>
     </spring:url>
</head>

<header>

     <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">

          <a href="/phD_Garden/"><img id="logo" src="<core:url value='/static/img/welcome.jpg'/>"/></a>
          <a class="navbar-brand" href="/phD_Garden/">PhD Garden</a><button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse"
               id="navcol-1">
               <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item dropdown"><a data-toggle="dropdown" aria-expanded="false" class="dropdown-toggle nav-link text-white" href="#"><spring:message code="category" /> </a>
                         <div role="menu" class="dropdown-menu">
                              <core:forEach items="${categories}" var="category">
                                   <core:forEach items="${category.translationCategory}" var="translation">
                                        <core:if test="${translation.language.code==locale}">
                                             <a role="presentation" class="dropdown-item" href="<core:url value='/products_Category/${category.id}'/>">${translation.name}</a>
                                        </core:if>
                                   </core:forEach>
                              </core:forEach>
                         </div>
                    </li>
               </ul>

               <span class="navbar-text actions">

                    <sec:authorize access="isAuthenticated()">
                         <div class="text-white login">
                              <spring:message code="welcome"/> : ${pageContext.request.userPrincipal.name}
                              <a class="btn btn-light action-button" href="<spring:url value='/logout'/>"> <spring:message code="logOut" /> </a>
                         </div>

                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                         <a class="text-white login" href="<spring:url value='/login'/>"> <spring:message code="logIn" /> </a>
                         <a class="btn btn-light action-button" role="button" href="<core:url value='/register'/>"> <spring:message code="signUp" /> </a>
                    </sec:authorize>
               </span>


               <a class="flag" href="${localeFr}"> <img src="<core:url value='/static/img/FR.png'/>"/> </a>
               <a class="flag" href="${localeEn}"> <img src="<core:url value='/static/img/GB.png'/>"/> </a>


               <div id="shopping-cart">
                    <a href="<core:url value='/shopping-cart' />" ><img src="<core:url value='/static/img/shopping-cart.png' />" /></a>
                    <a href="<core:url value='/shopping-cart' />">
                    <p id="paragraphCart">
                         <core:set var="itemsTotal" value="${0}" />
                         <core:forEach items="${shoppingCart}" var="product">
                              <core:set var="itemsTotal" value="${itemsTotal + product.value}" />
                         </core:forEach>
                         <spring:message code="productAmount"/> : ${
                            itemsTotal
                         }
                    </p>
                    </a>
               </div>
          </div>

          <script src="static/js/jquery.min.header.js"></script>
          <script src="static/bootstrap/js/bootstrap.min.header.js"></script>
     </nav>
</header>