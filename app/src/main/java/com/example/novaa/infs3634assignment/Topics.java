package com.example.novaa.infs3634assignment;

public class Topics {
    private int id;
    private String name;

    public Topics(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    /*
    public Topics(int id, String name, String path){
        this.setId(id);
        this.setName(name);
        this.setPath(path);
    }
    */

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

    /*
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    */

    @Override
    public String toString(){
        return name;
    }
}
