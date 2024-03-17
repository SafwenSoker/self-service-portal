package com.example.selfserviceportal.utils;

import com.example.selfserviceportal.dtos.UserDto;
import com.example.selfserviceportal.exceptions.EntityNotFoundException;
import com.example.selfserviceportal.handlers.ErrorCodes;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.ArrayList;

public class KeycloakService {

    public static UserDto toDto(String userId){
        UserDto userDto = new UserDto();
        UserRepresentation userRepresentation = new UserRepresentation();
        try {
            userRepresentation = KeycloakManager.getInstance().realm(KeycloakManager.realm).users().get(userId).toRepresentation();
        }catch (Exception e){
            throw new EntityNotFoundException("User with this id is not exist", ErrorCodes.ENTITY_NOT_FOUND, new ArrayList<>());
        }
        userDto.setUserId(userRepresentation.getId());
        userDto.setEmail(userRepresentation.getEmail());
        userDto.setLastName(userRepresentation.getLastName());
        userDto.setFirstName(userRepresentation.getLastName());
        userDto.setUserName(userRepresentation.getUsername());

        return  userDto;
    }
}
