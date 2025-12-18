/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ClienteBO;
import ar.com.ventas.bo.DireccionBO;
import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Direccion;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ClienteService {
    
    public void saveCliente(Cliente cliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        DireccionBO direccionBO = new DireccionBO();
        Direccion direccion = cliente.getDireccion();
        try{
            direccion = direccionBO.saveDireccion(direccion);
            cliente.setDireccion(direccion);
        }catch(Exception ex){
            throw new Exception(ex);
        }
        try {
            new ClienteBO().saveCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Cliente> getAllClientes() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try {
            clientes = new ClienteBO().getAllClientes();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public Cliente updateCliente(Cliente cliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        DireccionBO direccionBO = new DireccionBO();
        Direccion direccion = cliente.getDireccion();
        try {
            direccion = direccionBO.updateDireccion(direccion);
            cliente.setDireccion(direccion);
            new ClienteBO().updateCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cliente;
    }

    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesByFiltro(filtro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesByFiltroCalle(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesByFiltroCalle(filtro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public Cliente getClienteByCodigo(Integer codigo) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Cliente cliente = null;
        try {
            cliente = new ClienteBO().getClienteByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cliente;
    }
   //
    public Cliente getUltimo() throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Cliente cliente = null;
        try {
            cliente = new ClienteBO().getUltimo();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public Cliente getByCuit(String cuit) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Cliente cliente = null;
        try {
            cliente = new ClienteBO().getByCuit(cuit);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public List<Cliente> getClientesByAbono(Abono abono) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try {
            clientes = new ClienteBO().getClientesByAbono(abono);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
}
