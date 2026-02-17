package com.sirrdev.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    @Value("${my.custom.property}")
    private String customPropery;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("123")
    private Integer customPropertyInt;

    public MyFirstService(
        @Qualifier("bean1") MyFirstClass myFirstClass
    ){
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        //utilisation du bean ou de l'objet
        return  "the bean is saying : " + myFirstClass.sayHello();
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    public String getCustomPropery() {
        return customPropery;
    }
}

