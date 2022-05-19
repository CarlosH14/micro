package co.pragma.micro.imagen.infrastructure.drivenadapters.mongorepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.pragma.micro.imagen.infrastructure.drivenadapters.mongorepository.entities.Imagen;

@Repository
public interface ImagenMongoRepository extends MongoRepository<Imagen, Integer> {
    
    public List<Imagen> findByUserId(Integer userId);
}
