package servlet.department;

import base.BaseException;
import model.Department;
import service.DepartmentService;

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
@WebServlet(urlPatterns = "/depUpdate")
public class DepartmentUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        //根据id查询对象,拿到当前的值
        DepartmentService departmentService = new DepartmentService();
        Department currentDep = null;
        try {
            currentDep = departmentService.getDepById(Integer.parseInt(id));
            //保存当前的部门数据
            req.setAttribute("dep",currentDep);
            req.getRequestDispatcher("pages/views/department/editDepartment.jsp").forward(req,resp);
        } catch (BaseException e) {
            req.setAttribute("updateInfo","未找到这个部门:" + e.getMessage());
            req.getRequestDispatcher("queryDep?name=&page=1").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传过来的值
        String id = req.getParameter("id");
        String dep_name = req.getParameter("dep_name");
        String dep_des = req.getParameter("dep_des");

        //创建需要修改的对象
        Department department = new Department();
        department.setId(Integer.parseInt(id));
        department.setDep_name(dep_name);
        department.setDep_des(dep_des);

        try {
            DepartmentService departmentService = new DepartmentService();
            boolean b = departmentService.updateDep(department);
            if (b){
                resp.sendRedirect("queryDep?name=&page=1");
            }else {
                req.setAttribute("info","修改部门失败了");
                req.getRequestDispatcher("pages/views/department/editDepartment.jsp").forward(req,resp);
            }
        } catch (BaseException e) {
            req.setAttribute("info","修改部门失败了:" + e.getMessage());
            req.getRequestDispatcher("pages/views/department/editDepartment.jsp").forward(req,resp);
        }
    }
}
