package WatchMarket.comanda;

import WatchMarket.cos.Cos;
import WatchMarket.observer.ComandaObserverClass;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Comanda {
    @Id
    @GeneratedValue
    private Long id;
    private Cos cos;
    private String stareaComenzii;
    private String dataPlasareComanda;
    private String dataLivrareComanda;
    private ComandaObserverClass subject;

    public Comanda(){
    }

    public Comanda(Cos cos){
        this.cos = cos;
        this.stareaComenzii = "Comanda plasata";
        this.dataPlasareComanda = "";
        this.dataLivrareComanda = "";
        this.subject = new ComandaObserverClass();
        subject.onComanda(cos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cos getCos() {
        return cos;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    public String getStareaComenzii() {
        return stareaComenzii;
    }

    public void setStareaComenzii(String stareaComenzii) {
        this.stareaComenzii = stareaComenzii;
    }

    public String getDataPlasareComanda() {
        return dataPlasareComanda;
    }

    public void setDataPlasareComanda(String dataPlasareComanda) {
        this.dataPlasareComanda = dataPlasareComanda;
    }

    public String getDataLivrareComanda() {
        return dataLivrareComanda;
    }

    public void setDataLivrareComanda(String dataLivrareComanda) {
        this.dataLivrareComanda = dataLivrareComanda;
    }
}
