package ru.kochanovskiy.taxiservice;

import javax.servlet.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    private FilterConfig config = null;
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = config;
        String act = config.getInitParameter("active");
        if (act != null)
            active = (act.toUpperCase().equals("TRUE"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (active)
        {
            // Здесь можно вставить код для обработки
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        config = null;

    }
}
