package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    public CommandLineRunner commandLIneRunner(StudentRepository repository) {
        return args -> {

            Student mariam = Student.builder()
                    .name("Mariam")
                    .dob(LocalDate.of(2000, Month.JANUARY, 5))
                    .email("mariam.jamal@gmail.com")
                    .build();

            Student alex = Student.builder()
                    .name("Alex")
                    .dob(LocalDate.of(2004, Month.JANUARY, 5))
                    .email("alex.jamal@gmail.com")
                    .build();

//            repository.saveAll(List.of(mariam, alex));

        };
    }
}
