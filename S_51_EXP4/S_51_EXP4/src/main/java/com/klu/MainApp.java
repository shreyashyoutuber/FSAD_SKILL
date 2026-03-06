package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

        Student s = (Student) context.getBean("studentBean");

        s.displayStudent();
    }
}