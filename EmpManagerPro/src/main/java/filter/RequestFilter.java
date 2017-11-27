package filter;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Gary Wong
 * 2017/11/27
 * class describetion : 请求拦截器 拦截所有请求并打印请求信息
 */
@WebFilter(urlPatterns = "/*")
public class RequestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        //获取请求的url
        StringBuffer requestURL = httpRequest.getRequestURL();
        //获取请求的参数
        Map parameterMap = request.getParameterMap();

        String longStr = JSON.toJSONString(parameterMap);
        
        String str = "请求地址: " + requestURL + "\n" + "请求参数: " + longStr + "\n" + "请求时间" + new Date().toLocaleString();
        System.out.println(str);
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
