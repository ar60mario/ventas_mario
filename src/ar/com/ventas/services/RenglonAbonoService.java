/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RenglonAbonoBO;
import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.RenglonAbono;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RenglonAbonoService {
    public List<RenglonAbono> getAllRenglonAbonos() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RenglonAbono> abonos = null;
        try {
            abonos = new RenglonAbonoBO().getAllRenglonAbonos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return abonos;
    }
    
    public void saveRenglonAbono(RenglonAbono abono) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RenglonAbonoBO().saveRenglonAbono(abono);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<RenglonAbono> getRenglonAbonosByAbono(Abono abono) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RenglonAbono> renglones = null;
        try {
            renglones = new RenglonAbonoBO().getRenglonAbonosByAbono(abono);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public void deleteRenglonAbono(RenglonAbono abono) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RenglonAbonoBO().deleteRenglonAbono(abono);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
}
