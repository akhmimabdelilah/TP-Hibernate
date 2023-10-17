/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/*
 * @author akhmim
 */
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    private List<LigneCommandeProduit> ligneCommandeProduit;

    public Commande() {
    }

    public Commande(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LigneCommandeProduit> getLigneCommandeProduit() {
        return ligneCommandeProduit;
    }

    public void setLigneCommandeProduit(List<LigneCommandeProduit> ligneCommandeProduit) {
        this.ligneCommandeProduit = ligneCommandeProduit;
    }

    @Override
    public String toString() {
        return "Commande{" + "date=" + date + ", ligneCommandeProduit=" + ligneCommandeProduit + '}';
    }

}
