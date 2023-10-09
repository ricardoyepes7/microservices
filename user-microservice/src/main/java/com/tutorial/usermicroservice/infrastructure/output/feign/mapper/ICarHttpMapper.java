package com.tutorial.usermicroservice.infrastructure.output.feign.mapper;

import com.tutorial.usermicroservice.domain.model.Car;
import com.tutorial.usermicroservice.infrastructure.output.feign.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICarHttpMapper {
    Car toModel(CarDto carDto);
    CarDto toHttpClient(Car car);
}
