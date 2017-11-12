package servlet;

import sun.util.resources.LocaleData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * create by Gary Wong
 * 2017/11/12
 * class describetion : 文件上传
 */
@WebServlet(urlPatterns = "/upload")
@MultipartConfig
public class UpLoadFile extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1.获取文件的部件
            Part part = req.getPart("file");

            //2.获取请求信息
            String partHeader = part.getHeader("content-disposition");
            System.out.println(partHeader);

            //获取文件的后缀名
            String substring = partHeader.substring(partHeader.lastIndexOf("."), partHeader.length() - 1);
            System.out.println(substring);

            //获取上传文件的目标目录
            String realPath = req.getServletContext().getRealPath("/upload");
            System.out.println(realPath);

            //将文件重新命名 UUID 唯一值
            String fileName = realPath + "\\" + UUID.randomUUID().toString() + substring;

            //上传文件
            part.write(fileName);

            req.setAttribute("error", new Date().toLocaleString() + "文件上传成功");
        } catch (Exception e) {
            req.setAttribute("error","文件上传失败" + e.getMessage());
        }

        req.getRequestDispatcher("upload.jsp").forward(req,resp);
    }
}
