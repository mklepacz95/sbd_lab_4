package app.mongodb.dao.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PrzedmiotMongo {

    @Id
    private String id;

    private String nazwa;
    private Double cena;

    public PrzedmiotMongo() {
    }

    public PrzedmiotMongo(String nazwa, Double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
