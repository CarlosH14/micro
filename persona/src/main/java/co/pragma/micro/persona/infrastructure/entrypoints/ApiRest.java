package co.pragma.micro.persona.infrastructure.entrypoints;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.pragma.micro.persona.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.persona.domain.model.personamodel.PersonaModel;
import co.pragma.micro.persona.domain.usecase.PersonaUseCase;
import lombok.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class ApiRest {

    @Autowired
    private PersonaUseCase personaUseCase;

    @GetMapping("/path")
    public String commandName() {
        return "Hello World";
    }
    // ---------- CREATE ----------
    @PostMapping("/persona")
    public PersonaModel savePersona(@RequestBody PersonaModel personaModel) {
        return personaUseCase.save(personaModel);
    }
    // ---------- FIND ALL ----------
    @GetMapping("/persona")
    public List<PersonaModel> findAllPersona() {
        return personaUseCase.findAll();
    }

    // ---------- FIND BY ID ----------
    @GetMapping("/persona/{id}")
    public PersonaModel findByIdPersona(@PathVariable Integer id) {
        return personaUseCase.findById(id);
    }
    // ---------- UPDATE ----------
    @PutMapping("/persona/{id}")
    public PersonaModel updatePersona(@PathVariable Integer id, @RequestBody PersonaModel personaModelUpdate) {
        return personaUseCase.update(id, personaModelUpdate);
    }
    // ---------- DELETE ----------
    @DeleteMapping("/persona/{id}")
    public String deletePersona(@PathVariable Integer id) {
        return personaUseCase.deleteById(id);
    }
    // ---------- FIND BY TYPEID ----------
    @GetMapping("/persona/typeid/{typeid}")
    public List<PersonaModel> findByTypeidPersona(@PathVariable String typeid) {
        return personaUseCase.findByTypeid(typeid);
    }

    // ---------- FIND BY NUMBERID ----------
    @GetMapping("/persona/numberid/{numberid}")
    public List<PersonaModel> findByNumberidPersona(@PathVariable Long numberid) {
        return personaUseCase.findByNumberid(numberid);
    }

    // ---------- FIND BY TYPEID AND NUMBERID ----------
    @GetMapping("/persona/typeid/{typeid}/numberid/{numberid}")
    public List<PersonaModel> findByTypeidAndNumberidPersona(@PathVariable String typeid, @PathVariable Long numberid) {
        return personaUseCase.findByTypeidAndNumberid(typeid, numberid);
    }

    // ---------- FIND BY AGE GREATER THAN EQUAL ----------
    @GetMapping("/persona/age/{age}")
    public List<PersonaModel> findByAgeGreaterThanEqualPersona(@PathVariable Integer age) {
        return personaUseCase.findByAgeGreaterThanEqual(age);
    }
    // ---------- REST TEMPLATE PRUEBAS ----------

    @GetMapping("/persona/imagen/{id}")
    public List<ImagenModel> findImagen(@PathVariable("id") Integer id) {
        return personaUseCase.findImagen(id);
    }

    @GetMapping("/persona/imagen/")
    public List<ImagenModel> findAllImagen() {
        return personaUseCase.findAllImagen();
    }

}