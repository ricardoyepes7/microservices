package com.tutorial.bikemicroservice.infrastructure.configuration;

import com.tutorial.bikemicroservice.domain.api.IBikeServicePort;
import com.tutorial.bikemicroservice.domain.spi.IBikePersistencePort;
import com.tutorial.bikemicroservice.domain.usecase.BikeUseCase;
import com.tutorial.bikemicroservice.infrastructure.output.jpa.adapter.BikeJpaAdapter;
import com.tutorial.bikemicroservice.infrastructure.output.jpa.mapper.IBikeEntityMapper;
import com.tutorial.bikemicroservice.infrastructure.output.jpa.repository.IBikeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {
    @Bean
    public IBikeServicePort bikeServicePort(IBikePersistencePort bikePersistencePort){
        return new BikeUseCase(bikePersistencePort);
    }
    @Bean
    public IBikePersistencePort bikePersistencePort(IBikeRepository bikeRepository,
                                                    IBikeEntityMapper bikeEntityMapper){
        return new BikeJpaAdapter(bikeRepository,bikeEntityMapper);
    }
}
