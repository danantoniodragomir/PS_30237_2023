package WatchMarket.comanda;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ComandaController {
    private final ComandaRepo repository;

    ComandaController(ComandaRepo repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/comenzi")
    List<Comanda> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/comenzi")
    Comanda newComanda(@RequestBody Comanda newComanda) {
        return repository.save(newComanda);
    }

    // Single item

    @GetMapping("/comenzi/{id}")
    Comanda one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ComandaNotFoundException(id));
    }

    @PutMapping("/comenzi/{id}")
    Comanda replaceComanda(@RequestBody Comanda newComanda, @PathVariable Long id) {

        return repository.findById(id)
                .map(comanda -> {
                    comanda.setCos(newComanda.getCos());
                    comanda.setStareaComenzii(newComanda.getStareaComenzii());
                    comanda.setDataPlasareComanda(newComanda.getDataPlasareComanda());
                    comanda.setDataLivrareComanda(newComanda.getDataLivrareComanda());
                    return repository.save(comanda);
                })
                .orElseGet(() -> {
                    newComanda.setId(id);
                    return repository.save(newComanda);
                });
    }

    @DeleteMapping("/comenzi/{id}")
    void deleteCos(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
