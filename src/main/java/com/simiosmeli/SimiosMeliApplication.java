package com.simiosmeli;

//import com.simiosMeli.dataBase.DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

@EnableJpaRepositories
@SpringBootApplication
public class SimiosMeliApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(SimiosMeliApplication.class, args);

	}
	}

