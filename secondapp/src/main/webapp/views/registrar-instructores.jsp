<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 30/08/2023
  Time: 08:09 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>
<h1>Registro de Instructor</h1>
<form action="/user/registrar-instructores" method="post">
    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" required><br><br>

    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="rol">Rol:</label>
    <input type="text" id="rol" name="rol" required><br><br>

    <label for="estado">Estado:</label>
    <input type="text" id="estado" name="estado" required><br><br>

    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="apellido_paterno">Apellido Paterno:</label>
    <input type="text" id="apellido_paterno" name="apellido_paterno" required><br><br>

    <label for="apellido_materno">Apellido Materno:</label>
    <input type="text" id="apellido_materno" name="apellido_materno" required><br><br>

    <label for="curp">CURP:</label>
    <input type="text" id="curp" name="curp" required><br><br>

    <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
    <input type="text" id="fecha_nacimiento" name="fecha_nacimiento" required><br><br>

    <input type="submit" value="Registrar">

<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
