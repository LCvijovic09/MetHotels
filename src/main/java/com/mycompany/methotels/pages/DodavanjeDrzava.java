/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.components.GenericEditor;
import com.mycompany.methotels.dao.GenericDaoImpl;
import com.mycompany.methotels.dao.GradDrzavaDao;
import com.mycompany.methotels.entities.Drzava;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Lazar
 */
public class DodavanjeDrzava extends GenericEditor<Drzava>{
/*
    @Property
    private Drzava drzava;
    @Property
    private Drzava onedrzava;
    @Inject
    private GradDrzavaDao gdDao;
    @Property
    private List<Drzava> drzave;

    void onActivate() {
        if (drzave == null) {
            drzave = new ArrayList<Drzava>();

        }
        drzave = gdDao.getListaSvihDrzava();
    }

    @CommitAfter
    Object onSuccess() {
        
        gdDao.dodajDrzavu(drzava);
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        gdDao.obrisiDrzavu(id);
        return this;
    }
*/
}
