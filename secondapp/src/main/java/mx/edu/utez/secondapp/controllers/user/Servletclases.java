package mx.edu.utez.secondapp.controllers.user;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "Servletclases",
        urlPatterns = {

                "/clases/clases",
                "/user/admin",
                "/user/usuario",
                "/user/instructor",
                "/user/user",
                "/user/registrar"
        })
public class Servletclases extends HttpServlet {


}
