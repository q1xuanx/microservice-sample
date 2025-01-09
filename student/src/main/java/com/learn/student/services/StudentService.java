package com.learn.student.services;

import com.learn.student.entities.Student;
import com.learn.student.repositories.StudentRepository;
import com.learn.student.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> findBySchoolId(Integer schoolId){
        return studentRepository.findBySchoolId(schoolId);
    }

    public String login(LoginRequest login){
        if (login.getPassword().isEmpty() || login.getEmail().isEmpty()) {
            return "Missing password or email";
        }
        Boolean isExist = studentRepository.existsByEmailAndPassword(login.getEmail(), login.getPassword());
        if (Boolean.TRUE.equals(isExist)) {
            return "Ok";
        }
        return "Wrong email or password";
    }
}
