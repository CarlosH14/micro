package co.pragma.micro.persona.infrastructure.drivenadapters.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.pragma.micro.persona.infrastructure.drivenadapters.jparepository.entities.Persona;

@Repository
public interface JPARepository extends JpaRepository<Persona, Integer> {
        List<Persona> findByTypeId(String typeId);
        List<Persona> findByNumberId(Long numberId);
        List<Persona> findByTypeIdAndNumberId(String typeId, Long numberId);
        List<Persona> findByAgeGreaterThanEqual(Integer age);
}
