package app.mysql.controller;

import app.mysql.dao.SprzedazMysqlRepo;
import app.mysql.dao.entity.SprzedazMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SprzedazMysqlContreoller {

    private SprzedazMysqlRepo sprzedazMysqlRepo;

    @Autowired
    public SprzedazMysqlContreoller(SprzedazMysqlRepo sprzedazMysqlRepo) {
        this.sprzedazMysqlRepo = sprzedazMysqlRepo;
    }

    public Iterable<SprzedazMysql> getAll() {
        return sprzedazMysqlRepo.findAll();
    }

    public String save(SprzedazMysql sprzedazMysql) {
        if(sprzedazMysqlRepo.save(sprzedazMysql) != null) return "Zapisano";
        else return  "Nie udalo sie zapisac";
    }
}
