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
public class UsersevaluationquestionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVALUATIONID")
    private int evaluationid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTIONID")
    private int questionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERSID")
    private int usersid;

    public UsersevaluationquestionPK() {
    }

    public UsersevaluationquestionPK(int evaluationid, int questionid, int usersid) {
        this.evaluationid = evaluationid;
        this.questionid = questionid;
        this.usersid = usersid;
    }

    public int getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(int evaluationid) {
        this.evaluationid = evaluationid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getUsersid() {
        return usersid;
    }

    public void setUsersid(int usersid) {
        this.usersid = usersid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) evaluationid;
        hash += (int) questionid;
        hash += (int) usersid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersevaluationquestionPK)) {
            return false;
        }
        UsersevaluationquestionPK other = (UsersevaluationquestionPK) object;
        if (this.evaluationid != other.evaluationid) {
            return false;
        }
        if (this.questionid != other.questionid) {
            return false;
        }
        if (this.usersid != other.usersid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UsersevaluationquestionPK[ evaluationid=" + evaluationid + ", questionid=" + questionid + ", usersid=" + usersid + " ]";
    }
    
}
