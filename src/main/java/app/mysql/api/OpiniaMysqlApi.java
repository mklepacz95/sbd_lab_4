package app.mysql.api;

import app.mysql.controller.OpiniaMysqlController;
import app.mysql.dao.entity.OpiniaMysql;
import org.springframework.beans.factory.annotation.Autowired;
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
