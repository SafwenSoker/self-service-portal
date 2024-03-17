package com.example.selfserviceportal.controllers.impl;

import com.example.selfserviceportal.controllers.interfaces.ISelfServicePortalController;
import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.services.useCases.IRequestDayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("self-service")
@RequiredArgsConstructor
public class SelfServicePortalController implements ISelfServicePortalController {

    private final IRequestDayOffService requestDayOffService;

    @Override
    public ResponseEntity<DayOffRequestDto> sendRequest(DayOffRequestDto dayOffRequestDto) {
        return new ResponseEntity<>(requestDayOffService.createDayOffRequest(dayOffRequestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<DayOffRequestDto>> getRequestByUserId(String userId) {
        return new ResponseEntity<>(requestDayOffService.getAllRequestDayOffServiceByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteRequestById(Long id) {
        requestDayOffService.deleteDayOffServiceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DayOffRequestDto> updateRequest(DayOffRequestDto dayOffRequestDto) {
        return new ResponseEntity<>(requestDayOffService.updateDayOffService(dayOffRequestDto), HttpStatus.OK);
    }
}
