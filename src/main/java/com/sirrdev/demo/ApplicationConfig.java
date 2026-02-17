package com.sirrdev.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {

    @Bean("bean1")
    public MyFirstClass myFirstBean() {

        return new MyFirstClass("First Bean");
    }
    @Bean
    //@Profile("dev")
    public MyFirstClass mySecondBean() {

        return new MyFirstClass("Second Bean");
    }
    @Bean
    //@Primary
    //@Profile("test")
    public MyFirstClass myThirdBean() {

        return new MyFirstClass("Third Bean");
    }
}
