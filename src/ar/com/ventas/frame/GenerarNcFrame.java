package ar.com.ventas.frame;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Factura;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.FacturaService;
import ar.com.ventas.services.RenglonFacturaService;
import ar.com.ventas.services.TicketTimeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class GenerarNcFrame extends javax.swing.JFrame {

    private TicketTime tkt = null;
    private String token;
    private String sign;
    private String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
    private String userdir = "c:/certifmario";
    private String excepcion = "";
    private ActiveXComponent wsaa;
    private List<Cliente> clientes = null;
    private Integer hora = 0, minutos = 0, segundos = 0;
    private Date fecha;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String tipoComprob;
    private final DecimalFormat df = new DecimalFormat("#0.00");
    private String numeroFacturaPapel = "";
    private final String letraFacturaPapel = "L";
    private String sucursalFacturaPapel = "0";
    private String numCae = "";
    private String vencCae = "";
    private Integer comprobanteNumero = 0;

    public GenerarNcFrame() {
        initComponents();
        fechaTxt.setText(sdf.format(new Date()));
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        generarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        importeNcTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nroRefFcTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha Nc:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("jTextField1");

        generarBtn.setText("Generar");
        generarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Importe Nc:");

        importeNcTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeNcTxt.setText("jTextField1");

        jLabel3.setText("Nro fc Ref:");

        nroRefFcTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nroRefFcTxt.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(generarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importeNcTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(fechaTxt)
                            .addComponent(nroRefFcTxt))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(importeNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nroRefFcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(generarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void generarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarBtnActionPerformed
        generar();
    }//GEN-LAST:event_generarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(GenerarNcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarNcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarNcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarNcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarNcFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton generarBtn;
    private javax.swing.JTextField importeNcTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nroRefFcTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void generar() {
        int numf = 0;
        int suc = 6;
        clientes = null;
        try {
            clientes = new ClienteService().getAllClientes();
        } catch (Exception ex) {
            Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 221");
            return;
        }
        Long id = 1L;
        Configuracion config = null;
        try {
            config = new ConfiguracionService().getConfiguracionById(id);
        } catch (Exception ex) {
            Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 230");
            return;
        }
        numf += config.getNumeroNc();
//        System.out.println(numf);
//        System.exit(0);
        if (clientes != null && !clientes.isEmpty()) {
            Double importeAbono;
            for (Cliente cli : clientes) {
                if (cli.getActivo()) {
                    if (cli.getAbono() != null) {
                        String td_f = "11";
                        String pv = "6";
                        String nc = nroRefFcTxt.getText();
                        if (!cli.getGenerado()) {
                            Factura fc = new Factura();
                            // presentacion web
                            try {
                                LibraryLoader.loadJacobLibrary();
                                wsaa = new ActiveXComponent("WSAA");
                                System.out.println(Dispatch.get(wsaa, "InstallDir").toString()
                                        + " "
                                        + Dispatch.get(wsaa, "Version").toString()
                                );
                                Calendar cal = Calendar.getInstance();
                                fecha = cal.getTime();
                                hora = cal.get(Calendar.HOUR_OF_DAY);
                                minutos = cal.get(Calendar.MINUTE);
                                segundos = cal.get(Calendar.SECOND);
                                tkt = new TicketTimeService().getTicketById(1L);
                                if (fecha != tkt.getFecha()) {
                                    solicitarNuevoTicket();
                                } else if (hora != tkt.getHora()) {
                                    if (hora == tkt.getHora() + 1) {
                                        if (minutos > tkt.getMinuto()) {
                                            solicitarNuevoTicket();
                                        } else {
                                            int xMinuto = 60 - tkt.getMinuto();
                                            if ((xMinuto + minutos) > 30) {
                                                solicitarNuevoTicket();
                                            }
                                        }
                                    } else {
                                        solicitarNuevoTicket();
                                    }
                                } else if (minutos - tkt.getMinuto() > 30) {
                                    solicitarNuevoTicket();
                                }
                                ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
                                Dispatch.put(wsfev1, "Cuit", new Variant("20142553202"));
                                Dispatch.put(wsfev1, "Token", new Variant(token));
                                Dispatch.put(wsfev1, "Sign", new Variant(sign));
                                String cache = "";
                                wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL";
                                Dispatch.call(wsfev1, "Conectar",
                                        new Variant(cache),
                                        new Variant(wsdl)
                                );
                                String tipo_cbte = "13";
                                tipoComprob = tipo_cbte;
                                String pto_vta = "6"; // Sucursal declarada WS
                                sucursalFacturaPapel = "0006";
                                Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                                        new Variant(tipo_cbte),
                                        new Variant(pto_vta));
                                excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                                System.out.println(wsfev1);
                                JOptionPane.showMessageDialog(this, "Ult.Comprb." + ult.toString());
                                System.out.println("Ult.Comprb." + ult.toString());
                                comprobanteNumero = Integer.parseInt(ult.toString());

                                JOptionPane.showMessageDialog(this, "VERSION");
                                if (numf != comprobanteNumero) {
                                    JOptionPane.showMessageDialog(this, "No coinciden los numeros");
                                    return;
                                }
                                numf += 1;
                                comprobanteNumero += 1;
                                JOptionPane.showMessageDialog(this, numf);
                                String fechaWs = new SimpleDateFormat("yyyyMMdd").format(new Date());
                                String concepto = "1";// producto 
                                String cui = cli.getCuit();
                                String cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
                                String tipoD = String.valueOf(cli.getTipoDoc());
                                String tipo_doc = tipoD, nro_doc = cuit1; //tipo y numero
                                int cbte_nro = Integer.parseInt(ult.toString()) + 1,
                                        cbt_desde = cbte_nro,
                                        cbt_hasta = cbte_nro;
                                numeroFacturaPapel = String.valueOf(cbte_nro);
                                int largo = ("00000000" + numeroFacturaPapel).length();
                                numeroFacturaPapel = ("00000000" + numeroFacturaPapel).substring(largo - 8, largo);
                                //Double importeAbono = cli.getAbono().getImporte();
                                importeAbono = Double.valueOf(importeNcTxt.getText());
                                String imp_total = df.format(importeAbono).toString().replaceAll("\\,", "\\.");//"124.00";
                                String imp_tot_conc = "0";
                                String imp_neto = df.format(importeAbono).toString().replaceAll("\\,", "\\.");
                                String imp_iva = "0";
                                //int internos = 0;
                                String imp_trib = "0", imp_op_ex = "0";
                                String fecha_cbte = fechaWs, fecha_venc_pago = "";
                                String fecha_serv_desde = "", fecha_serv_hasta = "";
                                String moneda_id = "PES", moneda_ctz = "1.000";
                                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                                        new Variant(concepto), new Variant(tipo_doc),
                                        new Variant(nro_doc), new Variant(tipo_cbte),
                                        new Variant(pto_vta),
                                        new Variant(cbt_desde), new Variant(cbt_hasta),
                                        new Variant(imp_total), new Variant(imp_tot_conc),
                                        new Variant(imp_neto), new Variant(imp_iva),
                                        new Variant(imp_trib), new Variant(imp_op_ex),
                                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                                        new Variant(moneda_id), new Variant(moneda_ctz));

//                 Agrego los comprobantes asociados: 
//                            if (false) { // solo nc/nd 
                                Variant cbte_asoc_tipo = new Variant(td_f),
                                        cbte_asoc_pto_vta = new Variant(pv),
                                        cbte_asoc_nro = new Variant(nc);
                                Dispatch.call(wsfev1, "AgregarCmpAsoc",
                                        cbte_asoc_tipo, cbte_asoc_pto_vta, cbte_asoc_nro);
                                Dispatch.put(wsfev1, "Reprocesar", new Variant(false));
                                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                                excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                                String obs = Dispatch.get(wsfev1, "Obs").toString();
                                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                                if (!resultado.equals("A")) {
                                    JOptionPane.showMessageDialog(this, "Obs: " + obs + "\nError: " + errmsg);
                                    return;
                                }
                                if (vto != "" && vto != null) {
                                    vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                                }
                                numCae = cae.toString();
                                String ruta1 = "c:/comprobMario/" + tipoComprob
                                        + letraFacturaPapel + sucursalFacturaPapel
                                        + numeroFacturaPapel + ".xm1";
                                String ruta2 = "c:/comprobMario/" + tipoComprob
                                        + letraFacturaPapel + sucursalFacturaPapel
                                        + numeroFacturaPapel + ".xm2";
                                File archivo1 = new File(ruta1);
                                File archivo2 = new File(ruta2);
                                BufferedWriter bw1, bw2;
                                bw1 = new BufferedWriter(new FileWriter(archivo1));
                                bw2 = new BufferedWriter(new FileWriter(archivo2));
                                bw1.write(requ);
                                bw2.write(resp);
                                bw1.close();
                                bw2.close();
                                int x = 0;
                                Integer suma1 = 0;
                                Integer suma2 = 0;
                                String cadena = cuit1 + "0" + tipo_cbte + "0006" + cae + vto;
                                for (int i = 0; i < 39; i++) {
                                    if (x == 0) {
                                        int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                                        suma1 += num;
                                        x = 1;
                                    } else {
                                        int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                                        suma2 += num;
                                        x = 0;
                                    }
                                }
                                suma1 = suma1 * 3;
                                int total = suma1 + suma2;
                                int dv = (int) (rint(total / 10 + .9) * 10);
                                dv = dv - total;
                                cadena += String.valueOf(dv);
                                config.setNumeroNc(numf);
                                cli.setGenerado(true);
                                new ClienteService().updateCliente(cli);
                                new ConfiguracionService().updateConfiguracion(config);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(this, e);
                                e.printStackTrace();
                                return;
                            }

                            // fin presentacion web
                            try {
                                fc.setFecha(sdf.parse(fechaTxt.getText()));
                            } catch (ParseException ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 409");
                                return;
                            }
                            fc.setCae(Long.valueOf(numCae));
                            fc.setCliente(cli);
                            fc.setTipoDoc(13);
                            try {
                                fc.setFechaVencimCae(sdf.parse(vencCae));
                            } catch (ParseException ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 419");
                                return;
                            }
                            fc.setImporte(importeAbono);
                            fc.setNumero(comprobanteNumero);
                            fc.setSucursal(suc);
                            Integer nc_in = Integer.valueOf(nc);
                            fc.setNumeroReferencia(nc_in);
                            Factura fc2 = null;
                            try {
                                fc2 = new FacturaService().saveFactura(fc);
                            } catch (Exception ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 436");
                                return;
                            }
                            try {
                                config = new ConfiguracionService().getConfiguracionById(id);
                            } catch (Exception ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 443");
                                return;
                            }
                            Integer numero = Integer.valueOf(nroRefFcTxt.getText());
                            Factura fac = null;
                            // es 1 porque son Fc si es 2 es 13 Nota de Credito
                            try {
                                fac = new FacturaService().getFacturasByNro(numero, 1);
                            } catch (Exception ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 441");
                                return;
                            }
                            List<RenglonFactura> renglones = null;
                            try {
                                renglones = new RenglonFacturaService().getRenglonFacturasByFactura(fac);
                            } catch (Exception ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 449");
                                return;
                            }
                            if (renglones != null && !renglones.isEmpty()) {
                                for (RenglonFactura rf : renglones) {
                                    RenglonFactura re = new RenglonFactura();
                                    re.setFactura(fc2);
                                    re.setOrden(rf.getOrden());
                                    re.setImporte(rf.getImporte());
                                    re.setTexto(rf.getTexto());
                                    try {
                                        new RenglonFacturaService().saveRenglonFactura(re);
                                    } catch (Exception ex) {
                                        Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                        JOptionPane.showMessageDialog(this, "ERROR grabando renglones_NC");
                                        return;
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "NO se recuperaron los RENGLONES");
                                return;
                            }
                            config.setNumeroNc(numf);
                            try {
                                config = new ConfiguracionService().updateConfiguracion(config);
                            } catch (Exception ex) {
                                Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR Nro. 221");
                                return;
                            }
                        }
                    }
                }
//                int a = JOptionPane.showConfirmDialog(this,
//                         "Desea cancelar?\n¿Confirma la operación?",
//                        "Confirmar", JOptionPane.OK_CANCEL_OPTION);
//                if (a == 0) {
//                    break;
//                }
            }
            volver();
        }
    }

    private void solicitarNuevoTicket() {
        Dispatch.call(wsaa, "Autenticar",
                new Variant("wsfe"),
                //                new Variant(userdir + "/prodmario_2a9f20acca9d53c0.crt"),
                //                new Variant(userdir + "/clave.key"),
                new Variant(userdir + "/MARIO2020_484132ab2d5e5665.crt"),
                new Variant(userdir + "/clave_privada_20142553202_202010295426.key"),
                new Variant(wsdl));
        excepcion = Dispatch.get(wsaa, "Excepcion").toString();
        token = Dispatch.get(wsaa, "Token").toString();
        sign = Dispatch.get(wsaa, "Sign").toString();
        tkt.setFecha(fecha);
        tkt.setHora(hora);
        tkt.setMinuto(minutos);
        tkt.setSegundo(segundos);
        try {
            new TicketTimeService().updateTicket(tkt);
        } catch (Exception ex) {
            Logger.getLogger(GenerarNcFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo guardar nuevo Ticket");
        }
    }

    private void limpiarCampos() {
        importeNcTxt.setText("");
        nroRefFcTxt.setText("");
        fechaTxt.requestFocus();
    }
}
