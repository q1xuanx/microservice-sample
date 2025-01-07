package com.learn.school.controllers;

import com.learn.school.entities.School;
import com.learn.school.response.SchoolWithStudentResponse;
import com.learn.school.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<String> createSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
        return ResponseEntity.ok("School created");
    }
    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }
    @GetMapping("/get-school-with-students/{school-id}")
    public ResponseEntity<SchoolWithStudentResponse> schoolWithStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok().body(schoolService.schoolWithStudentResponse(schoolId));
    }
}
