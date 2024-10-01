package com.systex.eBiz.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化 Filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        // 檢查 session 是否包含登入的 user 資訊
        if (session == null || session.getAttribute("user") == null) {
            // 如果沒有登入，導向到登入頁面
            res.sendRedirect(req.getContextPath() + "/user/register");
        } else {
            // 如果已登入，繼續處理後續請求
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // 銷毀 Filter
    }
}

