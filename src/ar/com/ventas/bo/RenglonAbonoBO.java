/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RenglonAbonoDAO;
import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.RenglonAbono;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonAbonoBO {
    RenglonAbonoDAO dao = new RenglonAbonoDAO();
    public List<RenglonAbono> getAllRenglonAbonos() throws Exception{
        try {
            return dao.getAllRenglonAbonos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void saveRenglonAbono(RenglonAbono abono) throws Exception {
        try {
            dao.save(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<RenglonAbono> getRenglonAbonosByAbono(Abono abono) throws Exception{
        try {
            return dao.getRenglonAbonosByAbono(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void deleteRenglonAbono(RenglonAbono abono) throws Exception {
        try {
            dao.delete(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
}
