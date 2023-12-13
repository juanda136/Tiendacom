package Controlador;

import Modelo.ModeloLogin;
import Vista.Iniciar_Seccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * |
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class ControladorLogin implements ActionListener {

    ModeloLogin modlog = new ModeloLogin();
    Iniciar_Seccion iniciar = new Iniciar_Seccion();

    public ControladorLogin() {
        iniciar.getBtnIniciarSeccion().addActionListener(this);
        iniciar.getBtnMostrarClave().addActionListener(this);
    }

    public void iniciar() {
        iniciar.setLocationRelativeTo(null);
        iniciar.setTitle("Iniciar Sesión");
        iniciar.setVisible(true);
    }
    // Nuevo método para cargar una imagen en el JPanel y JFrame

    private void cargarFondo() {
        // Cargar imagen en el JPanel
        ImageIcon imagenPanel = new ImageIcon(getClass().getResource("/vista/imagenesFondos 28078- violeta.jpg"));
//        iniciar.getjPanelFondo().setImagen(imagenPanel.getImage());

        // Cargar imagen en el JFrame (puedes ajustar la ruta y el tamaño según tus necesidades)
        ImageIcon imagenFrame = new ImageIcon(getClass().getResource("/vista/imagenesFondos 28078- violeta.jpg"));
        iniciar.setIconImage(imagenFrame.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(iniciar.getjButtonMostrarClave())) {

            if (iniciar.getjPasswordContrasena().getEchoChar() == '\u2022') {
                iniciar.getjPasswordContrasena().setEchoChar((char) 0);
                iniciar.getjButtonMostrarClave().setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/imgenesIconos/candado(2).png")));
            } else {
                iniciar.getjPasswordContrasena().setEchoChar('\u2022');
                iniciar.getjButtonMostrarClave().setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/imagenesIcono/candado(2).png")));
            }
        }
        if (e.getSource().equals(iniciar.getBtnIniciarSeccion())) {
            modlog.setUsu(iniciar.getjTexUsuario().getText());
            String contra = new String(iniciar.getjPasswordContrasena().getPassword());
            modlog.setContra(contra);
            if (modlog.validar(modlog.getUsu(), modlog.getContra())) {
//                ControladorPrincipal contpri = new ControladorPrincipal();
                ControlPrincipal contpri = new ControlPrincipal();
                iniciar.setVisible(false);
                contpri.iniciar(0);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }

        }

    }
}
