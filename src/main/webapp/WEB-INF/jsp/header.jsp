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

          <img id="logo" src="<core:url value='/static/img/welcome.jpg'/>" href="/phD_Garden/home"/>
          <a class="navbar-brand" href="/phD_Garden/home">PhD Garden</a><button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
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
                    <a class="text-white login" href="#"> <spring:message code="logIn" /> </a>
                    <a class="btn btn-light action-button" role="button" href="#"> <spring:message code="signUp" /> </a>
               </span>


               <a class="flag" href="${localeFr}"> <img src="<core:url value='/static/img/FR.png'/>"/> </a>
               <a class="flag" href="${localeEn}"> <img src="<core:url value='/static/img/GB.png'/>"/> </a>


               <div id="shopping-cart">
                    <a href="<core:url value='/shopping-cart' />" ><img src="<core:url value='/static/img/shopping-cart.png' />" /></a>
                    <p id="paragraphCart">
                         <spring:message code="productAmount"/> : ${shoppingCart.size()}
                    </p>
               </div>
          </div>

          <script src="static/js/jquery.min.header.js"></script>
          <script src="static/bootstrap/js/bootstrap.min.header.js"></script>
     </nav>
</header>