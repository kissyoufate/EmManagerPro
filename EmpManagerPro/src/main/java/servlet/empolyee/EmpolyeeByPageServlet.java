package servlet.empolyee;

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
 * 2017/11/19
 * class describetion : 分页查询,首次进入时候调用
 */
@WebServlet(urlPatterns = "/empolyeeByPage")
public class EmpolyeeByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int size = 5;

        String page = req.getParameter("page");
        if (page == null || page.equals("")){
            page = "1";
        }

        EmpolyeeService empolyeeService = new EmpolyeeService();

        //当前页
        req.setAttribute("currentPage",page);

        //获得总条数
        int empCount = empolyeeService.getEmpCount();
        req.setAttribute("totalCount",empCount);
        req.setAttribute("totalCountInfo","共" + empCount + "条记录");

        //获得分页数目
        int pages = 0;
        if (empCount%size == 0){
            pages = empCount/size;
        }else {
            pages = empCount/size + 1;
        }
        req.setAttribute("pages",pages);

        //获取当前页数的数据
        List<Empolyee> list = empolyeeService.getEmpsByPageAndSize(Integer.parseInt(page)-1, size);
        req.setAttribute("lists", list);

        req.getRequestDispatcher("pages/views/empolyee/empManager.jsp?page=" + page).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
