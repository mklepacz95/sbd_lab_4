package app.mongodb.controller;

import app.mongodb.dao.OpiniaMongoRepo;
import app.mongodb.dao.document.OpiniaMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OpiniaMongoController {

    private OpiniaMongoRepo opiniaMongoRepo;

    @Autowired
    public OpiniaMongoController(OpiniaMongoRepo opiniaMongoRepo) {
        this.opiniaMongoRepo = opiniaMongoRepo;
    }

    public void save(OpiniaMongo opiniaMongo) {
        opiniaMongoRepo.save(opiniaMongo);
    }

}
