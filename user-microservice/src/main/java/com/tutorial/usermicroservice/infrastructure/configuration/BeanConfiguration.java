package com.tutorial.usermicroservice.infrastructure.configuration;

import com.tutorial.usermicroservice.domain.api.IBikeServicePort;
import com.tutorial.usermicroservice.domain.api.ICarServicePort;
import com.tutorial.usermicroservice.domain.api.IUserServicePort;
import com.tutorial.usermicroservice.domain.spi.IBikePersistencePort;
import com.tutorial.usermicroservice.domain.spi.ICarPersistencePort;
import com.tutorial.usermicroservice.domain.spi.IUserPersistencePort;
import com.tutorial.usermicroservice.domain.usecase.BikeUseCase;
import com.tutorial.usermicroservice.domain.usecase.CarUseCase;
import com.tutorial.usermicroservice.domain.usecase.UserUseCase;
import com.tutorial.usermicroservice.infrastructure.output.feign.adapter.BikeHttpAdapter;
import com.tutorial.usermicroservice.infrastructure.output.feign.adapter.CarHttpAdapter;
import com.tutorial.usermicroservice.infrastructure.output.feign.httpclient.IBikeFeignClient;
import com.tutorial.usermicroservice.infrastructure.output.feign.httpclient.ICarFeignClient;
import com.tutorial.usermicroservice.infrastructure.output.feign.mapper.IBikeHttpMapper;
import com.tutorial.usermicroservice.infrastructure.output.feign.mapper.ICarHttpMapper;
import com.tutorial.usermicroservice.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.tutorial.usermicroservice.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.tutorial.usermicroservice.infrastructure.output.jpa.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {
    @Bean
    public IUserServicePort userServicePort(IUserPersistencePort userPersistencePort) {
        return new UserUseCase(userPersistencePort);
    }

    @Bean
    public IUserPersistencePort userPersistencePort(IUserRepository userRepository,
                                                    IUserEntityMapper userEntityMapper) {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IBikeServicePort bikeServicePort(IBikePersistencePort bikePersistencePort) {
        return new BikeUseCase(bikePersistencePort);
    }

    @Bean
    public IBikePersistencePort bikePersistencePort(IBikeFeignClient bikeFeignClient,
                                                    IBikeHttpMapper bikeHttpMapper) {
        return new BikeHttpAdapter(bikeFeignClient, bikeHttpMapper);
    }

    @Bean
    public ICarServicePort carServicePort(ICarPersistencePort carPersistencePort) {
        return new CarUseCase(carPersistencePort);
    }

    @Bean
    public ICarPersistencePort carPersistencePort(ICarFeignClient carFeignClient,
                                                  ICarHttpMapper carHttpMapper) {
        return new CarHttpAdapter(carFeignClient, carHttpMapper);
    }
}