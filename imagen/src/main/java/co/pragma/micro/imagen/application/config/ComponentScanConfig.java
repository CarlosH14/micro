package co.pragma.micro.imagen.application.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;

import co.pragma.micro.imagen.domain.model.imagenmodel.gateways.ImagenModelRepository;
import co.pragma.micro.imagen.domain.usecase.ImagenUseCase;

import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.pragma.micro.imagen.architecture.domain.usecase",
        includeFilters = {
                @Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class ComponentScanConfig {
    @Bean
    public ImagenUseCase imagenUseCase(ImagenModelRepository imagenModelRepository) {
        return new ImagenUseCase(imagenModelRepository);
    }
}
