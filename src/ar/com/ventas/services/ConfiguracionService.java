/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ConfiguracionBO;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ConfiguracionService {
    public Configuracion getConfiguracionById(Long id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Configuracion conf = null;
        try {
            conf = new ConfiguracionBO().getConfiguracionById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return conf;
    }
    
    public Configuracion updateConfiguracion(Configuracion configuracion) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Configuracion conf = null;
        try {
            conf = new ConfiguracionBO().updateConfiguracion(configuracion);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return conf;
    }
}
