package pl.sda.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityService {

    private static EntityManagerFactory entityManagerFactory;

    public static  EntityManagerFactory entityManagerFactory(){
        if(entityManagerFactory == null){
            create();
        }
        return  entityManagerFactory;
    }

    public static void create(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
    }

    public static void close(){
        entityManagerFactory().close();
    }
}