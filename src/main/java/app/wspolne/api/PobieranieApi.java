package app.wspolne.api;

import app.mongodb.controller.SprzedazMongoController;
import app.mongodb.dao.document.SprzedazMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pobierzApi")
public class PobieranieApi {

    private SprzedazMongoController sprzedazMongoController;

    @Autowired
    public PobieranieApi(SprzedazMongoController sprzedazMongoController) {
        this.sprzedazMongoController = sprzedazMongoController;
    }

    @GetMapping("/pobierzMongo")
    public List<SprzedazMongo> getAllWithLimit() {
        return sprzedazMongoController.getAllLimit();
    }

}
