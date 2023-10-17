package Controlador;

import Modelo.ModeloCliente;
import Vista.Nuevocliente;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ControladorCliente implements ActionListener {

    Nuevocliente nuevoclien = new Nuevocliente();
    Principal prin = new Principal();
    ModeloCliente cliente = new ModeloCliente();
    

    public ControladorCliente() {
        nuevoclien.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoclien.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal pricipal = new ControladorPrincipal();
                pricipal.iniciar();
            }
        });
        nuevoclien.getjButtonGuardar().addActionListener(this);
    }

    public void Inicio() {

        prin.setVisible(false);
        nuevoclien.setLocationRelativeTo(null);
        nuevoclien.setVisible(true);

        nuevoclien.getCbxsexo().addItem("Seleccione...");
        Map<String, Integer> dato = cliente.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuevoclien.getCbxsexo().addItem(sexo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevoclien.getjButtonGuardar())) {
            if (nuevoclien.getJtxCedula().getText().isEmpty() || nuevoclien.getjTextNombre().getText().isEmpty() || nuevoclien.getjTexCorreo().getText().isEmpty()
                    || nuevoclien.getjTexDireccion().getText().isEmpty() || nuevoclien.getjTexTelefono().getText().isEmpty()
                    || nuevoclien.getCbxsexo().getSelectedItem().equals("Seleccione...")
                    || nuevoclien.getjDateChooser1().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos...");
            } else {
                JOptionPane.showMessageDialog(null, "Exito");
                String valorSexo = nuevoclien.getCbxsexo().getSelectedItem().toString();
                int sexo = cliente.llenarCombo("sexo").get(valorSexo);
            }

        }

    }
    

}
