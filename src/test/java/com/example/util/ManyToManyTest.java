package com.example.util;


import com.example.util.model.Dog;
import com.example.util.model.DogWalker;
import com.example.util.model.DogWalkerType;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ManyToManyTest {

    @Test
    @DisplayName("createDogWalkers")
    public void createDogWalkers(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        DogWalker dogwalker1 = new DogWalker("Jesus", true, DogWalkerType.MEDIUM);
        DogWalker dogwalker2 = new DogWalker("Lola", true, DogWalkerType.FREQUENT);
        DogWalker dogwalker3 = new DogWalker("Manuel", false, DogWalkerType.OCASSIONAL);

        Dog dog1 = new Dog("pitu", "sara", "pastor vasco", true,22);
        Dog dog2 = new Dog("chichu", "sara", "pastor aleman", true,22);
        Dog dog3 = new Dog("mimi", "sara", "chiguagua", true,22);


        dog1.getDogWalkers().add(dogwalker1);
        dog1.getDogWalkers().add(dogwalker2);
        dog1.getDogWalkers().add(dogwalker3);

        dog2.getDogWalkers().add(dogwalker1);

        session.save(dog1);
        session.save(dog2);
        session.save(dog3);

        session.save(dogwalker1);
        session.save(dogwalker2);
        session.save(dogwalker3);

        session.getTransaction().commit();

        session.close();

    }

}
