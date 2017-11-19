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
 * 2017/11/19
 * class describetion : none
 */
@WebServlet(urlPatterns = "/empolyeeAdd")
public class EmpolyeeAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("员工添加信息提交了");
        String emp_name = req.getParameter("emp_name");
        String emp_sex = req.getParameter("emp_sex");
        String emp_age = req.getParameter("emp_age");
        String emp_tel = req.getParameter("emp_tel");
        String dep_id = req.getParameter("dep_id");

        String errorInfo;
        Map map = new HashMap();

        if (emp_name == null || emp_name.equals("")){
            errorInfo = "请输入员工姓名";
            map.put("code","fail");
            map.put("messageInfo",errorInfo);

            resp.getWriter().write(JSON.toJSONString(map));
            return;
        }

        if (emp_age == null || emp_age.equals("") || Integer.parseInt(emp_age) < 0){
            errorInfo = "请输入正确的员工年龄";
            map.put("code","fail");
            map.put("messageInfo",errorInfo);

            resp.getWriter().write(JSON.toJSONString(map));
            return;
        }

        if (emp_sex == null || emp_sex.equals("")){
            errorInfo = "请输入员工性别";
            map.put("code","fail");
            map.put("messageInfo",errorInfo);

            resp.getWriter().write(JSON.toJSONString(map));
            return;
        }

        if (emp_tel == null || emp_tel.equals("")){
            errorInfo = "请输入员工联系方式";
            map.put("code","fail");
            map.put("messageInfo",errorInfo);

            resp.getWriter().write(JSON.toJSONString(map));
            return;
        }

        if (dep_id == null || Integer.parseInt(dep_id) < 0){
            errorInfo = "请选择员工部门";
            map.put("code","fail");
            map.put("messageInfo",errorInfo);

            resp.getWriter().write(JSON.toJSONString(map));
            return;
        }

        Empolyee empolyee = new Empolyee(null,emp_name,emp_sex,Integer.parseInt(emp_age),emp_tel,Integer.parseInt(dep_id));
        EmpolyeeService empolyeeService = new EmpolyeeService();

        System.out.println(empolyee);

        boolean b = empolyeeService.addEmp(empolyee);
        if (b){
            map.put("code","success");
            map.put("messageInfo","添加成功");
        }else {
            map.put("code","fail");
            map.put("messageInfo","添加失败");
        }

        resp.getWriter().write(JSON.toJSONString(map));
    }
}
