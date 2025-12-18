/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.TicketTimeBO;
import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class TicketTimeService {
    
    public TicketTime updateTicket(TicketTime ticket) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new TicketTimeBO().updateTicket(ticket);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ticket;
    }
    
    public TicketTime getTicketById(Long id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        TicketTime ticket = null;
        try {
            ticket = new TicketTimeBO().getTicketById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ticket;
    }
   
}
