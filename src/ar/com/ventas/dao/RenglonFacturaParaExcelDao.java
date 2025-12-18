package ar.com.ventas.dao;

import ar.com.ventas.entities.RenglonFacturaParaExcel;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class RenglonFacturaParaExcelDao extends GenericDAO {

    public List<RenglonFacturaParaExcel> getRenglonesFacturaActivosParaExcel() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFacturaParaExcel.class);
        criteria.add(Restrictions.eq("activo",true));
        List<RenglonFacturaParaExcel> renglones = (List<RenglonFacturaParaExcel>) criteria.list();
        return renglones;
    }
//
//    public List<Abono> getAllAbonosActivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.isNotNull("abono"));
//        criteria.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
}
