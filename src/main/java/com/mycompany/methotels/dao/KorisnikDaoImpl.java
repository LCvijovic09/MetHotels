/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Korisnik;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lazar
 */
public class KorisnikDaoImpl implements KorisnikDao{
    @Inject
    private Session session;

    @Override
    public void dodajKorisnika(Korisnik korisnik) {
    session.persist(korisnik);
    }

    @Override
    public void obrisiKorisnika(Integer id) {
    Korisnik kor=(Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("iDKorisnik", id)).uniqueResult();
    session.delete(kor);
    }

    @Override
    public boolean provjeriMejl(String mejl) {
    Long redovi=(Long) session.createCriteria(Korisnik.class).add(Restrictions.eq("mejl", mejl)).setProjection(Projections.rowCount()).uniqueResult();
    return (redovi==0) ? false : true;

    }

    @Override
    public Korisnik provjeriKorisnika(String mejl, String lozinka) {
        try {
            Korisnik korisnik=(Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("mejl", mejl)).add(Restrictions.eq("lozinka", lozinka)).uniqueResult();
            if(korisnik!=null){
                return korisnik;
            } 
                return null;
            
            
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Korisnik registrujKorisnika(Korisnik korisnik) {
     return (Korisnik)session.merge(korisnik);    
    }
    
    
}
