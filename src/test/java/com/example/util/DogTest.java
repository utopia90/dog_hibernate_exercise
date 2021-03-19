package com.example.util;

import com.example.util.model.Bone;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DogTest {
    @Test
    @DisplayName("Retrieve bone ordering dogs by name")
    public void retrieveBoneOrderingDogsByName() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Bone bone = session.find(Bone.class, 1L );

        bone.getDogs().forEach(dog -> System.out.println(dog.getName()));

        session.close();


    }
}
