/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author williamPM
 */
@Entity
@Table(name = "COMMENTARY")
@NamedQueries({
    @NamedQuery(name = "Commentary.findAll", query = "SELECT c FROM Commentary c"),
    @NamedQuery(name = "Commentary.findByQuestionid", query = "SELECT c FROM Commentary c WHERE c.commentaryPK.questionid = :questionid"),
    @NamedQuery(name = "Commentary.findByCommentaryid", query = "SELECT c FROM Commentary c WHERE c.commentaryPK.commentaryid = :commentaryid"),
    @NamedQuery(name = "Commentary.findByFeedback", query = "SELECT c FROM Commentary c WHERE c.feedback = :feedback")})
public class Commentary implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommentaryPK commentaryPK;
    @Size(max = 500)
    @Column(name = "FEEDBACK")
    private String feedback;
    @JoinColumn(name = "QUESTIONID", referencedColumnName = "QUESTIONID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;

    public Commentary() {
    }

    public Commentary(CommentaryPK commentaryPK) {
        this.commentaryPK = commentaryPK;
    }

    public Commentary(int questionid, int commentaryid) {
        this.commentaryPK = new CommentaryPK(questionid, commentaryid);
    }

    public CommentaryPK getCommentaryPK() {
        return commentaryPK;
    }

    public void setCommentaryPK(CommentaryPK commentaryPK) {
        this.commentaryPK = commentaryPK;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentaryPK != null ? commentaryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentary)) {
            return false;
        }
        Commentary other = (Commentary) object;
        if ((this.commentaryPK == null && other.commentaryPK != null) || (this.commentaryPK != null && !this.commentaryPK.equals(other.commentaryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commentary[ commentaryPK=" + commentaryPK + " ]";
    }
    
}
