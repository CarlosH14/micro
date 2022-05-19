package co.pragma.micro.imagen.infrastructure.entrypoints;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.pragma.micro.imagen.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.imagen.domain.usecase.ImagenUseCase;
import lombok.*;
@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
/**
 * This class is a REST controller that uses the ImagenUseCase class to perform CRUD operations on the
 * ImagenModel class
 */
public class ApiRest {

    @Autowired
    private ImagenUseCase imagenUseCase;

    @GetMapping("/path")
    public String commandName() {
        return "Hello World";
    }
    // ---------- CREATE ----------

    @PostMapping("/imagen")
    public ImagenModel saveImagen(@RequestParam("id") Integer id, @RequestParam("photo") MultipartFile file) throws IOException {
        return imagenUseCase.save(id, file);
    }
    // ---------- FIND ALL ----------

    @GetMapping("/imagen")
    public List<ImagenModel> findAllImagen() {
        return imagenUseCase.findAll();
    }
    // ---------- FIND BY ID ----------

    @GetMapping("/imagen/{id}")
    public ImagenModel findByIdImagen(@PathVariable Integer id) {
        return imagenUseCase.findById(id);
    }
    // ---------- UPDATE ----------

    @PutMapping("/imagen/{id}")
    public ImagenModel updateImagen(@PathVariable Integer id, @RequestParam("photo") MultipartFile file) throws IOException {
        return imagenUseCase.update(id, file);
    }
    // ---------- DELETE ----------

    @DeleteMapping("/imagen/{id}")
    public String deleteImagen(@PathVariable Integer id) {
        return imagenUseCase.deleteById(id);
    }
    // ---------- FIND BY USERID ----------

    @GetMapping("/imagen/userid/{userid}")
    public List<ImagenModel> findByUserIdImagen(@PathVariable Integer userid) {
        return imagenUseCase.findByUserId(userid);
    }

    // ---------- REST TEMPLATE PRUEBAS ----------

    
    @GetMapping("/imagen/s/{id}")
    public String findByImagenString(@PathVariable Integer id) throws UnsupportedEncodingException {
        return imagenUseCase.getImagenString(id);
    }
    

}


