/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
@Entity
@Table(name = "drzava")
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d")})
public class Drzava extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Naziv")
    private String naziv;
    @Column(name = "NazivHotela")
    private String nazivHotela;
    @OneToMany(mappedBy = "iDDrzava")
    private List<Grad> gradList;

    @Inject
    public Drzava() {
    }

    public Drzava(Integer iDDrzava) {
        this.iDDrzava = iDDrzava;
    }

    public Integer getIDDrzava() {
        return iDDrzava;
    }

    public void setIDDrzava(Integer iDDrzava) {
        this.iDDrzava = iDDrzava;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNazivHotela() {
        return nazivHotela;
    }

    public void setNazivHotela(String nazivHotela) {
        this.nazivHotela = nazivHotela;
    }

    public List<Grad> getGradList() {
        return gradList;
    }

    public void setGradList(List<Grad> gradList) {
        this.gradList = gradList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDrzava != null ? iDDrzava.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.iDDrzava == null && other.iDDrzava != null) || (this.iDDrzava != null && !this.iDDrzava.equals(other.iDDrzava))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Drzava[ iDDrzava=" + iDDrzava + " ]";
    }
    
}
