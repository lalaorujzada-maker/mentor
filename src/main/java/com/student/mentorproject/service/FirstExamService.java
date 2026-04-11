package com.student.mentorproject.service;

import com.student.mentorproject.dto.request.FirstExamRequestDto;
import com.student.mentorproject.dto.response.FirstExamResponseDto;

import java.util.List;

public interface FirstExamService {
    FirstExamResponseDto create(FirstExamRequestDto dto);

    FirstExamResponseDto getById(Long id);

    List<FirstExamResponseDto> getAll();

    FirstExamResponseDto update(Long id, FirstExamRequestDto dto);

    void delete(Long id);

    FirstExamResponseDto getByStudentId(Long studentId);
}
