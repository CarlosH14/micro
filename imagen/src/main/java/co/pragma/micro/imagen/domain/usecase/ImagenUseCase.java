package co.pragma.micro.imagen.domain.usecase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import co.pragma.micro.imagen.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.imagen.domain.model.imagenmodel.gateways.ImagenModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImagenUseCase {
    ImagenModelRepository imagenModelRepository;

    public List<ImagenModel> findAll(){return imagenModelRepository.findAll();}
    public ImagenModel findById(Integer id){return imagenModelRepository.findById(id);}
    public ImagenModel save(Integer id, MultipartFile file) throws IOException{return imagenModelRepository.save(id, file);}
    public ImagenModel update(Integer id, MultipartFile file) throws IOException{return imagenModelRepository.update(id, file);}
    public String deleteById(Integer id){return imagenModelRepository.deleteById(id);}
    public List<ImagenModel> findByUserId(Integer userId){return imagenModelRepository.findByUserId(userId);}

    public String getImagenString(Integer id) throws UnsupportedEncodingException{ return imagenModelRepository.getImagenString(id);}
    
}
