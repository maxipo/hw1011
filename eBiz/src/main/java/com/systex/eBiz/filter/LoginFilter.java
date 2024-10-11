package com.systex.eBiz.filter;

import com.systex.eBiz.service.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class LoginFilter implements Filter {

    @Autowired
    private UserService userService;
    private List<String> whitelistUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 定義白名單的 URL
        whitelistUrls = Arrays.asList(
            "/eBiz/index.jsp",
            "/eBiz/user/login",
            "/eBiz/user/register",
            "/eBiz/user/logout",
            "/eBiz/resources/css/bootstrap.min.css",
            "/eBiz/resources/js/bootstrap.min.js",
            "/eBiz/style/myStyle.css"
        );
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String requestPath = req.getRequestURI(); // 獲取當前請求的 URL

         if (whitelistUrls.contains(requestPath)) {
            chain.doFilter(request, response);
            return;
        }

         // 檢查 session 是否包含登入的 user 資訊
        if (session == null || session.getAttribute("user") == null) {
            // 如果沒有登入，導向到登入頁面
            res.sendRedirect(req.getContextPath() + "/user/login");
        } else {
            // 如果已登入，繼續處理後續請求
            chain.doFilter(request, response);
        }

         // 登入驗證
        if (requestPath.equals(req.getContextPath() + "/user/login") && "POST".equalsIgnoreCase(req.getMethod())) {
            String loginname = req.getParameter("loginname");
            String password = req.getParameter("password");

            // 使用 validateInput 方法驗證輸入
            if (!userService.validateInput(loginname, password)) {
                res.setContentType("text/html;charset=UTF-8");
                res.getWriter().write("<html><body><h3>登錄失敗，請檢查您的登錄名稱或密碼。</h3></body></html>");
                return;
            }
        }

    }

    @Override
    public void destroy() {
        // 銷毀 Filter
    }

}

