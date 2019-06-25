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
        <strong><spring:message code="console.creer.title"/></strong>.
    </div>

    <form method="GET"
          action="${UrlsControllers.CREATE_CONSOLE_URL}">
        <label for="search"><spring:message code="console.creer.enregistrerconsole"/></label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="console" class="custom-select " id="search">
                <option selected><spring:message code="console.creer.creerconsole"/></option>
                <c:forEach items="${consoles}" var="console">
                    <option value="${console.nom}" ${console.id == editConsole.id ? 'selected' : ''}>${console.nom}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-secondary"><spring:message
                    code="console.creer.boutoncharger"/></button>
        </div>
        <small id="searchHelpBlock" class="form-text text-muted">
            <spring:message code="console.creer.indication"/>
        </small>
    </form>
    <hr class="barre"/>

    <%--show if we created / edited console--%>
    <c:if test="${not empty consoleSave}">
        <c:set var="alertType"
               value="alert-success"
               scope="page"/>
        <spring:message code="console.creer.correct" var="alertMessage"/>
        <c:if test="${!consoleSave}">
            <c:set var="alertType"
                   value="alert-danger"
                   scope="page"/>
            <spring:message code="console.creer.error" var="alertMessage"/>
        </c:if>

        <div class="alert ${alertType}">
                ${alertMessage}
        </div>
    </c:if>

    <form:form method="POST"
               action="${UrlsControllers.CREATE_CONSOLE_URL}" modelAttribute="editConsole">
        <div class="form-group">
            <label for="nom"> <spring:message code="console.creer.nom.value"/>*</label>
            <spring:message code="console.creer.nom.placeholder" var="placeholder"/>
            <form:input path="nom" class="form-control" id="nom" placeholder='${placeholder}' required="required"/>
        </div>
        <div class="form-group">
            <label for="fabricant"><spring:message code="console.creer.fabricant.value"/></label>
            <spring:message code="console.creer.fabricant.placeholder" var="placeholder"/>
            <form:input path="fabricant" class="form-control" id="fabricant" placeholder='${placeholder}'
                        name="fabricant"/>
        </div>
        <div class="form-group">
            <label for="bits"><spring:message code="console.creer.bits.value"/></label>
            <form:input path="bits" type="number" class="form-control" id="bits" name="bits"/>
        </div>

        <div class="form-group">
            <label for="dateDeSortie"><spring:message code="console.creer.date.value"/>*</label>
            <form:input path="dateDeSortie" type="date" class="form-control date" id="dateDeSortie" name="dateDeSortie"
                        required="required"/>
        </div>
        <form:input type="hidden" name="id" path="id"/>
        <button type="submit" class="btn btn-secondary btn-block"><spring:message
                code="console.creer.button.enregistrer.value"/></button>

        <br/><br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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