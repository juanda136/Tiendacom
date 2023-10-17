/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class NuevoUsuario extends javax.swing.JFrame {
    

    /**
     * Creates new form NuevoUsuario1
     */
    
    public NuevoUsuario() {
        initComponents();
    }

    public JPanel getjPanelUsuario() {
        return jPanelUsuario;
    }

    public void setjPanelUsuario(JPanel jPanelUsuario) {
        this.jPanelUsuario = jPanelUsuario;
    }

    public JLabel getjLaCargo() {
        return jLbCargo;
    }

    public void setjLaCargo(JLabel jLaCargo) {
        this.jLbCargo = jLaCargo;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLbCargo() {
        return jLbCargo;
    }

    public void setjLbCargo(JLabel jLbCargo) {
        this.jLbCargo = jLbCargo;
    }

    public JLabel getjLbCorreo() {
        return jLbCorreo;
    }

    public void setjLbCorreo(JLabel jLbCorreo) {
        this.jLbCorreo = jLbCorreo;
    }

    public JLabel getjLbDireccion() {
        return jLbDireccion;
    }

    public void setjLbDireccion(JLabel jLbDireccion) {
        this.jLbDireccion = jLbDireccion;
    }

    public JLabel getjLbDocumento() {
        return jLbDocumento;
    }

    public void setjLbDocumento(JLabel jLbDocumento) {
        this.jLbDocumento = jLbDocumento;
    }

    public JLabel getjLbFecha_de_Nacimiento() {
        return jLbFecha_de_Nacimiento;
    }

    public void setjLbFecha_de_Nacimiento(JLabel jLbFecha_de_Nacimiento) {
        this.jLbFecha_de_Nacimiento = jLbFecha_de_Nacimiento;
    }

    public JLabel getjLbNombre() {
        return jLbNombre;
    }

    public void setjLbNombre(JLabel jLbNombre) {
        this.jLbNombre = jLbNombre;
    }

    public JLabel getjLbSexo() {
        return jLbSexo;
    }

    public void setjLbSexo(JLabel jLbSexo) {
        this.jLbSexo = jLbSexo;
    }

    public JLabel getjLbel9() {
        return jLbel9;
    }

    public void setjLbel9(JLabel jLbel9) {
        this.jLbel9 = jLbel9;
    }

    public JLabel getjLabelTelefono() {
        return jLabelTelefono;
    }

    public void setjLabelTelefono(JLabel jLabelTelefono) {
        this.jLabelTelefono = jLabelTelefono;
    }

    public JLabel getjLbNuevoUsuario() {
        return jLbNuevoUsuario;
    }

    public void setjLbNuevoUsuario(JLabel jLbNuevoUsuario) {
        this.jLbNuevoUsuario = jLbNuevoUsuario;
    }


   
    public String getSexoSeleccionado() {
        return cbxSexo.getSelectedItem().toString();
    }

    
   
public String getCargoSeleccionado() {
        return cbxCargo.getSelectedItem().toString();
}
    public JComboBox<String> getCbxcargo() {
        return cbxCargo;
    }

    public void setCbxcargo(JComboBox<String> cbxcargo) {
        this.cbxCargo = cbxcargo;
    }

    public JComboBox<String> getCbxsexo() {
        return cbxSexo;
    }

    public void setCbxsexo(JComboBox<String> cbxsexo) {
        this.cbxSexo = cbxsexo;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonGuardar() {
        return jButtonGuardar;
    }

    public void setjButtonGuardar(JButton jButtonGuardar) {
        this.jButtonGuardar = jButtonGuardar;
    }

    public JTextField getjTexCorreo() {
        return jTexCorreo;
    }

    public void setjTexCorreo(JTextField jTexCorreo) {
        this.jTexCorreo = jTexCorreo;
    }

    public JTextField getjTexDireccion() {
        return jTexDireccion;
    }

    public void setjTexDireccion(JTextField jTexDireccion) {
        this.jTexDireccion = jTexDireccion;
    }

    public JTextField getjTexDocumento() {
        return jTexDocumento;
    }

    public void setjTexDocumento(JTextField jTexDocumento) {
        this.jTexDocumento = jTexDocumento;
    }

    public JTextField getjTexLogin() {
        return jTexLogin;
    }

    public void setjTexLogin(JTextField jTexLogin) {
        this.jTexLogin = jTexLogin;
    }

    public JTextField getjTexTelefono() {
        return jTexTelefono;
    }

    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public void setjTexTelefono(JTextField jTexTelefono) {
        this.jTexTelefono = jTexTelefono;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JTextField getjTextNombre() {
        return jTextNombre;
    }

    public void setjTextNombre(JTextField jTextNombre) {
        this.jTextNombre = jTextNombre;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsuario = new javax.swing.JPanel();
        jLbNuevoUsuario = new javax.swing.JLabel();
        jLbDocumento = new javax.swing.JLabel();
        jTexDocumento = new javax.swing.JTextField();
        jLbNombre = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLbCorreo = new javax.swing.JLabel();
        jTexCorreo = new javax.swing.JTextField();
        jLbDireccion = new javax.swing.JLabel();
        jTexDireccion = new javax.swing.JTextField();
        jLbSexo = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        jLabelTelefono = new javax.swing.JLabel();
        jTexTelefono = new javax.swing.JTextField();
        jLbFecha_de_Nacimiento = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cbxCargo = new javax.swing.JComboBox<>();
        jLbCargo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTexLogin = new javax.swing.JTextField();
        jLbel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanelUsuario.setBackground(new java.awt.Color(204, 204, 204));
        jPanelUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanelUsuario.setForeground(new java.awt.Color(255, 0, 0));

        jLbNuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jLbNuevoUsuario.setForeground(new java.awt.Color(255, 0, 0));
        jLbNuevoUsuario.setText("NUEVO USUARIO");

        jLbDocumento.setForeground(new java.awt.Color(255, 0, 0));
        jLbDocumento.setText("Documento");

        jLbNombre.setForeground(new java.awt.Color(255, 0, 0));
        jLbNombre.setText("Nombre");

        jLbCorreo.setForeground(new java.awt.Color(255, 0, 0));
        jLbCorreo.setText("Correo");

        jLbDireccion.setForeground(new java.awt.Color(255, 0, 0));
        jLbDireccion.setText("Direccion");

        jLbSexo.setForeground(new java.awt.Color(255, 0, 0));
        jLbSexo.setText("Sexo");

        jLabelTelefono.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTelefono.setText("Telefono");

        jLbFecha_de_Nacimiento.setForeground(new java.awt.Color(255, 0, 0));
        jLbFecha_de_Nacimiento.setText("<html>Fecha de Nacimiento<html>");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLbCargo.setForeground(new java.awt.Color(255, 0, 0));
        jLbCargo.setText("Cargo");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Login");

        jLbel9.setForeground(new java.awt.Color(255, 0, 0));
        jLbel9.setText("Clave");

        jPasswordField1.setBackground(new java.awt.Color(214, 217, 223));

        jButtonCancelar.setForeground(new java.awt.Color(255, 0, 0));
        jButtonCancelar.setText("Cancelar");

        jButtonGuardar.setForeground(new java.awt.Color(255, 0, 0));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                        .addComponent(jLbCargo)
                                        .addGap(69, 69, 69)
                                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                                        .addGap(79, 79, 79)
                                                        .addComponent(jButtonGuardar))
                                                    .addComponent(jTexLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButtonCancelar)
                                                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                                        .addGap(41, 41, 41)
                                                        .addComponent(jLbel9))))))
                                    .addComponent(jLbDireccion))
                                .addGap(158, 158, 158))
                            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                .addComponent(jLbFecha_de_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTexTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLbSexo)
                            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                        .addComponent(jLbDocumento)
                                        .addGap(41, 41, 41)
                                        .addComponent(jTexDocumento))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelUsuarioLayout.createSequentialGroup()
                                        .addGap(223, 223, 223)
                                        .addComponent(jLbNuevoUsuario)))
                                .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                    .addComponent(jLbNombre)
                                    .addGap(60, 60, 60)
                                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                    .addComponent(jLbCorreo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTexCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTexDireccion))))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLbNuevoUsuario)
                .addGap(18, 18, 18)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbDocumento)
                    .addComponent(jTexDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbNombre))
                .addGap(21, 21, 21)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbDireccion)
                    .addComponent(jTexDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbSexo)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbFecha_de_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTexTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTelefono)))
                .addGap(21, 21, 21)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbCargo)
                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTexLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbel9)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGuardar))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
    
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLbCargo;
    private javax.swing.JLabel jLbCorreo;
    private javax.swing.JLabel jLbDireccion;
    private javax.swing.JLabel jLbDocumento;
    private javax.swing.JLabel jLbFecha_de_Nacimiento;
    private javax.swing.JLabel jLbNombre;
    private javax.swing.JLabel jLbNuevoUsuario;
    private javax.swing.JLabel jLbSexo;
    private javax.swing.JLabel jLbel9;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTexCorreo;
    private javax.swing.JTextField jTexDireccion;
    private javax.swing.JTextField jTexDocumento;
    private javax.swing.JTextField jTexLogin;
    private javax.swing.JTextField jTexTelefono;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}
