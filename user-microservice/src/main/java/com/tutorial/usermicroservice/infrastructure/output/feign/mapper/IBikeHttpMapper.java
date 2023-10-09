package com.tutorial.usermicroservice.infrastructure.output.feign.mapper;

import com.tutorial.usermicroservice.domain.model.Bike;
import com.tutorial.usermicroservice.infrastructure.output.feign.dto.BikeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBikeHttpMapper {
    Bike toModel(BikeDto bikeDto);

    BikeDto toHttpClient(Bike bike);
}
