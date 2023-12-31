/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class NuevaFactura extends javax.swing.JFrame {

    /**
     * Creates new form NuevaFactura
     */
    public NuevaFactura() {
        initComponents();
    }

    public JButton getBtnCacelar() {
        return BtnCacelar;
    }

    public void setBtnCacelar(JButton BtnCacelar) {
        this.BtnCacelar = BtnCacelar;
    }

    public JButton getBtnGuardarFactura() {
        return BtnGuardarFactura;
    }

    public JTextField getjTexIdententificacionProveedor() {
        return jTexIdententificacionProveedor;
    }

    public void setjTexIdententificacionProveedor(JTextField jTexIdententificacionProveedor) {
        this.jTexIdententificacionProveedor = jTexIdententificacionProveedor;
    }

    public void setBtnGuardarFactura(JButton BtnGuardarFactura) {
        this.BtnGuardarFactura = BtnGuardarFactura;
    }

    public JPanel getjPanelFactura() {
        return jPanelFactura;
    }

    public JButton getBtnBuscarIdentiProveedor() {
        return BtnBuscarIdentiProveedor;
    }

    public void setBtnBuscarIdentiProveedor(JButton BtnBuscarIdentiProveedor) {
        this.BtnBuscarIdentiProveedor = BtnBuscarIdentiProveedor;
    }

    public JButton getBtnBuscarIdentiUsuario() {
        return BtnBuscarIdentiUsuario;
    }

    public JTextField getjTexIdentificacionUsuario() {
        return jTexIdentificacionUsuario;
    }

    public void setjTexIdentificacionUsuario(JTextField jTexIdentificacionUsuario) {
        this.jTexIdentificacionUsuario = jTexIdentificacionUsuario;
    }

    public void setBtnBuscarIdentiUsuario(JButton BtnBuscarIdentiUsuario) {
        this.BtnBuscarIdentiUsuario = BtnBuscarIdentiUsuario;
    }

    public JComboBox<String> getjComboBoxTipoPago() {
        return cmbxTipodePago;
    }

    public void setjComboBoxTipoPago(JComboBox<String> jComboBoxTipoPago) {
        this.cmbxTipodePago = jComboBoxTipoPago;
    }

    public void setjPanelFactura(JPanel jPanelFactura) {
        this.jPanelFactura = jPanelFactura;
    }

    public JComboBox<String> getCmbxTipodePago() {
        return cmbxTipodePago;
    }

    public void setCmbxTipodePago(JComboBox<String> cmbxTipodePago) {
        this.cmbxTipodePago = cmbxTipodePago;
    }

    public JTextField getjTexNumerodeComprobante() {
        return jTexNumerodeComprobante;
    }

    public void setjTexNumerodeComprobante(JTextField jTexNumerodeComprobante) {
        this.jTexNumerodeComprobante = jTexNumerodeComprobante;
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFactura = new javax.swing.JPanel();
        jLabelNuevaFactura = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbxTipodePago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTexIdententificacionProveedor = new javax.swing.JTextField();
        jTexIdentificacionUsuario = new javax.swing.JTextField();
        jTexDescuento = new javax.swing.JTextField();
        BtnGuardarFactura = new javax.swing.JButton();
        BtnCacelar = new javax.swing.JButton();
        BtnBuscarIdentiProveedor = new javax.swing.JButton();
        BtnBuscarIdentiUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTexNumerodeComprobante = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNuevaFactura.setText("NUEVA FACTURA");

        jLabel2.setText("Tipo De Pago");

        cmbxTipodePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Efectivo", "Tarjeta de Credito" }));

        jLabel3.setText("<html>Identificacion Proveedor<html>");

        jLabel4.setText("Identificancion Usuario");

        jLabel5.setText("Descuento");

        jTexIdententificacionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexIdententificacionProveedorActionPerformed(evt);
            }
        });

        BtnGuardarFactura.setText("Guardar");

        BtnCacelar.setText("Cancelar");

        BtnBuscarIdentiProveedor.setText("Proveedor");

        BtnBuscarIdentiUsuario.setText("Usuario");

        jLabel1.setText("Numero de Comprobante");

        javax.swing.GroupLayout jPanelFacturaLayout = new javax.swing.GroupLayout(jPanelFactura);
        jPanelFactura.setLayout(jPanelFacturaLayout);
        jPanelFacturaLayout.setHorizontalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(103, 103, 103)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbxTipodePago, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNuevaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(BtnGuardarFactura)
                        .addGap(62, 62, 62)
                        .addComponent(BtnCacelar))
                    .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFacturaLayout.createSequentialGroup()
                            .addComponent(jTexIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BtnBuscarIdentiUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelFacturaLayout.createSequentialGroup()
                            .addComponent(jTexIdententificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BtnBuscarIdentiProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)))
                    .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTexDescuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(jTexNumerodeComprobante, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanelFacturaLayout.setVerticalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelNuevaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxTipodePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexIdententificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarIdentiProveedor)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarIdentiUsuario)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexNumerodeComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarFactura)
                    .addComponent(BtnCacelar))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTexIdententificacionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexIdententificacionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexIdententificacionProveedorActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarIdentiProveedor;
    private javax.swing.JButton BtnBuscarIdentiUsuario;
    private javax.swing.JButton BtnCacelar;
    private javax.swing.JButton BtnGuardarFactura;
    private javax.swing.JComboBox<String> cmbxTipodePago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelNuevaFactura;
    private javax.swing.JPanel jPanelFactura;
    private javax.swing.JTextField jTexDescuento;
    private javax.swing.JTextField jTexIdententificacionProveedor;
    private javax.swing.JTextField jTexIdentificacionUsuario;
    private javax.swing.JTextField jTexNumerodeComprobante;
    // End of variables declaration//GEN-END:variables
