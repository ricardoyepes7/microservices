package com.tutorial.bikemicroservice.application.mapper;

import com.tutorial.bikemicroservice.application.dto.BikeDto;
import com.tutorial.bikemicroservice.domain.model.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBikeDtoMapper {
    Bike toModel(BikeDto bikeDto);
    BikeDto toDto(Bike bike);
}
