package dao;

import model.Department;

/**
 * create by Gary Wong
 * 2017/11/17
 * class describetion : 部门的数据库操作
 */
public interface DepartmentMapper {

    /**
     * 增加一个部门
     * @param dep
     * @return
     */
    public int addDep(Department dep);
}
