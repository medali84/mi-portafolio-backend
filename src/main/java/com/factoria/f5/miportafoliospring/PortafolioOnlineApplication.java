package com.factoria.f5.miportafoliospring;

import com.factoria.f5.miportafoliospring.domain.models.Proyecto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class PortafolioOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortafolioOnlineApplication.class, args);
	}

}
