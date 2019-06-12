<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Home page</title>
        <link href="/css/bootstrap.css" rel="stylesheet"/>
        <link href="/css/main.css" rel="stylesheet"/>
        <link rel="icon" href="images/app-box.png">
    </head>
    <body class="body">
        <%@ include file="part/menu.jsp" %>
        <div class="col-sm-12">

            <h2><p class="bienvenue write">Bienvenue sur l'application de gestion des collections de jeux video</p></h2>
            <img src="images/game.png" class="displayed" />
           <%-- <img src="images/bienvenue.png" style="   width: 80%;height: auto; margin-left: auto; margin-right: auto;"/>--%>
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