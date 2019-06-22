package mongodb.mongodb.mysql.dao.entity;

import mongodb.mongodb.wspolne.enums.OpiniaOd;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OpiniaMysql {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private OpiniaOd od;

    private Double ocena;

    public OpiniaMysql() {
    }

    public OpiniaMysql(OpiniaOd od, Double ocena) {
        this.od = od;
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
