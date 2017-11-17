package model;

/**
 * create by Gary Wong
 * 2017/11/16
 * class describetion : 部门的实体类
 */
public class Department {
    private Integer id;
    private String dep_name;
    private String dep_des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_des() {
        return dep_des;
    }

    public void setDep_des(String dep_des) {
        this.dep_des = dep_des;
    }

    public Department() {
    }

    public Department( String dep_name, String dep_des) {
        this.dep_name = dep_name;
        this.dep_des = dep_des;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_des='" + dep_des + '\'' +
                '}';
    }
}
