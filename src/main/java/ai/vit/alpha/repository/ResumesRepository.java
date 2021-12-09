package ai.vit.alpha.repository;

import ai.vit.alpha.model.Resumes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ResumesRepository extends MongoRepository<Resumes,String> {

    @Query("{id:'?0'}")
    Resumes findByID(String id);

    @Query("{email:'?0'}")
    Resumes findByEmail(String email);

}
