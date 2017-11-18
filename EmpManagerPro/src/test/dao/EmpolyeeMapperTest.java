package dao;

import dao.EmpolyeeMapper;
import model.Empolyee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.SqlSessionFactoryTool;

import java.io.IOException;
import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/16
 * class describetion : 员工dao的测试类
 */
public class EmpolyeeMapperTest {

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            EmpolyeeMapper mapper = openSession.getMapper(EmpolyeeMapper.class);
            Empolyee empolyee = mapper.getEmpById(1);
            System.out.println(empolyee);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            EmpolyeeMapper mapper = openSession.getMapper(EmpolyeeMapper.class);

            Empolyee e = new Empolyee();
            e.setEmp_name("王刚");
            e.setEmp_age(20);
            e.setEmp_sex("男");
            e.setEmp_tel("13296540788");
            e.setDep_id(1);

            int i = mapper.addEmp(e);
            System.out.println(i);

            openSession.commit();
        } finally {
           openSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmpolyeeMapper mapper = openSession.getMapper(EmpolyeeMapper.class);

            Empolyee empolyee = new Empolyee(1, "王刚", "男", 22, "465454",1);
            empolyee.setEmp_name(null);

            System.out.println(empolyee);

            int i = mapper.updateEmp(empolyee);

            System.out.println(i);

            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        EmpolyeeMapper mapper = openSession.getMapper(EmpolyeeMapper.class);
        List<Empolyee> empolyeeList = mapper.getEmpByEmpName("1");
        System.out.println(empolyeeList);
    }
}
