package co.pragma.micro.persona.domain.model.imagenmodel;

import org.bson.types.Binary;

import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImagenModel {

    private Integer id;
    private Binary photo;
    private Integer userId;

}
