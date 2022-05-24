package co.pragma.micro.cliente.domain.model;

import org.bson.types.Binary;

import lombok.*;
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {

    private Binary photo;
    private Integer userId;

}