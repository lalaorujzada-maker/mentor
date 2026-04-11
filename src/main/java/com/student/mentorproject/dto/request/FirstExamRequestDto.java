package com.student.mentorproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirstExamRequestDto {
    @NotBlank
    private Long studentId;
    @NotBlank
    private Integer result;
}
