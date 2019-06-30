package app.mongodb.controller;

import app.mongodb.dao.document.OpiniaMongo;
import app.mongodb.dao.document.OsobaMongo;
import app.mongodb.dao.document.PrzedmiotMongo;
import app.mongodb.dao.document.SprzedazMongo;
import app.wspolne.enums.OpiniaOd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MongoController {
    private Random random = new Random();
    private SprzedazMongoController sprzedazMongoController;
    private OsobaMongoController osobaMongoController;
    private PrzedmiotMongoController przedmiotMongo;

    @Autowired
    public MongoController(SprzedazMongoController sprzedazMongoController, OsobaMongoController osobaMongoController, PrzedmiotMongoController przedmiotMongo) {
        this.sprzedazMongoController = sprzedazMongoController;
        this.osobaMongoController = osobaMongoController;
        this.przedmiotMongo = przedmiotMongo;
    }

    public void uzupelnij(Integer ile) {
        sprzedazMongoController.usun();
        for(int i = 1; i<= ile; i++) {
            List<OpiniaMongo> opinie = new ArrayList<>();
            opinie.add(new OpiniaMongo(OpiniaOd.KUPUJACY, random.nextDouble()*10));
            opinie.add(new OpiniaMongo(OpiniaOd.SPRZEDAWCA, random.nextDouble()*10));
            OsobaMongo kupujacy = osobaMongoController.findByImie("Osoba" + random.nextInt((int) (osobaMongoController.ile()+1)));
            OsobaMongo sprzedajacy = osobaMongoController.findByImie("Osoba" + random.nextInt((int) (osobaMongoController.ile()+1)));
            PrzedmiotMongo przedmiot = przedmiotMongo.findByNazwa("Przedtmiot"+ random.nextInt((int) przedmiotMongo.ile()) + 1);
            sprzedazMongoController.save(new SprzedazMongo(kupujacy, sprzedajacy, przedmiot, opinie));
        }
    }

    public List<SprzedazMongo> odczytaj() {
        return sprzedazMongoController.getAllLimit();
    }

}
