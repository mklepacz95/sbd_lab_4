package app.mongodb.controller;

import app.mongodb.dao.SprzedazMongoRepo;
import app.mongodb.dao.document.OpiniaMongo;
import app.mongodb.dao.document.OsobaMongo;
import app.mongodb.dao.document.SprzedazMongo;
import app.wspolne.enums.OpiniaOd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SprzedazMongoController {

    private SprzedazMongoRepo sprzedazMongoRepo;
    private OpiniaMongoController opiniaMongoController;
    private Random random = new Random();

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

    public List<SprzedazMongo> getAllLimit() {
        Integer ileWpisow = Math.toIntExact(sprzedazMongoRepo.count());
        long start = System.currentTimeMillis();
        List<SprzedazMongo> s = sprzedazMongoRepo.findAll();
        long stop = System.currentTimeMillis();
        System.out.println("Koniec wyszukiwania: " + LocalDateTime.now());
        File raport = new File("raport/raport.txt");
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter(raport, true));
            pw.append("\r\nMongoDB;"+ileWpisow+";"+(stop-start));
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znlazlo pliku raport.txt");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void usun() {
        sprzedazMongoRepo.deleteAll();
    }

}
