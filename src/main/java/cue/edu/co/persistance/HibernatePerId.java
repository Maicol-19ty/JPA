package cue.edu.co.persistance;

import cue.edu.co.model.Client;
import cue.edu.co.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernatePerId {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the client's ID to look for: ");
        Long id = sc.nextLong();

        EntityManager em = JpaUtil.getEntityManager();
        Client client = em.find(Client.class, id);
        System.out.println(client);

        Client client2 = em.find(Client.class, id);
        System.out.println(client2);
    }

}
