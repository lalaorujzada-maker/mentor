package com.student.mentorproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecondExamRequestDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
