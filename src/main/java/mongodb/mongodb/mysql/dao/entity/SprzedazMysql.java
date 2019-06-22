package mongodb.mongodb.mysql.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SprzedazMysql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private OsobaMysql kupujacy;

    @ManyToOne
    private OsobaMysql sprzedajacy;

    @ManyToOne
    private PrzedmiotMysql przedmiot;

    @ElementCollection
    @CollectionTable(name="listOfOpinion")
    private List<OpiniaMysql> opinie;

    public SprzedazMysql() {
    }

    public SprzedazMysql(OsobaMysql kupujacy, OsobaMysql sprzedajacy, PrzedmiotMysql przedmiot, List<OpiniaMysql> opinie) {
        this.kupujacy = kupujacy;
        this.sprzedajacy = sprzedajacy;
        this.przedmiot = przedmiot;
        this.opinie = opinie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OsobaMysql getKupujacy() {
        return kupujacy;
    }

    public void setKupujacy(OsobaMysql kupujacy) {
        this.kupujacy = kupujacy;
    }

    public OsobaMysql getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(OsobaMysql sprzedajacy) {
        this.sprzedajacy = sprzedajacy;
    }

    public PrzedmiotMysql getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(PrzedmiotMysql przedmiot) {
        this.przedmiot = przedmiot;
    }

    public List<OpiniaMysql> getOpinie() {
        return opinie;
    }

    public void setOpinie(List<OpiniaMysql> opinie) {
        this.opinie = opinie;
    }
}
