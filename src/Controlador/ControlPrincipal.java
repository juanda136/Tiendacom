/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Principal;

/**
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class ControlPrincipal {
    Principal  prin = new Principal();

    public ControlPrincipal() {
    }
    public void iniciar(int valor){
//        prin.getJtTienda().setSelectedIndex(valor);
        prin.setLocationRelativeTo(null);
        prin.setVisible(true);
    }
    
}
