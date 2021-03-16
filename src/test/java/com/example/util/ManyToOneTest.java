package com.example.util;

import com.example.util.model.Company;
import com.example.util.model.Employee;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;

public class ManyToOneTest {

    @Test
    @DisplayName("Create one company unidirectional")
    public void createOneCompany(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Company company = new Company("Imagina", "8080808D");
        Employee employee = new Employee("empleado1", 34,true,3000.00);

        session.beginTransaction();

        employee.setCompany(company);
        //sin guardar company primero ocurre: transientobjectexception
        session.save(employee);
        session.getTransaction().commit();
    }
}
