package com.example.util;

import com.example.util.model.Dog;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {
    @Test
     @DisplayName("queryAll")
    public void queryAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Dog> dogs = session.createQuery("from Dog", Dog.class).list();
        assertEquals(1, dogs.size());
        dogs.forEach(e -> assertNotNull(e.getName()));
        session.close();
    }
    @Test
    @DisplayName("Recuperar perro por ID")
    public void recuperarPerroPorId(){

        //Option1
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dog dog = session.find(Dog.class, 1L);

        assertEquals("Laika", dog.getName());

        session.close();
    }
    @Test
    @DisplayName("Recuperar perro por ID")
    public void recuperarUnoPorParametro(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "from Dog where id = :idPerro";
        Query query = session.createQuery(hql);
        query.setParameter("idPerro", 1L);
        Dog dog = (Dog) query.getSingleResult();
        assertNotNull(dog);
        assertEquals(1L, dog.getId());

        session.close();
}


    @Test
    @DisplayName("create one dog")
    public void createOneDog(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Dog dog1 = new Dog("pepi", "sara", "quick dog", true,22);

        session.beginTransaction();

        session.save(dog1);

        session.getTransaction().commit();

        System.out.println(dog1);

        session.close();
    }
    @Test
    @DisplayName("Update One")
    public void updateOne(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dog dogDB = session.find(Dog.class, 1L);

        session.beginTransaction();


        session.save(dogDB);

        session.getTransaction().commit();

        dogDB.setName(dogDB.getName() + " editado");

        session.close();

        System.out.println(dogDB);

    }
    @Test
    @DisplayName("Delete one")
    public void deleteOne(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dog dogDB = session.find(Dog.class, 1L);

        session.beginTransaction();
        session.delete(dogDB);
        System.out.println(dogDB);
        session.persist(dogDB);
        session.getTransaction().commit();

        System.out.println(dogDB);

        session.close();
    }

}