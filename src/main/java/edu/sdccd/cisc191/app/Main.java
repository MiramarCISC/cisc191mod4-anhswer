package edu.sdccd.cisc191.app;

import edu.sdccd.cisc191.model.Course;
import edu.sdccd.cisc191.model.Student;
<<<<<<< HEAD
import edu.sdccd.cisc191.repository.JdbcCourseRepository;
import edu.sdccd.cisc191.repository.JdbcStudentRepository;
import edu.sdccd.cisc191.repository.StudentRepository;
import edu.sdccd.cisc191.service.StudentService;

import edu.sdccd.cisc191.util.DatabaseConfig;
import edu.sdccd.cisc191.util.DatabaseInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // TODO initialize database
        DatabaseInitializer.initialize();
        try(Connection conn = DatabaseConfig.getConnection()){
            System.out.println("connected");
            conn.createStatement().executeUpdate("DELETE FROM courses");
            conn.createStatement().executeUpdate("DELETE FROM students");
            // TODO create student service and repositories
            var StudentRepo = new JdbcStudentRepository(conn);
            var courseRepo = new JdbcCourseRepository(conn);
            var studentService = new StudentService(StudentRepo);

            // TODO add at least 3 students
            studentService.addStudent(new Student(1,"Bob", 3.7));
            studentService.addStudent(new Student(2,"bob1", 3.4));
            studentService.addStudent(new Student(3,"bob2", 3.9));
            // TODO add at least 3 courses linked to students
            courseRepo.save(new Course(101,"AP US History",3));
            courseRepo.save(new Course(102,"Calculus",2));
            courseRepo.save(new Course(103,"English",1));
            // TODO print all students
            System.out.println("All students:");
            studentService.getAllStudents().forEach(System.out::println);
            // TODO find one student by ID
            System.out.println("\nStudent with ID 2:");
            System.out.println(studentService.getStudent(2));
            // TODO print courses for a student
            System.out.println("\nCourses for student 1:");
            courseRepo.findByStudentId(1).forEach(System.out::println);
            // TODO update one GPA
            System.out.println("\nUpdating gpa for student 3");
            studentService.changeGpa(3,4.0);
            // TODO delete one student
            System.out.println("\nRemaining students:");
            studentService.getAllStudents().forEach(System.out::println);

            System.out.println("\nRemaining courses:");
            courseRepo.findAll().forEach(System.out::println);
            // TODO print remaining students and courses
            conn.createStatement().executeUpdate(
                    "DELETE FROM courses WHERE student_id = 2"
            );
            studentService.removeStudent(2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
=======
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
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
