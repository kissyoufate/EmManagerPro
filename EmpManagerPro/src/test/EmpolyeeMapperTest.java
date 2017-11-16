import dao.EmpolyeeMapper;
import model.Empolyee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.SqlSessionFactoryTool;

import javax.sound.midi.Soundbank;
import java.io.IOException;

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

            Empolyee empolyee = new Empolyee();
            empolyee.setId(1);
            empolyee.setEmp_name("哈哈哈");
//            empolyee.setEmp_age(1111);

            System.out.println(empolyee);

            int i = mapper.updateEmp(empolyee);

            System.out.println(i);

            openSession.commit();
        } finally {
            openSession.close();
        }
    }
}
