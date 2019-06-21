<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title><spring:message code="site.title"/></title>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/main.css" rel="stylesheet"/>
    <link rel="icon" href="images/app-box.png">
</head>

<body class="body text-center">
<div class="col-sm-4 center">
    <form method="POST" action="login" class="form-signin">
        <br/>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <img class="mb-4" src="images/app-box.png" alt="" width="72" height="72">
            <h3 class="h3 mb-3 font-weight-normal"><spring:message code="site.title"/></h3>
            <h5><spring:message code="user.login.message.welcome"/></h5>
            <br/>
            <spring:message code="user.creer.login.value" var="placeholder"/>
            <input type="text" class="form-control" placeholder="${placeholder}" required="" autofocus=""
                   name="username">
            <br/>
            <spring:message code="user.creer.pass.value" var="placeholder"/>
            <input type="password" id="inputPassword" class="form-control" placeholder="${placeholder}" required=""
                   name="password">
            <span><font color="red">${error}</font></span>
            <span><font color="green">${message}</font></span>
            <br/><br/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <h6 class="text-center"><a href="/registration"><spring:message  code="create.compte.value"/></a></h6>
            <button class="btn btn-lg btn-secondary btn-block" type="submit"><spring:message code="user.login.button"/></button>
            <br/>
    </form>
</div>

<script src="js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>

