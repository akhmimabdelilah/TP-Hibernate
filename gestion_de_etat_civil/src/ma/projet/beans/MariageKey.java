/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.io.Serializable;
import javax.persistence.Embeddable;


/*
 * @author akhmim
 */
@Embeddable
public class MariageKey implements Serializable {

    private int homme_id;
    private int femme_id;

    public MariageKey() {
    }

    public MariageKey(int homme_id, int femme_id) {
        this.homme_id = homme_id;
        this.femme_id = femme_id;
    }

    public int getHomme_id() {
        return homme_id;
    }

    public void setHomme_id(int homme_id) {
        this.homme_id = homme_id;
    }

    public int getFemme_id() {
        return femme_id;
    }

    public void setFemme_id(int femme_id) {
        this.femme_id = femme_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MariageKey other = (MariageKey) obj;
        if (this.homme_id != other.homme_id) {
            return false;
        }
        if (this.femme_id != other.femme_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MariageKey{" + "homme_id=" + homme_id + ", femme_id=" + femme_id + '}';
    }
}
