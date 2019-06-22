package app.mongodb.dao;

import app.mongodb.dao.document.OpiniaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpiniaMongoRepo extends MongoRepository<OpiniaMongo, String> {
}
