package com.student.mentorproject.mapper;

import com.student.mentorproject.dto.request.FirstExamRequestDto;
import com.student.mentorproject.dto.response.FirstExamResponseDto;
import com.student.mentorproject.entity.FirstExamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FirstExamMapper {

    FirstExamEntity mapToFirstExam(FirstExamRequestDto firstExamRequestDto);

    FirstExamResponseDto toResponseDto(FirstExamEntity firstExamEntity);

    void updateFirstExam(FirstExamRequestDto firstExamRequestDto,
                         @MappingTarget FirstExamEntity firstExamEntity);

}
