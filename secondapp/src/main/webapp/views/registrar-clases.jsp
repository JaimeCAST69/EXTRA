<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 30/08/2023
  Time: 08:28 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Registro de Clase</h1>
<form action="/registrar_clase" method="post">
    <label for="nombre">Nombre de la Clase:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="descripcion">Descripción de la Clase:</label>
    <textarea id="descripcion" name="descripcion" rows="4" required></textarea><br><br>

    <label for="idinstructor">Instructor:</label>

    <input type="submit" value="Registrar Clase">
</form>


</body>
</html>
