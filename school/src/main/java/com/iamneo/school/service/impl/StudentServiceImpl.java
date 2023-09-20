package com.iamneo.school.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iamneo.school.client.StudentClient;
import com.iamneo.school.dto.SchoolStudentResponse;
import com.iamneo.school.entity.School;
import com.iamneo.school.repository.SchoolRepository;
import com.iamneo.school.service.SchoolService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    @Override
    public boolean saveSchool(School school) {
        Optional<School> schoolOptional = schoolRepository.findByName(school.getName());
        if (!schoolOptional.isPresent()) {
            schoolRepository.save(school);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public SchoolStudentResponse getAllStudnetsBySchoolId(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder().name("NOT_FOUND").email("NOT_FOUND").build());
        var students = studentClient.getAllStudentsBySchoolId(schoolId);
        return SchoolStudentResponse.builder()
                .schoolId(school.getId())
                .schoolName(school.getName())
                .schoolEmail(school.getEmail())
                .students(students)
                .build();
    }
}
