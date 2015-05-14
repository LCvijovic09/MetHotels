/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.KorisnikDao;
import com.mycompany.methotels.data.Role;
import com.mycompany.methotels.entities.Korisnik;
import com.mycompany.methotels.services.ProtectedPage;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})
public class RegistrujKorisnika {

    @Property
    private Korisnik korisnikReg;
    @Inject
    private KorisnikDao kDao;
    @SessionState
    private Korisnik logovanKorisnik;
    @Component
    private BeanEditForm form;

    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    
    @CommitAfter
    Object onSuccess(){
        if(!kDao.provjeriMejl(korisnikReg.getMejl())){
        String unhashPass=korisnikReg.getLozinka();
        korisnikReg.setLozinka(getMD5Hash(unhashPass));
        korisnikReg.setRola(Role.Korisnik);
        Korisnik kor=kDao.registrujKorisnika(korisnikReg);
      //  logovanKorisnik=kor;
        return this;
        }else{
            form.recordError("Unijeti E-Mail vec postoji");
            return null;    
        }
    }

}
