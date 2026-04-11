package com.student.mentorproject.mapper;

import com.student.mentorproject.dto.request.StudentRequestDto;
import com.student.mentorproject.dto.response.StudentResponseDto;
import com.student.mentorproject.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity mapToStudent(StudentRequestDto studentRequestDto);

    StudentResponseDto mapToStudentResponseDto(StudentEntity studentEntity);

    void updateStudent(StudentRequestDto studentRequestDto,
                       @MappingTarget StudentEntity studentEntity);
}
