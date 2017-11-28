package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * create by Gary Wong
 * 2017/11/28
 * class describetion : 登录过滤器 拦截所有请求
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();

        System.out.println(requestURI);
        if (requestURI.equals("/login") || requestURI.equals("/") || requestURI.equals("/index.jsp")) {
            chain.doFilter(request, response);
        } else {
            boolean b = false;
            //检查是否登录
            Cookie[] cookies = httpServletRequest.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("username")) {
                    String value = cookies[i].getValue();
                    if (value != null && !value.equals("")) {
                        b = true;
                    }
                }
            }

            if (b) {
                //登陆过,跳转
                chain.doFilter(request, response);
            } else {
                //未登录
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect("index.jsp");
            }
        }
    }

    public void destroy() {

    }
}
