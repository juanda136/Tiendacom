package Controlador;

import Modelo.ModeloUsuario;
import Vista.NuevoUsuario;
import Vista.Principal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class controladorUsuario implements ActionListener {

    NuevoUsuario nuevo = new NuevoUsuario();
    Principal prin = new Principal();
    ModeloUsuario modusu = new ModeloUsuario();

    public controladorUsuario() {

        nuevo.getBtnGuardarNuevo().addActionListener(this);
        nuevo.getBtnCancelarNuevo().addActionListener(this);
        nuevo.getBtnMostrarClaveNuevo().addActionListener(this);
        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevo.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal pricipal = new ControladorPrincipal();
                pricipal.Iniciar();
            }
        });
    }

    public void InicioUsuario() {

        prin.setVisible(false);
        nuevo.setLocationRelativeTo(null);
        nuevo.setTitle("Nuevo Usuario");
        nuevo.setVisible(true);

        nuevo.getCbxSexo().addItem("Seleccione...");
        Map<String, Integer> comsexo = modusu.llenarCombo("sexo");
        for (String sexo : comsexo.keySet()) {
            nuevo.getCbxSexo().addItem(sexo);
        }

        nuevo.getCbxCargo().addItem("Seleccione...");
        Map<String, Integer> comcargo = modusu.llenarCombo("cargo");
        for (String cargo : comcargo.keySet()) {
            nuevo.getCbxCargo().addItem(cargo);

        }

        nuevo.getCbxTipoDocumento().addItem("Seleccione...");
        Map<String, Integer> comtipodocumento = modusu.llenarCombo("tipodocumento");
        for (String tipo : comtipodocumento.keySet()) {
            nuevo.getCbxTipoDocumento().addItem(tipo);
        }
    }

    public void actionPerformed(ActionEvent e, int sex, int cargo, int tipo, int sexo) {
        if (e.getSource().equals(nuevo.getBtnMostrarClaveNuevo())) {
            if (nuevo.getjPassClave().getEchoChar() == '\u2022') {
                nuevo.getjPassClave().setEchoChar((char) 0);
                nuevo.getBtnMostrarClaveNuevo().setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/vista/imagenesiconos/candado .png")));
            } else {
                nuevo.getjPassClave().setEchoChar('\u2022');
                nuevo.getBtnMostrarClaveNuevo().setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/vista/imagenesiconos/candado (2).png")));
            }
        }
        if (e.getSource().equals(nuevo.getBtnGuardarNuevo())) {
            if (nuevo.getCbxTipoDocumento().getSelectedItem().equals("Seleccione...") || nuevo.getjTexDocumento().getText().isEmpty() || nuevo.getjTexNombre().getText().isEmpty() || nuevo.getjTexCorreo().getText().isEmpty()
                    || nuevo.getjTexDireccion().getText().isEmpty() || nuevo.getjTexLogin().getText().isEmpty() || nuevo.getjTexTelefono().getText().isEmpty()
                    || nuevo.getCbxSexo().getSelectedItem().equals("Seleccione...") || nuevo.getCbxCargo().getSelectedItem().equals("Seleccione...")
                    || nuevo.getJdchFecha().getDate() == null
                    || nuevo.getjPassClave().getPassword() == null) {

                JOptionPane.showMessageDialog(null, "Hay campos vacios, Debes llenar todos los campos...");
            } else {
                JOptionPane.showMessageDialog(null, "Exito");
                String valorSexo = nuevo.getCbxSexo().getSelectedItem().toString();
                String valorCargo = nuevo.getCbxCargo().getSelectedItem().toString();
                String valorTipoDocumento = nuevo.getCbxTipoDocumento().getSelectedItem().toString();
                int tipoDocumento = modusu.llenarCombo("tipodocumento").get(valorTipoDocumento);
                int Sex = modusu.llenarCombo("sexo").get(valorSexo);
                int Cargo = modusu.llenarCombo("cargo").get(valorCargo);
            }
            // Obtener la fecha
            java.util.Date fec = nuevo.getJdchFecha().getDate();
            long fe = fec.getTime();
            java.sql.Date fecha = new java.sql.Date(fe);

            // Obtener la contraseña
            char[] contra = nuevo.getjPassClave().getPassword();
            String contrasena = String.valueOf(contra);

            // Establecer los valores en el objeto 'modusu'// Obtener los valores de los campos
//            modusu.setTipoDocumento(nuevo.getcbxTipoDocumento().getSelectedItem().toString());
            modusu.setTipoDocumento(tipo);
            modusu.setDoc(Integer.parseInt(nuevo.getjTexDocumento().getText()));
            modusu.setNom(nuevo.getjTexNombre().getText());
            modusu.setTele(nuevo.getjTexTelefono().getText());
            modusu.setCorreo(nuevo.getjTexCorreo().getText());
            modusu.setDir(nuevo.getjTexDireccion().getText());
            modusu.setSex(sexo);
            modusu.setCargo(cargo);
            modusu.setLog(nuevo.getjTexLogin().getText());
            modusu.setClave(contrasena);

            if (nuevo.getBtnGuardarNuevo().getText().equals("guardar")) {
                modusu.insertarUsuario();
                modusu.limpiarCampos(nuevo.getjPanelUsuario().getComponents());
            } else {
                modusu.actualizarUsuario();
                nuevo.setVisible(false);
                nuevo.dispose();
                prin.getJtTienda().setSelectedIndex(0);
                nuevo.setVisible(true);
                modusu.mostrarTablaUsuario(prin.getjTableUsuario(), "", "usuario");

            }
        }
    
        if (e.getSource().equals(nuevo.getBtnCancelarNuevo())) {
            nuevo.dispose();
        }
    }

    public void actualizarUsuario(int doc) {
        modusu.buscarUsuario(doc);
        nuevo.getjTexDocumento().setEnabled(false);
        nuevo.getjTexLogin().setEnabled(false);
        nuevo.getCbxTipoDocumento().setEnabled(false);
        nuevo.getjTexDocumento().setText(String.valueOf(0));
        nuevo.getjTexCorreo().setText(modusu.getCor());
        nuevo.getjTexNombre().setText(modusu.getNom());
        nuevo.getjTexDireccion().setText(modusu.getDir());
        nuevo.getjTexTelefono().setText(modusu.getTele());
        nuevo.getjTexLogin().setText(modusu.getLog());
        nuevo.getjPassClave().setText(modusu.getClave());
        nuevo.getJdchFecha().setDate(modusu.getFec());

        //llenar sexo
        Map<String, Integer> dato = modusu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuevo.getCbxSexo().addItem(sexo);
            //obtener el valor guardado en la base de dato.
            String ValorSex = modusu.obtenerSeleccion(dato, modusu.getSex());
            nuevo.getCbxSexo().setSelectedItem(ValorSex);
        }
        Map<String, Integer> dato1 = modusu.llenarCombo("Cargo");
        for (String Cargo : dato1.keySet()) {
            nuevo.getCbxCargo().addItem(Cargo);
        }
        String ValorRol = modusu.obtenerSeleccion(dato, modusu.getCargo());
        nuevo.getCbxCargo().setSelectedItem(ValorRol);

        Map<String, Integer> dato2 = modusu.llenarCombo("Tipodoc");
        for (String TipoDocumento : dato2.keySet()) {
            nuevo.getCbxTipoDocumento().addItem(TipoDocumento);

            String ValorTipo = modusu.obtenerSeleccion(dato, modusu.getTipoDocumento());
            nuevo.getCbxTipoDocumento().setSelectedItem(ValorTipo);

            Border borde = BorderFactory.createTitledBorder(null, "Actualizar Usuario", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("verdana", Font.BOLD, 18));

            nuevo.getjPanelUsuario();
            prin.setVisible(false);
            nuevo.setLocationRelativeTo(null);
            nuevo.getBtnGuardarNuevo().setText("actualizar");
            nuevo.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevo.getBtnGuardarNuevo())) {
            modusu.insertarUsuario();
        }

    }

    public void eliminarUsuario(int doc) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al usuario? \n" + doc,
                "Eliminar Usuario", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            modusu.setDoc(doc);
            modusu.eliminarUsuario();
        }
    }

}
