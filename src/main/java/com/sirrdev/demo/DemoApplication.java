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
		var app = new SpringApplication(DemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

		//On demande au contexte Spring :
		//"Donne-moi le bean de type  MyFirstClass" getBean(...) → récupère un bean
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getCustomPropery());

	}

}
