package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.KorisnikDao;
import com.mycompany.methotels.entities.Korisnik;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class Login {

    @Inject
    private KorisnikDao kDao;
    @Property
    private Korisnik korisnikLogin;
    @SessionState
    private Korisnik logovanKorisnik;
    @Component
    private BeanEditForm form;

    Object onActivate() {
        if (logovanKorisnik.getMejl() != null) {
            return Index.class;
        }
        return null;
    }

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
    
    Object onSuccess(){
        String sifra=getMD5Hash(korisnikLogin.getLozinka());
        Korisnik kor=kDao.provjeriKorisnika(korisnikLogin.getMejl(), sifra);
        if(kor!=null){
            logovanKorisnik=kor;
            return Index.class;
        }else{
            form.recordError("UNijeli ste pogresne parametre");
            return null;
        }
    }
}
