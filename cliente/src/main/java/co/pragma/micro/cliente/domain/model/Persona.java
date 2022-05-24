package co.pragma.micro.cliente.domain.model;

import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Persona {
    private String name;
    private String lastName;
    private String city;
    private Integer age;
    private String typeId;
    private Long numberId;
}
