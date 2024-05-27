package bsu.poznyak.projectmanagementapplication.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        String loginURI = httpRequest.getContextPath() + "/controller?action=login";
        String registerURI = httpRequest.getContextPath() + "/controller?action=register";
        String rootURI = httpRequest.getContextPath() + "/";

        boolean loggedIn = (session != null && session.getAttribute("username") != null);
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);
        boolean rootRequest = httpRequest.getRequestURI().equals(rootURI);

        if (loggedIn && (loginRequest || registerRequest || rootRequest)) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?action=todo");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
