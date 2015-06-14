/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author williamPM
 */
@Embeddable
public class CommentaryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTIONID")
    private int questionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMENTARYID")
    private int commentaryid;

    public CommentaryPK() {
    }

    public CommentaryPK(int questionid, int commentaryid) {
        this.questionid = questionid;
        this.commentaryid = commentaryid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getCommentaryid() {
        return commentaryid;
    }

    public void setCommentaryid(int commentaryid) {
        this.commentaryid = commentaryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) questionid;
        hash += (int) commentaryid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentaryPK)) {
            return false;
        }
        CommentaryPK other = (CommentaryPK) object;
        if (this.questionid != other.questionid) {
            return false;
        }
        if (this.commentaryid != other.commentaryid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CommentaryPK[ questionid=" + questionid + ", commentaryid=" + commentaryid + " ]";
    }
    
}
