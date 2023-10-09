package com.tutorial.carmicroservice.application.mapper;

import com.tutorial.carmicroservice.application.dto.CarDto;
import com.tutorial.carmicroservice.domain.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICarDtoMapper {
    Car toModel(CarDto carDto);
    CarDto toDto(Car car);
}
