/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Factura;
import ar.com.ventas.utils.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class FacturaDAO extends GenericDAO {

    public List<Factura> getAllFacturas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Factura.class);
//        criteria.add(Restrictions.eq("inactivo",false));
        criteria.addOrder(Order.asc("detalle"));
        List<Factura> factura = (List<Factura>) criteria.list();
        return factura;
    }

    public List<Factura> getFacturasEntreFechas(Date fd, Date fa) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<Factura> facturas;
        facturas = (List<Factura>) session.createCriteria(Factura.class)
                .add(Restrictions.between("fecha", fd, fa))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("numero"))
                .list();
        return facturas;
    }
    
    public List<Factura> getFacturasPorCliente(Cliente cliente) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<Factura> facturas;
        facturas = (List<Factura>) session.createCriteria(Factura.class)
                .add(Restrictions.eq("cliente", cliente))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("numero"))
                .list();
        return facturas;
    }

    public Factura getFacturasByNro(Integer numero, Integer tipoDoc) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Factura factura = null;
        int ntd = 11;
        if(tipoDoc == 2){
            ntd = 13;
        }
        factura = (Factura) session.createCriteria(Factura.class)
                .add(Restrictions.eq("numero", numero))
                .add(Restrictions.eq("tipoDoc", ntd))
                //.addOrder(Order.asc("numero"))
                .uniqueResult();
        System.out.println(factura);
        return factura;
    }
    
    
    /*
    List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) 
                session.createCriteria(IvaVentas.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("cliente", cod))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
     */
}
