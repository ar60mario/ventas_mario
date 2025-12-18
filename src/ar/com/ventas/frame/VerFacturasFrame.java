package ar.com.ventas.frame;

import ar.com.ventas.entities.Factura;
import ar.com.ventas.entities.RenglonFacturaParaExcel;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.FacturaService;
import ar.com.ventas.services.RenglonFacturaParaExcelService;
import java.io.File;
import java.io.IOException;
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

public class VerFacturasFrame extends javax.swing.JFrame {

    private List<Factura> facturas = null;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<RenglonFacturaParaExcel> renglones;
    private RenglonFacturaParaExcel renglon;

    public VerFacturasFrame() {
        initComponents();
        deFechaTxt.setText(sdf.format(new Date()));
        aFechaTxt.setText(sdf.format(new Date()));
        leyenda2Txt.setText("");
        llenarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        excelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deFechaTxt = new javax.swing.JTextField();
        aFechaTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        leyendaTxt = new javax.swing.JTextField();
        leyenda2Txt = new javax.swing.JTextField();
        libroVentasBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        importeTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VER FACTURAS ENTRE FECHAS");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Dirección", "Núm. Fc.", "Importe", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);
        if (tablaFacturas.getColumnModel().getColumnCount() > 0) {
            tablaFacturas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaFacturas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tablaFacturas.getColumnModel().getColumn(2).setPreferredWidth(70);
            tablaFacturas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("De fecha:");

        jLabel2.setText("A fecha:");

        deFechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deFechaTxt.setText("DE FECHA");

        aFechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aFechaTxt.setText("A FECHA");

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        leyendaTxt.setText("2do. SEMESTRE 2022");

        leyenda2Txt.setText("LEYENDA 2");

        libroVentasBtn.setText("Libro Ventas");
        libroVentasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libroVentasBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Texto Excel:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboKeyPressed(evt);
            }
        });

        jLabel4.setText("Importe:");

        importeTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeTxt.setText("IMPORTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leyenda2Txt)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leyendaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(excelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(libroVentasBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscarBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(deFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(leyenda2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(excelBtn)
                    .addComponent(leyendaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libroVentasBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        llenarTabla();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void libroVentasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libroVentasBtnActionPerformed
        libroVentas();
    }//GEN-LAST:event_libroVentasBtnActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if(evt.getKeyCode()==10){
            int row = combo.getSelectedIndex();
            if(row > 0){
                renglon = renglones.get(row -1);
                completarCampos();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if(evt.getModifiers()==16){
            int row = combo.getSelectedIndex();
            if(row > 0){
                renglon = renglones.get(row -1);
                completarCampos();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

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
            java.util.logging.Logger.getLogger(VerFacturasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerFacturasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerFacturasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerFacturasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerFacturasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aFechaTxt;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField deFechaTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JTextField importeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField leyenda2Txt;
    private javax.swing.JTextField leyendaTxt;
    private javax.swing.JButton libroVentasBtn;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void llenarTabla() {
        facturas = null;
        Date fd = new Date();
        Date fa = new Date();
        try {
            fd = sdf.parse(deFechaTxt.getText());
            fa = sdf.parse(aFechaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            facturas = new FacturaService().getFacturasEntreFechas(fd, fa);
        } catch (Exception ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (facturas != null && !facturas.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaFacturas.getModel();
            for (Factura fc : facturas) {
                Object ob[] = new Object[5];
                ob[0] = fc.getCliente().getCodigo();
                ob[1] = fc.getCliente().getDireccion().getCalle() + " "
                        + fc.getCliente().getDireccion().getNumero();
                int largo = ("0000" + fc.getNumero().toString()).length();
                ob[2] = (("0000" + fc.getNumero().toString()).substring(largo - 4, largo));
                ob[3] = df.format(fc.getImporte());
                ob[4] = sdf.format(fc.getFecha());
                tbl.addRow(ob);
            }
            tablaFacturas.setModel(tbl);
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
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
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

//            String leyenda = leyendaTxt.getText();
            int x = 0;
            String des1 = leyenda2Txt.getText();
            Double importe = Double.valueOf(importeTxt.getText().replace(",", "."));
            for (int i = 0; i < rows; i++) {
                hoja1.addCell(new jxl.write.Label(0, y, facturas.get(i).getCliente().getCodigoMauro()));
                hoja1.addCell(new jxl.write.Label(1, y, renglon.getRubro().toString()));
                hoja1.addCell(new jxl.write.Label(2, y, des1 + " "
                        + facturas.get(i).getNumero().toString()));
                hoja1.addCell(new jxl.write.Number(3, y, importe));
                y += 1;
            }
        } catch (WriteException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 313");
        } catch (WriteException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 314");
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
        volver();
    }

    private void libroVentas() {
        String rutaArchivo = "c:/informes/libro_ventas.xls";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet hoja1 = libro.createSheet("Listado Facturas", 0);
        try {
            hoja1.addCell(new jxl.write.Label(0, 0, "Mario Gianotti"));
            hoja1.addCell(new jxl.write.Label(0, 1, "FECHA"));
            hoja1.addCell(new jxl.write.Label(1, 1, "FC/NC"));
            hoja1.addCell(new jxl.write.Label(2, 1, "NUMERO FC."));
            hoja1.addCell(new jxl.write.Label(3, 1, "RS_CALLE_NRO"));
            hoja1.addCell(new jxl.write.Label(4, 1, "IMPORTE FC"));
            hoja1.addCell(new jxl.write.Label(5, 1, "IMPORTE NC"));
            int y = 2;
            int rows = tablaFacturas.getRowCount();
            for (int i = 0; i < rows; i++) {
                hoja1.addCell(new jxl.write.Label(0, y, sdf.format(facturas.get(i).getFecha())));
                int tf = facturas.get(i).getTipoDoc();
                if (tf == 11) {
                    hoja1.addCell(new jxl.write.Label(1, y, "FC"));
                    hoja1.addCell(new jxl.write.Label(4, y, df.format(facturas.get(i).getImporte())));
                    hoja1.addCell(new jxl.write.Label(5, y, df.format(0.0)));
                } else {
                    hoja1.addCell(new jxl.write.Label(1, y, "NC"));
                    hoja1.addCell(new jxl.write.Label(4, y, df.format(0.0)));
                    hoja1.addCell(new jxl.write.Label(5, y, df.format(facturas.get(i).getImporte())));
                }
                hoja1.addCell(new jxl.write.Label(2, y,
                        "C_" + dfs.format(facturas.get(i).getSucursal())
                        + " " + dfn.format(facturas.get(i).getNumero())));
                hoja1.addCell(new jxl.write.Label(3, y, facturas.get(i).getCliente().getRazonSocial()
                        + " " + facturas.get(i).getCliente().getDireccion().getCalle()
                        + " " + facturas.get(i).getCliente().getDireccion().getNumero()));
                y += 1;
            }
        } catch (WriteException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 313");
        } catch (WriteException ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 314");
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
        volver();
    }

    private void llenarCombo() {
        leyendaTxt.setVisible(false);
        combo.removeAllItems();
        combo.addItem("");
        renglones = null;
        try {
            renglones = new RenglonFacturaParaExcelService().getRenglonesFacturaActivosParaExcel();
        } catch (Exception ex) {
            Logger.getLogger(VerFacturasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 435");
            return;
        }
        if(renglones != null && !renglones.isEmpty()){
            for(RenglonFacturaParaExcel re:renglones){
                combo.addItem(re.getTextoCorto());
            }
        }
    }

    private void completarCampos() {
        importeTxt.setText(df.format(renglon.getImporte()));
        leyenda2Txt.setText(renglon.getTexto());
    }
}
