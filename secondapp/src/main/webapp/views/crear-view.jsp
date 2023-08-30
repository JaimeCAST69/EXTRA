<%--
  Created by IntelliJ IDEA.
  User: CC12
  Date: 29/8/2023
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>
<<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Registro de usuario</div>
                <div class="card-body">
                    <form id="user-form" class="needs-validation" novalidate action="/admin/saveInstructor" method="post">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="usuario" class="fw-bold">Usuario:</label>
                                    <input type="email" name="usuario" id="usuario" class="form-control" required>
                                    <div class="invalid-feedback">Campo obligatorio | Debe de ser tipo correo '@'</div>
                                </div>
                                <div class="col">
                                    <label for="password" class="fw-bold">Password:</label>
                                    <input type="text" name="password" id="password" class="form-control" required>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="rol" class="fw-bold">Rol:</label>
                                    <select class="form-select" aria-label="Default select example" name="rol" id="rol" required>
                                        <option selected disabled value="">Seleccionar Role</option>
                                        <option value="ROLE">USER_ROLE</option>

                                    </select>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="nombre" class="fw-bold">Nombre:</label>
                                    <input type="text" name="nombre" id="nombre" class="form-control" required>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="apellidoPaterno" class="fw-bold">Apellido Paterno:</label>
                                    <input type="text" name="apellidoPaterno" id="apellidoPaterno" class="form-control" maxlength="50">
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="apellidoMaterno" class="fw-bold">Apellido Materno:</label>
                                    <input type="text" name="apellidoMaterno" id="apellidoMaterno" class="form-control" maxlength="50" required>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="curp" class="fw-bold">CURP:</label>
                                    <input type="text" name="curp" id="curp" class="form-control " maxlength="18" required>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="fechaNacimiento" class="fw-bold">Fecha de Nacimiento:</label>
                                    <input type="date" name="fechaNacimiento" id="fechaNacimiento" class="form-control" required>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="estado" class="fw-bold">Estado:</label>
                                    <select class="form-select" aria-label="Default select example" name="estado" id="estado" required>
                                        <option selected value="activo">ACTIVO</option>
                                    </select>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/admin/main" class="btn btn-outline-danger btn-sm">
                                        CANCELAR
                                    </a>
                                    <button type="submit" class="btn btn-outline-success btn-sm">
                                        ACEPTAR
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
