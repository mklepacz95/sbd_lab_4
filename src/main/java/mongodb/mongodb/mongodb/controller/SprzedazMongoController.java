package mongodb.mongodb.mongodb.controller;

import mongodb.mongodb.mongodb.dao.SprzedazMongoRepo;
import mongodb.mongodb.mongodb.dao.document.OpiniaMongo;
import mongodb.mongodb.mongodb.dao.document.SprzedazMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SprzedazMongoController {

    private SprzedazMongoRepo sprzedazMongoRepo;
    private OpiniaMongoController opiniaMongoController;

    @Autowired
    public SprzedazMongoController(SprzedazMongoRepo sprzedazMongoRepo, OpiniaMongoController opiniaMongoController) {
        this.sprzedazMongoRepo = sprzedazMongoRepo;
        this.opiniaMongoController = opiniaMongoController;
    }

    public List<SprzedazMongo> getAll() {
        return sprzedazMongoRepo.findAll();
    }

    public void save(SprzedazMongo sprzedazMongo) {
        for(OpiniaMongo o : sprzedazMongo.getOpinie()) opiniaMongoController.save(o);
        sprzedazMongoRepo.save(sprzedazMongo);
    }
}
