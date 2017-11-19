package servlet.empolyee;

import base.BaseException;
import model.Empolyee;
import service.EmpolyeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/18
 * class describetion : 模糊搜索
 */
@WebServlet(urlPatterns = "/empolyeeQuery")
public class EmpolyeeQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emp_name = req.getParameter("emp_name");

        if (emp_name==null || emp_name.equals("")){
            req.setAttribute("errorInfo","请输入至少一个字进行搜索");
        }else {
            EmpolyeeService empolyeeService = new EmpolyeeService();
            List<Empolyee> list = empolyeeService.getEmpLikeName(emp_name);
            req.setAttribute("lists", list);
            req.setAttribute("emp_name",emp_name);
        }
        req.getRequestDispatcher("pages/views/empolyee/empManager.jsp").forward(req, resp);
    }
}
