package servlet.department;

import base.BaseException;
import com.alibaba.fastjson.JSON;
import service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Gary Wong
 * 2017/11/25
 * class describetion : none
 */
@WebServlet(urlPatterns = "/deleDep")
public class DepartmentDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println("11111====" + id);

        Map map = new HashMap();
        if (id == null || id.equals("")){
            map.put("code","fail");
            map.put("message","请传入部门编号");
            resp.getWriter().write(JSON.toJSONString(map));
        }else {
            DepartmentService departmentService = new DepartmentService();
            try {
                boolean b = departmentService.deleDepById(Integer.parseInt(id));
                if (b){
                    //删除成功
                    map.put("code","success");
                    resp.getWriter().write(JSON.toJSONString(map));
                }else {
                    //删除失败
                    map.put("code","fail");
                    map.put("message","删除部门失败了");
                    resp.getWriter().write(JSON.toJSONString(map));
                }
            } catch (BaseException e) {
                //删除失败
                map.put("code","fail");
                map.put("message",e.getMessage());
                resp.getWriter().write(JSON.toJSONString(map));
            }
        }
    }
}
