package app.mysql.api;

import app.mysql.controller.PrzedmiotMysqlController;
import app.mysql.dao.entity.PrzedmiotMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysqlApi")
public class PrzedmiotMysqlApi {

    private PrzedmiotMysqlController przedmiotMysqlController;

    @Autowired
    public PrzedmiotMysqlApi(PrzedmiotMysqlController przedmiotMysqlController) {
        this.przedmiotMysqlController = przedmiotMysqlController;
    }

    /*
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Random random = new Random();
        for(int i = 0; i<=5000;i++) {
            przedmiotMysqlController.save(new PrzedmiotMysql("Przedmiot nr " + i, random.nextDouble() * 100));
            if( i == 10 ) przedmiotMysqlController.sprawdz();
        }
        System.out.println("Dodano 5 000 przedmiotow");

    }

     */

    @GetMapping("/przedmioty")
    public Iterable<PrzedmiotMysql> getAll() {
        return przedmiotMysqlController.getAll();
    }


    @GetMapping("/przedmioty/ile")
    public long getIloscPrzedmiotow() {
        return przedmiotMysqlController.sprawdz();
    }

}
