package com.student.mentorproject.service.impl;

import com.student.mentorproject.dto.request.StudentRequestDto;
import com.student.mentorproject.dto.response.StudentResponseDto;
import com.student.mentorproject.entity.StudentEntity;
import com.student.mentorproject.mapper.StudentMapper;
import com.student.mentorproject.repository.StudentRepository;
import com.student.mentorproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto create(StudentRequestDto dto) {
        StudentEntity entity = studentMapper.mapToStudent(dto);
        return studentMapper.mapToStudentResponseDto(studentRepository.save(entity));
    }

    @Override
    public StudentResponseDto getById(Long id) {
        StudentEntity entity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
        return studentMapper.mapToStudentResponseDto(entity);
    }

    @Override
    public List<StudentResponseDto> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::mapToStudentResponseDto)
                .toList();
    }

    @Override
    public StudentResponseDto update(Long id, StudentRequestDto dto) {
        StudentEntity entity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));

        studentMapper.updateStudent(dto, entity);

        return studentMapper.mapToStudentResponseDto(studentRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentEntity findByEmailOrThrow(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
    }

}
