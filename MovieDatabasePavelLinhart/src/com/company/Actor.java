package com.company;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

/*
        1. Třída **Actor** pro herce. Bude obsahovat minimálně atributy pro jméno, příjmení,
   rok narození, národnost, pohlaví (můžete případně přidat i další),
   pak alespoň jeden konstruktor, gettery a settery a metodu toString().

 */

public class Actor {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String nationality;
    private boolean sex;

    public Actor(String name, String surname, String dateOfBirth, String nationality, boolean sex) {
        if (isCorrectName(name)) {
            this.name = name;
        } else {
            this.name = null;
        }
        if (isCorrectSurname(surname)) {
            this.surname = surname;
        } else {
            this.surname = null;
        }
        if(isDateValid(dateOfBirth)) {
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
        }else{
            this.dateOfBirth = null;
        }
        this.nationality = nationality;

        this.sex = sex;     // true = žena
                            // false = muž
    }

    public Actor(String name, String surname) {
        if (isCorrectName(name)) {
            this.name = name;
        } else {
            this.name = null;
        }
        if (isCorrectSurname(surname)) {
            this.surname = surname;
        } else {
            this.surname = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isCorrectName(name)) {
            this.name = name;
        } else {
            this.name = null;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (isCorrectSurname(surname)) {
            this.surname = surname;
        } else {
            this.surname = null;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateBirth) {
        if(isDateValid(dateBirth)) {
            this.dateOfBirth = LocalDate.parse(dateBirth);
        }else{
            this.dateOfBirth = null;
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String report = "" ;
        if(name!=null) {
            report+= name + " ";
        } else{
            report+=",jméno neznámé ";
        }
        if(surname!=null){
            report+=surname;
        } else{
            report+=",příjmění neznámé ";
        }
        /*
        if (dateOfBirth!=null) {
            report += ", narozen: " + dateOfBirth.getDayOfMonth() + ". " + dateOfBirth.getMonthValue() + ". " + dateOfBirth.getYear();
        } else {
            report += ", narozen: neznámo";
        }
        if (sex) {
            report += ", pohlaví: žena";
        } else {
            report += ", pohlaví: muž";
        }
        report+= ", národnost: "+ nationality;

         */
        return report;
    }

    static int isActorExist(String name, String surname, List<Actor> actors){
        for (int i = 0; i < actors.size(); i++) {
            if(actors.get(i)==null){
                return -1;
            }
            if(actors.get(i).getName().equals(name)&&actors.get(i).getSurname().equals(surname)){
                return i;
            }
        }
        return -1;
    }

    public int getAge() {
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        }
        return -1;
    }

    private static boolean isDateValid(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private boolean isCorrectName(String name){
        Pattern patternName = Pattern.compile("([A-Ž][a-ž]+(-[A-Ž][a-ž]+)?)||([A-Ž]\\.([A-Ž]\\.)?)");
        Matcher nameMatcher = patternName.matcher(name);
        return nameMatcher.matches();
    }
    private boolean isCorrectSurname(String surname){
        Pattern patternSurname = Pattern.compile("([A-Ž][a-ž]+(-[A-Ž][a-ž]+)?([A-Ž][a-ž]+)?)||([A-Ž]\\.([A-Ž][a-ž]+(-[A-Ž][a-ž]+)?([A-Ž][a-ž]+)?))");
        Matcher surnameMatcher = patternSurname.matcher(surname);
        return surnameMatcher.matches();
    }
}


