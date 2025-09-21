package com.demo.VO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillGeneratorVo {
    private int bill_id;
    private String work_order_name;   // instead of w_id
    private String contractor_name;   // instead of contractor_id
    private BigDecimal bill_amount;
    private String status;
    private LocalDate bill_date;
    private String file_path_url;

    public BillGeneratorVo() {}

    public BillGeneratorVo(int bill_id, String work_order_name, String contractor_name,
                           BigDecimal bill_amount, String status, LocalDate bill_date, String file_path_url) {
        this.bill_id = bill_id;
        this.work_order_name = work_order_name;
        this.contractor_name = contractor_name;
        this.bill_amount = bill_amount;
        this.status = status;
        this.bill_date = bill_date;
        this.file_path_url = file_path_url;
    }

    // Getters and Setters
    public int getBill_id() { return bill_id; }
    public void setBill_id(int bill_id) { this.bill_id = bill_id; }

    public String getWork_order_name() { return work_order_name; }
    public void setWork_order_name(String work_order_name) { this.work_order_name = work_order_name; }

    public String getContractor_name() { return contractor_name; }
    public void setContractor_name(String contractor_name) { this.contractor_name = contractor_name; }

    public BigDecimal getBill_amount() { return bill_amount; }
    public void setBill_amount(BigDecimal bill_amount) { this.bill_amount = bill_amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getBill_date() { return bill_date; }
    public void setBill_date(LocalDate bill_date) { this.bill_date = bill_date; }

    public String getFile_path_url() { return file_path_url; }
    public void setFile_path_url(String file_path_url) { this.file_path_url = file_path_url; }
}
