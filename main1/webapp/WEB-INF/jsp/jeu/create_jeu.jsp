<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="site.title"/></title>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/main.css" rel="stylesheet"/>
    <link rel="icon" href="images/app-box.png">
</head>
<body class="body">
<%@ include file="../part/menu.jsp" %>
<div class="col-sm-12">
    <div class="alert alert-secondary ">
        <strong><spring:message code="jeu.creer.title"/></strong>.
    </div>

    <form method="GET"
          action="/create_jeu">
        <label for="search"><spring:message code="jeu.creer.enregistrer"/></label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="jeu" class="custom-select " id="search">
                <option selected><spring:message code="jeu.creer.creer"/></option>
                <c:forEach items="${jeux}" var="jeu">
                    <option value="${jeu.nom}" ${jeu.id == editJeu.id ? 'selected' : ''}>${jeu.nom}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-secondary"><spring:message code="jeu.creer.boutoncharger"/></button>
        </div>
        <small id="searchHelpBlock" class="form-text text-muted">
            <spring:message code="jeu.creer.indication"/>
        </small>
    </form>
    <hr class="barre"/>

    <%--show if we created / edited console--%>
    <c:if test="${not empty jeuSave}">
        <c:set var="alertType"
               value="alert-success"
               scope="page"/>
        <spring:message code="jeu.creer.correct" var="alertMessage"/>
        <c:if test="${!jeuSave}">
            <c:set var="alertType"
                   value="alert-danger"
                   scope="page"/>
            <spring:message code="jeu.creer.error" var="alertMessage"/>
        </c:if>

        <div class="alert ${alertType}">
                ${alertMessage}
        </div>
    </c:if>

    <form:form method="POST"
               action="/create_jeu" modelAttribute="editJeu">
        <div class="form-group">
            <label for="nom"> <spring:message code="jeu.creer.nom.value"/>*</label>
            <spring:message code="jeu.creer.nom.placeholder" var="placeholder"/>
            <form:input path="nom" class="form-control" id="nom" placeholder='${placeholder}' required="required"/>
        </div>
        <div class="form-group">
            <label for="editeur"><spring:message code="jeu.creer.fabricant.value"/></label>
            <spring:message code="jeu.creer.fabricant.placeholder" var="placeholder"/>
            <form:input path="editeur" class="form-control" id="editeur" placeholder='${placeholder}' name="editeur"/>
        </div>

        <div class="form-group">
            <label for="dateDeSortie"><spring:message code="console.creer.date.value"/>*</label>
            <form:input path="dateDeSortie" type="date" class="form-control date" id="dateDeSortie"
                        placeholder="Entrez la date de creation du jeu" name="dateDeSortie" required="required"/>
        </div>
        <form:input type="hidden" name="id" path="id"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-secondary btn-block"><spring:message
                code="console.creer.button.enregistrer.value"/></button>

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