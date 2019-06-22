package mongodb.mongodb.mongodb.dao;

import mongodb.mongodb.mongodb.dao.document.PrzedmiotMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzedmiotMongoRepo extends MongoRepository<PrzedmiotMongo, String> {
    PrzedmiotMongo findAllByNazwa(String nazwa);
}
