package ru.kochanovskiy.taxiservice.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        //HttpSession session = ;
        String url = request.getServletPath();
        if((null == request.getSession(false) && !url.equals("/login"))){
            //response.sendRedirect("/login");
            //request.getRequestDispatcher("/login.jsp").forward(req, resp);
            response.sendRedirect(request.getContextPath() + "/login");
        } else
            chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}
