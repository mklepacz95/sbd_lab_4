package mongodb.mongodb.mongodb.dao;

import mongodb.mongodb.mongodb.dao.document.OsobaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaMongoRepo extends MongoRepository<OsobaMongo, String> {
}
