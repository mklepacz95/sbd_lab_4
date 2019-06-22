package mongodb.mongodb.mysql.dao.entity;

import javax.persistence.*;

@Entity
public class PrzedmiotMysql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nazwa;
    private Double cena;

    public PrzedmiotMysql() {
    }

    public PrzedmiotMysql(String nazwa, Double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
