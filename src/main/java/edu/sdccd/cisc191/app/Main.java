package edu.sdccd.cisc191.app;

import edu.sdccd.cisc191.model.Course;
import edu.sdccd.cisc191.model.Student;
import edu.sdccd.cisc191.repository.JdbcStudentRepository;
import edu.sdccd.cisc191.repository.CourseRepository;
import edu.sdccd.cisc191.repository.StudentRepository;
import edu.sdccd.cisc191.util.DatabaseInitializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // initialize database
        DatabaseInitializer.initialize();

        // create repositories
        StudentRepository studentRepo = new JdbcStudentRepository();
        CourseRepository courseRepo = new CourseRepository() {
            @Override
            public void save(Course course) {

            }

            @Override
            public List<Course> findByStudentId(int studentId) {
                return List.of();
            }

            @Override
            public List<Course> findAll() {
                return List.of();
            }

            @Override
            public void deleteById(int id) {

            }
        };

        // add students
        studentRepo.save(new Student(1, "Dylan", 3.9));
        studentRepo.save(new Student(2, "Diana", 3.4));
        studentRepo.save(new Student(3, "Danielle", 3.7));

        // add courses (linked by student_id)
        courseRepo.save(new Course(1, "Biotech", 1));
        courseRepo.save(new Course(2, "Calculus", 1));
        courseRepo.save(new Course(3, "English", 2));

        // print all students
        System.out.println("All Students:");
        studentRepo.findAll().forEach(System.out::println);

        // find one student
        System.out.println("\nFind Student ID 1:");
        System.out.println(studentRepo.findById(1));

        // print courses for a student
        System.out.println("\nCourses for Student 1:");
        courseRepo.findByStudentId(1).forEach(System.out::println);

        // update GPA
        System.out.println("\nUpdating GPA...");
        studentRepo.updateGpa(2, 3.8);

        // delete a student
        System.out.println("\nDeleting Student 3...");
        studentRepo.deleteById(3);

        // print after changes
        System.out.println("\nAfter Updates:");
        System.out.println("Students:");
        studentRepo.findAll().forEach(System.out::println);

        System.out.println("Courses:");
        courseRepo.findAll().forEach(System.out::println);
    }
}