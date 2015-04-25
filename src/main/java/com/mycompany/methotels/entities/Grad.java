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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
@Entity
@Table(name = "grad")
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g")})
public class Grad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Grad")
    private Integer iDGrad;
    @Column(name = "Naziv")
    private String naziv;
    @JoinColumn(name = "ID_Drzava", referencedColumnName = "ID_Drzava")
    @ManyToOne
    private Drzava iDDrzava;

    @Inject
    public Grad() {
    }

    public Grad(Integer iDGrad) {
        this.iDGrad = iDGrad;
    }

    public Integer getIDGrad() {
        return iDGrad;
    }

    public void setIDGrad(Integer iDGrad) {
        this.iDGrad = iDGrad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Drzava getIDDrzava() {
        return iDDrzava;
    }

    public void setIDDrzava(Drzava iDDrzava) {
        this.iDDrzava = iDDrzava;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDGrad != null ? iDGrad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grad)) {
            return false;
        }
        Grad other = (Grad) object;
        if ((this.iDGrad == null && other.iDGrad != null) || (this.iDGrad != null && !this.iDGrad.equals(other.iDGrad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Grad[ iDGrad=" + iDGrad + " ]";
    }
    
}
