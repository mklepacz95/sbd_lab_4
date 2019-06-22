package app.mongodb.controller;

import app.mongodb.dao.OsobaMongoRepo;
import app.mongodb.dao.document.OsobaMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OsobaMongoController {

    private OsobaMongoRepo osobaMongoRepo;

    @Autowired
    public OsobaMongoController(OsobaMongoRepo osobaMongoRepo) {
        this.osobaMongoRepo = osobaMongoRepo;
    }

    public List<OsobaMongo> getAll() {
       return osobaMongoRepo.findAll();
    }

    public void save(OsobaMongo osobaMongo) {
        osobaMongoRepo.save(osobaMongo);
    }

    public long ile() {
        return osobaMongoRepo.count();
    }

}
