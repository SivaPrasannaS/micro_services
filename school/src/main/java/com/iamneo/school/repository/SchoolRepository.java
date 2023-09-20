package com.iamneo.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByName(String name);

}
