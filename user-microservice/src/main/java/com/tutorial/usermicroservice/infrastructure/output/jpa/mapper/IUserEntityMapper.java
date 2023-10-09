package com.tutorial.usermicroservice.infrastructure.output.jpa.mapper;

import com.tutorial.usermicroservice.domain.model.User;
import com.tutorial.usermicroservice.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    User toModel(UserEntity userEntity);
    UserEntity toEntity(User user);
}
