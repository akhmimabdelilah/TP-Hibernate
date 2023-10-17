/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * @author akhmim
 */
public class TacheService implements IDao<Tache> {

    @Override
    public boolean create(Tache o) {
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
    public Tache getById(int id) {
        Tache tache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = (Tache) session.get(Tache.class, id);
            tx.commit();
            return tache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return tache;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Tache> getAll() {
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            tx.commit();
            return taches;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return taches;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getTachesPrixSupérieurA1000DH() {
        List<Tache> taches;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache where prix > 1000").list();
            tx.commit();
            taches.stream().forEach((t) -> {
                System.out.println(t);
            });

        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void getTachesRealiseesEntreDeuxDate(Date minDate, Date maxDate){
//        this.getAll().stream()
//            .filter((t) -> (
//                    (t.getDateDebut().compareTo(minDate) == 1 || t.getDateDebut().compareTo(minDate) == 0) &&
//                    (t.getDateFin().compareTo(maxDate) == -1 || t.getDateFin().compareTo(maxDate) == 0)
//            ))
//            .forEach((t) -> {
//                System.out.println(t);
//            }); 
//    }
    public void getTachesRealiseesEntreDeuxDate(Date minDate, Date maxDate) {
        Session session = null;
        Transaction tx = null;
        String query = "FROM EmployeTache et "
                + "JOIN et.tache Tache "
                + "JOIN et.employe Employe "
                + "WHERE et.dateFinReelle <= CURRENT_DATE() AND "
                + "et.dateDebutReelle >= :minDate AND "
                + "et.dateFinReelle <= :maxDate";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            List<Object[]> results = session.createQuery(query)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .list();

            List<Tache> taches = new ArrayList<>();

            for (Object[] result : results) {
                Tache produit = (Tache) result[1];
                taches.add(produit);
            }

            for (Tache t : taches) {
                System.out.println(t);
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
