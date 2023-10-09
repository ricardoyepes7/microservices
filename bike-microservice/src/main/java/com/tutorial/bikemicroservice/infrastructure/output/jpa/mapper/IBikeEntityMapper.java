package com.tutorial.bikemicroservice.infrastructure.output.jpa.mapper;

import com.tutorial.bikemicroservice.domain.model.Bike;
import com.tutorial.bikemicroservice.infrastructure.output.jpa.entity.BikeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBikeEntityMapper {
    Bike toModel(BikeEntity bikeEntity);
    BikeEntity toEntity(Bike bike);
}
