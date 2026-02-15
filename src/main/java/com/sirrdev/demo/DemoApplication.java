package com.sirrdev.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//ctx est le conteneur IoC
		//Il contient tous les beans créés par Spring
		var ctx = SpringApplication.run(DemoApplication.class, args);

		//On demande au contexte Spring :
		//"Donne-moi le bean de type MyFirstClass" getBean(...) → récupère un bean
		MyFirstClass myFirstClass = ctx.getBean(com.sirrdev.demo.MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}

	//@Bean indique à Spring :
	//"La méthode suivante retourne un objet que tu dois gérer comme un bean"
	//Spring appelle cette méthode au démarrage
	//Il stocke l’objet retourné dans le contexte
	//Il le rend disponible pour injection
	//👉 Ici, Spring crée une instance de MyFirstClass
	@Bean
	public MyFirstClass myFirstClass() {
		return new MyFirstClass();
	}

}
