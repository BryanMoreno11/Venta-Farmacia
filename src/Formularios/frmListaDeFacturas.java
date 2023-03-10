/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Controlador.ClienteDAO;
import Controlador.FacturaDAO;
import Entidades.Cliente;
import Entidades.Factura;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class frmListaDeFacturas extends javax.swing.JFrame {

    /**
     * Creates new form frmListaDeFacturas
     */
    public frmListaDeFacturas() {
        initComponents();
        setSize(610,630);
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Imagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNUMFAC = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblSUBTOTAL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/backgrounHEader.png"))); // NOI18N
        jPanel1.add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Venta de Insumos MÉDICOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NÚMERO DE FACTURA:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblNUMFAC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblNUMFAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 250, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 270, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Localidad:");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Correo:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 130, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Fecha:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 130, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 560, 80));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 560, 170));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("IVA:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, -1, -1));
        jPanel1.add(lblIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("SUBTOTAL:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, -1, -1));
        jPanel1.add(lblSUBTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("TOTAL:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, -1, -1));
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 600, 550));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ingrese cedula de persona a consultar:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 130, -1));

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 100, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void ColocarDatos(int ID){
        FacturaDAO dao = new FacturaDAO();
        ClienteDAO cliDao = new ClienteDAO();
        String fecha = dao.getFecha(dao.ListarFactura(), ID);
        jTextField5.setText(fecha);
        String nombre = dao.getNombre(dao.ListarFactura(), ID);
        System.out.println("nombre = " + nombre);
        Cliente cli = cliDao.getCliente(cliDao.ListarCliente(), nombre);
        System.out.println(cli.getNombre());
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField5.setEditable(false);
        jTextField1.setText(cli.getNombre()+" "+cli.getApellido());
        jTextField2.setText(cli.getCiudad()+" "+cli.getProvincia());
        jTextField3.setText(cli.getCorreo());
        lblNUMFAC.setText("#000"+ID);
    }
    
    public Date ConseguirDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaRes=null;
        try {
            fechaRes = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaRes;
    }
    
    public void valoresEnLabels() {
        double total = 0;
        for (int i = (jTable1.getRowCount())-1; i >= 0; i--) {
            System.out.println("i = " + i);
            total += Double.parseDouble(jTable1.getValueAt(i, 4).toString());
        }
        DecimalFormat df = new DecimalFormat("##.00");
        double iva = total*0.12;
        double sub = total-iva;
        lblIVA.setText(df.format(iva)+" $");
        lblSUBTOTAL.setText(df.format(sub)+" $");
        lblTotal.setText(df.format(total)+" $");
    }
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!(jTextField4.getText().equals(""))) {
            FacturaDAO dao = new FacturaDAO();
            ClienteDAO cliDao = new ClienteDAO();
            int idConsulta = Integer.parseInt(jTextField4.getText());
            if (cliDao.verificarExistencia(cliDao.ListarCliente(), idConsulta) == true) {
                if (dao.existenciaCliente(dao.ListarFactura(), idConsulta) == true) {
                    valoresAComboBox(dao.ListarFactura(), idConsulta);
                    valoresEnLabels();
                } else {
                    JOptionPane.showMessageDialog(null, "La cedula ingresada no cuenta con facturas", "Cedula", JOptionPane.INFORMATION_MESSAGE);
                    jTextField4.setText(valorBase);
                }                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese cedula a consultar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (jComboBox1.getItemCount() != 0) {
            FacturaDAO dao = new FacturaDAO();
            int idVen = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            DefaultTableModel dt = dao.MostrarTablaFacturaPorID(dao.ListarFactura(), idVen);
            jTable1.setModel(dt);
            ColocarDatos(idVen);
            valoresEnLabels();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public String valorBase;
    public void valoresAComboBox(List<Factura> Facturas, int res) {
        valorBase =jTextField4.getText();
        ClienteDAO cliDao = new ClienteDAO();
        int valor = 0;
        if(jComboBox1.getItemCount()!=0){
            jComboBox1.removeAllItems();
        }
        for (int i = 0; i < Facturas.size(); i++) {
            //Crear metodo de validadicón de cedulas
            if (Facturas.get(i).getNombre().equals(cliDao.NombrePorCedula(cliDao.ListarCliente(), res))) {
                if (Facturas.get(i).getIdVenta() != valor) {
                    jComboBox1.addItem("000" + Facturas.get(i).getIdVenta());
                    valor = Facturas.get(i).getIdVenta();
                } else {
                    valor = Facturas.get(i).getIdVenta();
                }
            }

        }
    }

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
            java.util.logging.Logger.getLogger(frmListaDeFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListaDeFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListaDeFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListaDeFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmListaDeFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblNUMFAC;
    private javax.swing.JLabel lblSUBTOTAL;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
