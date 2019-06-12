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
        <strong>Creer ou editer un jeu video</strong>.
    </div>

    <form method="GET"
          action="/create_jeu" >
        <label for="search">Jeux enregistr�es</label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="jeu" class="custom-select " id="search">
                <option selected>Creer un jeu</option>
                <c:forEach items="${jeux}" var="jeu">
                    <option value="${jeu.nom}" ${jeu == editJeu ? 'selected' : ''}>${jeu.nom}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-secondary">Charger</button>
        </div>
        <small id="searchHelpBlock" class="form-text text-muted">
            Vous pouvez editer un jeu en selectionnant le jeu et en cliquant sur <b>charger</b>
        </small>
    </form>
    <hr class="barre"/>

    <%--show if we created / edited console--%>
    <c:if test="${not empty jeuSave}">
        <c:set var = "alertType"
               value = "alert-success"
               scope="page" />
        <c:set var = "alertMessage"
               value = " <strong>Correct!</strong> Votre enregistrement a �t� pris en compte."
               scope="page" />
        <c:if test="${!jeuSave}">
            <c:set var = "alertType"
                   value = "alert-danger"
                   scope="page" />
            <c:set var = "alertMessage"
                   value = " <strong>Oups...!</strong> probl�me avec votre enregistrement, verifiez que le jeu que vous essayez de creer n'existe pas deja"
                   scope="page" />
        </c:if>

        <div class="alert ${alertType}">
                ${alertMessage}
        </div>
    </c:if>

    <form:form method="POST"
               action="/create_jeu" modelAttribute="editJeu">
        <div class="form-group">
            <label for="nom">Nom</label>
            <form:input path="nom" class="form-control" id="nom" placeholder="Entrez le nom du jeu"/>
        </div>
        <div class="form-group">
            <label for="editeur">Editeur</label>
            <form:input path="editeur" class="form-control" id="editeur" placeholder="editeur" name="editeur" />
        </div>

        <div class="form-group">
            <label for="dateDeSortie">Date de sortie</label>
            <form:input path="dateDeSortie" type="date"    class="form-control date" id="dateDeSortie" placeholder="Entrez la date de creation du jeu" name="dateDeSortie" />
        </div>
        <form:input type="hidden"  name="id" path="id"/>
        <form:input type="hidden"  name="id" path="console"/>
        <button type="submit" class="btn btn-secondary btn-block">Enregister</button>

        <br/><br/>
    </form:form>

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