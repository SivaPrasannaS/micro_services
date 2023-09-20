package com.iamneo.school.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.school.dto.SchoolStudentResponse;
import com.iamneo.school.entity.School;
import com.iamneo.school.service.SchoolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSchool(@RequestBody School school) {
        boolean isDataSaved = schoolService.saveSchool(school);
        return isDataSaved ? ResponseEntity.ok("Data saved successfully") : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("/all/students")
    public ResponseEntity<SchoolStudentResponse> getAllStudentsBySchoolId(@RequestParam Long schoolId) {
        return ResponseEntity.ok(schoolService.getAllStudnetsBySchoolId(schoolId));
    }

}
