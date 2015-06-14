/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author williamPM
 */
@Entity
@Table(name = "USERSEVALUATIONQUESTION")
@NamedQueries({
    @NamedQuery(name = "Usersevaluationquestion.findAll", query = "SELECT u FROM Usersevaluationquestion u"),
    @NamedQuery(name = "Usersevaluationquestion.findByEvaluationid", query = "SELECT u FROM Usersevaluationquestion u WHERE u.usersevaluationquestionPK.evaluationid = :evaluationid"),
    @NamedQuery(name = "Usersevaluationquestion.findByQuestionid", query = "SELECT u FROM Usersevaluationquestion u WHERE u.usersevaluationquestionPK.questionid = :questionid"),
    @NamedQuery(name = "Usersevaluationquestion.findByUsersid", query = "SELECT u FROM Usersevaluationquestion u WHERE u.usersevaluationquestionPK.usersid = :usersid"),
    @NamedQuery(name = "Usersevaluationquestion.findByAnswer", query = "SELECT u FROM Usersevaluationquestion u WHERE u.answer = :answer")})
public class Usersevaluationquestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersevaluationquestionPK usersevaluationquestionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANSWER")
    private Character answer;
    @JoinColumn(name = "USERSID", referencedColumnName = "USERSID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "QUESTIONID", referencedColumnName = "QUESTIONID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;
    @JoinColumn(name = "EVALUATIONID", referencedColumnName = "EVALUATIONID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evaluation evaluation;

    public Usersevaluationquestion() {
    }

    public Usersevaluationquestion(UsersevaluationquestionPK usersevaluationquestionPK) {
        this.usersevaluationquestionPK = usersevaluationquestionPK;
    }

    public Usersevaluationquestion(UsersevaluationquestionPK usersevaluationquestionPK, Character answer) {
        this.usersevaluationquestionPK = usersevaluationquestionPK;
        this.answer = answer;
    }

    public Usersevaluationquestion(int evaluationid, int questionid, int usersid) {
        this.usersevaluationquestionPK = new UsersevaluationquestionPK(evaluationid, questionid, usersid);
    }

    public UsersevaluationquestionPK getUsersevaluationquestionPK() {
        return usersevaluationquestionPK;
    }

    public void setUsersevaluationquestionPK(UsersevaluationquestionPK usersevaluationquestionPK) {
        this.usersevaluationquestionPK = usersevaluationquestionPK;
    }

    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersevaluationquestionPK != null ? usersevaluationquestionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usersevaluationquestion)) {
            return false;
        }
        Usersevaluationquestion other = (Usersevaluationquestion) object;
        if ((this.usersevaluationquestionPK == null && other.usersevaluationquestionPK != null) || (this.usersevaluationquestionPK != null && !this.usersevaluationquestionPK.equals(other.usersevaluationquestionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usersevaluationquestion[ usersevaluationquestionPK=" + usersevaluationquestionPK + " ]";
    }
    
}
