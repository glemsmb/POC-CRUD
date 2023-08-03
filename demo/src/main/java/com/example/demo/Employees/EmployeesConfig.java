package com.example.demo.Employees;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EmployeesConfig {
    @Bean
    CommandLineRunner commandlinerunneremployees (EmployeesRepository employeerespository){

        return args -> {
            Employees Joseph = new Employees(
                    "Joseph",
                    "Ilaban",
                    LocalDate.of(2000, FEBRUARY, 24),
                    23,
                    "Male"
            );

            Employees James = new Employees(
                    "James",
                    "Reid",
                    LocalDate.of(1998, JANUARY, 15),
                    25,
                    "Male"
            );

            Employees Angeline = new Employees(
                    "Angeline",
                    "Bernardo",
                    LocalDate.of(1995, APRIL, 02),
                    28,
                    "Female"
            );


            employeerespository.saveAll(List.of(Joseph, James, Angeline));
        };
    }
}
