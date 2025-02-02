package com.learn.student.controllers;

import com.learn.student.request.LoginRequest;
import com.learn.student.services.StudentService;
import com.learn.student.entities.Student;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private Logger log = LoggerFactory.getLogger(StudentController.class);
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
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        String validLogin = studentService.login(loginRequest);
        if (validLogin != null && validLogin.equals("Ok")) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(validLogin);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validLogin);
    }
}
