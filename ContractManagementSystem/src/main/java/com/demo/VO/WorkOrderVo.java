package com.demo.VO;

import java.time.LocalDate;

public class WorkOrderVo {
    private int w_id;
    private int c_id;               // optional: backend resolves when adding
    private String contract_name;   // human-friendly
    private LocalDate w_issued_date;
    private String w_status;
    private String w_cost;
    private int contractor_id;      // optional
    private String contractor_name; // human-friendly

    public WorkOrderVo() {}

    public WorkOrderVo(int w_id, int c_id, String contract_name, LocalDate w_issued_date,
                       String w_status, String w_cost, int contractor_id, String contractor_name) {
        this.w_id = w_id;
        this.c_id = c_id;
        this.contract_name = contract_name;
        this.w_issued_date = w_issued_date;
        this.w_status = w_status;
        this.w_cost = w_cost;
        this.contractor_id = contractor_id;
        this.contractor_name = contractor_name;
    }

    // Getters & setters
    public int getW_id() { return w_id; }
    public void setW_id(int w_id) { this.w_id = w_id; }
    public int getC_id() { return c_id; }
    public void setC_id(int c_id) { this.c_id = c_id; }
    public String getContract_name() { return contract_name; }
    public void setContract_name(String contract_name) { this.contract_name = contract_name; }
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

