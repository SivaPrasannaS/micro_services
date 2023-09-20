package com.iamneo.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);

    List<Student> findAllBySchoolId(Long schoolId);

}
