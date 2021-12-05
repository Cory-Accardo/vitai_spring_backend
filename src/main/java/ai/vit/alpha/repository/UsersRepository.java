package ai.vit.alpha.repository;

import ai.vit.alpha.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository<Users, String> {
    @Query("{firstName:'?0'}")
    Users findByFirstName(String firstName);

    @Query("{username:'?0'}")
    Users findByUsername(String username);


    public long count();
}