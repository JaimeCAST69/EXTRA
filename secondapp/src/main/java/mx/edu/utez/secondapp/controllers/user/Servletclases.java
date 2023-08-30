package mx.edu.utez.secondapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.secondapp.models.DaoUser;
import mx.edu.utez.secondapp.models.Daoclases;
import mx.edu.utez.secondapp.models.User;
import mx.edu.utez.secondapp.models.clases;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Servletclases",
        urlPatterns = {

                "/user/ver-clases"
        })
public class Servletclases extends HttpServlet {
    String action;
    String redirect;
    String nombre,descripcion, estado;
    long idinstructor;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/registrar-clases":
                redirect="/views/resgistrar-clases.jsp";
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action){
            case  "/user/registrar-clases":
                nombre=req.getParameter("nombre");
                descripcion=req.getParameter("descripcion");
                estado=req.getParameter("estado");
                clases clases= new clases(nombre,descripcion, "ACTIVO");
                boolean result1 = new Daoclases().save(clases);
                if (result1){
                    redirect = "/user/user?result= " + result1 + "&message=" + URLEncoder.encode("¡Éxito! Usuario registrado correctamente.",
                            StandardCharsets.UTF_8);

                }else{
                    redirect = "/user/registrar?result= " + result1 + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.",
                            StandardCharsets.UTF_8);
                }
                break;
        }
    }
}


