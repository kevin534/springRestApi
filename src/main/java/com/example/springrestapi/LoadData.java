package com.example.springrestapi;


import com.example.springrestapi.models.Candidat;
import com.example.springrestapi.repositories.CandidatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class LoadData {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(CandidatRepository repository) throws ParseException {
        LOGGER.info("Launch Preloading");
        if(repository.count() == 0){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            Date dateNaisance = formatter.parse("05/06/2023");

            Candidat candidat = new Candidat("candidat 1","kevin",dateNaisance,"45 rue du soleil","Saint Etienne","42000");
            Candidat candidat1 = new Candidat("candidat 2","xavier",dateNaisance,"45 rue du soleil","Saint Etienne","42000");

            return args -> {
                LOGGER.info("Preloading " + repository.save(candidat));
            };
        }
        else{
            return args -> {
                LOGGER.info("Already initialized");
            };

        }
    }

}
