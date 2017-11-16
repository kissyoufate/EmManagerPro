package model;

/**
 * create by Gary Wong
 * 2017/11/16
 * class describetion : 员工的实体类
 */
public class Empolyee {
    private Integer id;
    private String emp_name;
    private String emp_sex;
    private Integer emp_age;
    private String emp_tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public Integer getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(Integer emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_tel() {
        return emp_tel;
    }

    public void setEmp_tel(String emp_tel) {
        this.emp_tel = emp_tel;
    }

    @Override
    public String toString() {
        return "Empolyee{" +
                "id=" + id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_sex='" + emp_sex + '\'' +
                ", emp_age=" + emp_age +
                ", emp_tel='" + emp_tel + '\'' +
                '}';
    }
}
