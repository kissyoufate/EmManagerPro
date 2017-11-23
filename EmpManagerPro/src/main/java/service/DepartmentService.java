package service;

import base.BaseException;
import dao.DepartmentMapper;
import model.Department;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
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

    /**
     * 根据页数和每页的数量来查询部门
     * @param page 页数
     * @param size 每页的个数
     * @return
     */
    public List<Department> getDepByPageAndSize(Integer page,Integer size,String searchName) throws BaseException{

        if (page == null || page < 0){
            throw new BaseException("请传入正确的页数");
        }

        if (size == null || size < 0){
            throw new BaseException("请传入正确的展示数量");
        }

        //从哪里开始查询
        int offset = page * size;
        int limit  = size;

        List<Department> departmentList = departmentMapper.getDepFromOffsetByLimit(offset, limit,searchName);
        return departmentList;
    }

    /**
     * 获取部门的总数量
     * @return
     */
    public int getDepCount(){
        int depCount = departmentMapper.getDepCount();
        return depCount;
    }
}
