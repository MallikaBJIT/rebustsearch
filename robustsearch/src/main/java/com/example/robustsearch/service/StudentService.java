package com.example.robustsearch.service;

import com.example.robustsearch.entity.Student;
import com.example.robustsearch.repository.StudentRepository;
import com.example.robustsearch.repository.StudentSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void create(Student student) {
        studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student get(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> searchStudents(String name, String department, String address) {
        return studentRepository.findAll(StudentSpecs.dynamicQuery(name, department, address));
    }
}
