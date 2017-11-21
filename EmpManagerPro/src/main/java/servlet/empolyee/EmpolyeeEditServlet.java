package servlet.empolyee;

import base.BaseException;
import com.alibaba.fastjson.JSON;
import model.Empolyee;
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
 * 2017/11/21
 * class describetion : none
 */
@WebServlet(urlPatterns = "/editEmp")
public class EmpolyeeEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("editEmp post");

        //获取传递过来的参数
        String id = req.getParameter("id");
        String emp_name = req.getParameter("emp_name");
        String emp_sex = req.getParameter("emp_sex");
        String emp_age = req.getParameter("emp_age");
        String emp_tel = req.getParameter("emp_tel");
        String dep_id = req.getParameter("dep_id");

        Integer int_id =  Integer.parseInt(id);
        Integer int_age = Integer.parseInt(emp_age);
        Integer int_dep_id = Integer.parseInt(dep_id);

        //创建需要修改的员工对象
        Empolyee empolyee = new Empolyee();
        empolyee.setId(int_id);
        empolyee.setEmp_name(emp_name);
        empolyee.setEmp_age(int_age);
        empolyee.setEmp_sex(emp_sex);
        empolyee.setEmp_tel(emp_tel);
        empolyee.setDep_id(int_dep_id);

        System.out.println(empolyee);

        EmpolyeeService empolyeeService = new EmpolyeeService();
        Map map = new HashMap();
        try {
            boolean b = empolyeeService.updateEmpByEmp(empolyee);
            if (b){
                //成功
                map.put("code","success");
                map.put("info","员工保存成功");
                map.put("path","empolyeeByPage?page=1");
            }else {
                //失败
                map.put("code","fail");
                map.put("info","修改员工失败");
                map.put("path","gotoEditEmp?id=" + id);
            }

            resp.getWriter().write(JSON.toJSONString(map));
        } catch (BaseException e) {
            //失败
            map.put("code","fail");
            map.put("info","修改员工失败" + e.getMessage());
            map.put("path","gotoEditEmp?id=" + id);
            resp.getWriter().write(JSON.toJSONString(map));
        }
    }
}
