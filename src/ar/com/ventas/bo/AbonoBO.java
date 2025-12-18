/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.AbonoDAO;
import ar.com.ventas.entities.Abono;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class AbonoBO {
    AbonoDAO dao = new AbonoDAO();
    public List<Abono> getAllAbonos() throws Exception{
        try {
            return dao.getAllAbonos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<Abono> getAllAbonosActivos() throws Exception{
        try {
            return dao.getAllAbonosActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void saveAbono(Abono abono) throws Exception {
        try {
            dao.save(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void updateAbono(Abono abono) throws Exception {
        try {
            dao.update(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
}
