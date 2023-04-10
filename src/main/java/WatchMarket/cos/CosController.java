package WatchMarket.cos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CosController {
    private final CosRepo repository;

    public CosController(CosRepo repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/cosuri")
    List<Cos> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/cosuri")
    Cos newCos(@RequestBody Cos newCos) {
        return repository.save(newCos);
    }

    // Single item

    @GetMapping("/cosuri/{id}")
    Cos one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CosNotFoundException(id));
    }

    @PutMapping("/cosuri/{id}")
    Cos replaceCos(@RequestBody Cos newCos, @PathVariable Long id) {

        return repository.findById(id)
                .map(cos -> {
                    cos.setUtilizator(newCos.getUtilizator());
                    cos.setProduse(newCos.getProduse());
                    return repository.save(cos);
                })
                .orElseGet(() -> {
                    newCos.setId(id);
                    return repository.save(newCos);
                });
    }

    @DeleteMapping("/cosuri/{id}")
    void deleteCos(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
