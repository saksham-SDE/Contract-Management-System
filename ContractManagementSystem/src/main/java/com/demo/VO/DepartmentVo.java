package com.demo.VO;
public class DepartmentVo {

    private int dep_id;
    private String dep_name;
    private String description;
    private String dep_address;

    public DepartmentVo() {}

    public DepartmentVo(int dep_id, String dep_name, String description, String dep_address) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.description = description;
        this.dep_address = dep_address;
    }

    public int getDep_id() { return dep_id; }
    public void setDep_id(int dep_id) { this.dep_id = dep_id; }

    public String getDep_name() { return dep_name; }
    public void setDep_name(String dep_name) { this.dep_name = dep_name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDep_address() { return dep_address; }
    public void setDep_address(String dep_address) { this.dep_address = dep_address; }
}

