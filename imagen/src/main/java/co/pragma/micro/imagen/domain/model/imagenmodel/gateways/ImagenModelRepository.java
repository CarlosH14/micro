package co.pragma.micro.imagen.domain.model.imagenmodel.gateways;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import co.pragma.micro.imagen.domain.model.imagenmodel.ImagenModel;

public interface ImagenModelRepository {
    
    List<ImagenModel> findAll();
    ImagenModel findById(Integer id);
    ImagenModel save(Integer id, MultipartFile file) throws IOException;
    ImagenModel update(Integer id, MultipartFile file) throws IOException;
    String deleteById(Integer id);
    List<ImagenModel> findByUserId(Integer userId);

    String getImagenString(Integer id) throws UnsupportedEncodingException;
}
