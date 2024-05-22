package cue.edu.co.persistance;

import cue.edu.co.model.Client;
import cue.edu.co.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCreate {

    public static void main(String[] args){
        EntityManager em= JpaUtil.getEntityManager();
        try {
            String nombre = JOptionPane.showInputDialog("Enter the name:");
            String apellido = JOptionPane.showInputDialog("Enter the last name:");
            String pago = JOptionPane.showInputDialog("Enter the payment method:");
            em.getTransaction().begin();
            Client c= new Client();
            c.setName(nombre);
            c.setLastName(apellido);
            c.setFormPay(pago);
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("The registered customer ID is " + c.getId());
            c = em.find(Client.class,c.getId());
            System.out.println(c);
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
