package com.example.robustsearch.controller;

import com.example.robustsearch.entity.Student;
import com.example.robustsearch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public String create(@RequestBody Student student) {
        studentService.create(student);
        return "created";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.delete(id);
        return "deleted";
    }

    @GetMapping("/get/{id}")
    public Student get(@PathVariable Integer id) {
        return studentService.get(id);
    }

    @GetMapping("/get")
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
