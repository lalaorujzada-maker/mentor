package com.student.mentorproject.service;

import com.student.mentorproject.dto.request.StudentRequestDto;
import com.student.mentorproject.dto.response.StudentResponseDto;
import com.student.mentorproject.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentResponseDto create(StudentRequestDto dto);

    StudentResponseDto getById(Long id);

    List<StudentResponseDto> getAll();

    StudentResponseDto update(Long id, StudentRequestDto dto);

    void delete(Long id);

    StudentEntity findByEmailOrThrow(String email);
}
