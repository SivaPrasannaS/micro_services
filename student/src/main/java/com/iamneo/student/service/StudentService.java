package com.iamneo.student.service;

import java.util.List;

import com.iamneo.student.entity.Student;

public interface StudentService {

    boolean saveStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getAllStudentsBySchoolId(Long schoolId);

}
