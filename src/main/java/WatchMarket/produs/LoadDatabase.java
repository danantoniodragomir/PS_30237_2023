package WatchMarket.produs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(WatchMarket.produs.LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProdusRepo repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Produs()));
            log.info("Preloading " + repository.save(new Produs("Ceas Seiko five",674.99,"Seiko Five MT-223563", "Automatic", "Seiko", "Japonia")));
        };
    }
}

