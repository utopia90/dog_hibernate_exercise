package com.example.util;

import com.example.util.model.Direction;
import com.example.util.model.Employee;
import com.example.util.model.Qualifications;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OneToOneTest {

    @Test
    @DisplayName("One to One 1")
    public void oneToOne() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = new Employee("Anthony", 22, true, 2000.00);
        Direction direction = new Direction("calle falsa", "Madrid", "2003", "spain");

        session.beginTransaction();

        session.save(direction);
        employee.setDirection(direction);
        session.save(employee);
        session.getTransaction().commit();

        System.out.println(direction);
        System.out.println(employee);
    }
    @Test
    @DisplayName("createDirection")
    public void createDirection() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = new Employee("Marcos", 22, true, 2000.40);
        Direction direction = new Direction("calle nueva", "Malaga", "2003", "spain");


        session.beginTransaction();
        direction.setEmployee(employee);
        employee.setDirection(direction);

        session.save(direction);
        session.save(employee);

        session.getTransaction().commit();

        session.close();

        session = HibernateUtil.getSessionFactory().openSession();

        Direction directionDB = session.find(Direction.class, direction.getId());

        System.out.println(directionDB.getEmployee());

        session.close();

    }
    @Test
    @DisplayName("One to One 1 Qualifications")
    public void oneToOneQualifications() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = new Employee("Richard", 22, true, 2000.00);
        Qualifications qualifications = new Qualifications("economics", "economy in the modern company", "english");

        session.beginTransaction();

        session.save(qualifications);
        employee.setQualifications(qualifications);
        session.save(employee);
        session.getTransaction().commit();

        System.out.println(qualifications);
        System.out.println(employee);
    }
    @Test
    @DisplayName("createQualification")
    public void createQualification() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = new Employee("Rigoberto", 22, true, 2000.40);
        Qualifications qualifications = new Qualifications("art degree", "history of art", "french");


        session.beginTransaction();
        qualifications.setEmployee(employee);
        employee.setQualifications(qualifications);

        session.save(qualifications);
        session.save(employee);

        session.getTransaction().commit();

        session.close();

        session = HibernateUtil.getSessionFactory().openSession();

        Qualifications qualificationsDB = session.find(Qualifications.class, qualifications.getId());

        System.out.println(qualificationsDB.getEmployee());

        session.close();

    }
}
