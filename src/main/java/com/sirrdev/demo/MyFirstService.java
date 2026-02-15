package com.sirrdev.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    //injection du bean myFirstClass
    private final MyFirstClass myFirstClass;


    //"Injecte automatiquement les dépendances nécessaires à ce constructeur."
    //⚠ Important
    //Depuis Spring 4.3+, si ta classe n’a qu’un seul constructeur,
    //@Autowired n’est même plus obligatoire.
    @Autowired
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        //utilisation du bean ou de l'objet
        return  "the bean is saying : " + myFirstClass.sayHello();
    }
}
