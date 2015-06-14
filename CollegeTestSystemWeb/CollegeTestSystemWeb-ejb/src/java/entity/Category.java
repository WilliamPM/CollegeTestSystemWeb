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
import javax.validation.constraints.Size;

/**
 *
 * @author williamPM
 */
@Entity
@Table(name = "CATEGORY")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryid", query = "SELECT c FROM Category c WHERE c.categoryPK.categoryid = :categoryid"),
    @NamedQuery(name = "Category.findByTagdescription", query = "SELECT c FROM Category c WHERE c.tagdescription = :tagdescription"),
    @NamedQuery(name = "Category.findByQuestionid", query = "SELECT c FROM Category c WHERE c.categoryPK.questionid = :questionid")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoryPK categoryPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TAGDESCRIPTION")
    private String tagdescription;
    @JoinColumn(name = "QUESTIONID", referencedColumnName = "QUESTIONID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;

    public Category() {
    }

    public Category(CategoryPK categoryPK) {
        this.categoryPK = categoryPK;
    }

    public Category(CategoryPK categoryPK, String tagdescription) {
        this.categoryPK = categoryPK;
        this.tagdescription = tagdescription;
    }

    public Category(int categoryid, int questionid) {
        this.categoryPK = new CategoryPK(categoryid, questionid);
    }

    public CategoryPK getCategoryPK() {
        return categoryPK;
    }

    public void setCategoryPK(CategoryPK categoryPK) {
        this.categoryPK = categoryPK;
    }

    public String getTagdescription() {
        return tagdescription;
    }

    public void setTagdescription(String tagdescription) {
        this.tagdescription = tagdescription;
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
        hash += (categoryPK != null ? categoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryPK == null && other.categoryPK != null) || (this.categoryPK != null && !this.categoryPK.equals(other.categoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ categoryPK=" + categoryPK + " ]";
    }
    
}
