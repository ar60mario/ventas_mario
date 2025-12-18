package ar.com.ventas.bo;

import ar.com.ventas.dao.RenglonFacturaParaExcelDao;
import ar.com.ventas.entities.RenglonFacturaParaExcel;
import java.util.List;
import org.hibernate.HibernateException;

public class RenglonFacturaParaExcelBo {

    RenglonFacturaParaExcelDao dao = new RenglonFacturaParaExcelDao();

    public List<RenglonFacturaParaExcel> getRenglonesFacturaActivosParaExcel() throws Exception {
        try {
            return dao.getRenglonesFacturaActivosParaExcel();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void saveRenglonFacturaParaExcel(RenglonFacturaParaExcel rf) throws Exception{
        try {
            dao.save(rf);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void updateRenglonFacturaParaExcel(RenglonFacturaParaExcel rf) throws Exception{
        try {
            dao.update(rf);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
//    public void saveAbono(Abono abono) throws Exception {
//        try {
//            dao.save(abono);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//    
//    public void updateAbono(Abono abono) throws Exception {
//        try {
//            dao.update(abono);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
}
