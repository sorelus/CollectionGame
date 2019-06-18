<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<nav class="navbar navbar-expand-lg navbar-light  fixed-top" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="/">
        <img src="images/app-box.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Collection Jeux
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.jeu.title"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/create_jeu"><spring:message code="menu.jeu.m1"/></a>
                    <a class="dropdown-item" href="/find_jeu"><spring:message code="menu.jeu.m2"/></a>
                    <a class="dropdown-item" href="/list_jeu"><spring:message code="menu.jeu.m3"/></a>
                    <a class="dropdown-item" href="/lier_jeu"><spring:message code="menu.jeu.m4"/> </a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.console.title"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/create_console"><spring:message code="menu.console.m1"/></a>
                    <a class="dropdown-item" href="/find_console"><spring:message code="menu.console.m2"/></a>
                    <a class="dropdown-item" href="/list_console"><spring:message code="menu.console.m3"/></a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.user.title"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/create_user"><spring:message code="menu.user.m1"/></a>
                    <a class="dropdown-item" href="/list_user"><spring:message code="menu.user.m2"/></a>
                    <a class="dropdown-item" href="/list_jeux_user"><spring:message code="menu.user.m3"/></a>
                </div>
            </li>
        </ul>

        <div class=" my-lg-0">
            <img src="images/icon.png" alt="Smiley user" height="32" width="32" style="float:outside;width:32px;height:32px;"/>
            Sorel
        </div>
    </div>
</nav>
<br/><br/>