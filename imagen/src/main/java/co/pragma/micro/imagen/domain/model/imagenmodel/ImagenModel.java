package co.pragma.micro.imagen.domain.model.imagenmodel;

import org.bson.types.Binary;

import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class ImagenModel {

    private Integer id;
    private Binary photo;
    private Integer userId;

}
