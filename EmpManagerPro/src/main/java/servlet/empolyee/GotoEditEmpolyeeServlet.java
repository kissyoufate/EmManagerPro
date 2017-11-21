package servlet.empolyee;

import base.BaseException;
import model.Department;
import model.Empolyee;
import service.DepartmentService;
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
 * 2017/11/21
 * class describetion : none
 */
@WebServlet(urlPatterns = "/gotoEditEmp")
public class GotoEditEmpolyeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传递过来的员工id 查询该id对应的员工
        String id = req.getParameter("id");
        EmpolyeeService empolyeeService = new EmpolyeeService();

        //查询所有的部门
        DepartmentService departmentService = new DepartmentService();
        List<Department> allDeps = departmentService.getAllDeps();
        try {
            Empolyee empolyee = empolyeeService.getEmpById(Integer.parseInt(id));
            req.setAttribute("empolyee",empolyee);
            req.setAttribute("allDeps",allDeps);
            req.getRequestDispatcher("pages/views/empolyee/editEmpolyee.jsp").forward(req,resp);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }
}
