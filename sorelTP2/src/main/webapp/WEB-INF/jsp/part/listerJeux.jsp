<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <c:forEach var="jeu" items="${collection}">

        <div class="col-md-3 jaquette" style="min-width: 300px;">
            <div class="alert alert-secondary ">
                <center>
                    <strong>${jeu.nom}</strong>.
                </center>
            </div>
            <div class="">
                <c:choose>
                    <c:when test="${not empty jeu.jaquette}">
                        <img src="/public/downloads/${jeu.jaquette}" style="width: 100%;height:250pt;min-width: 250px;"/>
                    </c:when>
                    <c:otherwise>
                        <img src="/images/images.png" style="width: 100%;height:250pt;min-width: 250px;"/>
                    </c:otherwise>
                </c:choose>

            </div>
            <table class="table table-bordered">
                <thead class="">
                <tr>
                    <th scope="col"><spring:message code="jeu.creer.fabricant.value"/></th>
                    <th scope="col"><spring:message code="jeu.list.console"/></th>
                    <th scope="col"><spring:message code="console.creer.date.value"/></th>
                </tr>
                </thead>
                <tr>
                    <td>${jeu.editeur}</td>
                    <td>${jeu.console.nom}</td>
                    <td>${jeu.dateDeSortie}</td>
                </tr>
                <tbody>

                </tbody>

            </table>
            <security:authorize access="hasAuthority('simple')">
                <security:authorize access="hasAuthority('admin')">
                    <div>
                        <form action="/create_jeu" method="GET">
                            <input type="hidden" value="${jeu.nom}" name="jeu"/>
                            <button type="submit" class="btn btn-primary btn-block">
                                <spring:message code="user.list.upload.jeu"/>
                            </button>
                        </form>
                    </div>
                </security:authorize>
            <c:if test="${not empty owner}">
                <div>
                    <form action="${PostAction2}" method="POST">
                        <input type="hidden" value="${jeu.id}" name="jeu"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-danger btn-block">
                            <spring:message code="user.list.delete.jeu"/>
                        </button>
                    </form>
                </div>
            </c:if>
            </security:authorize>
        </div>

    </c:forEach>
</div>