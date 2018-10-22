package com.example.novaa.infs3634assignment;

public class Topics {
    private int id;
    private String name;
    private String youtubePath;

    public Topics(int id, String name, String youtubePath) {
        this.setId(id);
        this.setName(name);
        this.setYoutubePath(youtubePath);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getYoutubePath() {
        return youtubePath;
    }

    public void setYoutubePath(String youtubePath) {
        this.youtubePath = youtubePath;
    }


    @Override
    public String toString() {
        return name;
    }
}
