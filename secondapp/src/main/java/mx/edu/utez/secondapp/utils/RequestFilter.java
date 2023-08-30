package mx.edu.utez.secondapp.utils;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = {"/*"})
public class RequestFilter implements Filter {

    List<String> whiteList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        whiteList.add("/user/auth");
        whiteList.add("/user/user");
        whiteList.add("/assets/js/bootstrap.bundle.min.js");
        whiteList.add("https://unpkg.com/feather-icons");
        whiteList.add("/assets/js/sweetalert2.all.min.js");
        whiteList.add("/assets/css/bootstrap.min.css");
        whiteList.add("/assets/css/sweetalert2.min.css");
        whiteList.add("/");
        whiteList.add("/user/logout");
        whiteList.add( "/user/registrar");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String action = request.getServletPath();
        if (whiteList.contains(action)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/user/user");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
