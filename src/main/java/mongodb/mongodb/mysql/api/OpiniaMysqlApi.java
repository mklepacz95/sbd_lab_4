package mongodb.mongodb.mysql.api;

import mongodb.mongodb.mysql.controller.OpiniaMysqlController;
import mongodb.mongodb.mysql.dao.entity.OpiniaMysql;
import mongodb.mongodb.wspolne.enums.OpiniaOd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/mysqlApi"))
public class OpiniaMysqlApi {

    OpiniaMysqlController opiniaMysqlController;

    @Autowired
    public OpiniaMysqlApi(OpiniaMysqlController opiniaMysqlController) {
        this.opiniaMysqlController = opiniaMysqlController;
    }

    @GetMapping("/opinie")
    public Iterable<OpiniaMysql> getAll() {
        return opiniaMysqlController.getAll();
    }
}
