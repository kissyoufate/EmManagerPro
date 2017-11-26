package servlet.department;

import base.BaseException;
import model.Department;
import service.DepartmentService;
import service.EmpolyeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by Gary Wong
 * 2017/11/26
 * class describetion : none
 */
@WebServlet(urlPatterns = "/depAdd")
public class DepartmentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转到添加页面
        req.getRequestDispatcher("pages/views/department/addDepartment.jsp").forward(req,resp);

//        resp.sendRedirect("pages/views/department/addDepartment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //添加部门的操作
        //获取页面传过来的数据
        String dep_name = req.getParameter("dep_name");
        String dep_des = req.getParameter("dep_des");

        //保存前一步输入的数据
        req.setAttribute("dep_name",dep_name);
        req.setAttribute("dep_des",dep_des);

        Department department = new Department();
        department.setDep_name(dep_name);
        department.setDep_des(dep_des);

        DepartmentService departmentService = new DepartmentService();
        try {
            boolean b = departmentService.addDep(department);
            if (b){
                //将成功的值放在session中

                resp.sendRedirect("queryDep?name=&page=1");
//                req.setAttribute("addSuccess","部门添加成功");
//                req.getRequestDispatcher("/queryDep").forward(req,resp);
            }else {
                req.setAttribute("info","添加部门失败,请重新添加");
                doGet(req,resp);
            }
        } catch (BaseException e) {
            req.setAttribute("info","添加部门失败:" + e.getMessage());
            doGet(req,resp);
        }
    }
}
