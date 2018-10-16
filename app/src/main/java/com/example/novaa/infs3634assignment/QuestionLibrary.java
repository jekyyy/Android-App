package com.example.novaa.infs3634assignment;

public class QuestionLibrary {

    //Creating an array to store Multiple-Choice Questions and create reusable code
    //Here, each variable is an array

    private String mQuestions [] = {
            "Which of the following is not an OOP concept in Java?",
            "At what stage is overloading determined?",
            "Which concept is a way of converting real world objects in terms of class?",
            "Which concept involves combining methods and attributes into a class?",


    };

    private String mChoices [] [] = {
            {"Inheritance", "Encapsulation", "Polymorphism", "Compilation"},
            {"At runtime", "At compile time", "At coding time", "At execution time"},
            {"Polymorphism", "Encapsulation", "Abstraction", "Inheritance" },
            {"Encapsulation", "Inheritance", "Polymorphism", "Abstraction"},

    };

    private String mCorrectAnswers[] = {"Compilation", "At compile time", "Abstraction", "Encapsulation"};


    //The 'getQuestion' method returns a question from the mQuestions array
    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    //returns the first item in an array of the mChoices array
    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;

    }


    //Following method returns the correct answer

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }


}