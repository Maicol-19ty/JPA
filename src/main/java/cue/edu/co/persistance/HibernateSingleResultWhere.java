package cue.edu.co.persistance;

import cue.edu.co.model.Client;
import cue.edu.co.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernateSingleResultWhere{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Client c where c.formPay = ? 1", Client.class);
        System.out.println("Enter a payment method:");
        String pay = s.next();
        query.setParameter(1, pay);
        query.setMaxResults(1);
        Client c = (Client)query.getSingleResult();
        System.out.println(c);
        em.close();
    }
}
