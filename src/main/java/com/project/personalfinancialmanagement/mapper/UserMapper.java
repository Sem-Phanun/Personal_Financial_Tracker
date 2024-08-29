package com.project.personalfinancialmanagement.mapper;

import com.project.personalfinancialmanagement.dto.ChangeNameDTO;
import com.project.personalfinancialmanagement.dto.IncomeDTO;
import com.project.personalfinancialmanagement.dto.UserDTO;
import com.project.personalfinancialmanagement.entity.Income;
import com.project.personalfinancialmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    @Mapping(target = "user", ignore = true)
    Income toIncome(IncomeDTO incomeDTO);
}
