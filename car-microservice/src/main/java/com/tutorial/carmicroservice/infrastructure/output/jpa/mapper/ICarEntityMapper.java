package com.tutorial.carmicroservice.infrastructure.output.jpa.mapper;

import com.tutorial.carmicroservice.domain.model.Car;
import com.tutorial.carmicroservice.infrastructure.output.jpa.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICarEntityMapper {
    Car toModel(CarEntity carEntity);
    CarEntity toEntity(Car car);
}
