/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ConfiguracionDAO;
import ar.com.ventas.entities.Configuracion;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ConfiguracionBO {
    ConfiguracionDAO dao = new ConfiguracionDAO();
    public Configuracion getConfiguracionById(Long id) throws Exception {
        Configuracion conf = null;
        try {
            conf = (Configuracion) dao.getById(Configuracion.class,id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return conf;
    }
    
    public Configuracion updateConfiguracion(Configuracion configuracion) throws Exception{
        Configuracion conf = null;
        try{
            conf = (Configuracion) dao.update(configuracion);
        }catch (HibernateException ex){
            throw new Exception(ex);
        }
        return conf;
    }
}
