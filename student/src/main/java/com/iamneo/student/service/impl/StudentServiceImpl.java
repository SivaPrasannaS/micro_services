package com.iamneo.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iamneo.student.entity.Student;
import com.iamneo.student.repository.StudentRepository;
import com.iamneo.student.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public boolean saveStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByName(student.getName());
        if (!studentOptional.isPresent()) {
            studentRepository.save(student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsBySchoolId(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
