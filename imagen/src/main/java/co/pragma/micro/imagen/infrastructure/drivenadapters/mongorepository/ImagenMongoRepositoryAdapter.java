package co.pragma.micro.imagen.infrastructure.drivenadapters.mongorepository;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.pragma.micro.imagen.application.config.ObjectMapperConfig;
import co.pragma.micro.imagen.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.imagen.domain.model.imagenmodel.gateways.ImagenModelRepository;
import co.pragma.micro.imagen.infrastructure.drivenadapters.mongorepository.entities.Imagen;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ImagenMongoRepositoryAdapter implements ImagenModelRepository {
    
    @Autowired
    ImagenMongoRepository imagenMongoRepository;

    private ObjectMapperConfig objectMapperConfig = Mappers.getMapper(ObjectMapperConfig.class);

    @Override
    public List<ImagenModel> findAll() {
        List<Imagen> imagen = imagenMongoRepository.findAll();
        List<ImagenModel> imagenModel = new ArrayList<ImagenModel>();
        imagen.forEach(e -> {
            imagenModel.add(objectMapperConfig.ImagenToImagenModel(e));
        });
        return imagenModel;
    }

    @Override
    public ImagenModel findById(Integer id) {
        Optional<Imagen> imagen = imagenMongoRepository.findById(id);
        if(imagenMongoRepository.findById(id).isPresent()){
            return (objectMapperConfig.ImagenToImagenModel(imagen.get()));
        }else{
            return null;
        }
    }

    @Override
    public ImagenModel save(Integer id, MultipartFile file) throws IOException {

        Binary photo = new Binary(BsonBinarySubType.BINARY, file.getBytes());
        Imagen imagen = new Imagen(id, photo, id);
        
        imagen = imagenMongoRepository.save(imagen);
        
        ImagenModel imagenModelResult;
        imagenModelResult = objectMapperConfig.ImagenToImagenModel(imagen);
        return imagenModelResult;
    }

    @Override
    public ImagenModel update(Integer id, MultipartFile file) throws IOException {
        Imagen imagen = imagenMongoRepository.findById(id).get();
        if(imagenMongoRepository.findById(id).isPresent()){
            Imagen imagenResult = imagen;
            Binary photo = new Binary(BsonBinarySubType.BINARY, file.getBytes());
            imagenResult.setId(id);
            imagenResult.setPhoto(photo);
            imagenResult.setUserId(id);
            imagenResult = imagenMongoRepository.save(imagenResult);
            return objectMapperConfig.ImagenToImagenModel(imagenResult);
        }else{
        return null;
        }
    }

    @Override
    public String deleteById(Integer id) {
        try {
            imagenMongoRepository.deleteById(id);
            return "Imagen eliminada";
        } catch (Exception e) {
            return "No se pudo eliminar la imagen";
        }
    }

    @Override
    public List<ImagenModel> findByUserId(Integer userId) {
        List<Imagen> imagen = imagenMongoRepository.findByUserId(userId);
        List<ImagenModel> imagenModel = new ArrayList<ImagenModel>();
        imagen.forEach(e -> {
            imagenModel.add(objectMapperConfig.ImagenToImagenModel(e));
        });
        return imagenModel;
    }


    
    @Override
    public String getImagenString(Integer id) throws UnsupportedEncodingException {
        Optional<Imagen> imagen = imagenMongoRepository.findById(id);
        if(imagenMongoRepository.findById(id).isPresent()){
            return imagen.get().toString();
        }  else { 
            return null;
        }
    }
    
}
