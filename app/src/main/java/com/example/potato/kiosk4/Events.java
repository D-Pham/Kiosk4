package com.example.potato.kiosk4;


public class Events {
    String pic;
    String name;
    String description;
    String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Events(String pic, String name, String description, String category){
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
