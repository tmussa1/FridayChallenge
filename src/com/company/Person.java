package com.company;

import java.util.ArrayList;

public class Person {
    public String name;
    public String email;
    public ArrayList<Education> education;
    public ArrayList<Experience> experience;
    public ArrayList<Skills> skills;

    Person(){}

    public Person(String name, String email, ArrayList<Education> education, ArrayList<Experience> experience, ArrayList<Skills> skills) {
        this.name = name;
        this.email = email;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
    }
}
