package com.tutorial.usermicroservice.application.mapper;

import com.tutorial.usermicroservice.application.dto.UserDto;
import com.tutorial.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserDtoMapper {
    UserDto toDto(User user);
    User toModel(UserDto userDto);
}
