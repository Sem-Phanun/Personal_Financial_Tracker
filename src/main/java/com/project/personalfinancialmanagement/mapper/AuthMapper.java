package com.project.personalfinancialmanagement.mapper;

import com.project.personalfinancialmanagement.dto.AuthRegisterDTO;
import com.project.personalfinancialmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    @Mapping(target = "password", ignore = true)
    User toAuthRegister(AuthRegisterDTO authRegisterDTO);

    AuthRegisterDTO toAuthRegisterDTO(User user);
}
