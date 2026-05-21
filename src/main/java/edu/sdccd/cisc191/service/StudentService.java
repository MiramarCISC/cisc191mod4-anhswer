package edu.sdccd.cisc191.service;

import edu.sdccd.cisc191.model.Student;
import edu.sdccd.cisc191.repository.CourseRepository;
import edu.sdccd.cisc191.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public void addStudent(Student student) {
<<<<<<< HEAD
        // TODO delegate to repository
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        repository.save(student);
    }
    public Student getStudent(int id) {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return repository.findById(id);
    }
    public List<Student> getAllStudents() {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return repository.findAll();
    }
    public void changeGpa(int id, double newGpa) {
<<<<<<< HEAD
        // TODO
        repository.updateGpa(id,newGpa);
=======
        repository.updateGpa(id, newGpa);
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }
    public void removeStudent(int id) {
<<<<<<< HEAD
        // TODO
=======
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        repository.deleteById(id);
    }
}