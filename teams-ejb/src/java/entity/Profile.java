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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amine
 */
@Entity
@Table(name = "PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findById", query = "SELECT p FROM Profile p WHERE p.id = :id"),
    @NamedQuery(name = "Profile.findByFname", query = "SELECT p FROM Profile p WHERE p.fname = :fname"),
    @NamedQuery(name = "Profile.findByLname", query = "SELECT p FROM Profile p WHERE p.lname = :lname"),
    @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email"),
    @NamedQuery(name = "Profile.findByPassword", query = "SELECT p FROM Profile p WHERE p.password = :password"),
    @NamedQuery(name = "Profile.findByImage", query = "SELECT p FROM Profile p WHERE p.image = :image")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LNAME")
    private String lname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 100)
    @Column(name = "IMAGE")
    private String image;
    @ManyToMany(mappedBy = "profileCollection")
    private Collection<Team> teamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
    private Collection<Msg> msgCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile1")
    private Collection<Msg> msgCollection1;
    @OneToMany(mappedBy = "adminid")
    private Collection<Team> teamCollection1;

    public Profile() {
    }

    public Profile(String id) {
        this.id = id;
    }

    public Profile(String id, String fname, String lname, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    @XmlTransient
    public Collection<Msg> getMsgCollection() {
        return msgCollection;
    }

    public void setMsgCollection(Collection<Msg> msgCollection) {
        this.msgCollection = msgCollection;
    }

    @XmlTransient
    public Collection<Msg> getMsgCollection1() {
        return msgCollection1;
    }

    public void setMsgCollection1(Collection<Msg> msgCollection1) {
        this.msgCollection1 = msgCollection1;
    }

    @XmlTransient
    public Collection<Team> getTeamCollection1() {
        return teamCollection1;
    }

    public void setTeamCollection1(Collection<Team> teamCollection1) {
        this.teamCollection1 = teamCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Profile[ id=" + id + " ]";
    }
    
}
