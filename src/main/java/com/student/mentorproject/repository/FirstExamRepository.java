package com.student.mentorproject.repository;

import com.student.mentorproject.entity.FirstExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirstExamRepository extends JpaRepository<FirstExamEntity, Long> {
    Optional<FirstExamEntity> findByStudent_Id(Long studentId);
    Optional<FirstExamEntity> findByStudentId(Long studentId);
}
