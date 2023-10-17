/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * @author akhmim
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int Id;

    protected String nom;
    protected String prenom;
    protected String telephone;
    protected String address;

    @Temporal(TemporalType.DATE)
    protected Date dateNaissance;

    public Personne() {
    }

    public Personne(String nom, String prenom, String telephone, String address, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.address = address;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "{" + "Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", address=" + address + ", dateNaissance=" + dateNaissance;
    }

}
