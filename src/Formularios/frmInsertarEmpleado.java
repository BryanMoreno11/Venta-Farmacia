/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Controlador.CargoDAO;
import Controlador.EmpleadosDAO;
import Entidades.Cargo;
import Entidades.Empleados;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class frmInsertarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form frmInsertarEmpleado
     */
    
    public String funcion;
    public frmInsertarEmpleado(String f) {
        initComponents();
        setSize(600,600);
        funcion=f;
        setLocationRelativeTo(this);
        MostrarCargosCombo();
        GenerarSerieEmpleados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Insertar Empleado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLabel2.setText("ID Empleado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 280, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 280, -1));

        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 280, -1));

        jLabel5.setText("Edad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, 10));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 280, -1));

        jLabel6.setText("Cargo:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 270, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/frmInsertar.png"))); // NOI18N
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCargoEntrando.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/frmInsertarPresionar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 180, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCargoEntrando.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPresionado.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 180, 30));

        jLabel7.setText("Sexo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jRadioButton1.setText("M");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        jRadioButton2.setText("F");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jLabel8.setText("Provincia:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, 20));

        jLabel9.setText("Ciudad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jTextField5.setToolTipText("");
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 270, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void SetDatos(Empleados emp){
        CargoDAO car =new CargoDAO();
        jTextField1.setText(String.valueOf(emp.getIdEmpleados()));
        jTextField1.setEditable(true);
        jTextField2.setText(emp.getNombre());
        jTextField3.setText(emp.getApellido());
        jTextField4.setText(String.valueOf(emp.getEdad()));        
        if(emp.getSexo().equals("M")){
            jRadioButton1.setSelected(true);
        }
        if(emp.getSexo().equals("F")){
            jRadioButton2.setSelected(true);
        }
        jTextField6.setText(emp.getProvincia());
        jTextField5.setText(emp.getCiudad());
        String cargo = car.ColocarCargo(car.ListarCargo(), emp.getId_Cargo());
        int idCargo = car.ValorCargo(car.ListarCargo(), cargo);
        jComboBox1.setSelectedIndex(car.PosicionCargo(car.ListarCargo(), idCargo)+1);
//        Cargo obc = (Cargo) cargo;        
    }
    
    
    public void GenerarSerieEmpleados(){
        EmpleadosDAO dao = new EmpleadosDAO();
        int serie = dao.NumeroSerie();
        if(serie==0){
            jTextField1.setText(String.valueOf(1));
        }
        else{
            int inc = serie+1;
            jTextField1.setText(String.valueOf(inc));
            jTextField1.setEditable(false);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean a = false;
        if (jRadioButton1.isSelected() || jRadioButton2.isSelected()) {
            a = true;
        }
        if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField4.getText().equals("") && !jTextField5.getText().equals("") && !jTextField6.getText().equals("") && jComboBox1.getSelectedIndex()!=0 && a == true) {
            int IdEmpleado = Integer.parseInt(jTextField1.getText());
            String nom = jTextField2.getText();
            String ape = jTextField3.getText();
            int ed = Integer.parseInt(jTextField4.getText());
            Cargo car = (Cargo) jComboBox1.getSelectedItem();
            int idCar = car.getIdCargo();
            String sex = "";
            if (jRadioButton1.isSelected()) {
                sex = "M";
            }
            if (jRadioButton2.isSelected()) {
                sex = "F";
            }
            String pro = jTextField6.getText();
            String ciu = jTextField5.getText();
            Empleados emp = new Empleados(IdEmpleado, nom, ape, ed, sex, pro, ciu, idCar);
            EmpleadosDAO dao = new EmpleadosDAO();
            if (funcion.equals("Insertar")) {
                dao.InsertarEmpleados(emp);
                JOptionPane.showMessageDialog(null, "Empleado ingresado existosamente","Empleado registrado",JOptionPane.INFORMATION_MESSAGE);
            }
            if (funcion.equals("Modificar")) {
                dao.ModificarEmpleados(emp);
                JOptionPane.showMessageDialog(null, "Empleado modificado existosamente","Empleado registrado",JOptionPane.INFORMATION_MESSAGE);
            }
            frmAdminEmpleados.ListarDatos();
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int su = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cancelar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (su == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void MostrarCargosCombo() {
        CargoDAO car = new CargoDAO();
        jComboBox1.setModel(car.MostrarComboBox());
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
            java.util.logging.Logger.getLogger(frmInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInsertarEmpleado("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}