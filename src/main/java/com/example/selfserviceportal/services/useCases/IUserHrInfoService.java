package com.example.selfserviceportal.services.useCases;

import com.example.selfserviceportal.entities.UserHRInfo;

public interface IUserHrInfoService {
    boolean createHrInfo(UserHRInfo hrInfo);
}
