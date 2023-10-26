package Controlador;

import Modelo.ModeloUsuario;
import Vista.NuevoUsuario;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class controladorUsuario implements ActionListener {

    NuevoUsuario nuevo = new NuevoUsuario();
    Principal prin = new Principal();
    ModeloUsuario usu = new ModeloUsuario();

    public controladorUsuario() {

        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal pricipal = new ControladorPrincipal();
                pricipal.iniciar();
            }
        });
        nuevo.getjButtonGuardar().addActionListener(this);
    }

    public void Inicio() {

        prin.setVisible(false);
        nuevo.setLocationRelativeTo(null);
        nuevo.setVisible(true);

        nuevo.getCbxsexo().addItem("Seleccione...");
        Map<String, Integer> dato = usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuevo.getCbxsexo().addItem(sexo);
        }

        nuevo.getCbxcargo().addItem("Seleccione...");
        Map<String, Integer> datos = usu.llenarCombo("cargo");
        for (String rol : datos.keySet()) {
            nuevo.getCbxcargo().addItem(rol);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevo.getjButtonGuardar())) {
            if (nuevo.getjTexDocumento().getText().isEmpty() || nuevo.getjTextNombre().getText().isEmpty() || nuevo.getjTexCorreo().getText().isEmpty()
                    || nuevo.getjTexDireccion().getText().isEmpty() || nuevo.getjTexLogin().getText().isEmpty() || nuevo.getjTexTelefono().getText().isEmpty()
                    || nuevo.getCbxsexo().getSelectedItem().equals("Seleccione...") || nuevo.getCbxcargo().getSelectedItem().equals("Seleccione...")
                    || nuevo.getjDateChooser1().getDate() == null
                    || nuevo.getjPasswordField1().getPassword() == null) {

                JOptionPane.showMessageDialog(null, "Hay campos vacios, Debes llenar todos los campos...");
            } else {
                JOptionPane.showMessageDialog(null, "Exito");
                String valorSexo = nuevo.getCbxsexo().getSelectedItem().toString();
                String valorCargo = nuevo.getCbxcargo().getSelectedItem().toString();
                int sexo = usu.llenarCombo("sexo").get(valorSexo);
                int cargo = usu.llenarCombo("cargo").get(valorCargo);
            }
            // Obtener la fecha
            java.util.Date fec = nuevo.getjDateChooser1().getDate();
            long fe = fec.getTime();
            java.sql.Date fecha = new java.sql.Date(fe);

// Obtener la contraseña
            char[] contra = nuevo.getjPasswordField1().getPassword();
            String contrasena = String.valueOf(contra);

// Establecer los valores en el objeto 'usu'// Obtener los valores de los campos
            usu.setDoc(Integer.parseInt(nuevo.getjTexDocumento().getText()));
            usu.setNom(nuevo.getjTextNombre().getText());
            usu.setTele(nuevo.getjTexTelefono().getText());
            usu.setCorreo(nuevo.getjTexCorreo().getText());
            usu.setDir(nuevo.getjTexDireccion().getText());
            usu.setSex(nuevo.getSexoSeleccionado().charAt(0));
            usu.setCargo(nuevo.getCargoSeleccionado().charAt(0));
            

// Insertar el usuario en la base de datos
            usu.insertarUsuario(); 
// Limpiar los componentes después de la inserción
            usu.limpiarCampos(nuevo.getjPanelUsuario().getComponents());


          
        }

    }

}
/*public void actualizar usuario(int doc){
              usu.buscarUsuario (doc);
              nuevo.getTxtDocumento().setEnabled(false);
              nuevo.getTxtLogin().setEnabled(false);
              nuevo.getTxtTipo().setEnabled(false);
              nuevo.getDocumento().setText(String,ValueOf(doc));
              nuevo.getCorreo().setText(Usu.getCor);
              nuevo.getNombre().setText(Usu.getNombre());
              nuevo.getDireccion().setText(Usu.getDir());
              nuevo.getTelefono().setText(Usu.getTel());
              nuevo.getLogin().setText(Usu.getLo());
              nuevo.getClave().setText(Usu.getCl());
              nuevo.getFecha().setText(Usu.getFec());
              //llenar sexo
              map<String,Integer> dato = usu.llenarcombo("sexo");
              for(String sexo : dato.Keyset()){
              nuevo.getJcvsexo(). addItem(sexo);
              //obtener el valor guardado en la base de dato.
              String ValorSexo= usu.obtenerSeleccio(dato,usu.getSex());
              nuevo.getJcbsexo().setselection(valorSexo);
             }
              map<String,Integer> dato = usu.llenarcombo("rol");
              for(String rol : dato.Keyset()){
              nuevo.getJcvCargo(). addItem(Rol);
              }
              String ValoRol= usu.obtenerSeleccion(dato,usu.getRol());
              nuevo.getJcbCargo().setselectionItem(valorRol);
              
              map<String,Integer> dato = usu.llenarcombo("Tipodoc");
              for(String Tipo : datof.Keyset()){
              nuevo.getJcvtipo(). addItem(tipodoc);
              
              String ValorTipo= usu.obtenerSeleccion(dato,usu.getTipo());
              nuevo.getJcbTipo().setselectionItem(valorTipo);

            Border borde= BorderFactory.createTitleedBorder(null,"actualizarUsuario"),
             javax.swing.border.TitledBorder.LE.*/