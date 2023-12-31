package Vista;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class Iniciar_Seccion extends javax.swing.JFrame {



     public  Iniciar_Seccion () {
       
     }
 

    public JButton getBtnIniciarSeccion() {
        return BtnIniciarSeccion;
    }

    public JButton getBtnMostrarClave() {
        return BtnMostrarClave;
    }

    public void setBtnMostrarClave(JButton BtnMostrarClave) {
        this.BtnMostrarClave = BtnMostrarClave;
    }

    public void setBtnIniciarSeccion(JButton BtnIniciarSeccion) {
        this.BtnIniciarSeccion = BtnIniciarSeccion;
    }
     
    public JPasswordField getjPasswordContrasena() {
        return jPasswordFieldContrasena;
    }

    public void setjPasswordContrasena(JPasswordField jPasswordContrasena) {
        this.jPasswordFieldContrasena = jPasswordContrasena;
    }

    public JButton getjButtonMostrarClave() {
        return BtnMostrarClave;
    }

    public void setjButtonMostrarClave(JButton jButtonMostrarClave) {
        this.BtnMostrarClave = jButtonMostrarClave;
    }

    public JTextField getjTexUsuario() {
        return jTexUsuario;
    }

    public void setjTexUsuario(JTextField jTexUsuario) {
        this.jTexUsuario = jTexUsuario;
    }

    public JPanel getjPanelFondo() {
        return jPanelFondo;
    }

    public void setjPanelFondo(JPanel jPanelFondo) {
        this.jPanelFondo = jPanelFondo;
    }

  
    

    /**
     * Creates new form Iniciar_Seccion
     */
  public void Iniciar_Seccion() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelIcono = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTexUsuario = new javax.swing.JTextField();
        jLabelContrasena = new javax.swing.JLabel();
        jPasswordFieldContrasena = new javax.swing.JPasswordField();
        BtnIniciarSeccion = new javax.swing.JButton();
        BtnMostrarClave = new javax.swing.JButton();
        jPanelFondo = new javax.swing.JPanel();
        jLabelFondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenesIconos/usuario (3).png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 170, 140));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 0));
        jLabelUsuario.setText("Usuario :");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jTexUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jTexUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTexUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 250, -1));

        jLabelContrasena.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelContrasena.setForeground(new java.awt.Color(255, 255, 0));
        jLabelContrasena.setText("Contraseña :");
        getContentPane().add(jLabelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jPasswordFieldContrasena.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordFieldContrasena.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPasswordFieldContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 250, -1));

        BtnIniciarSeccion.setBackground(new java.awt.Color(0, 0, 0));
        BtnIniciarSeccion.setForeground(new java.awt.Color(255, 255, 51));
        BtnIniciarSeccion.setText("Iniciar Seccion");
        getContentPane().add(BtnIniciarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        BtnMostrarClave.setBackground(new java.awt.Color(255, 255, 0));
        BtnMostrarClave.setForeground(new java.awt.Color(204, 204, 204));
        BtnMostrarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenesIconos/candado (2).png"))); // NOI18N
        getContentPane().add(BtnMostrarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 30, 40));
        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 340, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenesFondos/28078-violeta.jpg"))); // NOI18N
        jLabelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 540, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIniciarSeccion;
    private javax.swing.JButton BtnMostrarClave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordFieldContrasena;
    private javax.swing.JTextField jTexUsuario;
    // End of variables declaration//GEN-END:variables

}