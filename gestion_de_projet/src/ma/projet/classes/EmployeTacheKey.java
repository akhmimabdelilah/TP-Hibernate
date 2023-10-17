/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * @author akhmim
 */
@Embeddable
public class EmployeTacheKey implements Serializable {

    @Column(name = "employe")
    private int employeId;

    @Column(name = "tache")
    private int tacheId;

    public EmployeTacheKey() {
    }

    public EmployeTacheKey(int employeId, int tacheId) {
        this.employeId = employeId;
        this.tacheId = tacheId;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public int getTacheId() {
        return tacheId;
    }

    public void setTacheId(int tacheId) {
        this.tacheId = tacheId;
    }

    @Override
    public String toString() {
        return "EmployeTacheKey{" + "employeId=" + employeId + ", tacheId=" + tacheId + '}';
    }
}
