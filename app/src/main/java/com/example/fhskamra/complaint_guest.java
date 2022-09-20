package com.example.fhskamra;

public class complaint_guest {
    String name,branch,contact,detail;

    public complaint_guest(String name, String branch, String contact, String detail) {
        this.name = name;
        this.branch = branch;
        this.contact = contact;
        this.detail = detail;
    }

    public complaint_guest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
