/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.GradDrzavaDao;
import com.mycompany.methotels.entities.Drzava;
import com.mycompany.methotels.entities.Grad;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
public class DodavanjeGradova {
    @Property
    private Grad grad;
    @Property
    private Grad onegrad;
    @Inject
    private GradDrzavaDao gdDao;
    @Inject
    private Messages messages;
    @Property
    private Drzava iDDrzava;
    @Property
    @Persist
    private List<Drzava> drzave;
    public ValueEncoder getEncoder(){
       return new ValueEncoder<Drzava>() {

            @Override
            public String toClient(Drzava v) {
            return String.valueOf(v.getIDDrzava());
            }

            @Override
            public Drzava toValue(String string) {
            Drzava drz=gdDao.getDrzavaById(Integer.parseInt(string));
                return drz;
            }
        };
       
    }
    
    @Property
    private List<Grad> gradovi;
    void onActivate(){
        grad=new Grad();
        if(gradovi==null){
            gradovi=new ArrayList<Grad>();
        }
        gradovi=gdDao.getListaSvihGradova();
        drzave=gdDao.getListaSvihDrzava();
    }
    
    @CommitAfter
    Object onSuccess(){
        grad.setIDDrzava(iDDrzava);
        gdDao.doadjGrad(grad);
        return this;
    }
     public String getDrzava(){
        if(onegrad.getIDDrzava()!=null){
            return onegrad.getIDDrzava().getNaziv();
        }else{
            return "";
        }
    }
    
    @CommitAfter
    Object onActionFromDelete(int id){
        gdDao.obrisiGrad(id);
        return this;
    }
    
   
    
    
    
}
