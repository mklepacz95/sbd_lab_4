package app.mysql.api;

import app.mysql.controller.SprzedazMysqlContreoller;
import app.mysql.dao.entity.SprzedazMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mysqlApi")
public class SprzedazMysqlApi {

    private SprzedazMysqlContreoller sprzedazMysqlContreoller;

    @Autowired
    public SprzedazMysqlApi(SprzedazMysqlContreoller sprzedazMysqlContreoller) {
        this.sprzedazMysqlContreoller = sprzedazMysqlContreoller;
    }

    @GetMapping("/sprzedaze")
    public Iterable<SprzedazMysql> getAll() {
        return sprzedazMysqlContreoller.getAll();
    }

    @PostMapping("/sprzedaz")
    public String saveSprzedaz(@RequestBody SprzedazMysql sprzedazMysql) {
        return sprzedazMysqlContreoller.save(sprzedazMysql);
    }
}
