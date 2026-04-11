package com.student.mentorproject.repository;

import com.student.mentorproject.entity.SecondExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecondExamRepository extends JpaRepository<SecondExamEntity, Long> {
    Optional<SecondExamEntity> findByStudent_Id(Long studentId);

    boolean existsByStudent_Id(Long studentId);
}
