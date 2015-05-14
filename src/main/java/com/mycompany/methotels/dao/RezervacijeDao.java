/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author Lazar
 */
public interface RezervacijeDao {
   public void razduzi(Rezervacija rez);
   public List<Rezervacija> getListaSvihRezervacija();
   public void dodajSoba(Integer id);
   public void dodajSobu(Soba s);
    
    
    
}
