package WatchMarket.comanda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(WatchMarket.comanda.LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ComandaRepo repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Comanda()));
        };
    }
}
