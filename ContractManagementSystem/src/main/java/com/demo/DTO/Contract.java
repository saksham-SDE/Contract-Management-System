package com.demo.DTO;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;
    private int e_id;
    private int n_id;
    private String project_name;
    private LocalDate contract_start_date;
    private LocalDate contract_end_date;
    private BigDecimal contract_cost;
    private String contract_status;
    @Column(name = "contractor_id")
    private int contractorId;


    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getN_id() {
        return n_id;
    }

    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public LocalDate getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(LocalDate contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public LocalDate getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(LocalDate contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public BigDecimal getContract_cost() {
        return contract_cost;
    }

    public void setContract_cost(BigDecimal contract_cost) {
        this.contract_cost = contract_cost;
    }

    public String getContract_status() {
        return contract_status;
    }

    public void setContract_status(String contract_status) {
        this.contract_status = contract_status;
    }

    public int getContractorId() {
        return contractorId;
    }

    public void setContractorId(int contractorId) {
        this.contractorId = contractorId;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "c_id=" + c_id +
                ", e_id=" + e_id +
                ", n_id=" + n_id +
                ", project_name='" + project_name + '\'' +
                ", contract_start_date=" + contract_start_date +
                ", contract_end_date=" + contract_end_date +
                ", contract_cost=" + contract_cost +
                ", contract_status='" + contract_status + '\'' +
                ", contractor_id=" + contractorId +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
