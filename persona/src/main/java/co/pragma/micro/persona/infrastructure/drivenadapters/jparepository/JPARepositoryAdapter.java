package co.pragma.micro.persona.infrastructure.drivenadapters.jparepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.pragma.micro.persona.application.config.ObjectMapperConfig;
import co.pragma.micro.persona.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.persona.domain.model.personamodel.PersonaModel;
import co.pragma.micro.persona.domain.model.personamodel.gateways.PersonaModelRepository;
import co.pragma.micro.persona.infrastructure.drivenadapters.jparepository.entities.Persona;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class JPARepositoryAdapter implements PersonaModelRepository {
    
    @Autowired
    JPARepository jpaRepository;

    @Autowired
    RestTemplate restTemplate;
    
    public String urlImagen = "http://localhost:8087/api/imagen/";

    private ObjectMapperConfig objectMapperConfig = Mappers.getMapper(ObjectMapperConfig.class);


    @Override
    public List<PersonaModel> findAll() {
        List<Persona> persona = jpaRepository.findAll();
        List<PersonaModel> personaModel = new ArrayList<>();
        for (Persona p : persona) {
            personaModel.add(objectMapperConfig.PersonaToPersonaModel(p));
        }
        return personaModel;
    }

    @Override
    public PersonaModel findById(Integer id) {
        Optional<Persona> persona = jpaRepository.findById(id);
        if(persona.isPresent()){
            return (objectMapperConfig.PersonaToPersonaModel(persona.get()));
        }else{
            return null;
        }
    }

    @Override
    public PersonaModel save(PersonaModel personaModel) {
        Persona persona;
        persona = objectMapperConfig.PersonaModelToPersona(personaModel);
        persona = jpaRepository.save(persona);
        PersonaModel result;
        result = objectMapperConfig.PersonaToPersonaModel(persona);
        return result;
    }

    @Override
    public PersonaModel update(Integer id, PersonaModel personaModelUpdate){
        Optional<Persona> persona = jpaRepository.findById(id);
        
        if (persona.isEmpty()) {
            return null;
        }

        if(personaModelUpdate.getName() == null || personaModelUpdate.getName().equals("")){
            personaModelUpdate.setName(persona.get().getName());
        }
        if(personaModelUpdate.getLastName() == null || personaModelUpdate.getLastName().equals("")){
            personaModelUpdate.setLastName(persona.get().getLastName());
        }
        if(personaModelUpdate.getCity() == null || personaModelUpdate.getCity().equals("")){
            personaModelUpdate.setCity(persona.get().getCity());
        }
        if(personaModelUpdate.getAge() == null){
            personaModelUpdate.setAge(persona.get().getAge());
        }
        if(personaModelUpdate.getTypeId()== null || personaModelUpdate.getTypeId().equals("")){
            personaModelUpdate.setTypeId(persona.get().getTypeId());
        }
        if(String.valueOf(personaModelUpdate.getNumberId()).length() < 5 || String.valueOf(personaModelUpdate.getNumberId()).length() > 11 ){
            personaModelUpdate.setNumberId(persona.get().getNumberId());
        }

        personaModelUpdate.setId(id);

        Persona personaUpdate ;
        personaUpdate = objectMapperConfig.PersonaModelToPersona(personaModelUpdate);   
        personaUpdate = jpaRepository.save(personaUpdate);
        PersonaModel result;
        result = objectMapperConfig.PersonaToPersonaModel(personaUpdate);
        return result;


    }

    @Override
    public String deleteById(Integer id) {
        try {
            jpaRepository.deleteById(id);
            return "Persona eliminada";
        } catch (Exception e) {
            return "No se pudo eliminar la persona";
        }
    }

    @Override
    public List<PersonaModel> findByTypeid(String typeid) {
        List<Persona> persona = jpaRepository.findByTypeId(typeid);
        List<PersonaModel> personaModel = new ArrayList<>();
        persona.forEach(e -> {
            personaModel.add(objectMapperConfig.PersonaToPersonaModel(e));
        });
        return personaModel;
    }

    @Override
    public List<PersonaModel> findByNumberid(Long numberid) {
        List<Persona> persona = jpaRepository.findByNumberId(numberid);
        List<PersonaModel> personaModel = new ArrayList<>();
        persona.forEach(e -> {
            personaModel.add(objectMapperConfig.PersonaToPersonaModel(e));
        });
        return personaModel;
    }

    @Override
    public List<PersonaModel> findByTypeidAndNumberid(String typeid, Long numberid) {
        List<Persona> persona = jpaRepository.findByTypeIdAndNumberId(typeid, numberid);
        List<PersonaModel> personaModel = new ArrayList<>();
        persona.forEach(e -> {
            personaModel.add(objectMapperConfig.PersonaToPersonaModel(e));
        });
        return personaModel;
    }

    @Override
    public List<PersonaModel> findByAgeGreaterThanEqual(Integer age) {
        List<Persona> persona = jpaRepository.findByAgeGreaterThanEqual(age);
        List<PersonaModel> personaModel = new ArrayList<>();
        persona.forEach(e -> {
            personaModel.add(objectMapperConfig.PersonaToPersonaModel(e));
        });
        return personaModel;
    }

    @Override
    public List<ImagenModel> findImagen(Integer id){
        List<ImagenModel> forObject = restTemplate.getForObject(urlImagen+"userid/{id}" , List.class, id);
        return forObject;
    
    }

    @Override
    public List<ImagenModel> findAllImagen(){
        List<ImagenModel> forObject = restTemplate.getForObject(urlImagen, List.class);
        return forObject;
    
    }

    
    
}
