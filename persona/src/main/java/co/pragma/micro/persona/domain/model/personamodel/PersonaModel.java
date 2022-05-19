package co.pragma.micro.persona.domain.model.personamodel;


import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonaModel {

    private Integer id;
    private String name;
    private String lastName;
    private String city;
    private Integer age;
    private String typeId;
    private Long numberId;

}
