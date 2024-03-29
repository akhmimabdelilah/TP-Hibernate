/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.classes.Categorie;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * @author akhmim
 */
public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie o) {
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
    public List<Categorie> getAll() {
        List<Categorie> categories = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories = session.createQuery("from Categorie").list();
            tx.commit();
            return categories;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return categories;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Categorie getById(int id) {
        Categorie categorie = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorie = (Categorie) session.get(Categorie.class, id);
            tx.commit();
            return categorie;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return categorie;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
