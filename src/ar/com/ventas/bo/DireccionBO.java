/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.bo;

import ar.com.ventas.dao.DireccionDAO;
import ar.com.ventas.entities.Direccion;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class DireccionBO {
    
    private final DireccionDAO dao = new DireccionDAO();

    public Direccion saveDireccion(Direccion direccion) throws Exception {
        
        Direccion direc = null;
        
        try{
            direc = (Direccion) dao.save(direccion);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        
        return direc;
        
    }

    public Direccion updateDireccion(Direccion direccion) throws Exception {
        
        try{
            direccion = (Direccion) dao.update(direccion);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        
        return direccion;
    }
    
}
