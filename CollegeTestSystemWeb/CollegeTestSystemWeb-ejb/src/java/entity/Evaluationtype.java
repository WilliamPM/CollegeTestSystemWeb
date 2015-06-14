/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author williamPM
 */
@Entity
@Table(name = "EVALUATIONTYPE")
@NamedQueries({
    @NamedQuery(name = "Evaluationtype.findAll", query = "SELECT e FROM Evaluationtype e"),
    @NamedQuery(name = "Evaluationtype.findByEvaluationtypeid", query = "SELECT e FROM Evaluationtype e WHERE e.evaluationtypeid = :evaluationtypeid"),
    @NamedQuery(name = "Evaluationtype.findByDescription", query = "SELECT e FROM Evaluationtype e WHERE e.description = :description"),
    @NamedQuery(name = "Evaluationtype.findByClosedcode", query = "SELECT e FROM Evaluationtype e WHERE e.closedcode = :closedcode")})
public class Evaluationtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVALUATIONTYPEID")
    private Integer evaluationtypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 10)
    @Column(name = "CLOSEDCODE")
    private String closedcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationtypeid")
    private Collection<Evaluation> evaluationCollection;

    public Evaluationtype() {
    }

    public Evaluationtype(Integer evaluationtypeid) {
        this.evaluationtypeid = evaluationtypeid;
    }

    public Evaluationtype(Integer evaluationtypeid, String description) {
        this.evaluationtypeid = evaluationtypeid;
        this.description = description;
    }

    public Integer getEvaluationtypeid() {
        return evaluationtypeid;
    }

    public void setEvaluationtypeid(Integer evaluationtypeid) {
        this.evaluationtypeid = evaluationtypeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClosedcode() {
        return closedcode;
    }

    public void setClosedcode(String closedcode) {
        this.closedcode = closedcode;
    }

    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationtypeid != null ? evaluationtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluationtype)) {
            return false;
        }
        Evaluationtype other = (Evaluationtype) object;
        if ((this.evaluationtypeid == null && other.evaluationtypeid != null) || (this.evaluationtypeid != null && !this.evaluationtypeid.equals(other.evaluationtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Evaluationtype[ evaluationtypeid=" + evaluationtypeid + " ]";
    }
    
}
