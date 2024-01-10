package com.work.serviceapp;

import com.work.serviceapp.entities.Client;
import com.work.serviceapp.entities.Worker;
import com.work.serviceapp.repositories.ClientRepository;
import com.work.serviceapp.repositories.ServiceRepository;
import com.work.serviceapp.repositories.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@SpringBootApplication
public class ServiceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAppApplication.class, args);
    }

@Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository, WorkerRepository workerRepository,
                                        ServiceRepository serviceRepository){
        return args -> {
           clientRepository.save( Client.builder().firsName("Anas").lastName("Nafhi").dateNaissance(new Date()).email("Anasnafhi@gmail.com").build());
            clientRepository.save(Client.builder().firsName("Peter").lastName("Griffin").dateNaissance(new Date()).email("Peter@gmail.com").build());
            clientRepository.save(Client.builder().firsName("Stewie").lastName("Griffin").dateNaissance(new Date()).email("Stewie@gmail.com").build());

            workerRepository.save(Worker.builder().firsName("Anas").lastName("Nafnof").phoneNumber("0777946652").availability(Map.of(LocalDate.of(2024,12,13),"Casablanca"))
                    .zone("Sidimaarouf").build());


        };

}

}
