/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/*
 * @author akhmim
 */
@Entity
public class EmployeTache implements Serializable {

    @EmbeddedId
    private EmployeTacheKey id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutReelle;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinReelle;

    @JoinColumn(name = "employe", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Employe employe;

    @JoinColumn(name = "tache", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Tache tache;

    public EmployeTacheKey getId() {
        return id;
    }

    public void setId(EmployeTacheKey id) {
        this.id = id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "id=" + id + ", dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + ", employe=" + employe.getNom() + ", tache=" + tache.getNom() + '}';
    }

}
