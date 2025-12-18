package ar.com.ventas.frame;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Factura;
import ar.com.ventas.entities.RenglonAbono;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.FacturaService;
import ar.com.ventas.services.RenglonAbonoService;
import ar.com.ventas.services.RenglonFacturaService;
import ar.com.ventas.utils.PDFBuilder;
import com.itextpdf.text.DocumentException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ImpresionFacturasEntreFechasFrame extends javax.swing.JFrame {

    private List<Factura> facturas;
    private Factura factura = null;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final DecimalFormat df = new DecimalFormat("#0.00");
    private final DecimalFormat dfn = new DecimalFormat("00000000");
    private final String letraFacturaPapel = "C";
    private final String textoFacturaPapel = "FACTURA";
    private final String sucursalFacturaPapel = "0006";
    private String numeroFacturaPapel = "0";
    private String fechaFacturaPapel = "0";
    private String clienteFacturaPapel = "0";
    private String direccionFacturaPapel = "0";
    private String localidadFacturaPapel = "0";
    private String cuitFacturaPapel = "0";
    private String provinciaFacturaPapel = "0";
    private String codigoPostalFacturaPapel = "0";
    private String inscripcionClienteFacturaPapel = "";
    private final String renglonFc[] = new String[15];
    private final Double renglonFcIm[] = new Double[15];
    private String importeTotalFacturaPapel = "0";
    private String texto1Cae = "0";
    private String texto2Cae = "0";
    private String vencCae = "0";

    public ImpresionFacturasEntreFechasFrame() {
        initComponents();
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imprimirBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        fechaDeTxt = new javax.swing.JTextField();
        fechaAlTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        buscarBtn = new javax.swing.JButton();
        imprimirTodasBtn = new javax.swing.JButton();
        pdfTodasBtn = new javax.swing.JButton();
        pdfUnaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("IMPRESION FACTURAS NOTAS DE CREDITO Y PDF");

        jLabel1.setText("Desde fecha:");

        jLabel2.setText("Hasta Fecha:");

        imprimirBtn.setText("Imprimir Seleccionada");
        imprimirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirBtnActionPerformed(evt);
            }
        });

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        fechaDeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaDeTxt.setText("FECHA DE");

        fechaAlTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaAlTxt.setText("FECHA A");

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "núm fc", "núm nc", "Rsoc", "Calle Nro", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);
        if (tablaFacturas.getColumnModel().getColumnCount() > 0) {
            tablaFacturas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tablaFacturas.getColumnModel().getColumn(3).setPreferredWidth(180);
            tablaFacturas.getColumnModel().getColumn(4).setPreferredWidth(300);
        }

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        imprimirTodasBtn.setText("Imprimir Todas");
        imprimirTodasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirTodasBtnActionPerformed(evt);
            }
        });

        pdfTodasBtn.setText("PDF de todas");
        pdfTodasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfTodasBtnActionPerformed(evt);
            }
        });

        pdfUnaBtn.setText("PDF una");
        pdfUnaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfUnaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaDeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaAlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buscarBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imprimirBtn)
                        .addGap(18, 18, 18)
                        .addComponent(excelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(imprimirTodasBtn)
                        .addGap(18, 18, 18)
                        .addComponent(pdfTodasBtn)
                        .addGap(18, 18, 18)
                        .addComponent(pdfUnaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaDeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(fechaAlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imprimirBtn)
                    .addComponent(excelBtn)
                    .addComponent(volverBtn)
                    .addComponent(imprimirTodasBtn)
                    .addComponent(pdfTodasBtn)
                    .addComponent(pdfUnaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirBtnActionPerformed
        imprimir();
    }//GEN-LAST:event_imprimirBtnActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        llenarTabla();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void imprimirTodasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirTodasBtnActionPerformed
        imprimirTodas();
    }//GEN-LAST:event_imprimirTodasBtnActionPerformed

    private void pdfTodasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfTodasBtnActionPerformed
        pdf();
    }//GEN-LAST:event_pdfTodasBtnActionPerformed

    private void pdfUnaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfUnaBtnActionPerformed
        pdf1();
    }//GEN-LAST:event_pdfUnaBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpresionFacturasEntreFechasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBtn;
    private javax.swing.JButton excelBtn;
    private javax.swing.JTextField fechaAlTxt;
    private javax.swing.JTextField fechaDeTxt;
    private javax.swing.JButton imprimirBtn;
    private javax.swing.JButton imprimirTodasBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pdfTodasBtn;
    private javax.swing.JButton pdfUnaBtn;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void imprimir() {
        numeroFacturaPapel = "0";
        int row = tablaFacturas.getSelectedRow();
        if (row < 0) {
            return;
        }
        factura = facturas.get(row);
        int numFc = factura.getNumero();
        String strNumFc = String.valueOf(numFc);
        strNumFc = "00000000" + strNumFc;
        int largo = strNumFc.length();
        numeroFacturaPapel = strNumFc.substring(largo - 8, largo);
        fechaFacturaPapel = sdf.format(factura.getFecha());
        clienteFacturaPapel = factura.getCliente().getRazonSocial();
        direccionFacturaPapel = factura.getCliente().getDireccion().getCalle()
                + " " + factura.getCliente().getDireccion().getNumero();
        if (factura.getCliente().getDireccion().getPisoDto() != null) {
            direccionFacturaPapel += " "
                    + factura.getCliente().getDireccion().getPisoDto();
        }
        localidadFacturaPapel = factura.getCliente().getDireccion().getLocalidad();
        cuitFacturaPapel = factura.getCliente().getCuit();
        provinciaFacturaPapel = factura.getCliente().getDireccion().getProvincia();
        codigoPostalFacturaPapel = factura.getCliente().getDireccion().getCodigoPostal();
        if (factura.getCliente().getCategoriaAfip() == 1) {
            inscripcionClienteFacturaPapel = "RESPONSABLE INSCRIPTO";
        }
        if (factura.getCliente().getCategoriaAfip() == 6) {
            inscripcionClienteFacturaPapel = "MONOTRIBUTO";
        }
        if (factura.getCliente().getCategoriaAfip() == 3) {
            inscripcionClienteFacturaPapel = "NO RESPONSABLE";
        }
        if (factura.getCliente().getCategoriaAfip() == 4) {
            inscripcionClienteFacturaPapel = "EXENTO";
        }
        if (factura.getCliente().getCategoriaAfip() == 5) {
            inscripcionClienteFacturaPapel = "CONSUMIDOR FINAL";
        }
        Abono ab = factura.getCliente().getAbono();
        List<RenglonAbono> ra = null;
        try {
            ra = new RenglonAbonoService().getRenglonAbonosByAbono(ab);
        } catch (Exception ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
//        System.out.println(ra);
//        System.exit(0);
        if (ra != null && !ra.isEmpty()) {
            for (RenglonAbono reng : ra) {
                renglonFc[i] = reng.getTexto();
                renglonFcIm[i] = reng.getImporte();
                i += 1;
            }
        }
        importeTotalFacturaPapel = df.format(factura.getImporte());
        texto1Cae = String.valueOf(factura.getCae());
        vencCae = sdf.format(factura.getFechaVencimCae());
        int x = 0;
        Integer suma1 = 0;
        Integer suma2 = 0;
        String vto = new SimpleDateFormat("yyyyMMdd").format(factura.getFechaVencimCae());
        String cui = factura.getCliente().getCuit();
        String cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        String cadena = cuit1 + "11" + "0006" + texto1Cae + vto;
        if (cadena.length() > 37) {
            for (int y = 0; y < 39; y++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(y, y + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(y, y + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
        }
        suma1 = suma1 * 3;
        int total = suma1 + suma2;
        int dv = (int) (rint(total / 10 + .9) * 10);
        dv = dv - total;
        cadena += String.valueOf(dv);
        String txtCadenaRP = "";
        for (int s = 0; s < 40; s = s + 2) {
            String charNum = cadena.substring(s, s + 2);
            int numChar = Integer.valueOf(charNum);
            if (numChar < 50) {
                numChar += 48;
            } else {
                numChar += 142;
            }
            char c = (char) numChar;
            txtCadenaRP = txtCadenaRP + c;
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
        texto2Cae = txtCadenaRP;
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        Paper paper = new Paper();
        double margin = 10;
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
        pf.setPaper(paper);
        pj.setPrintable(new MyPrintable(), pf);
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException e) {
                System.out.println(e);
            }
        }
    }

    private void excel() {
        String rutaArchivo = "c:/informes/facturas_mario.xls";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet hoja1 = libro.createSheet("Listado Facturas", 0);
        try {
            hoja1.addCell(new jxl.write.Label(0, 0, "Mario Gianotti"));
            hoja1.addCell(new jxl.write.Label(0, 1, "CODIGO"));
            hoja1.addCell(new jxl.write.Label(1, 1, "RUBRO"));
            hoja1.addCell(new jxl.write.Label(2, 1, "DETALLE NUM.FC."));
            hoja1.addCell(new jxl.write.Label(3, 1, "IMPORTE"));
            int y = 2;
            int rows = tablaFacturas.getRowCount();
            int x = 0;
            for (int i = 0; i < rows; i++) {
                hoja1.addCell(new jxl.write.Label(0, y, facturas.get(i).getCliente().getCodigoMauro()));
                hoja1.addCell(new jxl.write.Label(1, y, "10"));
                hoja1.addCell(new jxl.write.Label(2, y,
                        facturas.get(i).getNumero().toString()));
                hoja1.addCell(new jxl.write.Label(3, y, facturas.get(i).getImporte().toString()));
                y += 1;
            }
        } catch (WriteException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 313");
        } catch (WriteException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 314");
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
        volver();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void limpiarCampos() {
        fechaDeTxt.setText(sdf.format(new Date()));
        fechaAlTxt.setText(sdf.format(new Date()));
        fechaDeTxt.requestFocus();
    }

    private void llenarTabla() {
        limpiarTabla();
        facturas = null;
        Date fd = new Date(), fa = new Date();
        try {
            fd = sdf.parse(fechaDeTxt.getText());
            fa = sdf.parse(fechaAlTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            facturas = new FacturaService().getFacturasEntreFechas(fd, fa);
        } catch (Exception ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (facturas != null && !facturas.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaFacturas.getModel();
            for (Factura fc : facturas) {
                Object ob[] = new Object[6];
                ob[0] = fc.getFecha();
                if (fc.getTipoDoc() == 11) {
                    ob[1] = dfn.format(fc.getNumero());
                }
                if (fc.getTipoDoc() == 13) {
                    ob[2] = dfn.format(fc.getNumero());
                }
                ob[3] = fc.getCliente().getRazonSocial();
                ob[4] = fc.getCliente().getDireccion().getCalle() + " "
                        + fc.getCliente().getDireccion().getNumero();
                ob[5] = df.format(fc.getImporte());
                tbl.addRow(ob);
            }
            tablaFacturas.setModel(tbl);
        }
    }

    private void imprimirTodas() {
        numeroFacturaPapel = "0";
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        if (pj.printDialog()) {
            for (Factura fc : facturas) {
                factura = fc;
                int numFc = factura.getNumero();
                String strNumFc = String.valueOf(numFc);
                strNumFc = "00000000" + strNumFc;
                int largo = strNumFc.length();
                numeroFacturaPapel = strNumFc.substring(largo - 8, largo);
                fechaFacturaPapel = sdf.format(factura.getFecha());
                //fechaFacturaPapel = "31/03/2017"; //sdf.format(factura.getFecha());
                clienteFacturaPapel = factura.getCliente().getRazonSocial();
                direccionFacturaPapel = factura.getCliente().getDireccion().getCalle()
                        + " " + factura.getCliente().getDireccion().getNumero();
                if (factura.getCliente().getDireccion().getPisoDto() != null) {
                    direccionFacturaPapel += " "
                            + factura.getCliente().getDireccion().getPisoDto();
                }
                localidadFacturaPapel = factura.getCliente().getDireccion().getLocalidad();
                cuitFacturaPapel = factura.getCliente().getCuit();
                provinciaFacturaPapel = factura.getCliente().getDireccion().getProvincia();
                codigoPostalFacturaPapel = factura.getCliente().getDireccion().getCodigoPostal();
                if (factura.getCliente().getCategoriaAfip() == 1) {
                    inscripcionClienteFacturaPapel = "RESPONSABLE INSCRIPTO";
                }
                if (factura.getCliente().getCategoriaAfip() == 6) {
                    inscripcionClienteFacturaPapel = "MONOTRIBUTO";
                }
                if (factura.getCliente().getCategoriaAfip() == 3) {
                    inscripcionClienteFacturaPapel = "NO RESPONSABLE";
                }
                if (factura.getCliente().getCategoriaAfip() == 4) {
                    inscripcionClienteFacturaPapel = "EXENTO";
                }
                if (factura.getCliente().getCategoriaAfip() == 5) {
                    inscripcionClienteFacturaPapel = "CONSUMIDOR FINAL";
                }
//                Abono ab = factura.getCliente().getAbono();
                List<RenglonFactura> ra = null;
                try {
                    ra = new RenglonFacturaService().getRenglonFacturasByFactura(factura);
                } catch (Exception ex) {
                    Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                int i = 0;
//        System.out.println(ra);
//        System.exit(0);
                if (ra != null && !ra.isEmpty()) {
                    for (RenglonFactura reng : ra) {
                        renglonFc[i] = reng.getTexto();
                        renglonFcIm[i] = reng.getImporte();
                        i += 1;
                    }
                }
                importeTotalFacturaPapel = df.format(factura.getImporte());
                texto1Cae = String.valueOf(factura.getCae());
                vencCae = sdf.format(factura.getFechaVencimCae());
                int x = 0;
                Integer suma1 = 0;
                Integer suma2 = 0;
                String vto = new SimpleDateFormat("yyyyMMdd").format(factura.getFechaVencimCae());
                String cui = factura.getCliente().getCuit();
                String cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
                String cadena = cuit1 + "11" + "0006" + texto1Cae + vto;
                if (cadena.length() > 37) {
                    for (int y = 0; y < 39; y++) {
                        if (x == 0) {
                            int num = Integer.valueOf(cadena.substring(y, y + 1).toString());
                            suma1 += num;
                            x = 1;
                        } else {
                            int num = Integer.valueOf(cadena.substring(y, y + 1).toString());
                            suma2 += num;
                            x = 0;
                        }
                    }
                }
                suma1 = suma1 * 3;
                int total = suma1 + suma2;
                int dv = (int) (rint(total / 10 + .9) * 10);
                dv = dv - total;
                cadena += String.valueOf(dv);
                String txtCadenaRP = "";
                for (int s = 0; s < 40; s = s + 2) {
                    String charNum = cadena.substring(s, s + 2);
                    int numChar = Integer.valueOf(charNum);
                    if (numChar < 50) {
                        numChar += 48;
                    } else {
                        numChar += 142;
                    }
                    char c = (char) numChar;
                    txtCadenaRP = txtCadenaRP + c;
                }
                txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
                texto2Cae = txtCadenaRP;

                Paper paper = new Paper();
                double margin = 10;
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pj.setPrintable(new MyPrintable(), pf);

                try {
                    pj.print();
                } catch (PrinterException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private void pdf() {
        int rows = tablaFacturas.getRowCount();
        if (rows < 1) {
            return;
        }
        for (int i = 0; i < rows; i++) {
            Factura iv = facturas.get(i);
            List<RenglonFactura> rf = null;
//        System.out.println("SIIIIIIIIIIIII");
            try {
                rf = new RenglonFacturaService().getRenglonFacturasByFactura(iv);
            } catch (Exception ex) {
                Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("err lineas");
            }
//        System.out.println(rf);
            if (rf != null && !rf.isEmpty()) {
                gpdf(iv, rf);
            }

            /*
        int row = tabla.getSelectedRow();
        if (row < 0) {
            return;
        }
        Factura iv = facturas.get(row);
        List<RenglonFactura> rf = null;
        try {
            rf = new RenglonFacturaService().getAllRenglonFacturaFromIvaVentas(iv);
        } catch (Exception ex) {
            Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rf != null && !rf.isEmpty()) {
            pdf(iv, rf);
        }
        
        String letra = "C";
        Integer sucursal = iv.getSucursal();
        if (letra.equals("B")) {
            try {
                new PDFBuilder().armarFacturaB(iv, rf);
                JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (sucursal.equals("6")) {
                try {
                    new PDFBuilder().armarFacturaA(iv, rf);
                    JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    new PDFBuilder().armarFacturaPanificadosA(iv, rf);
                    JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(DuplicadoFacturaPdfFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             */
        }
        JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
    }

    private void gpdf(Factura iv, List<RenglonFactura> rf) {
        try {
            if (iv.getTipoDoc() == 11) {
                new PDFBuilder().armarFacturaC(iv, rf);
            }
            if (iv.getTipoDoc() == 13) {
                new PDFBuilder().armarNc(iv, rf);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err1");
        } catch (DocumentException ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err2");
        } catch (Exception ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err3");
        }
    }

    private void pdf1() {
        int row = tablaFacturas.getSelectedRow();
        if (row < 0) {
            return;
        }
        Factura iv = facturas.get(row);
        List<RenglonFactura> rf = null;
        try {
            rf = new RenglonFacturaService().getRenglonFacturasByFactura(iv);
            JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
        } catch (Exception ex) {
            Logger.getLogger(ImpresionFacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err lineas");
        }
        if (rf != null && !rf.isEmpty()) {
            gpdf(iv, rf);
        }
    }

    private void limpiarTabla() {
        int rows = tablaFacturas.getRowCount();
        if (rows > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tablaFacturas.getModel();
            for (int i = 0; i < rows; i++) {
                tbl.removeRow(0);
            }
            tablaFacturas.setModel(tbl);
        }
    }

    class MyPrintable implements Printable {

        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex != 0) {
                return NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(1.0f));
            g2.setFont(new Font("Monospaced", Font.BOLD, 14));
            g2.setPaint(Color.black);
            g2.drawRect(25, 51, 180, 28);
            g2.drawRect(272, 55, 24, 25);
            g2.setStroke(new BasicStroke(0.8f));
            g2.drawLine(25, 280, 580, 280);
            g2.drawLine(25, 300, 580, 300);
            g2.drawLine(25, 707, 580, 707);
            g2.drawLine(25, 687, 580, 687);
            g2.drawLine(25, 160, 580, 160);
            int row = 62;
            g2.drawString("Sistemas y Servicios", 30, row);
            row = 76;
            g2.drawString("    Informáticos", 30, row);
            row = 91;
            g2.setFont(new Font("Monospaced", Font.PLAIN, 10));
            g2.drawString("de Mario Enrique Gianotti", 30, row);
            row = 104;
            g2.drawString("109 Paso 1927 - Gral. San Martín", 30, row);
            row = 117;
            g2.drawString("1650 - Pcia.Buenos Aires", 30, row);
            row = 130;
            g2.drawString("Tel: 15 5780-2499", 30, row);
            row = 142;
            g2.drawString("mail: mario.gianotti@gmail.com", 30, row);
            row = 127;
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            g2.drawString("CUIT: 20-14255320-2 C.M.: 901-067583-0", 300, row);
            row = 137;
            g2.drawString("Fecha Inicio Actividades: 01/05/2009", 300, row);
            row = 70;
            g2.setFont(new Font("Monospaced", Font.BOLD, 12));
            g2.drawString(letraFacturaPapel, 280, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 6));
            g2.drawString("Cod.Nro.11", 266, row + 17);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 10));
            row = 85;
            g2.drawString(textoFacturaPapel + " "
                    + sucursalFacturaPapel + " - "
                    + numeroFacturaPapel, 310, row);
            row = 105;
            //         123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            String espacio = "                                                        Fecha: ";
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            g2.drawString(espacio + fechaFacturaPapel, 30, row);
            //g2.drawString(espacio + "31/03/2017", 30, row);
            espacio = "               ";
            row = 185;
            g2.drawString("RAZON SOCIAL:", 45, row);
            row += 20;
            g2.drawString("DIRECCION:", 45, row);
            row += 20;
            g2.drawString("CODIGO POSTAL:", 45, row);
            g2.drawString("CUIT:", 340, row);
            row += 20;
            g2.drawString("LOCALIDAD:", 45, row);
            g2.drawString("CATEG.INSCRIP.AFIP.:", 340, row + 7);
            row += 20;
            g2.drawString("PROVINCIA:", 45, row);
            row = 185;
            g2.drawString(espacio + clienteFacturaPapel, 70, row);
            row += 20;
            espacio = "               ";
            g2.drawString(espacio + direccionFacturaPapel, 70, row);
            row += 20;
            g2.drawString(espacio + codigoPostalFacturaPapel, 70, row);
            g2.drawString(cuitFacturaPapel, 375, row);
            row += 20;
            g2.drawString(espacio + localidadFacturaPapel, 70, row);

            row += 20;
            g2.drawString(espacio + provinciaFacturaPapel, 70, row);
            g2.drawString(inscripcionClienteFacturaPapel, 340, row);
            row = 292;
            g2.drawString("                  DESCRIPCION                                                      IMPORTE", 30, row);
            row += 27;
            for (int i = 0; i < 15; i++) {
                if (renglonFc[i] != null) {
                    g2.drawString(renglonFc[i], 30, row);
                    if (renglonFcIm[i] > 0.0) {
                        g2.drawString(df.format(renglonFcIm[i]), 490, row);
                    }
                    row += 10;
                }
            }
            if (row < 700) {
                row = 700;
            }
            g2.setFont(new Font("Monospaced", Font.BOLD, 11));
            g2.drawString("TOTAL", 420, row);
            g2.drawString(importeTotalFacturaPapel, 490, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 11;
            row += 20;
            g2.drawString(" CAE " + texto1Cae + "  Venc. CAE " + vencCae, 30, row);
            g2.setFont(new Font("PF Interleavev 2 of 5 Text", Font.PLAIN, 18));
            g2.drawString("           " + texto2Cae, 160, row);
            return PAGE_EXISTS;
        }
    }
}
