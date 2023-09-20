package com.iamneo.school.dto;

import java.util.List;

import com.iamneo.school.vo.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolStudentResponse {
    private Long schoolId;
    private String schoolName;
    private String schoolEmail;
    private List<Student> students;
}
