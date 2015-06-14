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
import javax.persistence.ManyToMany;
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
@Table(name = "QUESTION")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQuestionid", query = "SELECT q FROM Question q WHERE q.questionid = :questionid"),
    @NamedQuery(name = "Question.findByEnunciation", query = "SELECT q FROM Question q WHERE q.enunciation = :enunciation"),
    @NamedQuery(name = "Question.findByAnswera", query = "SELECT q FROM Question q WHERE q.answera = :answera"),
    @NamedQuery(name = "Question.findByAnswerb", query = "SELECT q FROM Question q WHERE q.answerb = :answerb"),
    @NamedQuery(name = "Question.findByAnswerc", query = "SELECT q FROM Question q WHERE q.answerc = :answerc"),
    @NamedQuery(name = "Question.findByAnswerd", query = "SELECT q FROM Question q WHERE q.answerd = :answerd"),
    @NamedQuery(name = "Question.findByAnswere", query = "SELECT q FROM Question q WHERE q.answere = :answere"),
    @NamedQuery(name = "Question.findByCorrectanswer", query = "SELECT q FROM Question q WHERE q.correctanswer = :correctanswer")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTIONID")
    private Integer questionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ENUNCIATION")
    private String enunciation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ANSWERA")
    private String answera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ANSWERB")
    private String answerb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ANSWERC")
    private String answerc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ANSWERD")
    private String answerd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ANSWERE")
    private String answere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRECTANSWER")
    private Character correctanswer;
    @ManyToMany(mappedBy = "questionCollection")
    private Collection<Evaluation> evaluationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<Category> categoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<Commentary> commentaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<Usersevaluationquestion> usersevaluationquestionCollection;

    public Question() {
    }

    public Question(Integer questionid) {
        this.questionid = questionid;
    }

    public Question(Integer questionid, String enunciation, String answera, String answerb, String answerc, String answerd, String answere, Character correctanswer) {
        this.questionid = questionid;
        this.enunciation = enunciation;
        this.answera = answera;
        this.answerb = answerb;
        this.answerc = answerc;
        this.answerd = answerd;
        this.answere = answere;
        this.correctanswer = correctanswer;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getEnunciation() {
        return enunciation;
    }

    public void setEnunciation(String enunciation) {
        this.enunciation = enunciation;
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera;
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb;
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc;
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd;
    }

    public String getAnswere() {
        return answere;
    }

    public void setAnswere(String answere) {
        this.answere = answere;
    }

    public Character getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(Character correctanswer) {
        this.correctanswer = correctanswer;
    }

    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Collection<Commentary> getCommentaryCollection() {
        return commentaryCollection;
    }

    public void setCommentaryCollection(Collection<Commentary> commentaryCollection) {
        this.commentaryCollection = commentaryCollection;
    }

    public Collection<Usersevaluationquestion> getUsersevaluationquestionCollection() {
        return usersevaluationquestionCollection;
    }

    public void setUsersevaluationquestionCollection(Collection<Usersevaluationquestion> usersevaluationquestionCollection) {
        this.usersevaluationquestionCollection = usersevaluationquestionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionid != null ? questionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionid == null && other.questionid != null) || (this.questionid != null && !this.questionid.equals(other.questionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Question[ questionid=" + questionid + " ]";
    }
    
}
