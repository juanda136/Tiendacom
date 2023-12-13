package Controlador;

import Modelo.ModeloProveedor;
import Vista.NuevoProveedor;
import Vista.Principal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class controladorproveedor implements ActionListener {

    NuevoProveedor nuevoprove = new NuevoProveedor();
    Principal prin = new Principal();
    ModeloProveedor modprove = new ModeloProveedor();

    public controladorproveedor() {
        nuevoprove.getBtnGuardarProveedor().addActionListener(this);
        nuevoprove.getBtnCancelar().addActionListener(this);
        nuevoprove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoprove.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal pricipal = new ControladorPrincipal();
                pricipal.Iniciar();
            }
        });

    }

    public void InicioProveedor() {

        prin.setVisible(false);
        nuevoprove.setLocationRelativeTo(null);
        nuevoprove.setVisible(true);

        nuevoprove.getCbxSexo().addItem("Seleccione...");
        Map<String, Integer> comsexo = modprove.llenarCombo("sexo");
        for (String sexo : comsexo.keySet()) {
            nuevoprove.getCbxSexo().addItem(sexo);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevoprove.getBtnGuardarProveedor())) {
            if (nuevoprove.getjTexNombre().getText().isEmpty() || nuevoprove.getjTexCorreo().getText().isEmpty()
                    || nuevoprove.getjTexDireccion().getText().isEmpty() || nuevoprove.getjTexTelefono().getText().isEmpty()
                    || nuevoprove.getCbxSexo().getSelectedItem().equals("Seleccione...")
                    || nuevoprove.getJdchFechaNacimiento().getDate() == null || nuevoprove.getCbxTipoDocumento().getSelectedItem().equals("Seleccione:") || nuevoprove.getCbxTipoPersona().getSelectedItem().equals("Seleccione:")) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos...");
            } else {
                JOptionPane.showMessageDialog(null, "Exito");
                String valorSexo = nuevoprove.getCbxSexo().getSelectedItem().toString();
                int sexo = modprove.llenarCombo("sexo").get(valorSexo);

                // seleccion de fecha, cambia al formato de fecha al que entiende sql
                java.util.Date fec = nuevoprove.getJdchFechaNacimiento().getDate();
                long fe = fec.getTime();
                java.sql.Date fecha = new java.sql.Date(fe);

                modprove.setDocumento(Integer.parseInt(nuevoprove.getjTexDocumento().getText()));
                modprove.setTipodedocumento(nuevoprove.getCbxTipoDocumento().getSelectedItem().toString());
                modprove.setNom(nuevoprove.getjTexNombre().getText());
                modprove.setTipodepersona(nuevoprove.getCbxTipoPersona().getSelectedItem().toString());
                modprove.setFec(fecha);
                modprove.setSex(sexo);
                modprove.setTele(nuevoprove.getjTexTelefono().getText());
                modprove.setCorreo(nuevoprove.getjTexCorreo().getText());
                modprove.setDir(nuevoprove.getjTexDireccion().getText());

                if (nuevoprove.getBtnGuardarProveedor().getText().equals("Guardar")) {
                    modprove.insertarProveedor();
                    modprove.limpiar(nuevoprove.getjLabelNuevoProveedor().getComponents());
                } else {
                    modprove.actualizarProveedor();
                    nuevoprove.setVisible(false);
                    nuevoprove.dispose();
                    modprove.mostrarTablaProveedor(prin.getjTableProveedor(), "", "Proveedor");
                }
            }
        }
        if (e.getSource().equals(nuevoprove.getBtnCancelar())) {
            nuevoprove.dispose();
        }
    }

    public void actualizarProveedor(int doc) {
        modprove.buscarProveedor(doc);
        nuevoprove.getCbxTipoPersona().setEnabled(false);
        nuevoprove.getCbxTipoDocumento().setEnabled(false);
        nuevoprove.getjTexDocumento().setText(String.valueOf(doc));
        nuevoprove.getjTexNombre().setText(modprove.getNom());
        nuevoprove.getjTexTelefono().setText(modprove.getTele());
        nuevoprove.getjTexCorreo().setText(modprove.getCorreo());
        nuevoprove.getjTexDireccion().setText(modprove.getDir());
        nuevoprove.getJdchFechaNacimiento().setDate(modprove.getFec());

        //llenar Sexo
        Map<String, Integer> info = modprove.llenarCombo("sexo");
        for (String sexo : info.keySet()) {
            nuevoprove.getCbxSexo().addItem(sexo);
        }
        //obtener el valor de la base de datos
        String valoSexo = modprove.obtenerSeleccion(info, modprove.getSex());
        nuevoprove.getCbxSexo().setSelectedItem(valoSexo);

        //Llenar tipo de documento y de persona
        nuevoprove.getCbxTipoDocumento().setSelectedItem(modprove.getTipodedocumento());
        nuevoprove.getCbxTipoPersona().setSelectedItem(modprove.getTipodepersona());

        //Cambiar Titulo
        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Proveedor",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Tahoma", Font.BOLD, 14),
                new java.awt.Color(180, 0, 180));

        nuevoprove.getjLabelNuevoProveedor().setBorder(borde);
        prin.setVisible(false);
        nuevoprove.setLocationRelativeTo(null);
        nuevoprove.getBtnGuardarProveedor().setText("Actualizar");
        nuevoprove.setVisible(true);
    }

    //Eliminar cliente
    void eliminarProveedor(int doc, String sql) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al Proveedor? \n" + doc,
                "Eliminar Proveedor", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            modprove.setDocumento(doc);
            modprove.eliminarProveedor(sql);
        }
    }
}
