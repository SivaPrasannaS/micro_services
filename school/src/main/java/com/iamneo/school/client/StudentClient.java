package com.iamneo.school.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iamneo.school.vo.Student;

@FeignClient(name = "student-service", url = "${application.config.student-service.url}")
public interface StudentClient {

    @GetMapping("/school/all")
    List<Student> getAllStudentsBySchoolId(@RequestParam Long schoolId);
}
