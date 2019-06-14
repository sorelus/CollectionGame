<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Jeu video</title>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/main.css" rel="stylesheet"/>
    <link rel="icon" href="images/app-box.png">
</head>
<body class="body">
<%@ include file="../part/menu.jsp" %>
<div class="col-sm-12">
    <div class="alert alert-secondary ">
        <strong><spring:message code="jeu.search.title" /></strong>.
    </div>

    <form method="GET"
          action="/find_jeu" >
        <label for="search"><spring:message code="jeu.search.nom" /></label>
        <div class="input-group mb-2 mr-sm-2">
            <input type="text" class="form-control" id="search"  name="jeu" placeholder=""/>
            <button type="submit" class="btn btn-secondary"><spring:message code="jeu.search.button.value" /></button>
        </div>
        <small id="searchHelpBlock" class="form-text text-muted">
            <spring:message code="jeu.search.info.value" />
        </small>
    </form>
    <hr class="barre"/>

    <%--show if we created / edited console--%>
    <c:if test="${not empty find && not find }">
            <c:set var = "alertType"
                   value = "alert-danger"
                   scope="page" />
        <spring:message code="jeu.search.error.value" var="alertMessage" scope="page"/>

        <div class="alert ${alertType}">
                ${alertMessage}
        </div>
    </c:if>
        <div class="form-group">
            <label for="nom"><spring:message code="jeu.creer.nom.value" /></label>
            <label id="nom" class="form-control" >${select.nom}</label>
        </div>
        <div class="form-group">
            <label for="fabricant"><spring:message code="jeu.creer.fabricant.value" /></label>
            <label id="fabricant" class="form-control">${select.editeur}</label>
        </div>
        <div class="form-group">
            <label for="bits"><spring:message code="jeu.list.console" /></label>
            <label id="bits" class="form-control">${select.console.nom}</label>
        </div>

        <div class="form-group">
            <label for="dateDeSortie"><spring:message code="console.creer.date.value" /></label>
            <label id="dateDeSortie" class="form-control">${select.dateDeSortie}</label>
       </div>

</div>

</body>
<script src="/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/js/bootstrap.js"></script>
</html>