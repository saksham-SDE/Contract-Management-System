package com.demo.VO;

import java.time.LocalDate;

public class ContractorVo {

    private int contractor_id;
    private String name;
    private String email;
    private String contact_no;
    private String address;
    private String license_no;
    private LocalDate register_date;

    public ContractorVo() {}

    public ContractorVo(int contractor_id, String name, String email, String contact_no,
                        String address, String license_no, LocalDate register_date) {
        this.contractor_id = contractor_id;
        this.name = name;
        this.email = email;
        this.contact_no = contact_no;
        this.address = address;
        this.license_no = license_no;
        this.register_date = register_date;
    }

    // Getters and setters
    public int getContractor_id() { return contractor_id; }
    public void setContractor_id(int contractor_id) { this.contractor_id = contractor_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContact_no() { return contact_no; }
    public void setContact_no(String contact_no) { this.contact_no = contact_no; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getLicense_no() { return license_no; }
    public void setLicense_no(String license_no) { this.license_no = license_no; }
    public LocalDate getRegister_date() { return register_date; }
    public void setRegister_date(LocalDate register_date) { this.register_date = register_date; }
}

