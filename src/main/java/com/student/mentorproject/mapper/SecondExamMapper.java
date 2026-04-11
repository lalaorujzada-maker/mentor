package com.student.mentorproject.mapper;

import com.student.mentorproject.dto.request.SecondExamRequestDto;
import com.student.mentorproject.dto.response.SecondExamResponseDto;
import com.student.mentorproject.entity.SecondExamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SecondExamMapper {

    SecondExamEntity toEntity(SecondExamRequestDto secondExamRequestDto);

    SecondExamResponseDto toResponseDto(SecondExamEntity secondExamEntity);

    void update(SecondExamRequestDto secondExamRequestDto,
                          @MappingTarget SecondExamEntity secondExamEntity);

}