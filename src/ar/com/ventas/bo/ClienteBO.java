/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ClienteDAO;
import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Cliente;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ClienteBO {

    ClienteDAO dao = new ClienteDAO();

    public void saveCliente(Cliente cliente) throws Exception {
        try {
            dao.save(cliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public List<Cliente> getAllClientes() throws Exception {
        try {
            return dao.getAllClientes();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public Cliente updateCliente(Cliente cliente) throws Exception {
        try {
            cliente = (Cliente) dao.update(cliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }

    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesByFiltroCalle(String filtro) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesByFiltroCalle(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public Cliente getClienteByCodigo(Integer codigo) throws Exception {
        Cliente cliente = null;
        try {
            cliente = dao.getByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }
    //
    public Cliente getUltimo() throws Exception {
        Cliente cliente = null;
        try {
            cliente = dao.getUltimo();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public Cliente getByCuit(String cuit) throws Exception {
        Cliente cliente = null;
        try {
            cliente = dao.getByCuit(cuit);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public List<Cliente> getClientesByAbono(Abono abono) throws Exception {
        try {
            return dao.getClientesByAbono(abono);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
}
