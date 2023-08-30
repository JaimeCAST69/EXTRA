<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aldri
  Date: 14/08/2023
  Time: 01:50 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/user/admin">Administrador</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/user/registrar-instructores">Registrar instructores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/views/registrar-clases.jsp">Registrra clases</a>
                    </li>
                    <li>
                        <form action="/api/auth/logout">
                            <button class="alert-primary" >Salir</button>

                    </li>

                </ul>
            </div>

        </div>
    </nav>

    <!DOCTYPE html>
    <html>
    <head>
        <title>Listado de Instructores</title>
    </head>
    <body>
    <h1>Listado de Instructores</h1>
    <table>
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Contraseña</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="user" items="${users}" varStatus="s">
            <tr>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><c:out value="${user.roleId}"/></td>
                <td><c:out value="${user.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </body>
    </html>

    <jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
