package mx.edu.utez.secondapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.secondapp.models.DaoUser;
import mx.edu.utez.secondapp.models.User;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@WebServlet(name = "ServletUser",
        urlPatterns = {
                "/api/auth",
                "/api/auth/login",
                "/user/logout",
                "/user/index",
                "/user/admin",
                "/user/usuario",
                "/user/instructor",
                "/user/user",
                "/user/registrar"
        })
public class ServletUser extends HttpServlet {
    String action, redirect = "/api/user/admin";
    HttpSession session;
    String  usuario, password,nombre,apellido_paterno,apellido_materno,curp,fecha_nacimiento;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/user":
                redirect = "/index.jsp";
                break;
            case "/user/admin":
                List<User> instructores = new DaoUser().findinstructores();
                req.setAttribute("instructores", instructores);
                redirect = "/views/admin-view.jsp";
                break;
            case "/user/instructor":
                redirect = "/views/instructor-view.jsp";
                break;
            case "/user/logout":
                try {
                    HttpSession session = req.getSession(false);  // Obtener la sesión existente (sin crear una nueva)
                    if (session != null) {
                        session.invalidate();  // Invalidar la sesión para cerrarla
                    }
                    redirect = "/user/user?result=true&message=" + URLEncoder.encode("Sesión cerrada correctamente", StandardCharsets.UTF_8);
                } catch (Exception e) {

                }
                break;
            case "/user/registrar":
                redirect= "/views/crear-view.jsp";

        }
        req.getRequestDispatcher(redirect)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/api/auth":
                usuario = req.getParameter("usuario");
                password = req.getParameter("password");
                try {
                    User user = new DaoUser().loadUserByUsernameAndPassword(usuario, password);
                    if (user != null) {
                        session = req.getSession();
                        session.setAttribute("user", user);
                        switch (user.getRol()) {
                            case "ADMIN_ROLE":
                                redirect = "/user/admin";
                                break;
                            case "USER_ROLE":
                                redirect = "/user/usuario";
                                break;
                            case "INSTRUCTOR_ROLE":
                                redirect = "/user/instructor";
                                break;
                        }
                    } else {
                        throw new Exception("Credentials mismatch");
                    }
                } catch (Exception e) {
                    redirect = "/api/user/login?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/registrar":

                usuario=req.getParameter("usuario");
                password=req.getParameter("password");
                nombre=req.getParameter("nombre");
                apellido_paterno=req.getParameter("apellido_paterno");
                apellido_materno=req.getParameter("apellido_materno");
                curp=req.getParameter("curp");
                fecha_nacimiento=req.getParameter("fecha_nacimiento");

                User user = new User(0L,usuario,password, "USER_ROLE", "ACTIVO",nombre,apellido_paterno,apellido_materno,curp,fecha_nacimiento);
                boolean result1 = new DaoUser().save(user);
                if (result1){
                    redirect = "/user/user?result= " + result1 + "&message=" + URLEncoder.encode("¡Éxito! Usuario registrado correctamente.",
                            StandardCharsets.UTF_8);

                }else{
                    redirect = "/user/registrar?result= " + result1 + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.",
                            StandardCharsets.UTF_8);
                }
                break;
        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }
}
