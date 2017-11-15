package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by Gary Wong
 * 2017/11/15
 * class describetion : none
 */
@WebServlet(urlPatterns = "/ajaxtest")
public class AjaxTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //模拟查找数据库的方法
        //1.获取传过来的值
        String username = req.getParameter("username");

        if (username.equals("111")){
            resp.getWriter().write("用户名已经存在");
        }else {
            resp.getWriter().write("用户名可以使用");
        }

    }
}
