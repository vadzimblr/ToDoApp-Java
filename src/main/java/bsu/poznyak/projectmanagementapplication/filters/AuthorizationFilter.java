package bsu.poznyak.projectmanagementapplication.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/controller")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        String action = httpRequest.getParameter("action");

        boolean loggedIn = (session != null && session.getAttribute("username") != null);
        boolean todoRequest = "todo".equals(action);
        boolean logoutRequest = "logout".equals(action);
        if ((todoRequest || logoutRequest) && !loggedIn) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?action=login");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}

