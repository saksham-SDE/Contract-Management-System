package com.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int n_id;
    private String notification_status;
    private String notification_type;
    private LocalDate n_released_date;
    private LocalDate n_expiring_date;
    private String n_title;
    private String n_description;
    private String filePathURl;

    public String getFilePathURl() {
        return filePathURl;
    }

    public void setFilePathURl(String filePathURl) {
        this.filePathURl = filePathURl;
    }

    public int getN_id() {
        return n_id;
    }

    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    public String getNotification_status() {
        return notification_status;
    }

    public void setNotification_status(String notification_status) {
        this.notification_status = notification_status;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }

    public LocalDate getN_released_date() {
        return n_released_date;
    }

    public void setN_released_date(LocalDate n_released_date) {
        this.n_released_date = n_released_date;
    }

    public LocalDate getN_expiring_date() {
        return n_expiring_date;
    }

    public void setN_expiring_date(LocalDate n_expiring_date) {
        this.n_expiring_date = n_expiring_date;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_description() {
        return n_description;
    }

    public void setN_description(String n_description) {
        this.n_description = n_description;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "n_id=" + n_id +
                ", notification_status='" + notification_status + '\'' +
                ", notification_type='" + notification_type + '\'' +
                ", n_released_date=" + n_released_date +
                ", n_expiring_date=" + n_expiring_date +
                ", n_title='" + n_title + '\'' +
                ", n_description='" + n_description + '\'' +
                ", filePathURl='" + filePathURl + '\'' +
                '}';
    }
}
