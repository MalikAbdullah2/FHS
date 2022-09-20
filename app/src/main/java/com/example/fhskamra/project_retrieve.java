package com.example.fhskamra;

public class project_retrieve {
    String Name;
    String Details;
    String image;

    public project_retrieve() {
    }

    public project_retrieve(String name, String details, String image) {
        Name = name;
        Details = details;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
