package com.example.util;

import com.example.util.model.Dog;
import com.example.util.model.Veterinarian;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OneToOneTest {

    @Test
    @DisplayName("One to One 1")
    public void oneToOne() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dog dog = new Dog("lulu","sara","amazing dog", true, 12);
        Veterinarian veterinarian = new Veterinarian("Maria", "Madrid", true);

        session.beginTransaction();

        session.save(veterinarian);
        dog.setVeterinarian(veterinarian);
        session.save(dog);
        session.getTransaction().commit();

        System.out.println(dog);
        System.out.println(veterinarian);
    }
    @Test
    @DisplayName("createVeterinarian")
    public void createVeterinarian() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Dog dog = new Dog("pololo","sara","pretty dog", true, 12);
        Veterinarian veterinarian = new Veterinarian("Lola", "Barcelona", true);


        session.beginTransaction();
        veterinarian.setDog(dog);
        dog.setVeterinarian(veterinarian);

        session.save(veterinarian);
        session.save(dog);

        session.getTransaction().commit();

        session.close();

        session = HibernateUtil.getSessionFactory().openSession();

        Veterinarian veterinarianDB = session.find(Veterinarian.class, veterinarian.getId());

        System.out.println(veterinarianDB.getDog());

        session.close();

    }

}
