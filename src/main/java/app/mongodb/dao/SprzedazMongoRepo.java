package app.mongodb.dao;

import app.mongodb.dao.document.PrzedmiotMongo;
import app.mongodb.dao.document.SprzedazMongo;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprzedazMongoRepo extends MongoRepository<SprzedazMongo, String> {

}
