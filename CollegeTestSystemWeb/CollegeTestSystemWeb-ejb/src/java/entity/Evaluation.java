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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author williamPM
 */
@Entity
@Table(name = "EVALUATION")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByEvaluationid", query = "SELECT e FROM Evaluation e WHERE e.evaluationid = :evaluationid")})
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVALUATIONID")
    private Integer evaluationid;
    @JoinTable(name = "EVALUATIONQUESTION", joinColumns = {
        @JoinColumn(name = "EVALUATIONID", referencedColumnName = "EVALUATIONID")}, inverseJoinColumns = {
        @JoinColumn(name = "QUESTIONID", referencedColumnName = "QUESTIONID")})
    @ManyToMany
    private Collection<Question> questionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluation")
    private Collection<Usersevaluationquestion> usersevaluationquestionCollection;
    @JoinColumn(name = "EVALUATIONTYPEID", referencedColumnName = "EVALUATIONTYPEID")
    @ManyToOne(optional = false)
    private Evaluationtype evaluationtypeid;

    public Evaluation() {
    }

    public Evaluation(Integer evaluationid) {
        this.evaluationid = evaluationid;
    }

    public Integer getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(Integer evaluationid) {
        this.evaluationid = evaluationid;
    }

    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    public Collection<Usersevaluationquestion> getUsersevaluationquestionCollection() {
        return usersevaluationquestionCollection;
    }

    public void setUsersevaluationquestionCollection(Collection<Usersevaluationquestion> usersevaluationquestionCollection) {
        this.usersevaluationquestionCollection = usersevaluationquestionCollection;
    }

    public Evaluationtype getEvaluationtypeid() {
        return evaluationtypeid;
    }

    public void setEvaluationtypeid(Evaluationtype evaluationtypeid) {
        this.evaluationtypeid = evaluationtypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationid != null ? evaluationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaluationid == null && other.evaluationid != null) || (this.evaluationid != null && !this.evaluationid.equals(other.evaluationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Evaluation[ evaluationid=" + evaluationid + " ]";
    }
    
}
