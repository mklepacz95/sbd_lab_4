package app.mongodb.controller;

import app.mongodb.dao.PrzedmiotMongoRepo;
import app.mongodb.dao.document.PrzedmiotMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PrzedmiotMongoController {

    private PrzedmiotMongoRepo przedmiotMongoRepo;

    @Autowired
    public PrzedmiotMongoController(PrzedmiotMongoRepo przedmiotMongoRepo) {
        this.przedmiotMongoRepo = przedmiotMongoRepo;
    }

    public List<PrzedmiotMongo> getAll() {
        return przedmiotMongoRepo.findAll();
    }

    public void save(PrzedmiotMongo przedmiotMongo) {
        przedmiotMongoRepo.save(przedmiotMongo);
    }

    public PrzedmiotMongo findByNazwa(String nazwa) {
        return przedmiotMongoRepo.findAllByNazwa(nazwa);
    }

    public long ile() {
        return przedmiotMongoRepo.count();
    }

    public void usun() {
        przedmiotMongoRepo.deleteAll();
    }
}
