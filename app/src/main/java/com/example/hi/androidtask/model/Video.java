package com.example.hi.androidtask.model;

/**
 * Created by hi on 6/12/2017.
 */

public class Video {

    int image;
    String name, time, description;

    public Video() {
    }

    public Video(int image, String name, String time, String description) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
