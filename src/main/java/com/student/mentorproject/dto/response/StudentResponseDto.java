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
public class StudentResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
}
