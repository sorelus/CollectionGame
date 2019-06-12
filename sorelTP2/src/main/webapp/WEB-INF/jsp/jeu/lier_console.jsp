<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lier un jeu</title>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/main.css" rel="stylesheet"/>
    <link rel="icon" href="images/app-box.png">
</head>
<body class="body">
<%@ include file="../part/menu.jsp" %>
<div class="col-sm-12">
    <div class="alert alert-secondary ">
        <strong>lier une jeux à une console</strong>.
    </div>
    <h5>Selectionnez une jeu et la console avec laquelle vous voulez lier celui-ci</h5>
    <hr class="barre"/>
    <%--show if we created / edited console--%>
    <c:choose>
        <c:when test="${not empty jeuSave}">
            <c:set var = "alertType"
                   value = "alert-success"
                   scope="page" />
            <c:set var = "alertMessage"
                   value = " <strong>Correct!</strong> Votre enregistrement a été pris en compte."
                   scope="page" />
            <c:if test="${!jeuSave}">
                <c:set var = "alertType"
                       value = "alert-danger"
                       scope="page" />
                <c:set var = "alertMessage"
                       value = " <strong>Oups...!</strong> problème avec votre enregistrement, veuillew contacter l'adminstrateur"
                       scope="page" />
            </c:if>
            <div class="alert ${alertType}">
                    ${alertMessage}
            </div>
        </c:when>
        <c:when test="${empty jeuSave}">
         <br/><br/>
        </c:when>
    </c:choose>

    <form method="POST"
          action="/lier_jeu" >
        <label for="jeu">Jeux enregistrées</label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="jeu" class="custom-select " id="jeu">
                <c:forEach items="${jeux}" var="jeu">
                    <option value="${jeu.id}">${jeu.nom}</option>
                </c:forEach>
            </select>
        </div>
        <label for="console">Console</label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="console" class="custom-select " id="console">
                <c:forEach items="${consoles}" var="console">
                    <option value="${console.id}">${console.nom}</option>
                </c:forEach>
            </select>
        </div>
        <br/>
        <button type="submit" class="btn btn-secondary btn-block">LIER</button>
    </form>



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