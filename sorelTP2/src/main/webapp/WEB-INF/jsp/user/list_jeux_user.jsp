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
        <strong><spring:message code="user.list.jeu" /></strong>.
    </div>
    <form method="GET"
          action="/list_jeux_user" >
        <label for="search"><spring:message code="user.creer.enregistrer" /></label>
        <div class="input-group mb-2 mr-sm-2">
            <select name="login" class="custom-select " id="search">
                <option><spring:message code="user.list.select" /></option>
                <c:forEach items="${users}" var="temp">
                    <option value="${temp.login}" ${temp.login == editUser.login ? 'selected' : ''}>${temp.login}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-secondary"><spring:message code="console.creer.boutoncharger" /></button>
        </div>
        <small id="searchHelpBlock" class="form-text text-muted">
            <spring:message code="user.list.indication" />
        </small>
    </form>
    <hr class="barre"/>
    <br/>
    <div class="input-group mb-2 mr-sm-2">
        <button type="button" class="btn btn-success" onclick="cacher()"> <spring:message code="user.list.add.jeu" /> </button>
    </div>
    <div id="addJeux" style="display:none">
        <form action="/list_jeux_user" method="POST" >
            <div class="input-group mb-2 mr-sm-2">
                <select name="jeu"  class="custom-select" id="jeux">
                    <option><spring:message code="user.list.select" />

                    </option>
                    <c:forEach items="${jeux}" var="temp">
                        <option value="${temp.id}" >${temp.nom}</option>
                    </c:forEach>
                </select>
                <input type="hidden" value="${editUser.login}" name="login" />
                <button type="submit" class="btn btn-success"  > <spring:message code="user.list.add.jeu.aj" /> </button>
            </div>
        </form>

    </div>




    <table class="table table-bordered" >
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col"><spring:message code="jeu.creer.nom.value"/></th>
            <th scope="col"><spring:message code="jeu.creer.fabricant.value"/></th>
            <th scope="col"><spring:message code="jeu.list.console"/></th>
            <th scope="col"><spring:message code="console.creer.date.value"/></th>
            <th scope="col">***</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="jeu" items="${editUser.collection}">
            <tr>
                <th scope="row">${jeu.id}</th>
                <td>${jeu.nom}</td>
                <td>${jeu.editeur}</td>
                <td>${jeu.console.nom}</td>
                <td>${jeu.dateDeSortie}</td>
                <td >
                        <form action="/delete_jeu" method="POST" >
                            <input type="hidden" value="${jeu.id}" name="jeu"/>
                            <input type="hidden" value="${editUser.login}" name="login"/>
                            <button type="submit" class="btn btn-danger btn-block">
                                <spring:message code="user.list.delete.jeu" />
                            </button>
                        </form>
                </td>
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
<script>
    var blocAdd = document.getElementById("addJeux");
    function cacher(){
        blocAdd.style.display ="block";
    }

</script>
</html>