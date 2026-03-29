package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optional = repository.findById(id);
        if(optional.isPresent()){
            Student existing = optional.get();
            existing.setName(updatedStudent.getName());
            existing.setCourse(updatedStudent.getCourse());
            return repository.save(existing);
        }
        return null;
    }

    public boolean deleteStudent(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}