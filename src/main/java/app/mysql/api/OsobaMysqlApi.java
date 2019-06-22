package app.mysql.api;

import app.mysql.controller.OsobaMysqlController;
import app.mysql.dao.entity.OsobaMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysqlApi")
public class OsobaMysqlApi {

    private OsobaMysqlController osobaMysqlController;

    @Autowired
    public OsobaMysqlApi(OsobaMysqlController osobaMysqlController) {
        this.osobaMysqlController = osobaMysqlController;
    }

    public Iterable<OsobaMysql> getAll() {
        return osobaMysqlController.getAll();
    }

    /*
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        for(int i = 0; i<=10000;i++) {
            osobaMysqlController.save(new OsobaMysql("Imie " + i, "Nazwsko " + i*2));
        }
        System.out.println("Dodano 10 000 osob Mysql");
    }

     */

    @GetMapping("/osoba/ile")
    public long ile() {
        return osobaMysqlController.getCountForOosba();
    }
}
