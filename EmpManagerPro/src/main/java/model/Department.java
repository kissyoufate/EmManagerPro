package model;

/**
 * create by Gary Wong
 * 2017/11/16
 * class describetion : 部门的实体类
 */
public class Department {
    private Integer id;
    private String dep_name;
    private String dep_describetion;

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

    public String getDep_describetion() {
        return dep_describetion;
    }

    public void setDep_describetion(String dep_describetion) {
        this.dep_describetion = dep_describetion;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_describetion='" + dep_describetion + '\'' +
                '}';
    }
}
