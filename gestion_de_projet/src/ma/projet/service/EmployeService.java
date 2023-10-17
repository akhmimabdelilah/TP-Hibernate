/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * @author akhmim
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
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
    public Employe getById(int id) {
        Employe EmployeTache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            EmployeTache = (Employe) session.get(Employe.class, id);
            tx.commit();
            return EmployeTache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return EmployeTache;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Employe> getAll() {
        List<Employe> EmployeTaches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            EmployeTaches = session.createQuery("from Employe").list();
            tx.commit();
            return EmployeTaches;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return EmployeTaches;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getTachesByEmploye(Employe e) {
        e.getEmployeTache().stream().forEach((et) -> {
            System.out.println(et.getTache());
        });
    }

    public void getProjetsByEmploye(Employe e) {
        for (Projet p : e.getProjets()) {
            System.out.println(p);
        }
    }
}
