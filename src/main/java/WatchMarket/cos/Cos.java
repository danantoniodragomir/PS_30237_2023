package WatchMarket.cos;

import WatchMarket.produs.Produs;
import WatchMarket.utilizator.Utilizator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Cos {
    @Id
    @GeneratedValue
    private Long id;
    private Utilizator utilizator;
    private List<Produs> produse;

    public Cos(Utilizator utilizator){
        this.utilizator = utilizator;
    }

    public Cos() {
        this.utilizator= new Utilizator();
    }

    public void addProdus(Produs produs){
        this.produse.add(produs);
    }

    public void deleteProduse(){
        this.produse.clear();
    }

    public void deleteCos(){
        this.utilizator = null;
        this.id = null;
        this.deleteProduse();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }
}
