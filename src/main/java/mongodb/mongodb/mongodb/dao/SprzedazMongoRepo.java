package mongodb.mongodb.mongodb.dao;

import mongodb.mongodb.mongodb.dao.document.SprzedazMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprzedazMongoRepo extends MongoRepository<SprzedazMongo, String> {
}
