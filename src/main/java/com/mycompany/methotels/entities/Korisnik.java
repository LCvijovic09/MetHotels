/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import com.mycompany.methotels.data.Role;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "korisnik")
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")})
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Korisnik")
    private Integer iDKorisnik;
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "Prezime")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String adresa;
    @Basic(optional = false)
    @Column(name = "Mejl")
    private String mejl;
    @Basic(optional = false)
    @Column(name = "Lozinka")
    private String lozinka;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "Rola")
    private Role rola;

    @Inject
    public Korisnik() {
    }

    public Korisnik(Integer iDKorisnik) {
        this.iDKorisnik = iDKorisnik;
    }

    public Korisnik(Integer iDKorisnik, String ime, String prezime, String adresa, String mejl, String lozinka, Role rola) {
        this.iDKorisnik = iDKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.mejl = mejl;
        this.lozinka = lozinka;
        this.rola = rola;
    }

    public Integer getIDKorisnik() {
        return iDKorisnik;
    }

    public void setIDKorisnik(Integer iDKorisnik) {
        this.iDKorisnik = iDKorisnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Role getRola() {
        return rola;
    }

    public void setRola(Role rola) {
        this.rola = rola;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDKorisnik != null ? iDKorisnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.iDKorisnik == null && other.iDKorisnik != null) || (this.iDKorisnik != null && !this.iDKorisnik.equals(other.iDKorisnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Korisnik[ iDKorisnik=" + iDKorisnik + " ]";
    }
    
}
