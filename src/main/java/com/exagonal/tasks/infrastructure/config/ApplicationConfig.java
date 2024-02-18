package com.exagonal.tasks.infrastructure.config;

import com.exagonal.tasks.application.services.TaskService;
import com.exagonal.tasks.application.usecases.*;
import com.exagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.exagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.exagonal.tasks.domain.ports.out.ExternalServicePort;
import com.exagonal.tasks.infrastructure.adapters.out.externalservices.ExternalServiceAdapter;
import com.exagonal.tasks.infrastructure.adapters.out.database.JpaTaskRepositoryAdapter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(RestTemplate restTemplate) {
        return new ExternalServiceAdapter(restTemplate);
    }

    @Bean
    public RestTemplate createInstanceRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
