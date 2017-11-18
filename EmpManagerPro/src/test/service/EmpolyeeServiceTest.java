package service;

import base.BaseException;
import model.Empolyee;
import org.junit.Test;

import java.util.List;

/**
 * create by Gary Wong
 * 2017/11/18
 * class describetion : none
 */
public class EmpolyeeServiceTest {

    @Test
    public void test1(){
        EmpolyeeService empolyeeService = new EmpolyeeService();
        try {
//            Empolyee depolyee = empolyeeService.getEmpById(100);
//            System.out.println(depolyee);
//            List<Empolyee> allEmps = empolyeeService.getAllEmps();
//            System.out.println(allEmps);
            boolean b = empolyeeService.deleteEmpById(1);
            System.out.println(b);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }
}
