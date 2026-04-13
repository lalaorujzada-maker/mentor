package com.student.mentorproject.service;

import com.student.mentorproject.dto.request.SecondExamRequestDto;
import com.student.mentorproject.dto.response.SecondExamResponseDto;

import java.util.List;

public interface SecondExamService {
    SecondExamResponseDto register(SecondExamRequestDto requestDto);

    SecondExamResponseDto getById(Long id);

    SecondExamResponseDto getByStudentId(Long studentId);

    List<SecondExamResponseDto> getAll();

    SecondExamResponseDto update(Long id, SecondExamRequestDto requestDto);

    void delete(Long id);
}
