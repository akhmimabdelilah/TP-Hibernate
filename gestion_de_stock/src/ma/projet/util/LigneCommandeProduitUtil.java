/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.util;

import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.LigneCommandeProduitKey;
import ma.projet.classes.Produit;
import ma.projet.service.CommandeService;
import ma.projet.service.ProduitService;

/*
 * @author akhmim
 */
public class LigneCommandeProduitUtil {

    public static LigneCommandeProduit createAndAssociateLigneCommandeProduit(
            ProduitService produitService,
            CommandeService commandeService,
            int produitId,
            int commandeId,
            int quantite
    ) {
        Produit produit = produitService.getById(produitId);
        Commande commande = commandeService.getById(commandeId);

        LigneCommandeProduitKey ligneCommandeProduitKey = new LigneCommandeProduitKey(produit.getId(), commande.getId());

        LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit();
        ligneCommandeProduit.setId(ligneCommandeProduitKey);
        ligneCommandeProduit.setProduit(produit);
        ligneCommandeProduit.setCommande(commande);
        ligneCommandeProduit.setQuantite(quantite);

        // Add the ligneCommandeProduit to the command and produit
        commande.getLigneCommandeProduit().add(ligneCommandeProduit);
        produit.getLigneCommandeProduit().add(ligneCommandeProduit);

        return ligneCommandeProduit;
    }
}
