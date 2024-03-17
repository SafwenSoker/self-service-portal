package com.example.selfserviceportal.mapper;

import com.example.selfserviceportal.dtos.UserHrInfoDto;
import com.example.selfserviceportal.entities.UserHRInfo;
import com.example.selfserviceportal.utils.KeycloakService;

public class UserHrInfoMapper {
    private UserHrInfoMapper(){
    }

    public static UserHrInfoDto toDto(UserHRInfo userHRInfo) {
         return UserHrInfoDto.builder()
                .userDto(KeycloakService.toDto(userHRInfo.getUserId()))
                 .id(userHRInfo.getId())
                .startDate(userHRInfo.getStartDate())
                .endDate(userHRInfo.getEndDate())
                .note(userHRInfo.getNote())
                 .numberOfHoursOff(userHRInfo.getNumberOfHoursOff()).build();
    }


    public static UserHRInfo toEntity(UserHrInfoDto userHrInfoDto) {
        UserHRInfo userHRInfo = UserHRInfo.builder()
                .userId(userHrInfoDto.getUserDto().getUserId())
                .note(userHrInfoDto.getNote())
                .startDate(userHrInfoDto.getStartDate())
                .endDate(userHrInfoDto.getEndDate())
                .numberOfHoursOff(userHrInfoDto.getNumberOfHoursOff()).build();
        userHRInfo.setId(userHRInfo.getId());
        return userHRInfo;
    }
}
