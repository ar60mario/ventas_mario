package ar.com.ventas.frame;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.AbonoService;
import ar.com.ventas.services.ClienteService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbmClienteFrame extends javax.swing.JFrame {

    private List<Cliente> clientes = null;
    private List<Abono> abonos;

    public AbmClienteFrame() {
        initComponents();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        nuevoBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        habilitarPeriodoBtn = new javax.swing.JButton();
        bloquearPeriodoBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        aplicarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "R.S.", "Dirección", "CUI", "ABONO", "Mau", "Período Hab.", "Abono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(160);
            tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
            tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(40);
            tablaClientes.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        habilitarPeriodoBtn.setText("Habilitar Período");
        habilitarPeriodoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPeriodoBtnActionPerformed(evt);
            }
        });

        bloquearPeriodoBtn.setText("Bloquear Período");
        bloquearPeriodoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloquearPeriodoBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Abono");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        aplicarBtn.setText("Aplicar");
        aplicarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(habilitarPeriodoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(bloquearPeriodoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aplicarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(nuevoBtn)
                    .addComponent(modificarBtn)
                    .addComponent(habilitarPeriodoBtn)
                    .addComponent(bloquearPeriodoBtn)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aplicarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        nuevo();
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        modificar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void habilitarPeriodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPeriodoBtnActionPerformed
        habilitarPeriodo();
    }//GEN-LAST:event_habilitarPeriodoBtnActionPerformed

    private void bloquearPeriodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloquearPeriodoBtnActionPerformed
        bloquear();
    }//GEN-LAST:event_bloquearPeriodoBtnActionPerformed

    private void aplicarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarBtnActionPerformed
        int rowT = tablaClientes.getSelectedRow();
        if (rowT >= 0) {
            int rowC = combo.getSelectedIndex();
            if (rowC > 0) {
                rowC -= 1;
                Cliente cli = clientes.get(rowT);
                Abono ab = abonos.get(rowC);
                cli.setAbono(ab);
                try {
                    new ClienteService().updateCliente(cli);
                } catch (Exception ex) {
                    Logger.getLogger(AbmClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_aplicarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AbmClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmClienteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicarBtn;
    private javax.swing.JButton bloquearPeriodoBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton habilitarPeriodoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void llenarTabla() {
        limpiarTabla();
        clientes = null;
        try {
            clientes = new ClienteService().getAllClientes();
        } catch (Exception ex) {
            Logger.getLogger(AbmClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clientes != null && !clientes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaClientes.getModel();
            for (Cliente cli : clientes) {
                Object ob[] = new Object[8];
                ob[0] = cli.getCodigo();
                ob[1] = cli.getRazonSocial();
                ob[2] = cli.getDireccion().getCalle() + " " + cli.getDireccion().getNumero();
                ob[3] = cli.getCuit();
                if (cli.getAbono() != null) {
                    ob[4] = "SI";
                } else {
                    ob[4] = "NO";
                }
                ob[5] = cli.getCodigoMauro();
                if (cli.getGenerado()) {
                    ob[6] = "Generado";
                } else {
                    ob[6] = "Habilitado";
                }
                if (cli.getAbono() != null) {
                    ob[7] = cli.getAbono().getDetalle();
                }
                tbl.addRow(ob);
            }
            tablaClientes.setModel(tbl);
        }
        abonos = null;
        try {
            abonos = new AbonoService().getAllAbonos();
        } catch (Exception ex) {
            Logger.getLogger(AbmClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        combo.removeAllItems();
        combo.addItem("");
        if (abonos != null && !abonos.isEmpty()) {
            for (Abono ab : abonos) {
                combo.addItem(ab.getDetalle());
            }
        }
    }

    private void nuevo() {
        NuevoClienteFrame ncf = new NuevoClienteFrame();
        ncf.setVisible(true);
        this.dispose();
    }

    private void modificar() {
        int row = tablaClientes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecciones un cliente");
            return;
        }
        ModificarClienteFrame mcf = new ModificarClienteFrame(clientes.get(row));
        mcf.setVisible(true);
        this.dispose();
    }

    private void habilitarPeriodo() {
        int row = tablaClientes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione 1 Cliente");
            return;
        }
        int a = JOptionPane.showConfirmDialog(this, "Confirme Habilitar Período", "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            Cliente c = clientes.get(row);
            c.setGenerado(false);
            try {
                new ClienteService().updateCliente(c);
            } catch (Exception ex) {
                Logger.getLogger(AbmClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenarTabla();
        }
    }

    private void bloquear() {
        int row = tablaClientes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione 1 Cliente");
            return;
        }
        int a = JOptionPane.showConfirmDialog(this, "Confirme Habilitar Período", "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            Cliente c = clientes.get(row);
            c.setGenerado(true);
            try {
                new ClienteService().updateCliente(c);
            } catch (Exception ex) {
                Logger.getLogger(AbmClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenarTabla();
        }
    }

    private void limpiarTabla() {
        int rows = tablaClientes.getRowCount();
        if (rows > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tablaClientes.getModel();
            for (int i = 0; i < rows; i++) {
                tbl.removeRow(0);
            }
            tablaClientes.setModel(tbl);
        }
    }
}
