package com.example.potato.kiosk4;


public class Events {
    String pic;
    String name;
    String description;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Events(String pic, String name, String description){
        this.pic = pic;
        this.name = name;
        this.description = description;
    }
}
