/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.RezervacijeDao;
import com.mycompany.methotels.entities.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author Lazar
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})
public class Rezervacije {
    
    @Property
    private Rezervacije rezervacija;
    @Property
    private Rezervacija onerez;
    @Inject
    private RezervacijeDao rDao;
    @Property
    private List<Rezervacija> rezervacije;
   @Inject
    private Session session;
    
    void onActivate(){
        if(rezervacije==null){
            rezervacije=new ArrayList<Rezervacija>();
            
        }
        rezervacije=rDao.getListaSvihRezervacija();
    }
    
    Object onSuccess(){
        
        
        return this;
    }
    
    @CommitAfter
    Object onActionFromDelete(Rezervacija rez){
        Soba s=new Soba();
        s.setIDSoba(rez.getIDSobe());
        s.setImeSobe(rez.getImeSobe());
        s.setSprat(rez.getSprat());
        s.setDjakuzi(rez.getDjakuzi());
        s.setInternet(rez.getInternet());
        s.setTv(rez.getTv());
        
        session.merge(s);
        session.delete(rez);
        
        return this;
    }
    
    
}
