package com.tutorial.usermicroservice.application.mapper;

import com.tutorial.usermicroservice.application.dto.CarDto;
import com.tutorial.usermicroservice.domain.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICarDtoMapper {
    CarDto toDto(Car car);
    Car toModel(CarDto carDto);
}
