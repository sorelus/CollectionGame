<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="site.title"/></title>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/main.css" rel="stylesheet"/>
    <link rel="icon" href="images/app-box.png">
</head>
<body class="body">
<%@ include file="../part/menu.jsp" %>
<div class="col-sm-12">
    <div class="alert alert-secondary ">
        <strong><spring:message code="user.creer.title"/></strong>.
    </div>
    <security:authorize access="hasAuthority('admin')">
        <form method="GET"
              action="create_user">
            <label for="search"><spring:message code="user.creer.enregistrer"/></label>
            <div class="input-group mb-2 mr-sm-2">
                <select name="login" class="custom-select " id="search">
                    <option><spring:message code="user.creer.creeruser"/></option>
                    <c:forEach items="${users}" var="temp">
                        <option value="${temp.login}" ${temp.login == editUser.login ? 'selected' : ''}>${temp.login}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-secondary"><spring:message
                        code="console.creer.boutoncharger"/></button>
            </div>
            <small id="searchHelpBlock" class="form-text text-muted">
                <spring:message code="user.creer.indication"/>
            </small>
        </form>
        <hr class="barre"/>
    </security:authorize>
    <%--show if we created / edited user--%>
    <c:if test="${not empty errorJeu}">
        <c:set var="alertType"
               value="alert-success"
               scope="page"/>
        <spring:message code="user.creer.correct" var="alertMessage"/>
        <c:if test="${errorJeu}">
            <c:set var="alertType"
                   value="alert-danger"
                   scope="page"/>
            <spring:message code="user.creer.error" var="alertMessage"/>
        </c:if>

        <div class="alert ${alertType}">
                ${alertMessage}
        </div>
    </c:if>

    <form:form method="POST"
               action="${action}" modelAttribute="editUser">
        <div class="form-group">
            <label for="nom"> <spring:message code="user.creer.nom.value"/>*</label>
            <spring:message code="user.creer.nom.placeholder" var="placeholder"/>
            <form:input path="nom" class="form-control" id="nom" placeholder='${placeholder}'/>
        </div>
        <div class="form-group">
            <label for="prenom"> <spring:message code="user.creer.prenom.value"/></label>
            <spring:message code="user.creer.prenom.placeholder" var="placeholder"/>
            <form:input path="prenom" class="form-control" id="prenom" placeholder='${placeholder}'/>
        </div>
        <div class="form-group" style="display: ${editUser.login.length()>0 ? 'none' : 'block'}">
            <label for="login"><spring:message code="user.creer.login.value"/>*</label>
            <spring:message code="user.creer.login.placeholder" var="placeholder"/>
            <form:input path="login" class="form-control" id="login" placeholder='${placeholder}' name="login"
                        required="required"/>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="pass"><spring:message code="user.creer.pass.value"/>*</label>
                    <form:input path="pass" class="form-control" id="pass" name="password" type="password"
                                required="required"/>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="confirm"><spring:message code="user.creer.confirm.value"/>*</label>
                    <input class="form-control" id="confirm" type="password"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label for="date"><spring:message code="user.creer.date.value"/>*</label>
            <form:input path="dateDeNaissance" type="date" class="form-control date" id="date" name="date"
                        required="required"/>
        </div>
        <label for="role"><spring:message code="validation.creer.role"/></label>
        <form:select path="roles" class="form-control" id="role" multiple="false">
            <option value="1" ${editUser.roles.contains('admin') ? 'selected' : ''}>admin</option>
            <option value="2" ${editUser.roles.contains('simple') &&  !editUser.roles.contains('admin') ? 'selected' : ''}>simple</option>
        </form:select>

        <br/><br/>
        <form:input type="hidden" name="id" path="id"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-secondary btn-block"><spring:message
                code="console.creer.button.enregistrer.value"/></button>
        <br/><br/>
    </form:form>

</div>

</body>
<script src="js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="js/bootstrap.js"></script>

<script>
    <spring:message code="user.creer.confirm.error.value" var="errorVal"/>
    var password = document.getElementById("pass")
        , confirm_password = document.getElementById("confirm");

    function validatePassword() {
        if (password.value != confirm_password.value) {

            confirm_password.setCustomValidity("${errorVal}");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>
</html>