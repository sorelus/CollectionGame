<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--get url--%>
<c:set var="url" value="${pageContext.request.serverName}"/>
<c:set var="port" value="${pageContext.request.serverPort}"/>
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
        <strong><spring:message code="user.list.jeu"/> : ${editUser.login}</strong>.
    </div>
    <c:if test="${ empty owner}">
            <security:authorize access="hasAuthority('admin')">
            <form method="GET"
                  action="${UrlsControllers.LINK_USER_URL}">
                <label for="search"><spring:message code="user.creer.enregistrer"/></label>
                <div class="input-group mb-2 mr-sm-2">
                    <select name="login" class="custom-select " id="search">
                        <option><spring:message code="user.list.select"/></option>
                        <c:forEach items="${users}" var="temp">
                            <option value="${temp.login}" ${temp.login == editUser.login ? 'selected' : ''}>${temp.login}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-secondary"><spring:message
                            code="console.creer.boutoncharger"/></button>
                </div>
                <small id="searchHelpBlock" class="form-text text-muted">
                    <spring:message code="user.list.indication"/>
                </small>
            </form>
            <hr class="barre"/>
        </security:authorize>
    </c:if>
    <br/>
    <c:if test="${not empty editUser.login}">
        <div class="input-group mb-2 mr-sm-2">
            <button type="button" class="btn btn-success" onclick="cacher()"><spring:message
                    code="user.list.add.jeu"/></button>
        </div>
        <div id="addJeux" style="display:none">
            <form action="${PostAction1}" method="POST">
                <div class="input-group mb-2 mr-sm-2">
                    <select name="jeu" class="custom-select" id="jeux">
                        <option><spring:message code="user.list.select"/></option>
                        <c:forEach items="${jeux}" var="temp">
                            <option value="${temp.id}">${temp.nom}</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" value="${editUser.login}" name="login"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-success">
                        <spring:message code="user.list.add.jeu.aj"/></button>
                </div>
            </form>
        </div>
        <hr class="barre"/>
        <%--<c:if test="${not empty publicLink}">--%>
        <div class="input-group mb-2">
            <div class="input-group-prepend">
                <div class="input-group-text"><spring:message code="jeu.list.public.partage"/></div>
            </div>
            <c:set var="publicUrl" value="${url}:${port}/public/${userIdEncode}"/>
            <label class="form-control btn-secondary">${publicUrl}</label>
        </div>
        <%--  </c:if>--%>
        <c:set var="collection" scope="request" value="${editUser.collection}"/>
        <%@ include file="../part/listerJeux.jsp" %>
    </c:if>


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
<script>
    var blocAdd = document.getElementById("addJeux");

    function cacher() {
        blocAdd.style.display = "block";
    }

</script>
</html>