/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amine
 */
@Entity
@Table(name = "MSG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Msg.findAll", query = "SELECT m FROM Msg m"),
    @NamedQuery(name = "Msg.findBySenderid", query = "SELECT m FROM Msg m WHERE m.msgPK.senderid = :senderid"),
    @NamedQuery(name = "Msg.findByReceiverid", query = "SELECT m FROM Msg m WHERE m.msgPK.receiverid = :receiverid"),
    @NamedQuery(name = "Msg.findByNum", query = "SELECT m FROM Msg m WHERE m.msgPK.num = :num"),
    @NamedQuery(name = "Msg.findByContent", query = "SELECT m FROM Msg m WHERE m.content = :content"),
    @NamedQuery(name = "Msg.findBySenddate", query = "SELECT m FROM Msg m WHERE m.senddate = :senddate")})
public class Msg implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MsgPK msgPK;
    @Size(max = 200)
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "SENDDATE")
    @Temporal(TemporalType.DATE)
    private Date senddate;
    @JoinColumn(name = "RECEIVERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profile profile;
    @JoinColumn(name = "SENDERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profile profile1;

    public Msg() {
    }

    public Msg(MsgPK msgPK) {
        this.msgPK = msgPK;
    }

    public Msg(String senderid, String receiverid, int num) {
        this.msgPK = new MsgPK(senderid, receiverid, num);
    }

    public MsgPK getMsgPK() {
        return msgPK;
    }

    public void setMsgPK(MsgPK msgPK) {
        this.msgPK = msgPK;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile1() {
        return profile1;
    }

    public void setProfile1(Profile profile1) {
        this.profile1 = profile1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (msgPK != null ? msgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Msg)) {
            return false;
        }
        Msg other = (Msg) object;
        if ((this.msgPK == null && other.msgPK != null) || (this.msgPK != null && !this.msgPK.equals(other.msgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Msg[ msgPK=" + msgPK + " ]";
    }
    
}
