package com.demo.DTO;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wId;

    @Column(name = "c_id")
    private int cId;

    private LocalDate wIssuedDate;
    private String wStatus;
    private String wCost;

    @Column(name = "contractor_id")
    private int contractorId;

    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getWId() {
        return wId;
    }

    public void setWId(int wId) {
        this.wId = wId;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public LocalDate getWIssuedDate() {
        return wIssuedDate;
    }

    public void setWIssuedDate(LocalDate wIssuedDate) {
        this.wIssuedDate = wIssuedDate;
    }

    public String getWStatus() {
        return wStatus;
    }

    public void setWStatus(String wStatus) {
        this.wStatus = wStatus;
    }

    public String getWCost() {
        return wCost;
    }

    public void setWCost(String wCost) {
        this.wCost = wCost;
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
        return "WorkOrder{" +
                "wId=" + wId +
                ", cId=" + cId +
                ", wIssuedDate=" + wIssuedDate +
                ", wStatus='" + wStatus + '\'' +
                ", wCost='" + wCost + '\'' +
                ", contractorId=" + contractorId +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
