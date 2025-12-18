package ar.com.ventas.services;

import ar.com.ventas.bo.RenglonFacturaParaExcelBo;
import ar.com.ventas.entities.RenglonFacturaParaExcel;
import ar.com.ventas.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RenglonFacturaParaExcelService {

    RenglonFacturaParaExcelBo bo = new RenglonFacturaParaExcelBo();

    public List<RenglonFacturaParaExcel> getRenglonesFacturaActivosParaExcel() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RenglonFacturaParaExcel> renglones = null;
        try {
            renglones = bo.getRenglonesFacturaActivosParaExcel();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }

    public void saveRenglonFacturaParaExcel(RenglonFacturaParaExcel rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            bo.saveRenglonFacturaParaExcel(rf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void updateRenglonFacturaParaExcel(RenglonFacturaParaExcel rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            bo.updateRenglonFacturaParaExcel(rf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

//    public List<Abono> getAllAbonosActivos() throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public void updateAbono(Abono abono) throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().updateAbono(abono);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
}
