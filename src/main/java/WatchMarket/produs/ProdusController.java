package WatchMarket.produs;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdusController {

    private final ProdusRepo repository;

    public ProdusController(ProdusRepo repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/produse")
    List<Produs> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/produse")
    Produs newProdus(@RequestBody Produs newProdus) {
        return repository.save(newProdus);
    }

    // Single item

    @GetMapping("/produse/{id}")
    Produs one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProdusNotFoundException(id));
    }

    @PutMapping("/produse/{id}")
    Produs replaceProdus(@RequestBody Produs newProdus, @PathVariable Long id) {

        return repository.findById(id)
                .map(produs -> {
                    produs.setDenumireProdus(newProdus.getDenumireProdus());
                    produs.setPret(newProdus.getPret());
                    produs.setModel(newProdus.getModel());
                    produs.setMecanism(newProdus.getMecanism());
                    return repository.save(produs);
                })
                .orElseGet(() -> {
                    newProdus.setId(id);
                    return repository.save(newProdus);
                });
    }

    @DeleteMapping("/produse/{id}")
    void deleteProdus(@PathVariable Long id) {
        repository.deleteById(id);
    }
}