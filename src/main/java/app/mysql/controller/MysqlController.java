package app.mysql.controller;

import app.mysql.dao.OpiniaMysqlRepo;
import app.mysql.dao.OsobaMysqlRepo;
import app.mysql.dao.PrzedmiotMysqlRepo;
import app.mysql.dao.entity.OpiniaMysql;
import app.mysql.dao.entity.OsobaMysql;
import app.mysql.dao.entity.PrzedmiotMysql;
import app.mysql.dao.entity.SprzedazMysql;
import app.wspolne.enums.OpiniaOd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class MysqlController {
    private OsobaMysqlRepo osobaMysqlRepo;
    private OpiniaMysqlController opiniaMysqlController;
    private PrzedmiotMysqlRepo przedmiotMysqlRepo;
    private SprzedazMysqlContreoller sprzedazMysqlContreoller;
    private Random random = new Random();

    @Autowired
    public MysqlController(OsobaMysqlRepo osobaMysqlRepo, OpiniaMysqlController opiniaMysqlController, PrzedmiotMysqlRepo przedmiotMysqlRepo, SprzedazMysqlContreoller sprzedazMysqlContreoller) {
        this.osobaMysqlRepo = osobaMysqlRepo;
        this.opiniaMysqlController = opiniaMysqlController;
        this.przedmiotMysqlRepo = przedmiotMysqlRepo;
        this.sprzedazMysqlContreoller = sprzedazMysqlContreoller;
    }

    public boolean uzupelnij(Integer ile) {
        sprzedazMysqlContreoller.usun();
        int ileOsob = (int) osobaMysqlRepo.count();
        int ilePrzedmiotow = (int) przedmiotMysqlRepo.count();
        for(int i = 1; i <= ile; i++) {
            Optional<PrzedmiotMysql> przedmiot = przedmiotMysqlRepo.findById((long) (random.nextInt(ilePrzedmiotow) + 1));
            Optional<OsobaMysql> kupujacy = osobaMysqlRepo.findById((long) random.nextInt(ileOsob) + 1);
            while(!kupujacy.isPresent()) kupujacy = osobaMysqlRepo.findById((long) random.nextInt(ileOsob) + 1);
            Optional<OsobaMysql> sprzedajacy = osobaMysqlRepo.findById((long) random.nextInt(ileOsob) + 1);
            while(!sprzedajacy.isPresent()) sprzedajacy = osobaMysqlRepo.findById((long) random.nextInt(ileOsob) + 1);
            List<OpiniaMysql> opinie = new ArrayList<OpiniaMysql>();
            OpiniaMysql opinia = new OpiniaMysql(OpiniaOd.SPRZEDAWCA,random.nextDouble()*10);
            opinie.add(opiniaMysqlController.saveOpiniaMysql(opinia));
            opinia = new OpiniaMysql(OpiniaOd.KUPUJACY,random.nextDouble()*10);
            opinie.add(opiniaMysqlController.saveOpiniaMysql(opinia));
            if(kupujacy.isPresent() && sprzedajacy.isPresent() && przedmiot.isPresent()) {
                sprzedazMysqlContreoller.save(new SprzedazMysql(kupujacy.get(), sprzedajacy.get(), przedmiot.get(), opinie));
                //System.out.println(i);
            }
            else System.out.println(i);
        }
        System.out.println("dodano: " + ile + " rekordow");
        return true;
    }

    public Iterable<SprzedazMysql> odczytaj() {
        long start = System.currentTimeMillis();
        Iterable<SprzedazMysql> o = sprzedazMysqlContreoller.getAll();
        long stop = System.currentTimeMillis();
        System.out.println("Koniec wyszukiwania: " + LocalDateTime.now());
        File raport = new File("raport/raport.txt");
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter(raport, true));
            pw.append("\r\nMySQL;"+sprzedazMysqlContreoller.ile()+";"+(stop-start));
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znlazlo pliku raport.txt");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}
