package com.simiosMeli;

//import com.simiosMeli.dataBase.DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SimiosMeliApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(SimiosMeliApplication.class, args);

	}
	}

