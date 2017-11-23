package dao;

import model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据id删除一个部门
     * @param id
     */
    public boolean deleteDep(Integer id);

    /**
     * 根据id获取一个部门
     * @param id
     * @return 部门对象
     */
    public Department getDepById(Integer id);

    /**
     * 获取所有的部门
     * @return
     */
    public List<Department> getAllDep();

    /**
     * 根据传入的实体修改部门
     * @param department
     * @return 影响的行数
     */
    public int updateDep(Department department);

    /**
     * 根据部门名称模糊查询
     * @param dep_name
     * @return 部门对象集合
     */
    public List<Department> getDepByDepName(String dep_name);

    /**
     * 从第几个开始往后查询多少个部门信息
     * @param offset 从这里开始
     * @param limit  查询多少个
     * @return
     */
    public List<Department> getDepFromOffsetByLimit(@Param("offset") int offset,
                                                    @Param("limit") int limit,
                                                    @Param("searchName") String searchName
                                                    );

    /**
     * 查询所有的部门有多少个
     * @return
     */
    public int getDepCount();
}
