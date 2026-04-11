package com.student.mentorproject.controller;

import com.student.mentorproject.dto.request.SecondExamRequestDto;
import com.student.mentorproject.dto.response.SecondExamResponseDto;
import com.student.mentorproject.service.SecondExamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/second-exam")
@AllArgsConstructor
public class SecondExamController {
    private final SecondExamService secondExamService;

    // 🔥 REGISTER (MAIN TASK)
    @PostMapping("/register")
    public SecondExamResponseDto register(@RequestBody SecondExamRequestDto requestDto) {
        return secondExamService.register(requestDto);
    }

    @GetMapping("/{id}")
    public SecondExamResponseDto getById(@PathVariable Long id) {
        return secondExamService.getById(id);
    }

    @GetMapping("/student/{studentId}")
    public SecondExamResponseDto getByStudentId(@PathVariable Long studentId) {
        return secondExamService.getByStudentId(studentId);
    }

    @GetMapping
    public List<SecondExamResponseDto> getAll() {
        return secondExamService.getAll();
    }

    @PutMapping("/{id}")
    public SecondExamResponseDto update(@PathVariable Long id,
                                        @RequestBody SecondExamRequestDto requestDto) {
        return secondExamService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        secondExamService.delete(id);
    }
}

