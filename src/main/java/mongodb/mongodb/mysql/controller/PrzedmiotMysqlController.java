package mongodb.mongodb.mysql.controller;

import mongodb.mongodb.mysql.dao.PrzedmiotMysqlRepo;
import mongodb.mongodb.mysql.dao.entity.PrzedmiotMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PrzedmiotMysqlController {

    private PrzedmiotMysqlRepo przedmiotMysqlRepo;

    @Autowired
    public PrzedmiotMysqlController(PrzedmiotMysqlRepo przedmiotMysqlRepo) {
        this.przedmiotMysqlRepo = przedmiotMysqlRepo;
    }

    public Iterable<PrzedmiotMysql> getAll() {
        return przedmiotMysqlRepo.findAll();
    }

    public void save(PrzedmiotMysql przedmiotMysql) {
        przedmiotMysqlRepo.save(przedmiotMysql);
    }

    public long sprawdz() {
        return przedmiotMysqlRepo.count();
    }
}
