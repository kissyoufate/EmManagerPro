package servlet;

import com.sun.net.httpserver.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by Gary Wong
 * 2017/11/28
 * class describetion : none
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final String username = "admin";
    public static final String password = "123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //模拟登录
        String username1 = req.getParameter("username");
        String password1 = req.getParameter("password");

        //判断
        if (username1.equals(username) && password1.equals(password)){
            //登录成功,将用户名密码保存在cookies
            Cookie cookie = new Cookie("username",username1);
            //设置保存时间
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            resp.sendRedirect("/pages/index.jsp");
        }else {

            req.setAttribute("info","账号或密码错误!");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
