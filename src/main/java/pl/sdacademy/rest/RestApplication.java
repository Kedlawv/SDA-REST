package pl.sdacademy.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.sdacademy.database.hibernate.utils.DaoProvider;

@SpringBootApplication(scanBasePackages = "pl.sdacademy")
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
