package com.student.mentorproject.controller;

import com.student.mentorproject.dto.request.StudentRequestDto;
import com.student.mentorproject.dto.response.StudentResponseDto;
import com.student.mentorproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public StudentResponseDto create(@RequestBody StudentRequestDto requestDto) {
        return studentService.create(requestDto);
    }

    @GetMapping("/{id}")
    public StudentResponseDto getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id,
                                     @RequestBody StudentRequestDto requestDto) {
        return studentService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
