package cue.edu.co.persistance;

import cue.edu.co.model.Client;
import cue.edu.co.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateToList {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Client> clients = em.createQuery("select c from Client c",
                Client.class).getResultList();
        clients.forEach(System.out::println);
        em.close();
    }
}
