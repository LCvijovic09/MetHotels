/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.data;

import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
public class Soba {
    private String imeSobe,sprat;
    private Boolean internet,tv,djakuzi;

    
    @Inject
    public Soba() {
    }

    public Soba(String imeSobe, String sprat, Boolean internet, Boolean tv, Boolean djakuzi) {
        this.imeSobe = imeSobe;
        this.sprat = sprat;
        this.internet = internet;
        this.tv = tv;
        this.djakuzi = djakuzi;
    }

    public String getImeSobe() {
        return imeSobe;
    }

    public String getSprat() {
        return sprat;
    }

    public Boolean getInternet() {
        return internet;
    }

    public Boolean getTv() {
        return tv;
    }

    public Boolean getDjakuzi() {
        return djakuzi;
    }

    public void setImeSobe(String imeSobe) {
        this.imeSobe = imeSobe;
    }

    public void setSprat(String sprat) {
        this.sprat = sprat;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public void setDjakuzi(Boolean djakuzi) {
        this.djakuzi = djakuzi;
    }
    
    
    
    
}
