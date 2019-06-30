package app.wspolne.api;

import app.mongodb.controller.MongoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uzupelnijApi")
public class UzupelnijApi {

    private MongoController mongoController;

    @Autowired
    public UzupelnijApi(MongoController mongoController) {
        this.mongoController = mongoController;
    }

    @GetMapping("/{ile}")
    public void uzupelnij(@PathVariable Integer ile){
        mongoController.uzupelnij(ile);
    }
}
