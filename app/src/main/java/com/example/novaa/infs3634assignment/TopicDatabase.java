package com.example.novaa.infs3634assignment;

import java.util.ArrayList;

public class TopicDatabase {
    private static ArrayList<Topics> topicsArrayList = new ArrayList<Topics>() {
        {
            add(new Topics(1, "Object Oriented Programming", "pTB0EiLXUC8"));
            add(new Topics(2, "Attributes", "_H5uDyB7eVg"));
            add(new Topics(3, "Methods/Behaviors"));
            add(new Topics(4, "Abstraction"));
            add(new Topics(5, "Polymorphism"));
            add(new Topics(6, "Inheritance"));
            add(new Topics(7, "Encapsulation", "sNKKxc4QHqA"));

        }
    };

    public static ArrayList<Topics> getTopicsArrayList() {
        return topicsArrayList;
    }

    public static Topics getTopicsById(int id) {
        for (Topics t : topicsArrayList) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}

//TODO: ADD youtube paths to each topic please @Leslie.