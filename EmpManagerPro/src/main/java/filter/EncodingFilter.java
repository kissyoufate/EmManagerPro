package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * create by Gary Wong
 * 2017/11/15
 * class describetion : none
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("字符过滤器初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        if (uri.contains("json")){
            //如果包含json则设置为返回json
            response.setContentType("application/json;charset=utf-8");
        }
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
