package WatchMarket.Utilizator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UtilizatorRepo repository) {

        return args -> {
           log.info("Preloading " + repository.save(new Utilizator("Dragomir", "Dan","Vidraru 9-11","Administrator")));
           log.info("Preloading " + repository.save(new Utilizator("Pop", "Ionel", "Paris 17", "vanzator")));
           log.info("Preloading" + repository.save(new Utilizator("Popescu","Ioan","Bucuresti 20", "cumparator")));
        };
    }
}
