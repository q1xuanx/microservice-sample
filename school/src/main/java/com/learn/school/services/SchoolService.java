package com.learn.school.services;


import com.learn.school.client.StudentClient;
import com.learn.school.dto.StudentDto;
import com.learn.school.entities.School;
import com.learn.school.repositories.SchoolRepository;
import com.learn.school.response.SchoolWithStudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
    public SchoolWithStudentResponse schoolWithStudentResponse(Integer idSchool){
        School school = schoolRepository.findById(idSchool).orElse(School.builder().name("NOT FOUND").build());
        List<StudentDto> students = studentClient.findAllWithId(idSchool);
        return SchoolWithStudentResponse.builder()
                .schoolName(school.getName())
                .studentDtoList(students)
                .totalStudents(students.size())
                .build();
    }
}
