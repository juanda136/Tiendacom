/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloLogin;
import Vista.Iniciar_Seccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * |
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class ControladorLogin implements ActionListener {

    ModeloLogin modlog = new ModeloLogin();
    Iniciar_Seccion iniciar = new Iniciar_Seccion();
ControladorPrincipal contpri = new ControladorPrincipal();

    public ControladorLogin() {
        iniciar.getjButtoIIniciar().addActionListener(this);       
    }
    public void  iniciar(){
        iniciar.setLocationRelativeTo(null);
        iniciar.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(iniciar.getjButtoIIniciar())){
            modlog.setUsu(iniciar.getjTexUsuario().getText());
            String contra = new String( iniciar.getjPasswordContrasena().getPassword());
            modlog.setContra(contra);                   
            if (modlog.validar(modlog.getUsu(), modlog.getContra())){
                iniciar.setVisible(false);
                contpri.iniciar();
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
            
        }
     
    }
}
