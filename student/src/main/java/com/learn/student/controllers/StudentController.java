package com.learn.student.controllers;

import com.learn.student.services.StudentService;
import com.learn.student.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAllStudent());
    }
    @GetMapping("/find-all-with-id/{id_school}")
    public ResponseEntity<List<Student>> findAllWithId(@PathVariable("id_school") Integer idSchool) {
        return ResponseEntity.ok().body(studentService.findBySchoolId(idSchool));
    }
}
