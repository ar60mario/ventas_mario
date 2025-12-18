/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.utils;

import ar.com.ventas.entities.Factura;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class UtilFrame {
    
    private static final SimpleDateFormat sdf_qr = new SimpleDateFormat("yyyy-MM-dd");
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    
    public static JTable limpiarTabla(JTable tabla){
        int rows = tabla.getRowCount();
        if(rows > 0){
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for(int i = 0;i < rows; i++){
                tbl.removeRow(0);
            }
            tabla.setModel(tbl);
        }
        return tabla;
    }
    
    public static String generaQr(Factura fc){
        String data;
        String ver_qr = "1";
        Date fecha = fc.getFecha();
        String cuit_qr = "20142553202";
        String cui = fc.getCliente().getCuit();
        String modeloFcPapel = fc.getTipoDoc().toString();
        String pri = "";
        String med = "";
        String fin = "";
        int lgo = cui.length();
        if (lgo != 13) {
            cui = "0000000000000" + cui;
            int lgo1 = cui.length();
            fin = cui.substring(lgo1 - 11, lgo1);
        }
        if (lgo > 11) {
            pri = cui.substring(0, 2);
            med = cui.substring(3, 11);
            fin = cui.substring(12, 13);
        }
        String fecha_qr = sdf_qr.format(fecha);
        String numeroDoc_qr = pri + med + fin;
        String tipoComprobante_qr = modeloFcPapel;
        String numeroComprobante_qr = fc.getNumero().toString();
        String importe_qr = df.format(fc.getImporte()).replace(",", ".");
        String tipoDoc_qr = fc.getCliente().getTipoDoc().toString();
        String nroCae_qr = fc.getCae().toString();
        String puntoVenta_qr = fc.getSucursal().toString();
        String moneda_qr = "PES";
        String cotiz_qr = "1";
        String tipoCodigoAutoriz_qr = "E";
        data = "{\"ver\":" + ver_qr
                + ",\"fecha\":\"" + fecha_qr + "\""
                + ",\"cuit\":" + cuit_qr
                + ",\"ptoVta\":" + puntoVenta_qr
                + ",\"tipoCmp\":" + tipoComprobante_qr
                + ",\"nroCmp\":" + numeroComprobante_qr
                + ",\"importe\":" + importe_qr
                + ",\"moneda\":\"" + moneda_qr + "\""
                + ",\"ctz\":" + cotiz_qr
                + ",\"tipoDocRec\":" + tipoDoc_qr
                + ",\"nroDocRec\":" + numeroDoc_qr
                + ",\"tipoCodAut\":\"" + tipoCodigoAutoriz_qr + "\""
                + ",\"codAut\":" + nroCae_qr + "}";
        System.out.println(data);
//        System.exit(0);
        return data;
    }
    
    public static String decoder(File file) throws Exception {

        FileInputStream inputStream = new FileInputStream(file);

        BufferedImage image = ImageIO.read(inputStream);

        int width = image.getWidth();
        int height = image.getHeight();
        int[] pixels = new int[width * height];

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        // decode the barcode
        QRCodeReader reader = new QRCodeReader();
        Result result = reader.decode(bitmap);
        return new String(result.getText());
    }
    
    
}
