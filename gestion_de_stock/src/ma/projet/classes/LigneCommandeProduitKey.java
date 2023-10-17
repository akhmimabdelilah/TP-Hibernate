/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*
 * @author akhmim
 */
@Embeddable
public class LigneCommandeProduitKey implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit")
    private int produitId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande")
    private int commandeId;

    public LigneCommandeProduitKey() {
    }

    public LigneCommandeProduitKey(int produitId, int commandeId) {
        this.produitId = produitId;
        this.commandeId = commandeId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

}
