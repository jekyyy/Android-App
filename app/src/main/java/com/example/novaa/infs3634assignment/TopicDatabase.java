package com.example.novaa.infs3634assignment;

import java.util.ArrayList;

//Completed by Jacky
public class TopicDatabase {
    private static ArrayList<Topics> topicsArrayList = new ArrayList<Topics>() {
        {
            add(new Topics(1, "Object Oriented Programming", "pTB0EiLXUC8"));
            add(new Topics(2, "Attributes", "_H5uDyB7eVg"));
            add(new Topics(3, "Methods/Behaviors", "-IJ5izjbWIA"));
            add(new Topics(4, "Abstraction", "zZq_XDhU-rc"));
            add(new Topics(5, "Polymorphism", "AmdgVatPL9k"));
            add(new Topics(6, "Inheritance", "aFZ-0bbSLi8"));
            add(new Topics(7, "Encapsulation", "sNKKxc4QHqA"));

        }
    };

    public static ArrayList<Topics> getTopicsArrayList() {
        return topicsArrayList;
    }

}

// This class is used to store the data for each separate topic.