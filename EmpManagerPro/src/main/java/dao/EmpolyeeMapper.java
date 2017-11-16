package dao;

import model.Empolyee;

import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/16
 * class describetion : none
 */
public interface EmpolyeeMapper {

    /**
     * 根据id查询员工
     * @param id
     * @return 员工对象
     */
    public Empolyee getEmpById(Integer id);

    /**
     * 增加一个员工
     * @param empolyee 员工的对象
     * @return 数据库受影响行数
     */
    public int addEmp(Empolyee empolyee);

    /**
     * 获取所有的员工
     * @return 包含所有员工的集合
     */
    public List<Empolyee> getAllEmps();

    /**
     * 根据id删除员工
     * @param id
     * @return
     */
    public void delEmpById(Integer id);

    /**
     * 修改一个员工信息
     * @param empolyee 员工对象
     * @return 新的员工对象
     */
    public int updateEmp(Empolyee empolyee);
}
