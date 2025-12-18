/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RenglonFacturaDAO;
import ar.com.ventas.entities.Factura;
import ar.com.ventas.entities.RenglonFactura;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonFacturaBO {
    RenglonFacturaDAO dao = new RenglonFacturaDAO();
    public List<RenglonFactura> getAllRenglonFacturas() throws Exception{
        try {
            return dao.getAllRenglonFacturas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void saveRenglonFactura(RenglonFactura factura) throws Exception {
        try {
            dao.save(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<RenglonFactura> getRenglonFacturasByFactura(Factura factura) throws Exception{
        try {
            return dao.getRenglonFacturasByFactura(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void deleteRenglonFactura(RenglonFactura factura) throws Exception {
        try {
            dao.delete(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
}
