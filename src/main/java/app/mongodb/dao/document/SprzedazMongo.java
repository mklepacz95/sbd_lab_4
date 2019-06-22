package app.mongodb.dao.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class SprzedazMongo {

    @Id
    private String id;

    private OsobaMongo kupujacy;
    private OsobaMongo sprzedajacy;
    private PrzedmiotMongo przedmiot;
    private List<OpiniaMongo> opinie;

    public SprzedazMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OsobaMongo getKupujacy() {
        return kupujacy;
    }

    public void setKupujacy(OsobaMongo kupujacy) {
        this.kupujacy = kupujacy;
    }

    public OsobaMongo getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(OsobaMongo sprzedajacy) {
        this.sprzedajacy = sprzedajacy;
    }

    public PrzedmiotMongo getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(PrzedmiotMongo przedmiot) {
        this.przedmiot = przedmiot;
    }

    public List<OpiniaMongo> getOpinie() {
        return opinie;
    }

    public void setOpinie(List<OpiniaMongo> opinie) {
        this.opinie = opinie;
    }
}

