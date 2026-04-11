package com.student.mentorproject.controller;

import com.student.mentorproject.dto.request.FirstExamRequestDto;
import com.student.mentorproject.dto.response.FirstExamResponseDto;
import com.student.mentorproject.service.FirstExamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/first-exam")
@AllArgsConstructor
public class FirstExamController {
    private final FirstExamService firstExamService;

    @PostMapping
    public FirstExamResponseDto create(@RequestBody FirstExamRequestDto requestDto) {
        return firstExamService.create(requestDto);
    }

    @GetMapping("/{id}")
    public FirstExamResponseDto getById(@PathVariable Long id) {
        return firstExamService.getById(id);
    }

    @GetMapping("/student/{studentId}")
    public FirstExamResponseDto getByStudentId(@PathVariable Long studentId) {
        return firstExamService.getByStudentId(studentId);
    }

    @GetMapping
    public List<FirstExamResponseDto> getAll() {
        return firstExamService.getAll();
    }

    @PutMapping("/{id}")
    public FirstExamResponseDto update(@PathVariable Long id,
                                       @RequestBody FirstExamRequestDto requestDto) {
        return firstExamService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        firstExamService.delete(id);
    }
}
