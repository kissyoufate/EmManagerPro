package servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Gary Wong
 * 2017/11/15
 * class describetion : none
 */
@WebServlet(urlPatterns = "/jsontest")
public class JsonTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //模拟数据库查找数据,封装数据

        System.out.println("jsontest");

        ArrayList arrayList = new ArrayList();
        arrayList.add("张扬");
        arrayList.add("张扬1");
        arrayList.add("张扬2");
        arrayList.add("张扬3");
        arrayList.add("张扬4");
        arrayList.add("张扬5");

        Map map = new HashMap();
        map.put("data",arrayList);

        //转换成json
        String jsonString = JSON.toJSONString(map);
        resp.getWriter().write(jsonString);
    }
}
