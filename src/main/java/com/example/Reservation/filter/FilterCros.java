package com.example.Reservation.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class FilterCros implements Filter {
        public void init(FilterConfig filterConfig) throws ServletException {}
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletResponse resp = (HttpServletResponse)servletResponse;
            resp.setHeader("Access-Control-Allow-Origin", "http://localhost:9000");
            filterChain.doFilter(servletRequest,servletResponse);
        }
        public void destroy() {}
    }


