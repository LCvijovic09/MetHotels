/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Drzava;
import com.mycompany.methotels.entities.Grad;
import java.util.List;

/**
 *
 * @author Lazar
 */
public interface GradDrzavaDao {
    
    public List<Drzava> getListaSvihDrzava();
    public List<Grad> getListaSvihGradova();
    
    public Grad getGradById(Integer id);
    public Drzava getDrzavaById(Integer id);
    
    public void dodajDrzavu(Drzava drzava);
    public void doadjGrad(Grad grad);
    
    public void obrisiGrad(Integer id);
    public void obrisiDrzavu(Integer id);
    
}
