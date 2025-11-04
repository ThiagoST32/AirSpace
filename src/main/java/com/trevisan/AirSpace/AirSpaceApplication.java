package com.trevisan.AirSpace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class AirSpaceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AirSpaceApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.err.println(LocalDate.now());
    }
}
