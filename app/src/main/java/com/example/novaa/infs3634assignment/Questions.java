package com.example.novaa.infs3634assignment;

//Completed by Leslie

//In the Questions class, we have created a 'mQuestions' array to store questions for the Multiple Choice quiz.
public class Questions {

    public String mQuestions[] = {
            "Which of the following is NOT an OOP concept in Java?",
            "At what stage is overloading determined?",
            "Which concept of Java is a way of converting real world objects in terms of class?",
            "Which concept of Java is achieved by combining methods and attributes into a class?",
            "The Encapsulation concept in Java is:",
            "The following concept can be used for encapsulation in Java programs is called:",
            "Exposing only necessary information to clients (main programs, classes) is known as: ",
            "For the Cat and Animal classes, the correct way of inheritance in Java is:",
            "If I want to have common functions in a class and want to defer implementations of some other functions to derived classes, then we need to use:",
            "Java does not support which of the following?",
            "Which statement is true regarding an object?",
            "The wrapping up of data and functions into a single unit is called",
            "Which one is true about a constructor?",
            "What feature of OOP has a superclass/subclass concept?",
            "What specifies the behaviour for objects of a class in Java?"

    };

    //In the Questions class, we have created a 'mChoices' array to store multiple choice options for the Multiple Choice quiz.

    private String mChoices[][] = {
            {"Inheritance", "Encapsulation", "Polymorphism", "Compilation"},
            {"At run time", "At compile time", "At coding time", "At execution time"},
            {"Polymorphism", "Encapsulation", "Abstraction", "Inheritance"},
            {"Encapsulation", "Inheritance", "Polymorphism", "Abstraction"},
            {"Hiding Complexity", "Method Hiding", "Hiding Constructor", "None"},
            {"Wrapping data fields with methods", "Hiding data and internal methods using access modifiers in a class", "Using Interfaces", "All of the above"},
            {"Abstraction", "Encapsulation", "Data Hiding", "Hiding Complexity"},
            {"The class Cat extends Animal", "The class Animal extends Cat", "Both are correct", "None are correct"},
            {"An Interface", "An abstract class", "A static class", "None"},
            {"Inheritance", "Multiple inheritance for classes", "Multiple inheritance of interfaces", "Compile time polymorphism"},
            {"An object is what classes instantiated are from", "An object is an instance of a class", "An object is a variable", "An object is a reference to an attribute", "An object is not an instance of a class"},
            {"Encapsulation", "Abstraction", "Data Hiding", "Polymorphism"},
            {"A constructor has the same name as the class it is declared within", "A constructor may be declared private", "A constructor is used to create objects", "All of the above"},
            {"Multilevel Inheritance", "Single Inheritance", "Multiple Inheritances", "Hierarchical Inheritance"},
            {"Fields", "Methods", "Class", "Object"}

    };
    //In the Questions class, we have created a 'mCorrectAnswers' array to store all correct answers for each question.

    private String mCorrectAnswers[] = {"Compilation", "At compile time", "Abstraction", "Encapsulation", "Hiding Complexity", "All of the above", "Abstraction", "The class Cat extends Animal", "An abstract class", "Multiple inheritance of interfaces", "An object is an instance of a class", "Encapsulation", "All of the above", "Hierarchical Inheritance", "Methods"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;

    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;

    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
