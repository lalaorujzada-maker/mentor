package com.student.mentorproject.service.impl;

import com.student.mentorproject.dto.request.SecondExamRequestDto;
import com.student.mentorproject.dto.response.FirstExamResponseDto;
import com.student.mentorproject.dto.response.SecondExamResponseDto;
import com.student.mentorproject.entity.FirstExamEntity;
import com.student.mentorproject.entity.SecondExamEntity;
import com.student.mentorproject.entity.StudentEntity;
import com.student.mentorproject.exception.ConflictException;
import com.student.mentorproject.exception.ForbiddenException;
import com.student.mentorproject.exception.InvalidCredentialsException;
import com.student.mentorproject.exception.NotFoundException;
import com.student.mentorproject.mapper.SecondExamMapper;
import com.student.mentorproject.repository.SecondExamRepository;
import com.student.mentorproject.service.FirstExamService;
import com.student.mentorproject.service.SecondExamService;
import com.student.mentorproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SecondExamServiceImpl implements SecondExamService {
    private final SecondExamRepository secondExamRepository;
    private final SecondExamMapper secondExamMapper;
    private final StudentService studentService;
    private final FirstExamService firstExamService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SecondExamResponseDto register(SecondExamRequestDto requestDto) {

        StudentEntity student = studentService.findByEmailOrThrow(requestDto.getEmail());

        if (!passwordEncoder.matches(requestDto.getPassword(), student.getPassword())) {
            throw new InvalidCredentialsException("INVALID_CREDENTIALS"); // 401
        }

        FirstExamResponseDto firstExam = firstExamService.getByStudentId(student.getId());

        if (firstExam == null || !firstExam.getPass()) {
            throw new ForbiddenException("NOT_PASSED_FIRST_EXAM"); // 403
        }

        if (secondExamRepository.existsByStudent_Id(student.getId())) {
            throw new ConflictException("QR_ALREADY_EXISTS"); // 409
        }

        SecondExamEntity entity = new SecondExamEntity();
        entity.setStudent(student);

        String qrUrl = "https://api.qrserver.com/v1/create-qr-code/?data="
                + student.getId();

        entity.setQrUrl(qrUrl);

        SecondExamEntity saved = secondExamRepository.save(entity);

        return secondExamMapper.toResponseDto(saved);
    }

    @Override
    public SecondExamResponseDto getById(Long id) {

        SecondExamEntity entity = secondExamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SECOND_EXAM_NOT_FOUND"));

        return secondExamMapper.toResponseDto(entity);
    }

    @Override
    public SecondExamResponseDto getByStudentId(Long studentId) {

        SecondExamEntity entity = secondExamRepository.findByStudent_Id(studentId)
                .orElseThrow(() -> new NotFoundException("SECOND_EXAM_NOT_FOUND"));

        return secondExamMapper.toResponseDto(entity);
    }

    @Override
    public List<SecondExamResponseDto> getAll() {

        return secondExamRepository.findAll()
                .stream()
                .map(secondExamMapper::toResponseDto)
                .toList();
    }

    @Override
    public SecondExamResponseDto update(Long id, SecondExamRequestDto requestDto) {

        SecondExamEntity entity = secondExamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SECOND_EXAM_NOT_FOUND"));

        secondExamMapper.update(requestDto, entity);

        return secondExamMapper.toResponseDto(secondExamRepository.save(entity));
    }

    @Override
    public void delete(Long id) {

        SecondExamEntity entity = secondExamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SECOND_EXAM_NOT_FOUND"));

        secondExamRepository.delete(entity);
    }
}
