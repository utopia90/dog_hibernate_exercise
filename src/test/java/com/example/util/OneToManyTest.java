package com.example.util;

import com.example.util.model.Dog;
import com.example.util.model.DogShampoo;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OneToManyTest {

    @Test
    @DisplayName("Create Many Dog Shampoos ")
    public void createDogShampoosForDog() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Dog dog = new Dog("pilates", "sara", "fit dog", true, 9);
        DogShampoo dogShampoo1 = new DogShampoo("supershampoo","shine your dog hair");
        DogShampoo dogShampoo2 = new DogShampoo("dogpantene","curl your dog hair");
        DogShampoo dogShampoo3 = new DogShampoo("dogloreal","moistourize your dog hair");


        session.beginTransaction();

        dog.getDogShampoos().add(dogShampoo1);
        dog.getDogShampoos().add(dogShampoo2);
        dog.getDogShampoos().add(dogShampoo3);

        session.save(dogShampoo1);
        session.save(dogShampoo2);
        session.save(dogShampoo3);
        session.save(dog);

        session.getTransaction().commit();
    }
}
