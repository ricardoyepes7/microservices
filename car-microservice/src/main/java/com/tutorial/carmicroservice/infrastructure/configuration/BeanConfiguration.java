package com.tutorial.carmicroservice.infrastructure.configuration;

import com.tutorial.carmicroservice.domain.api.ICarServicePort;
import com.tutorial.carmicroservice.domain.spi.ICarPersistencePort;
import com.tutorial.carmicroservice.domain.usecase.CarUseCase;
import com.tutorial.carmicroservice.infrastructure.output.jpa.adapter.CarJpaAdapter;
import com.tutorial.carmicroservice.infrastructure.output.jpa.mapper.ICarEntityMapper;
import com.tutorial.carmicroservice.infrastructure.output.jpa.repository.ICarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {
    @Bean
    public ICarServicePort carServicePort(ICarPersistencePort carPersistencePort) {
        return new CarUseCase(carPersistencePort);
    }

    @Bean
    public ICarPersistencePort carPersistencePort(ICarRepository carRepository,
                                                  ICarEntityMapper carEntityMapper) {
        return new CarJpaAdapter(carRepository, carEntityMapper);
    }
}
