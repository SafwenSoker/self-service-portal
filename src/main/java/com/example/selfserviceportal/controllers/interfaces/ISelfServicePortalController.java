package com.example.selfserviceportal.controllers.interfaces;

import com.example.selfserviceportal.dtos.DayOffRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface ISelfServicePortalController {

    @PostMapping
    ResponseEntity<DayOffRequestDto> sendRequest(@RequestBody DayOffRequestDto dayOffRequestDto);
    @GetMapping(path = "/{userId}")
    ResponseEntity<List<DayOffRequestDto>> getRequestByUserId(@PathVariable String userId);
    @DeleteMapping(path = "/{id}")
    ResponseEntity<Void> deleteRequestById(@PathVariable Long id);
    @PutMapping
    ResponseEntity<DayOffRequestDto> updateRequest(@RequestBody DayOffRequestDto dayOffRequestDto);
}
