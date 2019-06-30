package app.mongodb.dao;

import app.mongodb.dao.document.OsobaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaMongoRepo extends MongoRepository<OsobaMongo, String> {
    OsobaMongo findAllByImie(String imie);
}
