package pl.sda;

import pl.sda.view.ConsoleManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();

            entityManager.close();
            entityManagerFactory.close();

    }


}
