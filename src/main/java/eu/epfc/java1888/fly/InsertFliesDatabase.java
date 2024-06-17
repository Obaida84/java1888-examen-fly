package eu.epfc.java1888.fly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDateTime;

@Configuration
public class InsertFliesDatabase {
    Logger logger = LoggerFactory.getLogger(InsertFliesDatabase.class);

    @Bean
    CommandLineRunner insertFlies(FlyRepository repository) {
        return args -> {
            insertFlies(repository, "A1", "Brussels", LocalDateTime.of(2024, 6, 14, 12, 8), "London", LocalDateTime.of(2024,06,20,12,25), "Top airlines", 421.23);
            insertFlies(repository, "B021", "Amsterdam", LocalDateTime.of(2024,6,15,10,39), "Brussels", LocalDateTime.of(2024,06,29,22,30), "Top airlines", 421.23);
        };
    }
    private void insertFlies(FlyRepository repository, String number, String departure, LocalDateTime departureTime , String arrival, LocalDateTime arrivalTime, String company, double price){
    Fly fly = new Fly(null, number, departure, departureTime, arrival, arrivalTime ,company, price);
    repository.save(fly);
    logger.info("insert" + fly);
    }
}

