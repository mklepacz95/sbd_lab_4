package app.mongodb.api;

import app.mongodb.controller.SprzedazMongoController;
import app.mongodb.dao.document.SprzedazMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongoApi")
public class SprzedazMongoApi {

    private SprzedazMongoController sprzedazMongoController;

    @Autowired
    public SprzedazMongoApi(SprzedazMongoController sprzedazMongoController) {
        this.sprzedazMongoController = sprzedazMongoController;
    }

    @GetMapping("/sprzedaze")
    public List<SprzedazMongo> getAll() {
        return sprzedazMongoController.getAllLimit();
    }

    @PostMapping("/sprzedaz")
    public void save(@RequestBody SprzedazMongo sprzedazMongo) {
        sprzedazMongoController.save(sprzedazMongo);
    }
}
