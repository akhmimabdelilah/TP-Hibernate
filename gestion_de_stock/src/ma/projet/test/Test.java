    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.LigneCommandeProduitKey;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeProduitService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import ma.projet.util.LigneCommandeProduitUtil;
import org.hibernate.Hibernate;

/*
 * @author akhmim
 */
public class Test {

    public static void main(String[] args) {

        int year = 2023 - 1900;

        // services
        CommandeService css = new CommandeService();
        CategorieService cgs = new CategorieService();
        ProduitService produitService = new ProduitService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();

//        // create commandes      
        css.create(new Commande(new Date(year, 4, 13)));
        css.create(new Commande(new Date(year, 9, 20)));
        css.create(new Commande(new Date(year, 1, 17)));
        css.create(new Commande(new Date(year, 5, 23)));
        css.create(new Commande(new Date(year, 7, 29)));
        css.create(new Commande(new Date(year, 8, 31)));

        // create categories
        cgs.create(new Categorie("code 1", "categorie 1"));
        cgs.create(new Categorie("code 2", "categorie 2"));
        cgs.create(new Categorie("code 3", "categorie 3"));

        // create produits
        produitService.create(new Produit("ref 1", 10, cgs.getById(1)));
        produitService.create(new Produit("ref 2", 43, cgs.getById(3)));
        produitService.create(new Produit("ref 3", 570, cgs.getById(1)));
        produitService.create(new Produit("ref 4", 390, cgs.getById(2)));
        produitService.create(new Produit("ref 5", 470, cgs.getById(3)));
        produitService.create(new Produit("ref 6", 450, cgs.getById(3)));
        produitService.create(new Produit("ref 7", 330, cgs.getById(1)));
        produitService.create(new Produit("ref 8", 440, cgs.getById(2)));
        produitService.create(new Produit("ref 9", 150, cgs.getById(1)));

        // Create a ligneCommandeProduit
        LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit();
        Produit produit_1 = produitService.getById(1);
        Commande commande_2 = css.getById(2);
        LigneCommandeProduitKey ligneCommandeProduitKey = new LigneCommandeProduitKey(produit_1.getId(), commande_2.getId());
        ligneCommandeProduit.setId(ligneCommandeProduitKey);
        ligneCommandeProduit.setProduit(produit_1);
        ligneCommandeProduit.setCommande(commande_2);
        ligneCommandeProduit.setQuantite(2);
        // Add the ligneCommandeProduit to the command
        commande_2.getLigneCommandeProduit().add(ligneCommandeProduit);
        produit_1.getLigneCommandeProduit().add(ligneCommandeProduit);
        lcps.create(ligneCommandeProduit);
//        
        LigneCommandeProduit ligneCommandeProduit2 = new LigneCommandeProduit();
        Produit produit_2 = produitService.getById(2);
        ligneCommandeProduit2.setId(new LigneCommandeProduitKey(produit_2.getId(), commande_2.getId()));
        ligneCommandeProduit2.setProduit(produit_2);
        ligneCommandeProduit2.setCommande(commande_2);
        ligneCommandeProduit2.setQuantite(2);
        // Add the ligneCommandeProduit to the command
        commande_2.getLigneCommandeProduit().add(ligneCommandeProduit2);
        produit_2.getLigneCommandeProduit().add(ligneCommandeProduit2);
        lcps.create(ligneCommandeProduit2);

        LigneCommandeProduit ligneCommandeProduit3 = new LigneCommandeProduit();
        Produit produit_4 = produitService.getById(4);
        Commande commande_3 = css.getById(3);
        ligneCommandeProduit3.setId(new LigneCommandeProduitKey(produit_4.getId(), commande_3.getId()));
        ligneCommandeProduit3.setProduit(produit_4);
        ligneCommandeProduit3.setCommande(commande_3);
        ligneCommandeProduit3.setQuantite(2);
        // Add the ligneCommandeProduit to the command
        commande_3.getLigneCommandeProduit().add(ligneCommandeProduit3);
        produit_4.getLigneCommandeProduit().add(ligneCommandeProduit3);
        lcps.create(ligneCommandeProduit3);

        // afficher la liste des produits par catégorie 1
        System.out.println("\nLa liste des produits par catégorie 1\n");
        produitService.affichierProduitsParCategorie(cgs.getById(1));

        //afficher la liste des produits commandés entre 2023-01-1 et 2023-12-1
        System.out.println("\nLa liste des produits commandés entre 2023-01-1 et 2023-12-1\n");
        produitService.affichierProduitEntreDeuxDate(new Date(year, 0, 1), new Date(year, 11, 1));

        // afficher les produits commandés dans la commande 2
        System.out.println("\nLes produits commandés dans la commande 2\n");
        produitService.affichierProduitParCommand(css.getById(2));

        // afficher la liste des produits dont le prix est supérieur à 100
        System.out.println("\nLa liste des produits dont le prix est supérieur à 100\n");
        produitService.affichierProduitPrixSuperieur100DH();

    }

}
