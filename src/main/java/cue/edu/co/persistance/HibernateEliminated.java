package cue.edu.co.persistance;

import cue.edu.co.model.Client;
import cue.edu.co.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateEliminated {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the client's id to eliminate:");
        Long id= s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Client client = em.find(Client.class,id);
            em.getTransaction().begin();
            em.remove(client);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
