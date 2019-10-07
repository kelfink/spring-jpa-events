package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner runner(EventRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Event("AnEvent", "Fabulous", 99L));
            repository.save(new Event("MyEvent", "Great", 1L));
            repository.save(new Event("Kim", "Bauer", 99L));
            repository.save(new Event("David", "Palmer", 1L));
            repository.save(new Event("Michelle", "Dessler", 1L));

            // fetch all events
            log.info("Events found with findAll():");
            log.info("-------------------------------");
            for (Event event : repository.findAll()) {
                log.info(event.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Event event = repository.findById(1L);
            log.info("Event found with findById(1L):");
            log.info("--------------------------------");
            log.info(event.toString());
            log.info("");

            // fetch customers by last name
            log.info("Event found with user id('99'):");
            log.info("--------------------------------------------");
            repository.findByUserId(99L).forEach(event99 -> {
                log.info(event99.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}