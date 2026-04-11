package com.student.mentorproject.dto.response;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString
public class SecondExamResponseDto {
    private Long id;
    private Long studentId;
    private Integer result;
    private Boolean pass;
    private String message;
}
