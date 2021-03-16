package com.example.util;

import com.example.util.model.Employee;
import com.example.util.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {
    @Test
     @DisplayName("queryAll")
    public void queryAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        assertEquals(1, employees.size());
        employees.forEach(e -> assertNotNull(e.getName()));
        session.close();
    }
    @Test
    @DisplayName("Recuperar empleado por ID")
    public void recuperarEmpleadoPorId(){

        //Option1
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.find(Employee.class, 1L);

        assertNotNull(employee);
        assertEquals(1L, employee.getId());

        session.close();
    }
    @Test
    @DisplayName("Recuperar empleado por ID")
    public void recuperarUnoPorParametro(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "from Employee where id = :idEmpleado";
        Query query = session.createQuery(hql);
        query.setParameter("idEmpleado", 1L);
        Employee employee = (Employee) query.getSingleResult();
        assertNotNull(employee);
        assertEquals(1L, employee.getId());

        session.close();
}


    @Test
    @DisplayName("create one employee")
    public void createOneEmployee(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee1 = new Employee("Juan", 25, true, 3000.0D);

        session.beginTransaction();

        session.save(employee1);

        session.getTransaction().commit();

        System.out.println(employee1);

        session.close();
    }
    @Test
    @DisplayName("Update One")
    public void updateOne(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employeeDB = session.find(Employee.class, 1L);

        session.beginTransaction();


        session.save(employeeDB);

        session.getTransaction().commit();
        session.close();
        employeeDB.setName(employeeDB.getName() + " editado");


        System.out.println(employeeDB);

    }
    @Test
    @DisplayName("Delete one")
    public void deleteOne(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employeeDB = session.find(Employee.class, 1L);

        session.beginTransaction();
        session.delete(employeeDB);
        System.out.println(employeeDB);
        session.persist(employeeDB);
        session.getTransaction().commit();

        System.out.println(employeeDB);

        session.close();
    }

}