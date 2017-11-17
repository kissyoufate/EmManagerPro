package dao;

import model.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.SqlSessionFactoryTool;

import java.io.IOException;

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
}

