package mongodb.mongodb.mongodb.dao;

import mongodb.mongodb.mongodb.dao.document.OpiniaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpiniaMongoRepo extends MongoRepository<OpiniaMongo, String> {
}
