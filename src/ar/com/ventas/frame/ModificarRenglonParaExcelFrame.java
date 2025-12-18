package ar.com.ventas.frame;

import ar.com.ventas.entities.RenglonFacturaParaExcel;
import ar.com.ventas.services.RenglonFacturaParaExcelService;
import ar.com.ventas.utils.Constantes;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ModificarRenglonParaExcelFrame extends javax.swing.JFrame {

    private JPanel contentPanel;
    private RenglonFacturaParaExcel re;
    private DecimalFormat df = new DecimalFormat("#0.00");
    
    public ModificarRenglonParaExcelFrame(RenglonFacturaParaExcel re) {
        initComponents();
        limpiarCampos();
        this.re = re;
        llenarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoTxt = new javax.swing.JTextArea();
        importeTxt = new javax.swing.JTextField();
        textoCortoTxt = new javax.swing.JTextField();
        grabarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        activoChk = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código Rubro:");

        jLabel2.setText("Texto:");

        jLabel3.setText("Importe:");

        codigoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTxt.setText("CODIGO");
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTxtKeyPressed(evt);
            }
        });

        textoTxt.setColumns(20);
        textoTxt.setLineWrap(true);
        textoTxt.setRows(5);
        textoTxt.setAutoscrolls(false);
        textoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoTxtKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(textoTxt);

        importeTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeTxt.setText("IMPORTE");
        importeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importeTxtKeyPressed(evt);
            }
        });

        textoCortoTxt.setText("jTextField1");
        textoCortoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoCortoTxtKeyPressed(evt);
            }
        });

        grabarBtn.setText("Grabar");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });
        grabarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grabarBtnKeyPressed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Texto Corto:");

        activoChk.setText("Activo");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(grabarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(activoChk))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(textoCortoTxt)))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activoChk))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoCortoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grabarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        grabar();
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void codigoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyPressed
        if(evt.getKeyCode()==10){
            if(!codigoTxt.getText().isEmpty()){
                textoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_codigoTxtKeyPressed

    private void textoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoTxtKeyPressed
        if(evt.getKeyCode()==10){
            if(!textoTxt.getText().isEmpty()){
                textoCortoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_textoTxtKeyPressed

    private void importeTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importeTxtKeyPressed
        if(evt.getKeyCode()==10){
            if(!importeTxt.getText().isEmpty()){
                grabarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_importeTxtKeyPressed

    private void textoCortoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCortoTxtKeyPressed
        if(evt.getKeyCode()==10){
            if(!textoCortoTxt.getText().isEmpty()){
                importeTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_textoCortoTxtKeyPressed

    private void grabarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grabarBtnKeyPressed
        if(evt.getKeyCode()==10){
            grabar();
        }
    }//GEN-LAST:event_grabarBtnKeyPressed

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
            java.util.logging.Logger.getLogger(ModificarRenglonParaExcelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarRenglonParaExcelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarRenglonParaExcelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarRenglonParaExcelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarRenglonParaExcelFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoChk;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JButton grabarBtn;
    private javax.swing.JTextField importeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textoCortoTxt;
    private javax.swing.JTextArea textoTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        codigoTxt.setText("");
        textoTxt.setText("");
        importeTxt.setText("");
        textoCortoTxt.setText("");
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        JFrame jFrame = ModificarRenglonParaExcelFrame.this;
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("ABM RENGLONES PARA EXCEL");
        String str0 = "NUEVO RENGLON"; // + " " + str1;
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(contentPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volver();
            }
        });
    }

    private void grabar() {
        if(validar()){
//            RenglonFacturaParaExcel rf = new RenglonFacturaParaExcel();
            Double importe = Double.valueOf(importeTxt.getText().replace(",", "."));
            Integer rubro = Integer.valueOf(codigoTxt.getText());
            re.setActivo(true);
            re.setImporte(importe);
            re.setRubro(rubro);
            re.setTexto(textoTxt.getText());
            re.setTextoCorto(textoCortoTxt.getText());
            try {
                new RenglonFacturaParaExcelService().updateRenglonFacturaParaExcel(re);
                JOptionPane.showMessageDialog(this, "TEXTO GUARDADO");
                volver();
            } catch (Exception ex) {
                Logger.getLogger(ModificarRenglonParaExcelFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 320");
            }
        }
    }

    private void volver() {
        AbmRenglonParaExcelFrame arpef = new AbmRenglonParaExcelFrame();
        arpef.setVisible(true);
        this.dispose();
    }

    private boolean validar() {
        if(codigoTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "INGRESE CODIGO DE RUBRO");
            return false;
        }
        if(textoTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "INGRESE TEXTO AMPLIO PARA EXCEL");
            return false;
        }
        if(textoCortoTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "INGRESE TEXTO CORTO PARA REFERENCIA");
            return false;
        }
        if(importeTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "INGRESE IMPORTE");
            return false;
        }
        return true;
    }

    private void llenarCampos() {
        codigoTxt.setText(re.getRubro().toString());
        textoTxt.setText(re.getTexto());
        textoCortoTxt.setText(re.getTextoCorto());
        importeTxt.setText(df.format(re.getImporte()));
        if(re.getActivo()){
            activoChk.setSelected(true);
        } else {
            activoChk.setSelected(false);
        }
    }
}
