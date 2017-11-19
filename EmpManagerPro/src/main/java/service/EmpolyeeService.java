package service;

import base.BaseException;
import com.github.pagehelper.PageHelper;
import dao.DepartmentMapper;
import dao.EmpolyeeMapper;
import model.Empolyee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/18
 * class describetion : 员工的业务逻辑层
 */
public class EmpolyeeService {

    private static SqlSession sqlSession;
    private static EmpolyeeMapper empolyeeMapper;

    static {
        try {
            sqlSession = SqlSessionFactoryTool.getSqlSessionFactory().openSession();
            empolyeeMapper = sqlSession.getMapper(EmpolyeeMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查找员工
     * @param id
     * @return 员工对象
     * @throws BaseException id为空 || 员工不存在
     */
    public Empolyee getEmpById(Integer id) throws BaseException{
        if (id == null || id.toString().equals("")){
            throw new BaseException("id不能为空");
        }

        Empolyee empolyee = empolyeeMapper.getEmpById(id);

        if (empolyee == null){
            throw new BaseException("没有找到该员工");
        }

        return empolyee;
    }

    /**
     * 获取所有的员工
     * @return
     * @throws BaseException
     */
    public List<Empolyee> getAllEmps() throws BaseException{
        List<Empolyee> allEmps = empolyeeMapper.getAllEmps();
        if (allEmps.size() == 0){
            throw new BaseException("没有找到任何员工");
        }
        return allEmps;
    }

    /**
     * 根据id删除员工
     * @param id
     * @return
     * @throws BaseException
     */
    public boolean deleteEmpById(Integer id) throws BaseException{
        if (id == null || id.toString().equals("")){
            throw new BaseException("id不能为空");
        }

        boolean b = empolyeeMapper.delEmpById(id);
        if (b) {
            return true;
        }
        return false;
    }

    /**
     * 编辑一个员工
     * @param empolyee 员工的对象
     * @return
     * @throws BaseException
     */
    public boolean updateEmpByEmp(Empolyee empolyee) throws BaseException{
        if (empolyee == null || empolyee.getId() == null){
            throw new BaseException("员工或员工id不能为空");
        }
        int i = empolyeeMapper.updateEmp(empolyee);
        if (i > 0){
            return true;
        }
        return false;
    }

    /**
     * 根据名字模糊查询员工,如果不传则查所有
     * @param empName
     * @return
     */
    public List<Empolyee> getEmpLikeName(String empName){
        List<Empolyee> allEmps = new ArrayList<Empolyee>();
        if (empName == null || empName.equals("")){
            allEmps = empolyeeMapper.getAllEmps();
        }else
            allEmps = empolyeeMapper.getEmpByEmpName(empName);

        return allEmps;
    }

    public List<Empolyee> getEmpsByPageAndSize(int page,int size){
        int offset = page * size;
        int pageSize = size;
        List<Empolyee> list = empolyeeMapper.getEmpsByPage(offset, pageSize);
        return list;
    }

    public int getEmpCount(){
        return empolyeeMapper.getEmpCount();
    }
}
