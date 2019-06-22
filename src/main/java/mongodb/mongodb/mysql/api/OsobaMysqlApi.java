package mongodb.mongodb.mysql.api;

import mongodb.mongodb.mysql.controller.OsobaMysqlController;
import mongodb.mongodb.mysql.dao.entity.OsobaMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        for(int i = 0; i<=10000;i++) {
            osobaMysqlController.save(new OsobaMysql("Imie " + i, "Nazwsko " + i*2));
        }
        System.out.println("Dodano 10 000 osob Mysql");
    }
}
