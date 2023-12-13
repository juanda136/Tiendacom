package Controlador;

import Modelo.ModeloProducto;
import Vista.NuevoProducto;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class ControladorProducto implements ActionListener {

    NuevoProducto nuevoprod = new NuevoProducto();
    Principal prin = new Principal();
    ModeloProducto modproduc = new ModeloProducto();

    public ControladorProducto() {
        nuevoprod.getBtnBuscarImagen().addActionListener(this);
        nuevoprod.getBtnGuardarProducto().addActionListener(this);
        nuevoprod.getBtnCancelar().addActionListener(this);
        nuevoprod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoprod.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princ = new ControladorPrincipal();
//                princ.iniciarPrincipal(0);
            }
        });
    }

    public void InicioProducto() {
        prin.setVisible(false);
        nuevoprod.setLocationRelativeTo(null);
        nuevoprod.setTitle("Nuevo Producto");
        nuevoprod.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(nuevoprod.getBtnBuscarImagen())){
            modproduc.buscarImangen();
            File file= new File(modproduc.getRuta());
            String archivo= file.getName();//obtiene solo el nombre de la ruta
            nuevoprod.getjTexImagen().setText(archivo);
        }
        if(e.getSource().equals(nuevoprod.getBtnGuardarProducto())){
            modproduc.setNom(nuevoprod.getjTexNombreProducto().getText());
            modproduc.setDes(nuevoprod.getjTexAreaDesProducto().getText());
            modproduc.setImagen(modproduc.obtenerimagen(modproduc.getRuta()));
            modproduc.insertarProducto();
            modproduc.limpiar(nuevoprod.getjPanelProducto().getComponents());
        }
 if (e.getSource().equals(nuevoprod.getBtnGuardarProducto())) {
            //validar campos vacios
            if ((nuevoprod.getjTexNombreProducto().getText().isEmpty()) || nuevoprod.getjTexAreaDesProducto().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar información en los campos de Nombre y Descripción");
            } else {
                modproduc.setNom(nuevoprod.getjTexNombreProducto().getText());
                modproduc.setDes(nuevoprod.getjTexAreaDesProducto().getText());
                modproduc.setImagen(modproduc.obtenerimagen(modproduc.getRuta()));

                if (nuevoprod.getBtnGuardarProducto().getText().equals("Guardar")) {
                    modproduc.insertarProducto();
                    modproduc.limpiar(nuevoprod.getjPanelProducto().getComponents());
                    nuevoprod.setVisible(false);//para que cuando guarde se cierre de inmediato la ventana
                    nuevoprod.dispose();
                } else {
                    modproduc.actualizarProducto();
                    nuevoprod.setVisible(false);
                    nuevoprod.dispose();
                    modproduc.mostrarTablaProducto(prin.getjTableProducto(), "", "Producto");
                }
            }
        }
        if (e.getSource().equals(nuevoprod.getBtnCancelar())) {
            nuevoprod.dispose();
        }
    }
     void actualizarProducto(int doc) {
        modproduc.buscarProducto(doc);
        nuevoprod.getjTexNombreProducto().setText(modproduc.getNom());
        nuevoprod.getjTexAreaDesProducto().setText(modproduc.getDes());
        nuevoprod.getjTexImagenProducto().setText(modproduc.getRuta());

        File file = new File(modproduc.getRuta());
        String archivo = file.getName();//obtiene solo el nombre de la ruta
        nuevoprod.getjTexNombreProducto().setText(archivo);

        //Cambiar Titulo
        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Producto",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Yu Gothic UI", 1, 36),
                new java.awt.Color(204, 0, 204));
        nuevoprod.getjLabelNuevoProducto().setBorder(borde);
        prin.setVisible(false);
        nuevoprod.setLocationRelativeTo(null);
        nuevoprod.getBtnGuardarProducto().setText("Actualizar");
        nuevoprod.setVisible(true);
    }

    //Eliminar cliente
    void eliminarProducto(int doc) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Producto? \n" + doc,
                "Eliminar Producto", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            modproduc.setDoc(doc);
            modproduc.eliminarProducto();
        }
    }
}

  