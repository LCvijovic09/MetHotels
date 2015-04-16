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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
@Entity
@Table(name = "soba")
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")})
public class Soba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Soba")
    @Validate("required,maxLength=25,minLength=3")
    private Integer iDSoba;
    @Column(name = "ImeSobe")
    private String imeSobe;
    @Validate("required,maxLength=10,minLength=1")
    @Column(name = "Sprat")
    private String sprat;
    @Validate("required")
    @Column(name = "Internet")
    private Boolean internet;
    @Validate("required")
    @Column(name = "TV")
    private Boolean tv;
    @Column(name = "Djakuzi")
    @Validate("required")
    private Boolean djakuzi;

    @Inject
    public Soba() {
    }

    public Soba(Integer iDSoba) {
        this.iDSoba = iDSoba;
    }

    public Integer getIDSoba() {
        return iDSoba;
    }

    public void setIDSoba(Integer iDSoba) {
        this.iDSoba = iDSoba;
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

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getDjakuzi() {
        return djakuzi;
    }

    public void setDjakuzi(Boolean djakuzi) {
        this.djakuzi = djakuzi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSoba != null ? iDSoba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.iDSoba == null && other.iDSoba != null) || (this.iDSoba != null && !this.iDSoba.equals(other.iDSoba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Soba[ iDSoba=" + iDSoba + " ]";
    }
    
}
