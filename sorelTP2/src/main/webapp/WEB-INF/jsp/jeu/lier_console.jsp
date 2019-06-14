<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <strong><spring:message code="jeu.lier.title" /></strong>.
    </div>
    <h5><spring:message code="jeu.lier.info" /></h5>
    <hr class="barre"/>
    <%--show if we created / edited console--%>
    <c:choose>
        <c:when test="${not empty jeuSave}">
            <c:set var = "alertType"
                   value = "alert-success"
                   scope="page" />
            <spring:message code="jeu.lier.correct" var="alertMessage"/>
            <c:if test="${!jeuSave}">
                <c:set var = "alertType"
                       value = "alert-danger"
                       scope="page" />
                <spring:message code="jeu.lier.error" var="alertMessage"/>
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
        <label for="jeu"><spring:message code="jeu.creer.enregistrer" /></label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="jeu" class="custom-select " id="jeu">
                <c:forEach items="${jeux}" var="jeu">
                    <option value="${jeu.id}">${jeu.nom}</option>
                </c:forEach>
            </select>
        </div>
        <label for="console"><spring:message code="console.creer.enregistrerconsole" /></label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="console" class="custom-select " id="console">
                <c:forEach items="${consoles}" var="console">
                    <option value="${console.id}">${console.nom}</option>
                </c:forEach>
            </select>
        </div>
        <br/>
        <button type="submit" class="btn btn-secondary btn-block"><spring:message code="jeu.lier.button"/></button>
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