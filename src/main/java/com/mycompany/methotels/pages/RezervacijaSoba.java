/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lazar
 */
public class RezervacijaSoba {
    @Property
    private Soba onesoba;
    @Property
    private Soba soba;
    @Inject
    private Session session;
    @Property
    private List<Soba> sobe;
    
    void onActivate(){
        if(sobe==null){
            sobe=new ArrayList<Soba>();
        }
        sobe=(ArrayList<Soba>)session.createCriteria(Soba.class).list();
        
    }
    
    Object onSuccess(){
        
        return this;
    }
    
    
}
