package com.iamneo.school.service;

import java.util.List;

import com.iamneo.school.dto.SchoolStudentResponse;
import com.iamneo.school.entity.School;

public interface SchoolService {

    boolean saveSchool(School student);

    List<School> getAllSchools();

    SchoolStudentResponse getAllStudnetsBySchoolId(Long schoolId);

}
