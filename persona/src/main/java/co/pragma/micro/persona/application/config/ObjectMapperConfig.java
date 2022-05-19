package co.pragma.micro.persona.application.config;

import org.mapstruct.Mapper;

import co.pragma.micro.persona.domain.model.personamodel.PersonaModel;
import co.pragma.micro.persona.infrastructure.drivenadapters.jparepository.entities.Persona;

@Mapper
public interface ObjectMapperConfig{

    // A mapper for the entities and the models.
    //ToData
    public PersonaModel PersonaToPersonaModel(Persona e);

    //ToEntity
    public Persona PersonaModelToPersona(PersonaModel d);
}