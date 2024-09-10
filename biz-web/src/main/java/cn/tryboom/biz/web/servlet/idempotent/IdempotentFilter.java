package cn.tryboom.biz.web.servlet.idempotent;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author biao
 */
public class IdempotentFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 使用 HttpSession Id -> cookie 来自于 headers
        String token = request.getParameter("token");

        // HttpSession 与 Redis 打通，利用 Spring Session
        // HttpSession#setAttribute 它底层利用 Redis Hash
        HttpSession httpSession = request.getSession(false);

        Object value = httpSession.getAttribute(token);

        if (value != null) {
            // 抛出异常
            throw new ServletException("幂等性校验错误");
        }

        // 设置状态
        httpSession.setAttribute(token, token);
        try {
            // 处理
            filterChain.doFilter(request, response);
        } finally {
            // 移除状态
            httpSession.removeAttribute(token);
        }
    }
}
