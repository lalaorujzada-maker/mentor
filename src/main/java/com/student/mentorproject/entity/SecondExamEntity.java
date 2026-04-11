package com.student.mentorproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "second_exam")
public class SecondExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private StudentEntity student;

    private String qrUrl;

    private Integer result;

    private Boolean pass;

}
