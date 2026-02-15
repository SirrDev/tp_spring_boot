package com.sirrdev.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration → indique que la classe contient des définitions de beans.
//Concrètement :
//Spring va lire cette classe au démarrage
//Il va exécuter les méthodes annotées @Bean
//Il va enregistrer les objets retournés dans le ApplicationContext
//⚠ Important :
//@Configuration est une version spécialisée de @Component.
@Configuration
public class ApplicationConfig {

    @Bean("myBean")
    public MyFirstClass myFirstClass() {
        return new MyFirstClass();
    }
}
