package com.example.selfserviceportal.services.impl;

import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.entities.DayoffRequest;
import com.example.selfserviceportal.entities.UserHRInfo;
import com.example.selfserviceportal.exceptions.EntityNotFoundException;
import com.example.selfserviceportal.handlers.ErrorCodes;
import com.example.selfserviceportal.mapper.DayOffRequestMapper;
import com.example.selfserviceportal.repository.DayOffRequestRepository;
import com.example.selfserviceportal.services.useCases.IRequestDayOffService;
import com.example.selfserviceportal.services.useCases.IUserHrInfoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SelfServicePortalImpl implements IRequestDayOffService, IUserHrInfoService {

    private final DayOffRequestRepository repository;

    @Override
    public List<DayOffRequestDto> getAllRequestDayOffServiceByUserId(String userId) {
        return repository.findAllByUserId(userId).stream()
                .map(DayOffRequestMapper::toDto).toList();
    }

    @Override
    public DayOffRequestDto updateDayOffService(DayOffRequestDto dayOffRequestDto) {

        DayoffRequest request= repository.findById(dayOffRequestDto.getId()).orElseThrow(()->
                new EntityNotFoundException("Id with this day off request is not found", ErrorCodes.ENTITY_NOT_FOUND));

        if (Objects.nonNull(dayOffRequestDto.getDaysoffType())) {
            request.setDaysoffType(
                    dayOffRequestDto.getDaysoffType());
        }

        if (Objects.nonNull(
                dayOffRequestDto.getReason())
                && !"".equalsIgnoreCase(
                dayOffRequestDto.getReason())) {
            request.setReason(
                    dayOffRequestDto.getReason());
        }

        if (Objects.nonNull(dayOffRequestDto.getStartDate())) {
            request.setStartDate(
                    dayOffRequestDto.getStartDate());
        }

        if (Objects.nonNull(dayOffRequestDto.getEndDate())) {
            request.setEndDate(
                    dayOffRequestDto.getEndDate());
        }

        if (Objects.nonNull(dayOffRequestDto.getStatus())) {
            request.setStatus(
                    dayOffRequestDto.getStatus());
        }

        return DayOffRequestMapper.toDto(repository.save(request));
    }

    @Override
    public void deleteDayOffServiceById(Long id) {
        DayoffRequest dayoffRequest1 = repository.findById(id).orElse(null);
        if(dayoffRequest1 == null)
            throw new EntityNotFoundException("there is no dayOffRequest with this id"
            ,ErrorCodes.ENTITY_NOT_FOUND);
      repository.deleteById(id);
      DayoffRequest dayoffRequest=repository.findById(id).orElse(null);
      if(dayoffRequest != null){
          throw new EntityNotFoundException("DayoffRequest not deleted id is not found",
                  ErrorCodes.ENTITY_NOT_FOUND);
      }
    }

    @Override
    @Transactional
    public DayOffRequestDto createDayOffRequest(DayOffRequestDto dayOffRequestDto) {
        DayoffRequest dayoffRequest = DayOffRequestMapper.toEntity(dayOffRequestDto);
        repository.save(dayoffRequest);
        return DayOffRequestMapper.toDto(dayoffRequest);
    }

    @Override
    public boolean createHrInfo(UserHRInfo hrInfo) {
        return false;
    }
}
