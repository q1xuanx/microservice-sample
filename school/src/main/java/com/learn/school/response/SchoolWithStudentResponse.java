package com.learn.school.response;

import com.learn.school.dto.StudentDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolWithStudentResponse {
    private String schoolName;
    private List<StudentDto> studentDtoList;
    private int totalStudents;
}
