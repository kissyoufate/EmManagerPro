package service;

import dao.DepartmentMapper;
import model.Department;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryTool;

import java.io.IOException;
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/19
 * class describetion : none
 */
public class DepartmentService {

    private static SqlSession sqlSession;
    private static DepartmentMapper departmentMapper;

    static {
        try {
            sqlSession = SqlSessionFactoryTool.getSqlSessionFactory().openSession();
            departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 获取所有的部门
     * @return
     */
    public List<Department> getAllDeps(){
        List<Department> departmentList = departmentMapper.getAllDep();
        System.out.println(departmentList);
        return departmentList;
    }
}
