/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Korisnik;

/**
 *
 * @author Lazar
 */
public interface KorisnikDao {
    public void dodajKorisnika(Korisnik korisnik);
    public void obrisiKorisnika(Integer id);
    public boolean provjeriMejl(String mejl);
    public Korisnik provjeriKorisnika(String mejl,String lozinka);
    public Korisnik registrujKorisnika(Korisnik korisnik);
    
}
