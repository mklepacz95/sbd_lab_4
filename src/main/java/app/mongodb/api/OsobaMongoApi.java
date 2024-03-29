package app.mongodb.api;

import app.mongodb.controller.OsobaMongoController;
import app.mongodb.dao.document.OsobaMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mogngoApi")
public class OsobaMongoApi {

    private OsobaMongoController osobaMongoController;

    @Autowired
    public OsobaMongoApi(OsobaMongoController osobaMongoController) {
        this.osobaMongoController = osobaMongoController;
    }

    /*
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        osobaMongoController.usun();
        for(int i = 0; i< 10000; i++) {
            osobaMongoController.save(new OsobaMongo("Osoba" + i,"Nazwisko"));
        }
        System.out.println("Dodano 10 000 osob Mongo");
    }
     */

    @GetMapping("/osoba/ile")
    public long ile() {
        return osobaMongoController.ile();
    }

}
