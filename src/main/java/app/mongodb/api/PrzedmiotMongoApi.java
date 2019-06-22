package app.mongodb.api;

import app.mongodb.controller.PrzedmiotMongoController;
import app.mongodb.dao.document.PrzedmiotMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/mongoApi")
public class PrzedmiotMongoApi {

    private PrzedmiotMongoController przedmiotMongoController;
    private Random random = new Random();

    @Autowired
    public PrzedmiotMongoApi(PrzedmiotMongoController przedmiotMongoController) {
        this.przedmiotMongoController = przedmiotMongoController;
    }
    /*
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        for(int i = 0; i < 5000;i++)
            przedmiotMongoController.save(new PrzedmiotMongo("Przedtmiot"+i,random.nextDouble()*100));
        System.out.println("Dodano 5 000 przedmiotow Mongo");
    }

     */

    @GetMapping("/przedmioty")
    public List<PrzedmiotMongo> getAll() {
        return przedmiotMongoController.getAll();
    }

    @PostMapping("/przedmiot")
    public void save(PrzedmiotMongo przedmiotMongo) {
        przedmiotMongoController.save(przedmiotMongo);
    }

    @GetMapping("/przedmiot/{nazwa}")
    public PrzedmiotMongo findByNazwa(@PathVariable String nazwa) {
        return przedmiotMongoController.findByNazwa(nazwa);
    }

    @GetMapping("/przedmioty/ile")
    public long ile() {
        return przedmiotMongoController.ile();
    }
}
