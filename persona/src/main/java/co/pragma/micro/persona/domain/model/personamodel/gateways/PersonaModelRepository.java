package co.pragma.micro.persona.domain.model.personamodel.gateways;

import java.util.List;


import co.pragma.micro.persona.domain.model.imagenmodel.ImagenModel;
import co.pragma.micro.persona.domain.model.personamodel.PersonaModel;

public interface PersonaModelRepository {
    
    List<PersonaModel> findAll();
    PersonaModel findById(Integer id);
    PersonaModel save(PersonaModel personaModel);
    PersonaModel update(Integer id, PersonaModel personaModelUpdate) ;
    String deleteById(Integer id);

    List<PersonaModel> findByTypeid(String typeid);
    List<PersonaModel> findByNumberid(Long numberid);
    List<PersonaModel> findByTypeidAndNumberid(String typeid, Long numberid);
    List<PersonaModel> findByAgeGreaterThanEqual(Integer age);

    List<ImagenModel> findImagen(Integer id);
    List<ImagenModel> findAllImagen();
    
}
