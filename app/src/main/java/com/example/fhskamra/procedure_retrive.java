package com.example.fhskamra;

public class procedure_retrive {
    String Name;
    String url;

    public procedure_retrive(String name, String url) {
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
