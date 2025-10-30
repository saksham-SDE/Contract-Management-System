package com.demo.DTO;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;
    private int c_id;
    private int bill_id;
    private BigDecimal amount;
    @Column(name = "p_status")
    private String status;
    private LocalDateTime p_time;

    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String pStatus) {
        this.status = pStatus;
    }

    public LocalDateTime getP_time() {
        return p_time;
    }

    public void setP_time(LocalDateTime p_time) {
        this.p_time = p_time;
    }


    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", c_id=" + c_id +
                ", bill_id=" + bill_id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", p_time=" + p_time +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
