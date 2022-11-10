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
import javax.validation.constraints.Size;

/**
 *
 * @author amine
 */
@Embeddable
public class MsgPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "SENDERID")
    private String senderid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "RECEIVERID")
    private String receiverid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM")
    private int num;

    public MsgPK() {
    }

    public MsgPK(String senderid, String receiverid, int num) {
        this.senderid = senderid;
        this.receiverid = receiverid;
        this.num = num;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (senderid != null ? senderid.hashCode() : 0);
        hash += (receiverid != null ? receiverid.hashCode() : 0);
        hash += (int) num;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MsgPK)) {
            return false;
        }
        MsgPK other = (MsgPK) object;
        if ((this.senderid == null && other.senderid != null) || (this.senderid != null && !this.senderid.equals(other.senderid))) {
            return false;
        }
        if ((this.receiverid == null && other.receiverid != null) || (this.receiverid != null && !this.receiverid.equals(other.receiverid))) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MsgPK[ senderid=" + senderid + ", receiverid=" + receiverid + ", num=" + num + " ]";
    }
    
}
