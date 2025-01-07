package com.learn.school.client;


import com.learn.school.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="students-service", url = "${application.config.students-url}")
public interface StudentClient {
    @GetMapping("/find-all-with-id/{id_school}")
    List<StudentDto> findAllWithId(@PathVariable("id_school") Integer idSchool);
}
