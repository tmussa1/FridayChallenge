package com.company;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
	    String name = input.nextLine();
        System.out.println("Enter your email: ");
        String email = input.nextLine();

        System.out.println("Enter your education: ");

        int index2 = 0;
        ArrayList<Education>eduList = new ArrayList<Education>();

        while(index2 < 10){
            Scanner input3 = new Scanner(System.in);
            System.out.println("Enter your degree level: ");
            String degreeLevel = input.nextLine();
            System.out.println("Enter your major: ");
            String major = input.nextLine();
            System.out.println("Enter your school: ");
            String school = input.nextLine();
            System.out.println("Enter your year of graduation: ");
            String yearOfGraduation = input.nextLine();

            eduList.add(new Education(degreeLevel, major, school, yearOfGraduation));

            System.out.println("Would you like to add more education or press 'Q' to quit");
            char quit = input3.next().charAt(0);
            if(quit == 'Q' || quit == 'q'){
                break;
            }
            index2++;
        }
        System.out.println("Enter your work experiences: ");

        int index = 0;
        ArrayList<Experience> expList = new ArrayList<Experience>();

        while(index < 10) {
            Scanner input2 = new Scanner(System.in);

            System.out.println("Enter your title: ");
            String title = input.nextLine();
            System.out.println("Enter your place of work: ");
            String placeOfWork = input.nextLine();
            System.out.println("Enter your start date: ");
            String startDate = input.nextLine();
            System.out.println("Enter your end date: ");
            String endDate = input.nextLine();
            System.out.println("Enter your duty: ");
            String duty1 = input.nextLine();
            System.out.println("Enter your second duty: ");
            String duty2 = input.nextLine();

            expList.add(new Experience(title, placeOfWork, startDate,endDate, duty1, duty2));

            System.out.println("Would you like to add more experience or press 'Q' to quit");
            char quit = input2.next().charAt(0);
            if(quit == 'Q' || quit == 'q'){
                break;
            }

            index++;
        }

        System.out.println("Enter your skills: ");

        int index3 = 0;
        ArrayList<Skills>skiList = new ArrayList<Skills>();

        while(index3 < 20){
            Scanner input3 = new Scanner(System.in);
            System.out.println("Enter your skill: ");
            String skill = input3.nextLine();
            System.out.println("Enter your rating: ");
            String rating  = input3.nextLine();

            skiList.add(new Skills(skill, rating));

            System.out.println("Would you like to add more skills or press 'Q' to quit");
            char quit = input3.next().charAt(0);
            if(quit == 'Q' || quit == 'q'){
                break;
            }
            index3++;
        }
        Person person = new Person(name, email, eduList, expList, skiList);

        FileWriter fWriter = null;
        BufferedWriter writer= null;
        try{
            fWriter = new FileWriter("C:/Users/GBTC441006ur/IdeaProjects/OOP/OOP.txt");
            writer = new BufferedWriter(fWriter);
            writer.write(name);
            writer.newLine();
            writer.write(email);
            writer.newLine();
            writer.write("Education");
            writer.newLine();
            for(Education edu : person.education) {
                writer.write(edu.degreeLevel);
                writer.write(" in ");
                writer.write(edu.major);
                writer.newLine();
                writer.write(edu.school);
                writer.write(" , ");
                writer.write(edu.yearOfGraduation);
                writer.newLine();
                writer.newLine();
            }
            writer.write("Experience");
            writer.newLine();
            for(Experience ex: person.experience){
                writer.write(ex.title);
                writer.newLine();
                writer.write(ex.placeOfWork);
                writer.write(" , ");
                writer.write(ex.startDate);
                writer.write(" - ");
                writer.write(ex.endDate);
                writer.newLine();
                writer.write("- Duty 1, ");
                writer.write(ex.duty1);
                writer.newLine();
                writer.write("- Duty 2, ");
                writer.write(ex.duty2);
                writer.newLine();
                writer.newLine();
            }
            writer.write("Skills");
            writer.newLine();
            for(Skills ski: person.skills){
                writer.write(ski.skillName);
                writer.write(" , ");
                writer.write(ski.rating);
                writer.newLine();
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
