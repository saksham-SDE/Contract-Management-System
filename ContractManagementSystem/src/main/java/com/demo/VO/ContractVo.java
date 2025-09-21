package com.demo.VO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractVo {

    private int c_id;
    private String project_name;
    private LocalDate contract_start_date;
    private LocalDate contract_end_date;
    private BigDecimal contract_cost;
    private String contract_status;

    private String employee_name;
    private String notification_title;
    private String contractor_name; // NEW

    public ContractVo() {}

    public ContractVo(int c_id, String project_name, LocalDate contract_start_date, LocalDate contract_end_date,
                      BigDecimal contract_cost, String contract_status,
                      String employee_name, String notification_title, String contractor_name) {
        this.c_id = c_id;
        this.project_name = project_name;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_cost = contract_cost;
        this.contract_status = contract_status;
        this.employee_name = employee_name;
        this.notification_title = notification_title;
        this.contractor_name = contractor_name;
    }

    // Getters and Setters
    public int getC_id() { return c_id; }
    public void setC_id(int c_id) { this.c_id = c_id; }
    public String getProject_name() { return project_name; }
    public void setProject_name(String project_name) { this.project_name = project_name; }
    public LocalDate getContract_start_date() { return contract_start_date; }
    public void setContract_start_date(LocalDate contract_start_date) { this.contract_start_date = contract_start_date; }
    public LocalDate getContract_end_date() { return contract_end_date; }
    public void setContract_end_date(LocalDate contract_end_date) { this.contract_end_date = contract_end_date; }
    public BigDecimal getContract_cost() { return contract_cost; }
    public void setContract_cost(BigDecimal contract_cost) { this.contract_cost = contract_cost; }
    public String getContract_status() { return contract_status; }
    public void setContract_status(String contract_status) { this.contract_status = contract_status; }
    public String getEmployee_name() { return employee_name; }
    public void setEmployee_name(String employee_name) { this.employee_name = employee_name; }
    public String getNotification_title() { return notification_title; }
    public void setNotification_title(String notification_title) { this.notification_title = notification_title; }
    public String getContractor_name() { return contractor_name; }
    public void setContractor_name(String contractor_name) { this.contractor_name = contractor_name; }
}
