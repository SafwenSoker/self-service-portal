package com.example.selfserviceportal.dtos;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserHrInfoDto {
    private Long id;

    private int numberOfHoursOff;

    private LocalDate startDate;

    private LocalDate endDate;

    private double note;

    private UserDto userDto;
}
