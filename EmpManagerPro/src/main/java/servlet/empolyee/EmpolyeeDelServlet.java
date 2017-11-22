package servlet.empolyee;

import base.BaseException;
import com.alibaba.fastjson.JSON;
import service.EmpolyeeService;

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
 * 2017/11/22
 * class describetion : none
 */
@WebServlet(urlPatterns = "/deleEmp")
public class EmpolyeeDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传递过来的id 和当前的页数
        String id = req.getParameter("id");

        EmpolyeeService empolyeeService = new EmpolyeeService();

        Map map = new HashMap();

        try {
            boolean b = empolyeeService.deleteEmpById(Integer.parseInt(id));
            if (b){
                //删除成功
                map.put("code","success");
                map.put("message","成功删除员工");
                resp.getWriter().write(JSON.toJSONString(map));
            }else {
                //删除失败
                map.put("code","fail");
                map.put("message","删除员工失败");
                resp.getWriter().write(JSON.toJSONString(map));
            }
        } catch (BaseException e) {
            //删除失败
            map.put("code","fail");
            map.put("message","删除员工失败" + e.getMessage());
            resp.getWriter().write(JSON.toJSONString(map));
        }

    }
}
