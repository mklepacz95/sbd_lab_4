package app.wspolne.api;

import app.mongodb.controller.MongoController;
import app.mysql.controller.MysqlController;
import app.mysql.controller.SprzedazMysqlContreoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raport")
public class RaportApi {

    private MysqlController mysqlController;
    private MongoController mongoController;
    private SprzedazMysqlContreoller sprzedazMysqlContreoller;

    @Autowired
    public RaportApi(MysqlController mysqlController, MongoController mongoController, SprzedazMysqlContreoller sprzedazMysqlContreoller) {
        this.mysqlController = mysqlController;
        this.mongoController = mongoController;
        this.sprzedazMysqlContreoller = sprzedazMysqlContreoller;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void raport() {
        mongoController.uzupelnij(500000);
        mongoController.odczytaj();
        mongoController.uzupelnij(250000);
        mongoController.odczytaj();
        mongoController.uzupelnij(100000);
        mongoController.odczytaj();
        if (mysqlController.uzupelnij(100000)) {
            mysqlController.odczytaj();
        }if (mysqlController.uzupelnij(250000)) {
            mysqlController.odczytaj();
        }if (mysqlController.uzupelnij(500000)) {
            mysqlController.odczytaj();
        }



    }
}
