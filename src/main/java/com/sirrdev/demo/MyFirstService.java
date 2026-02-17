package com.sirrdev.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    //injection du bean myFirstClass
    private final MyFirstClass myFirstClass;


    public MyFirstService(
           MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        //utilisation du bean ou de l'objet
        return  "the bean is saying : " + myFirstClass.sayHello();
    }
}
