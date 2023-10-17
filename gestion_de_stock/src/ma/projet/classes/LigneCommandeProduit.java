/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/*
 * @author akhmim
 */
@Entity
public class LigneCommandeProduit {

    @EmbeddedId
    private LigneCommandeProduitKey id;

    @MapsId("produitId")
    @JoinColumn(name = "produit", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Produit produit;

    @MapsId("commandeId")
    @JoinColumn(name = "commande", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Commande commande;

    private int quantite;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LigneCommandeProduitKey getId() {
        return id;
    }

    public void setId(LigneCommandeProduitKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LigneCommandeProduit{" + ", produit=" + produit.getRef() + ", commande=" + commande.getId() + ", quantite=" + quantite + '}';
    }

}
