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
@Table(name = "USERSTYPE")
@NamedQueries({
    @NamedQuery(name = "Userstype.findAll", query = "SELECT u FROM Userstype u"),
    @NamedQuery(name = "Userstype.findByUserstypeid", query = "SELECT u FROM Userstype u WHERE u.userstypeid = :userstypeid"),
    @NamedQuery(name = "Userstype.findByDescription", query = "SELECT u FROM Userstype u WHERE u.description = :description")})
public class Userstype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERSTYPEID")
    private Integer userstypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userstypeid")
    private Collection<Users> usersCollection;

    public Userstype() {
    }

    public Userstype(Integer userstypeid) {
        this.userstypeid = userstypeid;
    }

    public Userstype(Integer userstypeid, String description) {
        this.userstypeid = userstypeid;
        this.description = description;
    }

    public Integer getUserstypeid() {
        return userstypeid;
    }

    public void setUserstypeid(Integer userstypeid) {
        this.userstypeid = userstypeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userstypeid != null ? userstypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userstype)) {
            return false;
        }
        Userstype other = (Userstype) object;
        if ((this.userstypeid == null && other.userstypeid != null) || (this.userstypeid != null && !this.userstypeid.equals(other.userstypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userstype[ userstypeid=" + userstypeid + " ]";
    }
    
}
