/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * @author akhmim
 */
@Entity
@Table(name = "Mariage")
public class Mariage {

    @EmbeddedId
    private MariageKey id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private int nbrEnfant;

    @ManyToOne
    @JoinColumn(name = "homme_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Homme homme;

    @ManyToOne
    @JoinColumn(name = "femme_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Femme femme;

    public Mariage() {
    }

    public MariageKey getId() {
        return id;
    }

    public void setId(MariageKey id) {
        this.id = id;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    @Override
    public String toString() {
        return "Mariage{" + "dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbrEnfant=" + nbrEnfant + '}';
    }
}
