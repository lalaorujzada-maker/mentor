package com.student.mentorproject.service;

import com.student.mentorproject.dto.request.SecondExamRequestDto;
import com.student.mentorproject.dto.response.SecondExamResponseDto;

import java.util.List;

public interface SecondExamService {
    // CREATE (REGISTER)
    SecondExamResponseDto register(SecondExamRequestDto requestDto);

    // READ
    SecondExamResponseDto getById(Long id);

    SecondExamResponseDto getByStudentId(Long studentId);

    List<SecondExamResponseDto> getAll();

    // UPDATE
    SecondExamResponseDto update(Long id, SecondExamRequestDto requestDto);

    // DELETE
    void delete(Long id);
}
