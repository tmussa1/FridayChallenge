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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Person person = new Person();
        String regex = "^[a-zA-Z\\s-]+$"; //for strings with spaces

        while(true) {
        System.out.println("Enter your name: ");
	    String name = input.nextLine();
	                                    //Validation
            if (name.matches(regex)) {
                person.name = name;
                break;
            } else {
                System.out.println("Enter valid value ");
            }
        }

        while(true) {
        System.out.println("Enter your email: ");
        String email = input.nextLine();

        String regex2 = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
                                                                        //Validation
        Pattern pat = Pattern.compile(regex2);
        Matcher match = pat.matcher(email);

            if (match.matches()) {
                person.email = email;
                break;
            } else {
                System.out.println("Enter valid value ");
            }
        }
        System.out.println("Enter your education: ");

        int index2 = 0;
        ArrayList<Education>eduList = new ArrayList<Education>();

        while(index2 < 10){
            Scanner input3 = new Scanner(System.in);
            Education edu = new Education();
        while(true) {
            System.out.println("Enter your degree level: ");
            String degreeLevel = input3.nextLine();

            if (degreeLevel.matches(regex)) {
                edu.degreeLevel = degreeLevel;
                break;
            } else {
                System.out.println("Enter valid value ");
            }
        }
        while(true) {
            System.out.println("Enter your major: ");
            String major = input3.nextLine();

            if (major.matches(regex)) {
                edu.major = major;
                break;
            } else {
                System.out.println("Enter valid value ");
            }
        }
        while(true) {
            System.out.println("Enter your school: ");
            String school = input3.nextLine();

            if (school.matches(regex)) {
                edu.school = school;
                break;
            } else {
                System.out.println("Enter valid value ");
            }
        }
        String regex4 = "^[0-9]+$";
        Pattern pat = Pattern.compile(regex4);
        while(true) {
            System.out.println("Enter your year of graduation: ");
            String yearOfGraduation = input3.nextLine();
            Matcher match = pat.matcher(yearOfGraduation); //validation

            if (match.matches()) {
                edu.yearOfGraduation = yearOfGraduation;
                break;
            } else {
                System.out.println("Enter valid integer: ");
            }
        }
            eduList.add(edu);

            System.out.println("Would you like to add more education or press 'Q' to quit");
            char quit = input3.next().charAt(0);
            if(quit == 'Q' || quit == 'q'){
                break;
            }
            index2++;
        }
        person.education = eduList;

        System.out.println("Enter your work experiences: ");

        int index = 0;
        ArrayList<Experience> expList = new ArrayList<Experience>();
        String regex5 = "^[a-zA-Z\\s-||]+$";
        while(index < 10) {
            Scanner input2 = new Scanner(System.in);

            Experience exp = new Experience();
            while(true) {
                System.out.println("Enter your title: ");
                String title = input2.nextLine();

                if (title.matches(regex5)) {
                    exp.title = title;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }
            while(true) {
                System.out.println("Enter your place of work: ");
                String placeOfWork = input2.nextLine();

                if (placeOfWork.matches(regex)) {
                    exp.placeOfWork = placeOfWork;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }
            String regex3 = "^[a-zA-Z\\s0-9]+$";  //Validation
            Pattern pattern = Pattern.compile(regex3);

            while(true) {
                System.out.println("Enter your start date: ");
                String startDate = input2.nextLine();

                Matcher matcher = pattern.matcher(startDate);

                if (matcher.matches()) {
                    exp.startDate = startDate;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }

            while(true) {
                System.out.println("Enter your end date: ");
                String endDate = input2.nextLine();

                Matcher matcher2 = pattern.matcher(endDate);

                if (matcher2.matches()) {
                    exp.endDate = endDate;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }

            while(true) {
                System.out.println("Enter your duty: ");
                String duty1 = input2.nextLine();

                if (duty1.matches(regex)) {
                    exp.duty1 = duty1;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }

            while(true) {
                System.out.println("Enter your second duty: ");
                String duty2 = input2.nextLine();

                if (duty2.matches(regex)) {
                    exp.duty2 = duty2;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }
            expList.add(exp);

            System.out.println("Would you like to add more experience or press 'Q' to quit");
            char quit = input2.next().charAt(0);
            if(quit == 'Q' || quit == 'q'){
                break;
            }

            index++;
        }

        person.experience = expList;

        System.out.println("Enter your skills: ");

        int index3 = 0;
        ArrayList<Skills>skiList = new ArrayList<Skills>();

        while(index3 < 20){
            Scanner input4 = new Scanner(System.in);

            Skills skill = new Skills();

            while(true) {
                System.out.println("Enter your skill: ");
                String skillName = input4.nextLine();

                if (skillName.matches(regex)) {
                    skill.skillName = skillName;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }
            while(true) {
                System.out.println("Enter your rating: ");
                String rating = input4.nextLine();

                if (rating.matches(regex)) {
                    skill.rating = rating;
                    break;
                } else {
                    System.out.println("Enter valid value ");
                }
            }
            skiList.add(skill);

            System.out.println("Would you like to add more skills or press 'Q' to quit");
            char quit = input4.next().charAt(0);
            if(quit == 'Q' || quit == 'q'){
                break;
            }
            index3++;
        }
        person.skills = skiList;

        FileWriter fWriter = null;
        BufferedWriter writer= null;
        try{
            fWriter = new FileWriter("C:/Users/GBTC441006ur/IdeaProjects/OOP/OOP.txt");
            writer = new BufferedWriter(fWriter);
            writer.write(person.name);
            writer.newLine();
            writer.write(person.email);
            writer.newLine();
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
