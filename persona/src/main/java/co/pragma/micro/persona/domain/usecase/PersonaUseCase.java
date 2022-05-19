package co.pragma.micro.persona.domain.usecase;

import java.util.List;


import co.pragma.micro.persona.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.persona.domain.model.personamodel.PersonaModel;
import co.pragma.micro.persona.domain.model.personamodel.gateways.PersonaModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonaUseCase {

    PersonaModelRepository personaModelRepository;

    public List<PersonaModel> findAll(){return personaModelRepository.findAll();}
    public PersonaModel findById(Integer id){return personaModelRepository.findById(id);}
    public PersonaModel save(PersonaModel personaModel){return personaModelRepository.save(personaModel);}
    public PersonaModel update(Integer id, PersonaModel personaModelUpdate){return personaModelRepository.update(id, personaModelUpdate);}
    public String deleteById(Integer id){return personaModelRepository.deleteById(id);}

    public List<PersonaModel> findByTypeid(String typeid){return personaModelRepository.findByTypeid(typeid);}
    public List<PersonaModel> findByNumberid(Long numberid){return personaModelRepository.findByNumberid(numberid);}
    public List<PersonaModel> findByTypeidAndNumberid(String typeid, Long numberid){return personaModelRepository.findByTypeidAndNumberid(typeid, numberid);}
    public List<PersonaModel> findByAgeGreaterThanEqual(Integer age){return personaModelRepository.findByAgeGreaterThanEqual(age);}

    public List<ImagenModel> findImagen(Integer id){return personaModelRepository.findImagen(id);}
    public List<ImagenModel> findAllImagen(){return personaModelRepository.findAllImagen();}
    
}
