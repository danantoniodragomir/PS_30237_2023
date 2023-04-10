package WatchMarket.utilizator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Utilizator {
    @Id
    @GeneratedValue
    private Long id;
    private String nume;
    private String prenume;
    private String rol;
    private String adresa;

    public Utilizator() {
        this.nume = "Doe";
        this.prenume = "John";
        this.adresa = "Nowhere str.";
        this.rol = "cumparaotr";
    }

    public Utilizator(String nume, String prenume, String adresa, String rol) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
