package com.demo.VO;

import java.time.LocalDate;

public class WorkOrderVo {

    private int w_id;
    private String project_name;
    private LocalDate w_issued_date;
    private String w_status;
    private String w_cost;
    private int contractor_id;
    private String contractor_name;

    public WorkOrderVo() {}

    public WorkOrderVo(int w_id, String project_name, LocalDate w_issued_date,
                       String w_status, String w_cost, int contractor_id, String contractor_name) {
        this.w_id = w_id;
        this.project_name = project_name;
        this.w_issued_date = w_issued_date;
        this.w_status = w_status;
        this.w_cost = w_cost;
        this.contractor_id = contractor_id;
        this.contractor_name = contractor_name;
    }

    // Getters and Setters
    public int getW_id() { return w_id; }
    public void setW_id(int w_id) { this.w_id = w_id; }
    public String getProject_name() { return project_name; }
    public void setProject_name(String project_name) { this.project_name = project_name; }
    public LocalDate getW_issued_date() { return w_issued_date; }
    public void setW_issued_date(LocalDate w_issued_date) { this.w_issued_date = w_issued_date; }
    public String getW_status() { return w_status; }
    public void setW_status(String w_status) { this.w_status = w_status; }
    public String getW_cost() { return w_cost; }
    public void setW_cost(String w_cost) { this.w_cost = w_cost; }
    public int getContractor_id() { return contractor_id; }
    public void setContractor_id(int contractor_id) { this.contractor_id = contractor_id; }
    public String getContractor_name() { return contractor_name; }
    public void setContractor_name(String contractor_name) { this.contractor_name = contractor_name; }
}
