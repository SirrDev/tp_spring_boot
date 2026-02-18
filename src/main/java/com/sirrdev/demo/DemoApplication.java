package com.sirrdev.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;


//@SpringBootApplication
//C’est une annotation spéciale qui combine 3 annotations :
//@Configuration → indique que la classe contient des beans
//@ComponentScan → Spring va scanner les composants dans le package
//@EnableAutoConfiguration → Spring configure automatiquement l’application
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

}
