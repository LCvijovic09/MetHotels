/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lazar
 */
@ProtectedPage
@RolesAllowed(value = {"Admin"})
public class DodavanjeSoba {

    @Property
    private Soba soba;
    @Inject
    private Session session;
    @Property
    private ArrayList<Soba> sobe;
    @Property
    private Soba onesoba;

    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
// createCriteria metoda pravi Select * upit nad prosleðenom klasom
        sobe = (ArrayList<Soba>) session.createCriteria(Soba.class).list();
    }

    @CommitAfter
    Object onSuccess() {
        // persist metoda èuva objekatu bazi podataka
        session.persist(soba);
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(Soba s) {
        Rezervacija rez = new Rezervacija();
        rez.setDjakuzi(s.getDjakuzi());
        rez.setImeSobe(s.getImeSobe());
        rez.setIDSobe(s.getIDSoba());
        rez.setInternet(s.getInternet());
        rez.setTv(s.getTv());
        rez.setSprat(s.getSprat());
       
        session.merge(rez);
        session.delete(s);
        return this;
    }

}
