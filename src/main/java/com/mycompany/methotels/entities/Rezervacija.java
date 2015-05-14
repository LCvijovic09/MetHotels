/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")})
public class Rezervacija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Sobe")
    private Integer iDSobe;
    @Basic(optional = false)
    @Column(name = "ImeSobe")
    private String imeSobe;
    @Basic(optional = false)
    @Column(name = "Sprat")
    private String sprat;
    @Basic(optional = false)
    @Column(name = "Internet")
    private boolean internet;
    @Basic(optional = false)
    @Column(name = "TV")
    private boolean tv;
    @Basic(optional = false)
    @Column(name = "Djakuzi")
    private boolean djakuzi;

    @Inject
    public Rezervacija() {
    }

    public Rezervacija(Integer iDSobe) {
        this.iDSobe = iDSobe;
    }

    public Rezervacija(Integer iDSobe, String imeSobe, String sprat, boolean internet, boolean tv, boolean djakuzi) {
        this.iDSobe = iDSobe;
        this.imeSobe = imeSobe;
        this.sprat = sprat;
        this.internet = internet;
        this.tv = tv;
        this.djakuzi = djakuzi;
    }

    public Integer getIDSobe() {
        return iDSobe;
    }

    public void setIDSobe(Integer iDSobe) {
        this.iDSobe = iDSobe;
    }

    public String getImeSobe() {
        return imeSobe;
    }

    public void setImeSobe(String imeSobe) {
        this.imeSobe = imeSobe;
    }

    public String getSprat() {
        return sprat;
    }

    public void setSprat(String sprat) {
        this.sprat = sprat;
    }

    public boolean getInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean getTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean getDjakuzi() {
        return djakuzi;
    }

    public void setDjakuzi(boolean djakuzi) {
        this.djakuzi = djakuzi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSobe != null ? iDSobe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.iDSobe == null && other.iDSobe != null) || (this.iDSobe != null && !this.iDSobe.equals(other.iDSobe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Rezervacija[ iDSobe=" + iDSobe + " ]";
    }
    
}
