package co.pragma.micro.persona.infrastructure.drivenadapters.jparepository.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Integer id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "lastname", nullable = false)
    String lastName;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "age", nullable = false)
    Integer age;
    @Column(name = "typeid", nullable = false)
    String typeId;
    @Column(name = "numberid", nullable = false, unique = true)
    Long numberId;

}
