package com.example.fhskamra;

public class pdf_ret {
    public String Name;
    public String url;

    public pdf_ret() {
    }

    public pdf_ret(String name, String url) {
        Name = name;
        this.url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
