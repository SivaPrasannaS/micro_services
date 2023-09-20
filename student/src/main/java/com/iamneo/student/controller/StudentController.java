package com.iamneo.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.student.entity.Student;
import com.iamneo.student.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        boolean isDataSaved = studentService.saveStudent(student);
        return isDataSaved ? ResponseEntity.ok("Data saved successfully") : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/school/all")
    public ResponseEntity<List<Student>> getAllStudentsBySchoolId(@RequestParam Long schoolId) {
        return ResponseEntity.ok(studentService.getAllStudentsBySchoolId(schoolId));
    }

}
