package co.pragma.micro.imagen.application.config;

import org.mapstruct.Mapper;

import co.pragma.micro.imagen.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.imagen.infrastructure.drivenadapters.mongorepository.entities.Imagen;

@Mapper
public interface ObjectMapperConfig{

    //ToData
    public ImagenModel ImagenToImagenModel(Imagen e);

    //ToEntity
    public Imagen ImagenModelToImagen(ImagenModel d);

}