package com.simiosMeli;

//import com.simiosMeli.dataBase.DB;
import com.simiosMeli.services.DnaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SimiosMeliApplication {

	public static void main(String[] args) throws SQLException {

		//Connection connection = DB.getConnection();
		//DB.closeConnection();


		SpringApplication.run(SimiosMeliApplication.class, args);

		DnaService dnaService = new DnaService();

		String [] dnaSimios = new String[] {"CAGTAG", "TTTCAT", "GCAGGC", "ACTGAC", "TGAATC"};


		//boolean result = dnaService.findAll(dnaSimios);
		//System.out.println(String.format("O resultado é: %s", result));
	}
	}

