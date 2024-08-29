package com.project.personalfinancialmanagement.mapper;

import com.project.personalfinancialmanagement.dto.ChangeNameDTO;
import com.project.personalfinancialmanagement.dto.UserDTO;
import com.project.personalfinancialmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    
}
