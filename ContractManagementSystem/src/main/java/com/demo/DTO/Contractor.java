package com.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractor_id;
    private String name;
    private String email;
    private String contact_no;
    private String address;
    private String license_no;
    private LocalDate register_date;

    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getContractor_id() {
        return contractor_id;
    }

    public void setContractor_id(int contractor_id) {
        this.contractor_id = contractor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicense_no() {
        return license_no;
    }

    public void setLicense_no(String license_no) {
        this.license_no = license_no;
    }

    public LocalDate getRegister_date() {
        return register_date;
    }

    public void setRegister_date(LocalDate register_date) {
        this.register_date = register_date;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "contractor_id=" + contractor_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", address='" + address + '\'' +
                ", license_no='" + license_no + '\'' +
                ", register_date=" + register_date +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
