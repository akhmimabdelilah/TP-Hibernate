package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTacheKey;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;


/*
 * @author akhmim
 */
public class Test {

    public static void main(String[] args) {

        // cree les services
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();

        // cree les employes
        es.create(new Employe("nom 1", "prenom 1", "4484389348"));
        es.create(new Employe("nom 2", "prenom 2", "8934245825"));
        es.create(new Employe("nom 3", "prenom 3", "4487889534"));
        es.create(new Employe("nom 4", "prenom 4", "0987897378"));
        es.create(new Employe("nom 5", "prenom 5", "0001918377"));

        // cree les taches
        Tache tache_1 = new Tache("Conception", new Date(2023 - 1900, 0, 1), new Date(2023 - 1900, 4, 1), 1400);
        Tache tache_2 = new Tache("Développement", new Date(2023 - 1900, 6, 1), new Date(2023 - 1900, 9, 1), 900);
        Tache tache_3 = new Tache("Tache 3", new Date(2021 - 1900, 2, 1), new Date(2022 - 1900, 4, 1), 400);
        Tache tache_4 = new Tache("Analyse", new Date(2021 - 1900, 8, 1), new Date(2021 - 1900, 10, 1), 2900);
        Tache tache_5 = new Tache("Tache 5", new Date(2023 - 1900, 10, 1), new Date(2024 - 1900, 2, 1), 9100);
        Tache tache_6 = new Tache("Tache 6", new Date(2023 - 1900, 9, 11), new Date(2023 - 1900, 11, 17), 1700);
        Tache tache_7 = new Tache("Tache 7", new Date(2024 - 1900, 1, 1), new Date(2024 - 1900, 2, 1), 19103);
        Tache tache_8 = new Tache("Tache 8", new Date(2023 - 1900, 9, 17), new Date(2024 - 1900, 6, 1), 7060);

        // cree les projets
        Projet p_1 = new Projet("projet 1", new Date(2023 - 1900, 0, 1), new Date(2024 - 1900, 0, 1), es.getById(1));
        Projet p_2 = new Projet("projet 2", new Date(2023 - 1900, 5, 1), new Date(2027 - 1900, 9, 1), es.getById(4));
        Projet p_3 = new Projet("projet 3", new Date(2017 - 1900, 0, 1), new Date(2021 - 1900, 8, 1), es.getById(2));
        Projet p_4 = new Projet("projet 4", new Date(2023 - 1900, 2, 1), new Date(2023 - 1900, 8, 1), es.getById(3));
        Projet p_5 = new Projet("Gestion de stock", new Date(2021 - 1900, 7, 15), new Date(2021 - 1900, 10, 18), es.getById(1));
        Projet p_6 = new Projet("projet 6", new Date(2023 - 1900, 10, 11), new Date(2026 - 1900, 10, 11), es.getById(3));

        // adding tasks 1, 2 et 3 to projcet 1
        p_1.addTache(tache_1);
        p_1.addTache(tache_3);
        p_1.addTache(tache_2);

        // adding tasks 2 et 6 to projcet 2
        p_2.addTache(tache_2);
        p_2.addTache(tache_6);

        // adding tasks 7 et 8 to projcet 3
        p_3.addTache(tache_7);
        p_3.addTache(tache_8);

        // adding tasks 4 to projcet 4
        p_4.addTache(tache_4);

        // adding tasks 4 et 6 to projcet 5
        p_5.addTache(tache_4);
        p_5.addTache(tache_6);

        // adding tasks 1, 5, 7 et 8 to projcet 6
        p_6.addTache(tache_1);
        p_6.addTache(tache_8);
        p_6.addTache(tache_7);
        p_6.addTache(tache_5);

        // commit projets
        ps.create(p_1);
        ps.create(p_2);
        ps.create(p_3);
        ps.create(p_4);
        ps.create(p_5);
        ps.create(p_6);

        // commit tasks
        ts.create(tache_1);
        ts.create(tache_2);
        ts.create(tache_3);
        ts.create(tache_4);
        ts.create(tache_5);
        ts.create(tache_6);
        ts.create(tache_7);
        ts.create(tache_8);

        // cree EmployeTaches
        Employe employe_1 = es.getById(1);
        EmployeTache employeTache_1 = new EmployeTache();
        employeTache_1.setId(new EmployeTacheKey(employe_1.getId(), tache_5.getId()));
        employeTache_1.setDateDebutReelle(new Date(2023 - 1900, 10, 6));
        employeTache_1.setDateFinReelle(new Date(2024 - 1900, 3, 1));
        employeTache_1.setEmploye(employe_1);
        employeTache_1.setTache(tache_5);
        employe_1.getEmployeTache().add(employeTache_1);
        tache_5.getEmployeTaches().add(employeTache_1);
        ets.create(employeTache_1);

        EmployeTache employeTache_2 = new EmployeTache();
        employeTache_2.setId(new EmployeTacheKey(employe_1.getId(), tache_6.getId()));
        employeTache_2.setDateDebutReelle(new Date(2023 - 1900, 10, 1));
        employeTache_2.setDateFinReelle(new Date(2024 - 1900, 0, 17));
        employeTache_2.setEmploye(employe_1);
        employeTache_2.setTache(tache_6);
        employe_1.getEmployeTache().add(employeTache_2);
        tache_6.getEmployeTaches().add(employeTache_2);
        ets.create(employeTache_2);

        EmployeTache employeTache_3 = new EmployeTache();
        employeTache_3.setId(new EmployeTacheKey(employe_1.getId(), tache_3.getId()));
        employeTache_3.setDateDebutReelle(new Date(2021 - 1900, 2, 1));
        employeTache_3.setDateFinReelle(new Date(2022 - 1900, 6, 1));
        employeTache_3.setEmploye(employe_1);
        employeTache_3.setTache(tache_3);
        employe_1.getEmployeTache().add(employeTache_3);
        tache_3.getEmployeTaches().add(employeTache_3);
        ets.create(employeTache_3);

        Employe employe_2 = es.getById(2);
        EmployeTache employeTache_4 = new EmployeTache();
        employeTache_4.setId(new EmployeTacheKey(employe_2.getId(), tache_4.getId()));
        employeTache_4.setDateDebutReelle(new Date(2021 - 1900, 8, 1));
        employeTache_4.setDateFinReelle(new Date(2021 - 1900, 10, 15));
        employeTache_4.setEmploye(employe_2);
        employeTache_4.setTache(tache_4);
        employe_2.getEmployeTache().add(employeTache_4);
        tache_4.getEmployeTaches().add(employeTache_4);
        ets.create(employeTache_4);

        EmployeTache employeTache_5 = new EmployeTache();
        employeTache_5.setId(new EmployeTacheKey(employe_2.getId(), tache_5.getId()));
        employeTache_5.setDateDebutReelle(new Date(2023 - 1900, 10, 26));
        employeTache_5.setDateFinReelle(new Date(2024 - 1900, 3, 18));
        employeTache_5.setEmploye(employe_2);
        employeTache_5.setTache(tache_5);
        employe_2.getEmployeTache().add(employeTache_5);
        tache_5.getEmployeTaches().add(employeTache_5);
        ets.create(employeTache_5);

        // afficher la liste tâches réalisées par l'employé 1
        System.out.println("\n=============\nafficher la liste tâches réalisées par l'employé 1\n");
        es.getTachesByEmploye(employe_1);
        System.out.println("\n=============\n");

        // afficher la liste projets gérées par l'employé 1
        System.out.println("\n=============\nafficher la liste projets gérées par l'employé 1\n");
        es.getProjetsByEmploye(employe_1);
        System.out.println("\n=============\n");

        // afficher la liste des tâches planifiées pour le projet 6
        System.out.println("\n=============\nafficher la liste des tâches planifiées pour le projet 6\n");
        ps.getTachesPlanifieesByProjet(ps.getById(6));
        System.out.println("\n=============\n");

        // afficher la liste des tâches réalisées dans le projet 5
        System.out.println("\n=============\nafficher la liste des tâches réalisées dans le projet 5\n");
        ps.getTachesRealiseesByProjet(ps.getById(5));
        System.out.println("\n=============\n");

        // afficher la liste des tâches dont le prix supérieur à 1000 DH
        System.out.println("\n=============\nafficher la liste des tâches dont le prix supérieur à 1000 DH\n");
        ts.getTachesPrixSupérieurA1000DH();
        System.out.println("\n=============\n");

        // afficher la liste des tâches réalisées entre deux dates dans
        System.out.println("\n=============\nafficher la liste des tâches réalisées entre deux dates dans\n");
        ts.getTachesRealiseesEntreDeuxDate(new Date(2021 - 1900, 0, 1), new Date(2021 - 1900, 11, 31));
        System.out.println("\n=============\n");
    }

}
