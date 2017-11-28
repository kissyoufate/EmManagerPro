package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by Gary Wong
 * 2017/11/28
 * class describetion : 进入管理平台
 */
@WebServlet(urlPatterns = "/gotoManager")
public class GotoManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("pages/index.jsp");
    }
}
