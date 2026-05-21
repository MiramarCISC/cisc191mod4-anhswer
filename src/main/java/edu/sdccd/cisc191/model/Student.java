package edu.sdccd.cisc191.model;

public class Student {

    private final int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
<<<<<<< HEAD
        // TODO validate fields and assign them
        if(id<= 0){
            throw new IllegalArgumentException("Id cannot be negative");
        }
        if(gpa< 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("Out of range");
        }
        if( name == null || name.trim().isEmpty() ){
            throw new IllegalArgumentException("Empty name");
        }
        this.gpa = gpa;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        // TODO


=======
        // validation
        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be greater than 0");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }

        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return id;
    }

    public String getName() {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return name;
    }

    public double getGpa() {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return gpa;
    }

    public void setName(String name) {
<<<<<<< HEAD
        // TODO validate and assign
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void setGpa(double gpa) {
        // TODO validate and assign
        if(gpa < 0.0 || gpa > 4.0){
            throw new IllegalArgumentException("Out of range");
        }
=======
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        this.name = name;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        // TODO
        return "Student id: "+ id + ", name"+ name +"/" + "gpa="
                + gpa;
=======
        return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }
}