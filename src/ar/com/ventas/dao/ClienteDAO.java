/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class ClienteDAO extends GenericDAO {

    public List<Cliente> getAllClientes() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        Criteria cri = criteria.createCriteria("direccion");
        criteria.add(Restrictions.eq("activo",true));
        criteria.addOrder(Order.asc("codigoMauro"));
        criteria.addOrder(Order.asc("razonSocial"));
        cri.addOrder(Order.asc("calle"));
        cri.addOrder(Order.asc("numero"));
        //Criteria criteria1 = criteria.createCriteria("direccion");
        
        
        List<Cliente> clientes = (List<Cliente>) criteria.list();
        return clientes;
    }
 
    public List<Cliente> getClientesByFiltro(String filtro) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.razonSocial like :filtro ");
        sb.append("order by clie.razonSocial asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        clientes = (List<Cliente>) query.list();
        return clientes;
    }

    public List<Cliente> getClientesByFiltroCalle(String filtro) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        Criteria criteria1 = criteria.createCriteria("direccion");
        criteria1.add(Restrictions.like("calle", "%"+filtro+"%"));
        clientes = (List<Cliente>) criteria.list();
        return clientes;
    }
    
    public Cliente getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }
    
    public Cliente getByCuit(String cuit) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("cuit", cuit));
        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }
    
    public Cliente getUltimo() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.addOrder(Order.desc("codigo"));
        List<Cliente> c = (List<Cliente>) criteria.list();
        Cliente cliente = c.get(0);
        return cliente;
    }

    public List<Cliente> getClientesByAbono(Abono abono) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("abono", abono));
        clientes = (List<Cliente>) criteria.list();
        return clientes;
    }
}
