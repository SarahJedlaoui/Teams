package entity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name = "TEAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findByCode", query = "SELECT t FROM Team t WHERE t.code = :code"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name"),
    @NamedQuery(name = "Team.findByIsprivate", query = "SELECT t FROM Team t WHERE t.isprivate = :isprivate"),
    @NamedQuery(name = "Team.findByImage", query = "SELECT t FROM Team t WHERE t.image = :image")})
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ISPRIVATE")
    private Boolean isprivate;
    @Size(max = 100)
    @Column(name = "IMAGE")
    private String image;
    @JoinTable(name = "TEAMMEMBER", joinColumns = {
        @JoinColumn(name = "TEAM", referencedColumnName = "CODE")}, inverseJoinColumns = {
        @JoinColumn(name = "PROFILE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Profile> profileCollection;
    @JoinColumn(name = "ADMINID", referencedColumnName = "ID")
    @ManyToOne
    private Profile adminid;

    public Team() {
    }

    public Team(String code) {
        this.code = code;
    }

    public Team(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(Boolean isprivate) {
        this.isprivate = isprivate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    public Profile getAdminid() {
        return adminid;
    }

    public void setAdminid(Profile adminid) {
        this.adminid = adminid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Team[ code=" + code + " ]";
    }
    
}
