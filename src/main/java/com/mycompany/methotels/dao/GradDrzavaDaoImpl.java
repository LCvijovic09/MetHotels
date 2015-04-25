/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Drzava;
import com.mycompany.methotels.entities.Grad;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lazar
 */
public class GradDrzavaDaoImpl implements GradDrzavaDao{

    @Inject
    private Session session;
    @Override
    public List<Drzava> getListaSvihDrzava() {
 return session.createCriteria(Drzava.class).list();
 }

    @Override
    public List<Grad> getListaSvihGradova() {
    return session.createCriteria(Grad.class).list();
    }

    @Override
    public Grad getGradById(Integer id) {
    return (Grad) session.createCriteria(Grad.class).add(Restrictions.eq("iDGrad", id)).uniqueResult();
    }

    @Override
    public Drzava getDrzavaById(Integer id) {
    return (Drzava) session.createCriteria(Drzava.class).add(Restrictions.eq("iDDrzava", id)).uniqueResult();
    }

    @Override
    public void dodajDrzavu(Drzava drzava) {
    session.persist(drzava);
    }

    @Override
    public void doadjGrad(Grad grad) {
    session.persist(grad);
    }

    @Override
    public void obrisiGrad(Integer id) {
    Grad grad=(Grad) session.createCriteria(Grad.class).add(Restrictions.eq("iDGrad", id)).uniqueResult();
    session.delete(grad);
    
    }

    @Override
    public void obrisiDrzavu(Integer id) {
    Drzava drzava=(Drzava) session.createCriteria(Drzava.class).add(Restrictions.eq("iDDrzava", id)).uniqueResult();
    session.delete(drzava);
    }
    
}
