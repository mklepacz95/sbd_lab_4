package app.mongodb.dao.document;

import app.wspolne.enums.OpiniaOd;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Document
public class OpiniaMongo {

    @Id
    private String id;

    @Enumerated(EnumType.ORDINAL)
    private OpiniaOd od;
    private Double ocena;

    public OpiniaMongo() {
    }

    public OpiniaMongo(OpiniaOd od, Double ocena) {
        this.od = od;
        this.ocena = ocena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OpiniaOd getOd() {
        return od;
    }

    public void setOd(OpiniaOd od) {
        this.od = od;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }
}
