/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Abono;
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
public class AbonoDAO extends GenericDAO {

    public List<Abono> getAllAbonos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Abono.class);
//        criteria.add(Restrictions.eq("inactivo",false));
        criteria.addOrder(Order.asc("detalle"));
        List<Abono> abono = (List<Abono>) criteria.list();
        return abono;
    }

    public List<Abono> getAllAbonosActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Abono.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.isNotNull("abono"));
        criteria.addOrder(Order.asc("detalle"));
        List<Abono> abono = (List<Abono>) criteria.list();
        return abono;
    }
}
