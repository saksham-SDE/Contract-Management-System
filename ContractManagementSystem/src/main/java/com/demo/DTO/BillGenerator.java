package com.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BillGenerator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_id;
    private int w_id;
    private int contractor_id;
    private BigDecimal bill_amount;
    private String status;
    private LocalDate bill_date;
    private String file_path_url;
    private boolean isDeleted = false; // Soft delete flag

    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getContractor_id() {
        return contractor_id;
    }

    public void setContractor_id(int contractor_id) {
        this.contractor_id = contractor_id;
    }

    public BigDecimal getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(BigDecimal bill_amount) {
        this.bill_amount = bill_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBill_date() {
        return bill_date;
    }

    public void setBill_date(LocalDate bill_date) {
        this.bill_date = bill_date;
    }

    public String getFile_path_url() {
        return file_path_url;
    }

    public void setFile_path_url(String file_path_url) {
        this.file_path_url = file_path_url;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "BillGenerator{" +
                "bill_id=" + bill_id +
                ", w_id=" + w_id +
                ", contractor_id=" + contractor_id +
                ", bill_amount=" + bill_amount +
                ", status='" + status + '\'' +
                ", bill_date=" + bill_date +
                ", file_path_url='" + file_path_url + '\'' +
                ", isDeleted=" + isDeleted +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
