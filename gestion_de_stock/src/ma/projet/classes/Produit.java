/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * @author akhmim
 */
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;
    private float prix;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", fetch = FetchType.EAGER)
    private List<LigneCommandeProduit> ligneCommandeProduit;

    public Produit() {
    }

    public Produit(String ref, float prix, Categorie categorie) {
        this.ref = ref;
        this.prix = prix;
        this.categorie = categorie;
    }

    public String getRef() {
        return ref;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneCommandeProduit> getLigneCommandeProduit() {
        return ligneCommandeProduit;
    }

    public void setLigneCommandeProduit(List<LigneCommandeProduit> ligneCommandeProduit) {
        this.ligneCommandeProduit = ligneCommandeProduit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", ref=" + ref + ", prix=" + prix + ", categorie=" + categorie.getLibelle() + ", ligneCommandeProduit=" + ligneCommandeProduit + '}';
    }
}
