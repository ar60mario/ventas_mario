/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RenglonFacturaBO;
import ar.com.ventas.entities.Factura;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RenglonFacturaService {
    public List<RenglonFactura> getAllRenglonFacturas() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RenglonFactura> facturas = null;
        try {
            facturas = new RenglonFacturaBO().getAllRenglonFacturas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public void saveRenglonFactura(RenglonFactura factura) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RenglonFacturaBO().saveRenglonFactura(factura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<RenglonFactura> getRenglonFacturasByFactura(Factura factura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RenglonFactura> renglones = null;
        try {
            renglones = new RenglonFacturaBO().getRenglonFacturasByFactura(factura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public void deleteRenglonFactura(RenglonFactura factura) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RenglonFacturaBO().deleteRenglonFactura(factura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
}
