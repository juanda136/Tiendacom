package Controlador;

import Modelo.ModeloProveedor;
import Vista.NuevoProveedor;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class controladorproveedor implements ActionListener {

    NuevoProveedor nuevoprove = new NuevoProveedor();
    Principal prin = new Principal();
    ModeloProveedor prove = new ModeloProveedor();

    public controladorproveedor() {
        nuevoprove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoprove.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal pricipal = new ControladorPrincipal();
                pricipal.iniciar();
            }
        });
        nuevoprove.getjButtonGuardar().addActionListener(this);
    }
 
    public void Inicio() {

        prin.setVisible(false);
        nuevoprove.setLocationRelativeTo(null);
        nuevoprove.setVisible(true);

        nuevoprove.getCbxsexo().addItem("Seleccione...");
        Map<String, Integer> dato = prove.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuevoprove.getCbxsexo().addItem(sexo);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevoprove.getjButtonGuardar())) {
            if (nuevoprove.getjTextNombre().getText().isEmpty() || nuevoprove.getjTexCorreo().getText().isEmpty()
                    || nuevoprove.getjTexDireccion().getText().isEmpty() || nuevoprove.getjTexTelefono().getText().isEmpty()
                    || nuevoprove.getCbxsexo().getSelectedItem().equals("Seleccione...")
                    || nuevoprove.getjDateChooser1().getDate() == null || nuevoprove.getCbxTipodedocumento().getSelectedItem().equals("Seleccione:") || nuevoprove.getCbxTipodepersona().getSelectedItem().equals("Seleccione:")) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos...");
            } else {
                JOptionPane.showMessageDialog(null, "Exito");
                String valorSexo = nuevoprove.getCbxsexo().getSelectedItem().toString();
                int sexo = prove.llenarCombo("sexo").get(valorSexo);
            }

        }

    }

}
