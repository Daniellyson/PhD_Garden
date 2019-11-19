<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="./include/importTags.jsp"%>

<header>

     <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="#"><img id="logo" src='<spring:url value="/images/welcome.jpg"/>'></a>
          <!--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
          </button>-->
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
               <ul class="navbar-nav">
                    <li class="nav-item active">
                         <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                         <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                         <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Dropdown link
                         </a>
                         <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                              <a class="dropdown-item" href="#">Action</a>
                              <a class="dropdown-item" href="#">Another action</a>
                              <a class="dropdown-item" href="#">Something else here</a>
                         </div>
                    </li>
               </ul>
          </div>
          <div id="locale-wrapper">
               <spring:url var="localeFr" value="">
                    <spring:param name="locale" value="fr"/>
               </spring:url>
               <spring:url var="localeEn" value="">
                    <spring:param name="locale" value="en"/>
               </spring:url>

               <a href="${localeFr}"><img class="locale-icon" src='<spring:url value="/images/FR.png"/>'></a>
               <a href="${localeEn}"><img class="locale-icon" src='<spring:url value="/images/GB.png"/>'></a>
          </div>
     </nav>

</header>