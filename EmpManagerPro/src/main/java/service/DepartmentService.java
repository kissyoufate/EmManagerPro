package service;

import base.BaseException;
import dao.DepartmentMapper;
import model.Department;
import model.Empolyee;
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
     *
     * @return
     */
    public List<Department> getAllDeps() {
        List<Department> departmentList = departmentMapper.getAllDep();
        System.out.println(departmentList);
        return departmentList;
    }

    /**
     * 根据页数和每页的数量来查询部门
     *
     * @param page 页数
     * @param size 每页的个数
     * @return
     */
    public List<Department> getDepByPageAndSize(Integer page, Integer size, String searchName) throws BaseException {

        if (page == null || page < 0) {
            throw new BaseException("请传入正确的页数");
        }

        if (size == null || size < 0) {
            throw new BaseException("请传入正确的展示数量");
        }

        //从哪里开始查询
        int offset = page * size;
        int limit = size;

        List<Department> departmentList = departmentMapper.getDepFromOffsetByLimit(offset, limit, searchName);
        return departmentList;
    }

    /**
     * 获取部门的总数量
     *
     * @return
     */
    public int getDepCount() {
        int depCount = departmentMapper.getDepCount();
        return depCount;
    }

    /**
     * 根据id删除一个部门 将其dep_mark属性修改为0不显示
     * @param id 部门id
     * @return
     * @throws BaseException
     */
    public boolean deleDepById(Integer id) throws BaseException {
        boolean b = departmentMapper.deleteDep(id);
        sqlSession.commit();
        return b;
    }

    public boolean addDep(Department department) throws BaseException{
        if (department == null){
            throw new BaseException("请传入部门对象");
        }

        if (department.getDep_name() == null || department.getDep_name().equals("")){
            throw new BaseException("请添加部门名称");
        }

        if (department.getDep_des() == null || department.getDep_des().equals("")){
            throw new BaseException("请输入部门的描述");
        }

        int i = departmentMapper.addDep(department);

        if (i > 0){
            sqlSession.commit();
            return true;
        }
        return false;
    }

    /**
     * 根据id修改部门信息
     * @param department 部门对象
     * @return
     * @throws BaseException
     */
    public boolean updateDep(Department department) throws BaseException{
        if (department == null){
            throw new BaseException("部门不能为空");
        }

        if (department.getId() == null || department.getId().equals("")){
            throw new BaseException("部门id未找到或为空");
        }

        int i = departmentMapper.updateDep(department);
        sqlSession.commit();

        if (i > 0){
            return true;
        }
        return false;
    }

    /**
     * 根据id获取部门对象
     * @param id 部门id
     * @return
     * @throws BaseException
     */
    public Department getDepById(Integer id) throws BaseException{
        if (id == null || id.equals("")){
            throw new BaseException("部门id为空");
        }

        Department department = departmentMapper.getDepById(id);

        if (department == null) {
            throw new BaseException("未找到部门");
        }

        return department;
    }
}
