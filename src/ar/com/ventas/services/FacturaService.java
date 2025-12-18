/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.FacturaBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Factura;
import ar.com.ventas.utils.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class FacturaService {
    public List<Factura> getAllFacturas() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Factura> facturas = null;
        try {
            facturas = new FacturaBO().getAllFacturas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public Factura saveFactura(Factura factura) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            factura = new FacturaBO().saveFactura(factura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
    public Factura getFacturasByNro(Integer numero, Integer tipoDoc) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Factura factura;
        try {
            factura = new FacturaBO().getFacturasByNro(numero, tipoDoc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
    public List<Factura> getFacturasEntreFechas(Date fd, Date fa) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Factura> facturas = null;
        try {
            facturas = new FacturaBO().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<Factura> getFacturasPorCliente(Cliente cliente) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Factura> facturas = null;
        try {
            facturas = new FacturaBO().getFacturasPorCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
}
