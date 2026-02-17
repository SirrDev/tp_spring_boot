package com.sirrdev.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;

    private Environment environment;

    //setter injection, similar to the method injection
    @Autowired
    private void setMyFirstClass(
            @Qualifier("bean1") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        //utilisation du bean ou de l'objet
        return  "the bean is saying : " + myFirstClass.sayHello();
    }

    public String getJavaVersion() {
        //utilisation du bean ou de l'objet
        return  environment.getProperty("java.version" );
    }

    public String getOSName() {
        //utilisation du bean ou de l'objet
        return  environment.getProperty("os.name" );
    }

    public String readProp() {
        //utilisation du bean ou de l'objet
        return  environment.getProperty("my.custom.property" );
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
