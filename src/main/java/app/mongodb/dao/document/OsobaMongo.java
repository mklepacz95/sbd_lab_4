package app.mongodb.dao.document;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class OsobaMongo {

    @Id
    private String id;

    private String imie;
    private String nazwisko;

    public OsobaMongo() {
    }

    public OsobaMongo(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
