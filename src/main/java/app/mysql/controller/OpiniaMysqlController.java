package app.mysql.controller;

import app.mysql.dao.OpiniaMysqlRepo;
import app.mysql.dao.entity.OpiniaMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OpiniaMysqlController {

    OpiniaMysqlRepo opiniaMysqlRepo;

    @Autowired
    public OpiniaMysqlController(OpiniaMysqlRepo opiniaMysqlRepo) {
        this.opiniaMysqlRepo = opiniaMysqlRepo;
    }

    public OpiniaMysql saveOpiniaMysql(OpiniaMysql opiniaMysql) {
        return opiniaMysqlRepo.save(opiniaMysql);
    }

    public Iterable<OpiniaMysql> getAll() {
        return opiniaMysqlRepo.findAll();
    }
}
