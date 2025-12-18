package ar.com.ventas.main;

import ar.com.ventas.frame.AbmAbonoFrame;
import ar.com.ventas.frame.AbmClienteFrame;
import ar.com.ventas.frame.AbmRenglonAbonoFrame;
import ar.com.ventas.frame.AbmRenglonParaExcelFrame;
import ar.com.ventas.frame.FacturasPorClienteFrame;
import ar.com.ventas.frame.GenerarAbonoFrame;
import ar.com.ventas.frame.GenerarFacturaFrame;
import ar.com.ventas.frame.GenerarNcFrame;
import ar.com.ventas.frame.HabilitarPeriodoPorAbonoFrame;
import ar.com.ventas.frame.ImportarClienteFrame;
import ar.com.ventas.frame.ImpresionFacturasEntreFechasFrame;
import ar.com.ventas.frame.ModificarConfiguracionFrame;
import ar.com.ventas.frame.RecuperarDeAfipFrame;
import ar.com.ventas.frame.TestAfipFrame;
import ar.com.ventas.frame.VerFacturasFrame;
import ar.com.ventas.utils.LectorDeExcel;
import ar.com.ventas.utils.UtilFrame;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salirBtn = new javax.swing.JButton();
        codeBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        abmAbonosMnu = new javax.swing.JMenuItem();
        abmTextoAbonosMnu = new javax.swing.JMenuItem();
        abmClientesMnu = new javax.swing.JMenuItem();
        habilitarPeriodoMnu = new javax.swing.JMenuItem();
        configMnu = new javax.swing.JMenuItem();
        renglonParaExcelMnu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        importarClientesMnu = new javax.swing.JMenuItem();
        crearTablasMnu = new javax.swing.JMenuItem();
        pruebaAfipMnu = new javax.swing.JMenuItem();
        NotaCreditoMnu = new javax.swing.JMenuItem();
        recuperarFcNcDesdeAfipMnu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        facturasMnu = new javax.swing.JMenuItem();
        abonosMnu = new javax.swing.JMenuItem();
        impresionFcMnu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        verFacturasMnu = new javax.swing.JMenuItem();
        facturasPorClienteMnu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        versionMnu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GME - FACTURACION ABONOS");

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        codeBtn.setText("code");
        codeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenu3.setText("ABM");

        abmAbonosMnu.setText("Abonos");
        abmAbonosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmAbonosMnuActionPerformed(evt);
            }
        });
        jMenu3.add(abmAbonosMnu);

        abmTextoAbonosMnu.setText("Renglón Abonos");
        abmTextoAbonosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmTextoAbonosMnuActionPerformed(evt);
            }
        });
        jMenu3.add(abmTextoAbonosMnu);

        abmClientesMnu.setText("Clientes");
        abmClientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmClientesMnuActionPerformed(evt);
            }
        });
        jMenu3.add(abmClientesMnu);

        habilitarPeriodoMnu.setText("Habilitar Período");
        habilitarPeriodoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPeriodoMnuActionPerformed(evt);
            }
        });
        jMenu3.add(habilitarPeriodoMnu);

        configMnu.setText("Configuración");
        configMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configMnuActionPerformed(evt);
            }
        });
        jMenu3.add(configMnu);

        renglonParaExcelMnu.setText("Renglon Para Excel");
        renglonParaExcelMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renglonParaExcelMnuActionPerformed(evt);
            }
        });
        jMenu3.add(renglonParaExcelMnu);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Herramientas");

        importarClientesMnu.setText("Importar Clientes");
        importarClientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarClientesMnuActionPerformed(evt);
            }
        });
        jMenu2.add(importarClientesMnu);

        crearTablasMnu.setText("Crear Tablas");
        crearTablasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearTablasMnuActionPerformed(evt);
            }
        });
        jMenu2.add(crearTablasMnu);

        pruebaAfipMnu.setText("Prueba Afip");
        pruebaAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaAfipMnuActionPerformed(evt);
            }
        });
        jMenu2.add(pruebaAfipMnu);

        NotaCreditoMnu.setText("Nota De Crédito");
        NotaCreditoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotaCreditoMnuActionPerformed(evt);
            }
        });
        jMenu2.add(NotaCreditoMnu);

        recuperarFcNcDesdeAfipMnu.setText("Recuperar Fc/Nc de Afip");
        recuperarFcNcDesdeAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperarFcNcDesdeAfipMnuActionPerformed(evt);
            }
        });
        jMenu2.add(recuperarFcNcDesdeAfipMnu);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Procesos");

        facturasMnu.setText("Facturas");
        facturasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasMnuActionPerformed(evt);
            }
        });
        jMenu4.add(facturasMnu);

        abonosMnu.setText("Abonos");
        abonosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonosMnuActionPerformed(evt);
            }
        });
        jMenu4.add(abonosMnu);

        impresionFcMnu.setText("Impresion Facturas e/Fechas");
        impresionFcMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impresionFcMnuActionPerformed(evt);
            }
        });
        jMenu4.add(impresionFcMnu);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Informes");

        verFacturasMnu.setText("Ver Facturas");
        verFacturasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFacturasMnuActionPerformed(evt);
            }
        });
        jMenu5.add(verFacturasMnu);

        facturasPorClienteMnu.setText("Facturas x Cliente");
        facturasPorClienteMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasPorClienteMnuActionPerformed(evt);
            }
        });
        jMenu5.add(facturasPorClienteMnu);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("?");

        versionMnu.setText("Version");
        versionMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionMnuActionPerformed(evt);
            }
        });
        jMenu6.add(versionMnu);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salirBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(codeBtn)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(codeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(salirBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        salir();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void abmAbonosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmAbonosMnuActionPerformed
        abmAbonos();
    }//GEN-LAST:event_abmAbonosMnuActionPerformed

    private void abmTextoAbonosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmTextoAbonosMnuActionPerformed
        abmTextoAbonos();
    }//GEN-LAST:event_abmTextoAbonosMnuActionPerformed

    private void abmClientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmClientesMnuActionPerformed
        abmClientes();
    }//GEN-LAST:event_abmClientesMnuActionPerformed

    private void importarClientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarClientesMnuActionPerformed
        importarClientes();
    }//GEN-LAST:event_importarClientesMnuActionPerformed

    private void crearTablasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearTablasMnuActionPerformed
        crearTablas();
    }//GEN-LAST:event_crearTablasMnuActionPerformed

    private void verFacturasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFacturasMnuActionPerformed
        verFacturas();
    }//GEN-LAST:event_verFacturasMnuActionPerformed

    private void versionMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionMnuActionPerformed
        version();
    }//GEN-LAST:event_versionMnuActionPerformed

    private void facturasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasMnuActionPerformed
        facturas();
    }//GEN-LAST:event_facturasMnuActionPerformed

    private void abonosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonosMnuActionPerformed
        abonos();
    }//GEN-LAST:event_abonosMnuActionPerformed

    private void impresionFcMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impresionFcMnuActionPerformed
        impresionFc();
    }//GEN-LAST:event_impresionFcMnuActionPerformed

    private void pruebaAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaAfipMnuActionPerformed
        TestAfipFrame taf = new TestAfipFrame();
        taf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pruebaAfipMnuActionPerformed

    private void habilitarPeriodoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPeriodoMnuActionPerformed
        habilitarPeriodo();
    }//GEN-LAST:event_habilitarPeriodoMnuActionPerformed

    private void configMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMnuActionPerformed
        configuracion();
    }//GEN-LAST:event_configMnuActionPerformed

    private void NotaCreditoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotaCreditoMnuActionPerformed
        nc();
    }//GEN-LAST:event_NotaCreditoMnuActionPerformed

    private void recuperarFcNcDesdeAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperarFcNcDesdeAfipMnuActionPerformed
        recuperar();
    }//GEN-LAST:event_recuperarFcNcDesdeAfipMnuActionPerformed

    private void facturasPorClienteMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasPorClienteMnuActionPerformed
        fc_x_cliente();
    }//GEN-LAST:event_facturasPorClienteMnuActionPerformed

    private void codeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeBtnActionPerformed
        code();
    }//GEN-LAST:event_codeBtnActionPerformed

    private void renglonParaExcelMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renglonParaExcelMnuActionPerformed
        renglonExcel();
    }//GEN-LAST:event_renglonParaExcelMnuActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem NotaCreditoMnu;
    private javax.swing.JMenuItem abmAbonosMnu;
    private javax.swing.JMenuItem abmClientesMnu;
    private javax.swing.JMenuItem abmTextoAbonosMnu;
    private javax.swing.JMenuItem abonosMnu;
    private javax.swing.JButton codeBtn;
    private javax.swing.JMenuItem configMnu;
    private javax.swing.JMenuItem crearTablasMnu;
    private javax.swing.JMenuItem facturasMnu;
    private javax.swing.JMenuItem facturasPorClienteMnu;
    private javax.swing.JMenuItem habilitarPeriodoMnu;
    private javax.swing.JMenuItem importarClientesMnu;
    private javax.swing.JMenuItem impresionFcMnu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem pruebaAfipMnu;
    private javax.swing.JMenuItem recuperarFcNcDesdeAfipMnu;
    private javax.swing.JMenuItem renglonParaExcelMnu;
    private javax.swing.JButton salirBtn;
    private javax.swing.JMenuItem verFacturasMnu;
    private javax.swing.JMenuItem versionMnu;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        int escape = JOptionPane.showConfirmDialog(null, "CONFIRME SALIR DEL SISTEMA", "Atención - salir de SISTEMA", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            System.exit(0);
        }
    }

    private void abmAbonos() {
        AbmAbonoFrame aaf = new AbmAbonoFrame();
        aaf.setVisible(true);
        this.dispose();
    }

    private void abmTextoAbonos() {
        AbmRenglonAbonoFrame atf = new AbmRenglonAbonoFrame();
        atf.setVisible(true);
        this.dispose();
    }

    private void abmClientes() {
        AbmClienteFrame acf = new AbmClienteFrame();
        acf.setVisible(true);
        this.dispose();
    }

    private void importarClientes() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarClienteFrame icf = new ImportarClienteFrame(archivo);
                icf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void crearTablas() {
        CrearTablasFrame ctf = new CrearTablasFrame();
        ctf.setVisible(true);
        this.dispose();
    }

    private void verFacturas() {
        VerFacturasFrame vff = new VerFacturasFrame();
        vff.setVisible(true);
        this.dispose();
    }

    private void version() {
        VersionFrame vf = new VersionFrame();
        vf.setVisible(true);
        this.dispose();
    }

    private void facturas() {
        GenerarFacturaFrame ff = new GenerarFacturaFrame();
        ff.setVisible(true);
        this.dispose();
    }

    private void abonos() {
        GenerarAbonoFrame af = new GenerarAbonoFrame();
        af.setVisible(true);
        this.dispose();
    }

    private void impresionFc() {
        ImpresionFacturasEntreFechasFrame ifeff = new ImpresionFacturasEntreFechasFrame();
        ifeff.setVisible(true);
        this.dispose();
    }

    private void habilitarPeriodo() {
        HabilitarPeriodoPorAbonoFrame hpxaf = new HabilitarPeriodoPorAbonoFrame();
        hpxaf.setVisible(true);
        this.dispose();
    }

    private void configuracion() {
        ModificarConfiguracionFrame mcf = new ModificarConfiguracionFrame();
        mcf.setVisible(true);
        this.dispose();
    }

    private void nc() {
        GenerarNcFrame nc = new GenerarNcFrame();
        nc.setVisible(true);
        this.dispose();
    }

    private void recuperar() {
        RecuperarDeAfipFrame rdaf = new RecuperarDeAfipFrame();
        rdaf.setVisible(true);
        this.dispose();
    }

    private void fc_x_cliente() {
        FacturasPorClienteFrame fxcf = new FacturasPorClienteFrame();
        fxcf.setVisible(true);
        this.dispose();
    }

    private void code() {
        File fi = new File("d://qrafip.png");
        try {
            String str = UtilFrame.decoder(fi);
            System.out.println(str);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

//        String codigo = "eyJ2ZXIiOjEsImZlY2hhIjoiMjAyMi0wNy0wNCIsImN1aXQiOjIwMTQyNTUzMjAyLCJwdG9WdGEiOjgsInRpcG9DbXAiOjEzLCJucm9DbXAiOjEsImltcG9ydGUiOjQ2MDEsIm1vbmVkYSI6IlBFUyIsImN0eiI6MSwidGlwb0RvY1JlYyI6ODAsIm5yb0RvY1JlYyI6MzA2MDY2MjMwOTMsInRpcG9Db2RBdXQiOiJFIiwiY29kQXV0Ijo3MjI3Mjk1NDQzNTY5NH0=";
        String codigo = "eyJ2ZXIiOjEsImZlY2hhIjoiMjAyMi0wNy0wMSIsImN1aXQiOjIwMTQyNTUzMjAyLCJwdG9WdGEiOjYsInRpcG9DbXAiOjExLCJucm9DbXAiOjI3OTUsImltcG9ydGUiOjI4MjAwMCwibW9uZWRhIjoiUEVTIiwiY3R6IjoxLCJ0aXBvRG9jUmVjIjo4MCwibnJvRG9jUmVjIjozMDYwNjYyMzA5MywidGlwb0NvZEF1dCI6IkUiLCJjb2RBdXQiOjcyMjYyNjYwMzI0MTE1fQ==";
        //               eyJ2ZXIiOjEsImZlY2hhIjoiMjAyMi0wNy0wMSIsImN1aXQiOjIwMTQyNTUzMjAyLCJwdG9WdGEiOjYsInRpcG9DbXAiOjExLCJucm9DbXAiOjI3ODksImltcG9ydGUiOjI4MjAwMCwibW9uZWRhIjoiUEVTIiwiY3R6IjoxLCJ0aXBvRG9jUmVjIjo4MCwibnJvRG9jUmVjIjozMDY3Nzg1Mjk0OCwidGlwb0NvZEF1dCI6IkUiLCJjb2RBdXQiOjcyMjYyNjYwMzE0MDMxfQ==
        try {
            byte[] by2 = codigo.getBytes("UTF-8");
            byte[] decoded = Base64.getDecoder().decode(codigo);
            String decodedMsg = new String(decoded);
            System.out.println("Decoded Message " + decodedMsg);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void renglonExcel() {
        AbmRenglonParaExcelFrame arpef = new AbmRenglonParaExcelFrame();
        arpef.setVisible(true);
        this.dispose();
    }

}
