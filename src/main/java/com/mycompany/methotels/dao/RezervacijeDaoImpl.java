/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lazar
 */
public class RezervacijeDaoImpl implements RezervacijeDao{
    @Inject
    private Session session;

    @Override
    public void razduzi(Rezervacija rez) {
    
    session.delete(rez);
    }

    @Override
    public List<Rezervacija> getListaSvihRezervacija() {
    return (ArrayList<Rezervacija>) session.createCriteria(Rezervacija.class).list();
    }

    @Override
    public void dodajSoba(Integer id) {
         Soba s=(Soba) session.createCriteria(Soba.class).add(Restrictions.eq("iDSoba", id)).uniqueResult();
    session.persist(s);
    }

    @Override
    public void dodajSobu(Soba s) {
    session.merge(s);
    }
    
}
