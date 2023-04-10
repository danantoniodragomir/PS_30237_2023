package WatchMarket.utilizator;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilizatorController {

    private final UtilizatorRepo repository;

    UtilizatorController(UtilizatorRepo repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/utilizatori")
    List<Utilizator> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/utilizatori")
    Utilizator newUtilizator(@RequestBody Utilizator newUtilizator) {
        return repository.save(newUtilizator);
    }

    // Single item

    @GetMapping("/utilizatori/{id}")
    Utilizator one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UtilizatorNotFoundException(id));
    }

    @PutMapping("/utilizatori/{id}")
    Utilizator replaceUtilizator(@RequestBody Utilizator newUtilizator, @PathVariable Long id) {

        return repository.findById(id)
                .map(utilizator -> {
                    utilizator.setNume(newUtilizator.getNume());
                    utilizator.setPrenume(newUtilizator.getPrenume());
                    utilizator.setAdresa(newUtilizator.getAdresa());
                    utilizator.setRol(newUtilizator.getRol());
                    return repository.save(utilizator);
                })
                .orElseGet(() -> {
                    newUtilizator.setId(id);
                    return repository.save(newUtilizator);
                });
    }

    @DeleteMapping("/utilizatori/{id}")
    void deleteUtilizator(@PathVariable Long id) {
        repository.deleteById(id);
    }
}