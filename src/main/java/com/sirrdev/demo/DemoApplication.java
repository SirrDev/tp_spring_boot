package com.sirrdev.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//@SpringBootApplication
//C’est une annotation spéciale qui combine 3 annotations :
//@Configuration → indique que la classe contient des beans
//@ComponentScan → Spring va scanner les composants dans le package
//@EnableAutoConfiguration → Spring configure automatiquement l’application
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//ctx est le conteneur IoC
		//Il contient tous les beans créés par Spring
		var ctx = SpringApplication.run(DemoApplication.class, args);

		//On demande au contexte Spring :
		//"Donne-moi le bean de type  MyFirstClass" getBean(...) → récupère un bean
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getCustomPropery());
		System.out.println(myFirstService.getCustomPropertyInt());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
	}

}
