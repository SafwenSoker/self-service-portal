package com.example.selfserviceportal.mapper;


import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.entities.DayoffRequest;
import com.example.selfserviceportal.utils.KeycloakService;

public class DayOffRequestMapper {

    private DayOffRequestMapper(){

    }
    public static DayOffRequestDto toDto(DayoffRequest dayoffRequest) {
        return DayOffRequestDto.builder().id(dayoffRequest.getId())
                .userDto(KeycloakService.toDto(dayoffRequest.getUserId()))
                .reason(dayoffRequest.getReason())
                .startDate(dayoffRequest.getStartDate())
                .endDate(dayoffRequest.getEndDate())
                .daysoffType(dayoffRequest.getDaysoffType()).build();
    }


    public static DayoffRequest toEntity(DayOffRequestDto dayOffRequestDto) {
        DayoffRequest dayoffRequest = DayoffRequest.builder()
                .userId(dayOffRequestDto.getUserDto().getUserId())
                .reason(dayOffRequestDto.getReason())
                .startDate(dayOffRequestDto.getStartDate())
                .endDate(dayOffRequestDto.getEndDate())
                .daysoffType(dayOffRequestDto.getDaysoffType()).build();
        dayoffRequest.setId(dayOffRequestDto.getId());
        return dayoffRequest;
    }
}
