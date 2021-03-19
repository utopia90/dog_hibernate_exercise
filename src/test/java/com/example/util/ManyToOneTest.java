package com.example.util;

import com.example.util.model.Bone;
import com.example.util.model.Dog;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManyToOneTest {

    @Test
    @DisplayName("Create Bone Unidirectional")
    public void createBoneUnidirectional() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Bone bone = new Bone( "bone material", true);
        Dog dog = new Dog("lulita", "sara", "little dog",true,22 );
        Dog dog2 = new Dog("pepita", "sara", "sleepy dog",true,22 );

        session.beginTransaction();

        // Persistir
        dog.setBone(bone);
        dog2.setBone(bone);

        session.persist(dog); // crear
        session.persist(dog2);


        session.getTransaction().commit();
    }
}
