package servlet.empolyee;

import model.Department;
import service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/19
 * class describetion : 进入添加员工页面,要查出所有的部门提供选择
 */
@WebServlet(urlPatterns = "/gotoAddEmp")
public class GotoAddEmpolyeeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //所有的部门查询
        DepartmentService departmentService = new DepartmentService();
        List<Department> list = departmentService.getAllDeps();

        req.setAttribute("lists",list);
        req.getRequestDispatcher("pages/views/empolyee/addEmpolyee.jsp").forward(req,resp);
    }
}
