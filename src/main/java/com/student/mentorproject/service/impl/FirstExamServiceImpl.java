package com.student.mentorproject.service.impl;

import com.student.mentorproject.dto.request.FirstExamRequestDto;
import com.student.mentorproject.dto.response.FirstExamResponseDto;
import com.student.mentorproject.entity.FirstExamEntity;
import com.student.mentorproject.exception.NotFoundException;
import com.student.mentorproject.mapper.FirstExamMapper;
import com.student.mentorproject.repository.FirstExamRepository;
import com.student.mentorproject.service.FirstExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FirstExamServiceImpl implements FirstExamService {

    private final FirstExamRepository firstExamRepository;
    private final FirstExamMapper firstExamMapper;

    @Override
    public FirstExamResponseDto create(FirstExamRequestDto dto) {
        FirstExamEntity entity = firstExamMapper.mapToFirstExam(dto);
        return firstExamMapper.toResponseDto(firstExamRepository.save(entity));
    }

    @Override
    public FirstExamResponseDto getById(Long id) {
        FirstExamEntity entity = firstExamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("FIRST_EXAM_NOT_FOUND"));
        return firstExamMapper.toResponseDto(entity);
    }

    @Override
    public List<FirstExamResponseDto> getAll() {
        return firstExamRepository.findAll()
                .stream()
                .map(firstExamMapper::toResponseDto)
                .toList();
    }

    @Override
    public FirstExamResponseDto update(Long id, FirstExamRequestDto dto) {
        FirstExamEntity entity = firstExamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("FIRST_EXAM_NOT_FOUND"));

        firstExamMapper.updateFirstExam(dto, entity);

        return firstExamMapper.toResponseDto(firstExamRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        firstExamRepository.deleteById(id);
    }

    @Override
    public FirstExamResponseDto getByStudentId(Long studentId) {

        FirstExamEntity entity = firstExamRepository.findByStudentId(studentId)
                .orElseThrow(() -> new NotFoundException("FIRST_EXAM_NOT_FOUND"));

        return firstExamMapper.toResponseDto(entity);
    }
}
