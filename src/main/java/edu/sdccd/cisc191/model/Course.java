package edu.sdccd.cisc191.model;

public class Course {

    private final int id;
    private final String title;
    private final int studentId;

    public Course(int id, String title, int studentId) {
<<<<<<< HEAD
        // TODO validate fields and assign them
        if(id <= 0){
            throw new IllegalArgumentException("Id cannot be below 0");
        }
        if(title == null || title.trim().isEmpty() ){
            throw new IllegalArgumentException("Title should not be null or empty");
        }
        if(studentId <= 0){
            throw new IllegalArgumentException("StudentID cannot be below 0");
        }
=======
        // validation
        if (id <= 0) {
            throw new IllegalArgumentException("Course ID must be greater than 0");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title cannot be blank");
        }
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be greater than 0");
        }

>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        this.id = id;
        this.title = title;
        this.studentId = studentId;
    }

    public int getId() {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return id;
    }

    public String getTitle() {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return title;
    }

    public int getStudentId() {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return studentId;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        // TODO
        return "course id: " + id + ", title: " + title + "/" +
                ", studentId=" + studentId;
=======
        return "Course [id=" + id + ", title=" + title + ", studentId=" + studentId + "]";
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }
}