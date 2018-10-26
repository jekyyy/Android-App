package com.example.novaa.infs3634assignment;

/*This class is a typical Object Class for creating 'Topics', which we will be using in TopicList.java
file to display teach lesson. Each topic has an id, name and youtube path contains a youtube video
to further enhance the students knowledge. */


//Completed by Jacky
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

    // This method is used to display the actual name of the Topic on the View. Without this method,
    // the reference code will be displayed instead, which will make no sense to students.
    @Override
    public String toString() {
        return name;
    }
}
