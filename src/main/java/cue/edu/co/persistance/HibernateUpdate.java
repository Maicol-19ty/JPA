package cue.edu.co.persistance;

import cue.edu.co.model.Client;
import cue.edu.co.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Scanner;

public class HibernateUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the client's ID to update: ");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.println("Enter new name: ");
        String newName = sc.nextLine();

        System.out.println("Enter new last name: ");
        String newLastName = sc.nextLine();

        System.out.println("Enter new form of payment: ");
        String newFormPay = sc.nextLine();

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = JpaUtil.getEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            Client client = em.find(Client.class, id);
            if (client != null) {
                client.setName(newName);
                client.setLastName(newLastName);
                client.setFormPay(newFormPay);
                em.merge(client);
                System.out.println("Client updated successfully: " + client);
            } else {
                System.out.println("Client with ID " + id + " not found.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            JpaUtil.getEntityManager().close();
        }
    }
}
