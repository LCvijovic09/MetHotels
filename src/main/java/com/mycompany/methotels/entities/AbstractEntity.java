/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Lazar
 */
@MappedSuperclass
public class AbstractEntity implements Serializable, Comparable<AbstractEntity> {
 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Basic(optional = false)
 @Column(name = "ID_Drzava")
 protected Integer iDDrzava;
 public int compareTo(AbstractEntity o) {
 return this.toString().compareTo(o.toString());
 }

    public Integer getiDDrzava() {
        return iDDrzava;
    }

    public void setiDDrzava(Integer iDDrzava) {
        this.iDDrzava = iDDrzava;
    }

    
 
 
}

