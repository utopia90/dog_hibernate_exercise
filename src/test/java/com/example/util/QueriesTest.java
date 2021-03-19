package com.example.util;

import com.example.util.model.Bone;
import com.example.util.model.Dog;
import com.example.util.model.DogWalker;
import com.example.util.model.DogWalkerType;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QueriesTest {

    @Test
    @DisplayName("filterByDogWalkerType")
    public void filterByProjectType() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        DogWalker dogWalker1 = new DogWalker("luis", false, DogWalkerType.OCASSIONAL);
        DogWalker dogWalker2 = new DogWalker("clara", true, DogWalkerType.MEDIUM);
        DogWalker dogWalker3 = new DogWalker("estefanía", true, DogWalkerType.FREQUENT);


        session.beginTransaction();

        session.save(dogWalker1);
        session.save(dogWalker2);
        session.save(dogWalker3);

        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();

        Query<DogWalker> query = session.createQuery("select distinct p from DogWalker p where type = :dogWalkerType", DogWalker.class);
        query.setParameter("dogWalkerType", DogWalkerType.MEDIUM);
        List<DogWalker> walkers = query.list();

        System.out.println(walkers);
        session.close();
    }
    @Test
    @DisplayName("queryJoin")
    public void queryJoin() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Dog> query = session.createQuery("select distinct c from Dog c join fetch c.bone where c.id = 1", Dog.class);

        Dog dog = query.getSingleResult();

        System.out.println("=========");
        System.out.println(dog);
        System.out.println(dog.getBone());

    }
}