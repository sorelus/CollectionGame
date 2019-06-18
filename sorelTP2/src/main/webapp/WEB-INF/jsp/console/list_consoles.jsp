<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <strong><spring:message code="console.list.title"/></strong>
    </div>

    <table class="table table-bordered" >
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col"><spring:message code="console.creer.nom.value"/></th>
            <th scope="col"><spring:message code="console.creer.fabricant.value"/></th>
            <th scope="col"><spring:message code="console.creer.bits.value"/></th>
            <th scope="col"><spring:message code="console.creer.date.value"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="console" items="${consoles}">
            <tr>
                <th scope="row">${console.id}</th>
                <td>${console.nom}</td>
                <td>${console.fabricant}</td>
                <td>${console.bits}</td>
                <td>${console.dateDeSortie}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

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