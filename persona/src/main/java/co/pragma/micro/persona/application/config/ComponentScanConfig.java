package co.pragma.micro.persona.application.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;

import co.pragma.micro.persona.domain.model.personamodel.gateways.PersonaModelRepository;
import co.pragma.micro.persona.domain.usecase.PersonaUseCase;

import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.pragma.micro.persona.architecture.domain.usecase",
        includeFilters = {
                @Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class ComponentScanConfig {
    @Bean
    public PersonaUseCase personaUseCase(PersonaModelRepository personaModelRepository) {
        return new PersonaUseCase(personaModelRepository);
    }
}
