package mx.edu.utez.secondapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Servletclases",
        urlPatterns = {

                "/clases/clases",
                "/user/admin",
                "/user/usuario",
                "/user/instructor",
                "/user/user",
                "/user/registrar",
                "user/ver-clases"
        })
public class Servletclases extends HttpServlet {
    String action;
    String redirect;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/registrar-clases":
                redirect="/views/resgistrar-clases.jsp";
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


