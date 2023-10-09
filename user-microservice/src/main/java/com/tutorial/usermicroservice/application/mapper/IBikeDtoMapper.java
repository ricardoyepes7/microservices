package com.tutorial.usermicroservice.application.mapper;

import com.tutorial.usermicroservice.application.dto.BikeDto;
import com.tutorial.usermicroservice.domain.model.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBikeDtoMapper {
    BikeDto toDto(Bike bike);

    Bike toModel(BikeDto bikeDto);
}
