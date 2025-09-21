package com.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int w_id;
    private int c_id;
    private LocalDate w_issued_date;
    private String w_status;
    private String w_cost;
    private int contractor_id;

    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public LocalDate getW_issued_date() {
        return w_issued_date;
    }

    public void setW_issued_date(LocalDate w_issued_date) {
        this.w_issued_date = w_issued_date;
    }

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }

    public String getW_cost() {
        return w_cost;
    }

    public void setW_cost(String w_cost) {
        this.w_cost = w_cost;
    }

    public int getContractor_id() {
        return contractor_id;
    }

    public void setContractor_id(int contractor_id) {
        this.contractor_id = contractor_id;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "w_id=" + w_id +
                ", c_id=" + c_id +
                ", w_issued_date=" + w_issued_date +
                ", w_status='" + w_status + '\'' +
                ", w_cost='" + w_cost + '\'' +
                ", contractor_id=" + contractor_id +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
