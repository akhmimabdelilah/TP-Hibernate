/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * @author akhmim
 */
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet o) {
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
    public Projet getById(int id) {
        Projet projet = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
            return projet;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return projet;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Projet> getAll() {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            tx.commit();
            return projets;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return projets;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getTachesPlanifieesByProjet(Projet p) {
        p.getTaches().stream().filter((t) -> (t.getDateDebut().compareTo(new Date()) == 1)).forEach((t) -> {
            System.out.println(t);
        });
    }

    public void getTachesRealiseesByProjet(Projet p) {
        System.out.println("Projet: " + p.getId() + "\t\t\t Nom: " + p.getNom() + "\t Date début: " + p.getDateDebut());
        System.out.println("Liste des tachés :");
        System.out.println("\tNum\t\tNom\t\tDate Début Réelle\t\tDate Fin Réelle");

        if (!p.getTaches().isEmpty()) {
            p.getTaches().stream().forEach((t) -> {
                if (!t.getEmployeTaches().isEmpty()) {
                    Date dateDebutReelle = t.getEmployeTaches().get(0).getDateDebutReelle();
                    Date dateFinReelle = t.getEmployeTaches().get(0).getDateFinReelle();

                    // determine le plus petit dateDebutReelle et le plus grande dateFinReelle
                    for (EmployeTache et : t.getEmployeTaches()) {
                        if (dateDebutReelle.compareTo(et.getDateDebutReelle()) == 1) {
                            dateDebutReelle = et.getDateDebutReelle();
                        }
                        if (dateFinReelle.compareTo(et.getDateFinReelle()) == -1) {
                            dateFinReelle = et.getDateFinReelle();
                        }
                    }

                    // tache realise
                    if (dateFinReelle.compareTo(new Date()) == -1) {
                        System.out.println("\t" + t.getId() + "\t\t" + t.getNom() + "\t\t" + dateDebutReelle + "\t\t\t" + dateFinReelle);
                    }
                } else {
                    System.out.println("There are no finished tasks yet!");
                }

            });
        }
    }
}
