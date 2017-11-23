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
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/18
 * class describetion : none
 */
@WebServlet(urlPatterns = "/queryDep")
public class DepartmentQueryServlet extends HttpServlet {

    //定义limit数量
    private static final int size = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传过来的搜索名字
        String name = req.getParameter("name");
        //获取传过来的参数 当前页数
        String currentPage = req.getParameter("page");
        if (currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }
        //转换类型
        Integer int_page = Integer.parseInt(currentPage) - 1;

        DepartmentService departmentService = new DepartmentService();
        //获取部门的数量
        int depCount = departmentService.getDepCount();
        System.out.println(depCount);
        //需要展示的总页数
        int totalPages = 0;
        if (depCount%size == 0){
            totalPages = depCount/size;
        }else {
            totalPages = depCount/size + 1;
        }
        //获取根据参数需要展示的部门
        try {
            List<Department> list = departmentService.getDepByPageAndSize(int_page, size,name);

            //保存页面需要展示的数据
            req.setAttribute("currentPage",currentPage);//当前页数
            req.setAttribute("totalPages",totalPages);//总页数
            req.setAttribute("size",size);//每页展示的数量
            req.setAttribute("depCount",depCount);//部门总个数
            req.setAttribute("list",list);//当前页码下的所有部门
            req.setAttribute("name",name);//保存搜索的关键字
            req.getRequestDispatcher("pages/views/department/depManager.jsp").forward(req,resp);
        } catch (BaseException e) {
            req.setAttribute("currentPage",currentPage);//当前页数
            req.setAttribute("totalPages",totalPages);//总页数
            req.setAttribute("size",size);//每页展示的数量
            req.setAttribute("count",depCount);//部门总个数
            req.setAttribute("list",null);//当前页码下的所有部门
            req.setAttribute("info",e.getMessage());
            req.setAttribute("name",name);//保存搜索的关键字
            req.getRequestDispatcher("pages/views/department/depManager.jsp").forward(req,resp);
        }
    }
}
