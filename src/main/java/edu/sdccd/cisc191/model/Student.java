package edu.sdccd.cisc191.model;

public class Student {

    private final int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
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
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
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
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
    }
}