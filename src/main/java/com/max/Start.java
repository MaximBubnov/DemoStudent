package com.max;

import com.max.entity.Exam;
import com.max.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class Start {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        //вставка студента в БД
       /* Student student = new Student();
        student.setFirstName("Galina");
        student.setSecondName("Ponomareva");
        student.setAge(19);

        session.save(student);*/

       //вывод студента из бд
        Student student = session.get(Student.class, 1);
        /*System.out.println(student);*/

        //изменение параметров у студента в БД
        /*student.setAge(22);*/

        Set<Exam> exams = student.getExams();

        transaction.commit();


        session.close();
        sessionFactory.close();
    }
}
