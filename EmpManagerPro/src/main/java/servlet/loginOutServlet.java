package servlet;

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
 * class describetion : 退出登录 清楚账号cookies
 */
@WebServlet(urlPatterns = "/loginOut")
public class loginOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("username")) {
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
                System.out.println("退出成功");
                break;
            }
        }
        resp.sendRedirect("index.jsp");
    }
}
