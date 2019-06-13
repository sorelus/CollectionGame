<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Console</title>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/main.css" rel="stylesheet"/>
    <link rel="icon" href="images/app-box.png">
</head>
<body class="body">
<%@ include file="../part/menu.jsp" %>
<div class="col-sm-12">
    <div class="alert alert-secondary ">
        <strong>Chercher une console</strong>.
    </div>

    <form method="GET"
          action="/find_console" >
        <label for="search">Nom de la console</label>
        <div class="input-group mb-2 mr-sm-2">
            <input type="text" class="form-control" id="search"  name="console" placeholder=""/>
            <button type="submit" class="btn btn-secondary">chercher</button>
        </div>
        <small id="searchHelpBlock" class="form-text text-muted">
           Veillez vous assurez de bien entrer le nom <b>( ce champ est sensible  à la case)</b>
        </small>
    </form>
    <hr class="barre"/>

    <%--show if we created / edited console--%>
    <c:if test="${not empty find && not find }">
            <c:set var = "alertType"
                   value = "alert-danger"
                   scope="page" />
            <c:set var = "alertMessage"
                   value = " <strong>Oups...!</strong> Cette console n'existe pas encore en DB"
                   scope="page" />

        <div class="alert ${alertType}">
                ${alertMessage}
        </div>
    </c:if>
        <div class="form-group">
            <label for="nom">Nom</label>
            <label id="nom" class="form-control" >${select.nom}</label>

        </div>
        <div class="form-group">
            <label for="fabricant">Fabricant</label>
            <label id="fabricant" class="form-control">${select.fabricant}</label>
        </div>
        <div class="form-group">
            <label for="bits">bits</label>
            <label id="bits" class="form-control">${select.bits}</label>
        </div>

        <div class="form-group">
            <label for="dateDeSortie">Date de sortie</label>
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