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
public class CategoryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORYID")
    private int categoryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTIONID")
    private int questionid;

    public CategoryPK() {
    }

    public CategoryPK(int categoryid, int questionid) {
        this.categoryid = categoryid;
        this.questionid = questionid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) categoryid;
        hash += (int) questionid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryPK)) {
            return false;
        }
        CategoryPK other = (CategoryPK) object;
        if (this.categoryid != other.categoryid) {
            return false;
        }
        if (this.questionid != other.questionid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CategoryPK[ categoryid=" + categoryid + ", questionid=" + questionid + " ]";
    }
    
}
