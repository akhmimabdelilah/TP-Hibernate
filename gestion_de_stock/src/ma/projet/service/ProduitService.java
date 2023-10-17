/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.classes.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * @author akhmim
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produits;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Produit getById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
            return produit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void affichierProduitsParCategorie(Categorie c) {
        for (Produit p : c.getProduits()) {
            System.out.println(p);
        }

        System.out.println("\n=========================================\n");
    }

    public void affichierProduitEntreDeuxDate(Date minDate, Date maxDate) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            String hql = "FROM LigneCommandeProduit l "
                    + "join l.commande Commande  "
                    + "join l.produit Produit "
                    + "WHERE Commande.date BETWEEN :minDate and :maxDate";

            List<Object[]> results = session.createQuery(hql)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .list();

            tx.commit();

            List<Produit> produits = new ArrayList<>();

            for (Object[] result : results) {
                Produit produit = (Produit) result[2];
                produits.add(produit);
            }

            for (Produit p : produits) {
                System.out.println(p.getRef());
            }

        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        System.out.println("\n=========================================\n");
    }

    public void affichierProduitParCommand(Commande c) {
        SimpleDateFormat format = new SimpleDateFormat("dd E yyyy");

        System.out.println("Commande: " + c.getId() + "\t" + "Date: " + format.format(c.getDate()));
        System.out.println("Liste des produits :");
        System.out.println("\tRéférence\tPrix\tQuantité");

        for (LigneCommandeProduit ligneCommandeProduit : c.getLigneCommandeProduit()) {
            Produit p = ligneCommandeProduit.getProduit();
            System.out.println("\t" + p.getRef() + "\t\t" + p.getPrix() + " DH" + "\t\t" + ligneCommandeProduit.getQuantite());
//            if(ligneCommandeProduit.getCommande().getId() == c.getId()){
//                
//            }
        }

        System.out.println("\n=========================================\n");
    }

    public void affichierProduitPrixSuperieur100DH() {
        for (Produit p : this.getAll()) {
            if (p.getPrix() > 100) {
                System.out.println(p);
            }
        }

        System.out.println("\n=========================================\n");
    }

    public void affichierProduitPrixSuperieur100DHAvecHQL() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit where prix > 100").list();
            tx.commit();
            System.out.println(produits);
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        System.out.println("\n=========================================\n");
    }
}
