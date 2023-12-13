package Controlador;

import Modelo.ModeloCliente;
import Vista.Nuevocliente;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorCliente implements ActionListener {

    Nuevocliente nuevoclien = new Nuevocliente();
    Principal prin = new Principal();
    ModeloCliente modcliente = new ModeloCliente();

    public ControladorCliente() {
        nuevoclien.getBtnGuardarCliente().addActionListener(this);
        nuevoclien.getBtnCancelar().addActionListener(this);
        nuevoclien.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoclien.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal pricipal = new ControladorPrincipal();
                pricipal.Iniciar();
            }
        });
      
    }

    public void InicioCliente() {

        prin.setVisible(false);
        nuevoclien.setLocationRelativeTo(null);
        nuevoclien.setVisible(true);
        
        nuevoclien.getCbxSexo().addItem("Selecione...");
        Map<String,Integer>comsexo= modcliente.llenarCombo("sexo");
        for(String sexo:comsexo.keySet()){
        nuevoclien.getCbxSexo().addItem(sexo);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevoclien.getBtnGuardarCliente())) {
            if (nuevoclien.getjTexCedula().getText().isEmpty() || nuevoclien.getjTexNombre().getText().isEmpty() || nuevoclien.getjTexCorreo().getText().isEmpty()
                    || nuevoclien.getjTexDireccion().getText().isEmpty() || nuevoclien.getjTexTelefono().getText().isEmpty()
                    || nuevoclien.getCbxsexo().getSelectedItem().equals("Seleccione...")
                    || nuevoclien.getJdchfNacimiento().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos...");
            } else {
                JOptionPane.showMessageDialog(null, "Exito");
                String valorSexo = nuevoclien.getCbxsexo().getSelectedItem().toString();
                int sexo = modcliente.llenarCombo("sexo").get(valorSexo);
                
                 java.util.Date fec = nuevoclien.getJdchfNacimiento().getDate();
                    long fe = fec.getTime();
                    java.sql.Date fecha= new java.sql.Date(fe);
                    
                    modcliente.setCedu(Integer.parseInt(nuevoclien.getjTexCedula().getText()));
                    modcliente.setTipod(nuevoclien.getCbxTipoDocumento().getSelectedItem().toString());
                    modcliente.setNom(nuevoclien.getjTexNombre().getText());
                    modcliente.setFec(fecha);
                    modcliente.setTele(nuevoclien.getjTexTelefono().getText());
                    modcliente.setCor(nuevoclien.getjTexCorreo().getText());
                    modcliente.setDir(nuevoclien.getjTexDireccion().getText());
                    modcliente.setSex(sexo);
                   
    
                    if (nuevoclien.getBtnGuardarCliente().getText().equals("Guardar")) {
                        modcliente.insertarCliente();
                      //  modcliente.limpiar(nuevoclien.getjpCliente().getComponents());
                    } else {
                        modcliente.actualizarCliente();
                        nuevoclien.setVisible(false);
                        nuevoclien.dispose();
                        modcliente.mostrarTablaCliente(prin.getjTableCliente(), "", "Cliente");
//                    prin.getTpPrincipal().setSelectedIndex(0);
                    }
                }
            }

            if (e.getSource().equals(nuevoclien.getBtnCancelar())) {
                nuevoclien.dispose();
            }
        }
    }

