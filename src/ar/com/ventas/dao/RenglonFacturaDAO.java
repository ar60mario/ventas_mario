/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Factura;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class RenglonFacturaDAO  extends GenericDAO {
    public List<RenglonFactura> getAllRenglonFacturas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
//        criteria.add(Restrictions.eq("inactivo",false));
        criteria.addOrder(Order.asc("id"));
        List<RenglonFactura> factura = (List<RenglonFactura>) criteria.list();
        return factura;
    }
    
    public List<RenglonFactura> getRenglonFacturasByFactura(Factura factura) {
        System.out.println(factura);
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
        criteria.add(Restrictions.eq("factura",factura));
        criteria.addOrder(Order.asc("orden"));
        List<RenglonFactura> renglones = (List<RenglonFactura>) criteria.list();
        return renglones;
    }
}
