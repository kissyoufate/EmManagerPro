package dao;

import model.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.SqlSessionFactoryTool;

import java.io.IOException;
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/17
 * class describetion : 部门的数据库操作测试
 */
public class DepartmentMapperTest {

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Department department = new Department("技术部","程序员聚集地");

            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            int i = mapper.addDep(department);
            if (i > 0){
                openSession.commit();
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
//            Department department = mapper.getDepById(1);
//
//            System.out.println(department);

//            List<Department> departmentList = mapper.getAllDep();
//            System.out.println(departmentList);

//            mapper.deleteDep(2);

//            Department department = new Department();
//            department.setId(1);
//            department.setDep_name("开发部");
//
//            int i = mapper.updateDep(department);
//
//            openSession.commit();
//            System.out.println(i);

            List<Department> list = mapper.getDepByDepName("1");
            System.out.println(list);
        } finally {
            openSession.close();
        }
    }
}

