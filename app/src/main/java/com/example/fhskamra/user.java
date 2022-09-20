package com.example.fhskamra;

public class user {
    String email,name,cnic,number;

    public user(String email, String name, String cnic, String number) {
        this.email = email;
        this.name = name;
        this.cnic = cnic;
        this.number = number;
    }

    public user() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
