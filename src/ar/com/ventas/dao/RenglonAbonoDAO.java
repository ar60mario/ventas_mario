/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.RenglonAbono;
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
public class RenglonAbonoDAO  extends GenericDAO {
    public List<RenglonAbono> getAllRenglonAbonos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonAbono.class);
//        criteria.add(Restrictions.eq("inactivo",false));
        criteria.addOrder(Order.asc("detalle"));
        List<RenglonAbono> abono = (List<RenglonAbono>) criteria.list();
        return abono;
    }
    
    public List<RenglonAbono> getRenglonAbonosByAbono(Abono abono) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonAbono.class);
        criteria.add(Restrictions.eq("abono",abono));
        criteria.addOrder(Order.asc("orden"));
        List<RenglonAbono> renglones = (List<RenglonAbono>) criteria.list();
        return renglones;
    }
}
