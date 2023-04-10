package WatchMarket.produs;

import WatchMarket.utilizator.Utilizator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produs {
    @Id
    @GeneratedValue
    private Long id;
    private String denumireProdus;
    private double pret;
    private String model;
    private String mecanism;
    private String producator;
    private String taraOrigineProducator;
    private Utilizator vanzator;

    public Produs() {
        this.denumireProdus = "ceas";
        this.pret = 0.0;
        this.model = "ceasNou";
        this.mecanism = "Quartz";
        this.producator = "producatorCeas";
        this.taraOrigineProducator = "Elvetia";
    }



    public Produs(String denumireProdus, double pret, String model, String mecanism, String producator, String taraOrigineProducator) {
        this.denumireProdus = denumireProdus;
        this.pret = pret;
        this.model = model;
        this.mecanism = mecanism;
        this.producator = producator;
        this.taraOrigineProducator = taraOrigineProducator;
    }

    public Long getId() {
        return id;
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public void setDenumireProdus(String denumireProdus) {
        this.denumireProdus = denumireProdus;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMecanism() {
        return mecanism;
    }

    public void setMecanism(String mecanism) {
        this.mecanism = mecanism;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getTaraOrigineProducator() {
        return taraOrigineProducator;
    }

    public void setTaraOrigineProducator(String taraOrigineProducator) {
        this.taraOrigineProducator = taraOrigineProducator;
    }

    public void setVanzator(Utilizator vanzator){
        this.vanzator = vanzator;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
