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
        System.out.println("Request Path: " + requestPath); // 日誌請求路徑
        System.out.println("Session: " + session); // 日誌 session 狀態

         if (whitelistUrls.contains(requestPath)) {
            chain.doFilter(request, response);
            return;
        }

         // 檢查 session 是否包含登入的 user 資訊
        if (session == null || session.getAttribute("user") == null) {
            // 如果沒有登入，導向到登入頁面
            res.sendRedirect(req.getContextPath() + "/user/login");
            return;
        }
//        } else {
//            // 如果已登入，繼續處理後續請求
//            chain.doFilter(request, response);
//        }

        if ("POST".equalsIgnoreCase(req.getMethod()) && requestPath.equals(req.getContextPath() + "/user/login")) {
            String loginname = req.getParameter("loginname");
            String password = req.getParameter("password");

            if (loginname == null || loginname.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.setContentType("application/json");
                String jsonResponse = "{\"message\": \"請填寫所有必填欄位\"}"; // JSON 响应
                res.getWriter().write(jsonResponse); // 写入响应
                return; // 終止請求處理
            }

//            // Validate credentials using the UserService (example, adjust as necessary)
//            if (!userService.validateInput(loginname, password)) {
//                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                res.setContentType("application/json");
//                String jsonResponse = "{\"message\": \"無效的登入名稱或密碼\"}";
//                res.getWriter().write(jsonResponse);
//                return; // Stop further processing
//            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 銷毀 Filter
    }

}

