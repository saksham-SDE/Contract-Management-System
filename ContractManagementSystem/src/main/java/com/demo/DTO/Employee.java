package com.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int e_id;
    private String name;
    private int dep_id;
    private String e_designation;
    private String e_email_id;
    private String e_contact_no;


    private LocalDateTime deletedAt; // Timestamp of deletion

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getE_designation() {
        return e_designation;
    }

    public void setE_designation(String e_designation) {
        this.e_designation = e_designation;
    }

    public String getE_email_id() {
        return e_email_id;
    }

    public void setE_email_id(String e_email_id) {
        this.e_email_id = e_email_id;
    }

    public String getE_contact_no() {
        return e_contact_no;
    }

    public void setE_contact_no(String e_contact_no) {
        this.e_contact_no = e_contact_no;
    }


    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", name='" + name + '\'' +
                ", dep_id=" + dep_id +
                ", e_designation='" + e_designation + '\'' +
                ", e_email_id='" + e_email_id + '\'' +
                ", e_contact_no='" + e_contact_no + '\'' +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
