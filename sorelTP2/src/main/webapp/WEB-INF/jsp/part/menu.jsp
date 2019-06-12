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
                    Jeux Videos
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/create_jeu">Create/Editer</a>
                    <a class="dropdown-item" href="/list_jeu">Lister</a>
                    <a class="dropdown-item" href="/lier_jeu">lier à une console </a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Consoles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/create_console">Create/Editer</a>
                    <a class="dropdown-item" href="/list_console">Lister</a>
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