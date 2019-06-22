package app.mysql.controller;

import app.mysql.dao.OsobaMysqlRepo;
import app.mysql.dao.entity.OsobaMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OsobaMysqlController {

    private OsobaMysqlRepo osobaMysqlRepo;

    @Autowired
    public OsobaMysqlController(OsobaMysqlRepo osobaMysqlRepo) {
        this.osobaMysqlRepo = osobaMysqlRepo;
    }

    public Iterable<OsobaMysql> getAll() {
        return osobaMysqlRepo.findAll();
    }

    public void save(OsobaMysql osobaMysql) {
        osobaMysqlRepo.save(osobaMysql);
    }

    public long getCountForOosba() {
        return osobaMysqlRepo.count();
    }
}
