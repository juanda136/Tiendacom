package Controlador;

import Modelo.ModeloFacturaC;
import Modelo.ModeloProducto;
import Modelo.ModeloProveedor;
import Modelo.ModeloUsuario;
import Vista.DetalleFactura;
import Vista.BuscarProducto;
import Vista.NuevaFactura;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorFacturaC implements ActionListener, DocumentListener {

    NuevaFactura nuevafact = new NuevaFactura();
    Principal prin = new Principal();
    DetalleFactura detalle = new DetalleFactura();
    BuscarProducto buscar= new BuscarProducto();
    DetalleFactura detallefact = new DetalleFactura();


    ModeloUsuario modusu = new ModeloUsuario();
    ModeloProducto modprod = new ModeloProducto();
    ModeloProveedor modprov = new ModeloProveedor();
    ModeloFacturaC modfac = new ModeloFacturaC();

    public ControladorFacturaC() {
        nuevafact.getBtnGuardarFactura().addActionListener(this);
        nuevafact.getBtnCacelar().addActionListener(this);
        nuevafact.getBtnBuscarIdentiProveedor().addActionListener(this);
        nuevafact.getBtnBuscarIdentiUsuario().addActionListener(this);

        buscar.getjTexBuscar().getDocument().addDocumentListener(this);
        detallefact.getBtnbuscarproducto().addActionListener(this);
      
        detallefact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevafact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buscar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        nuevafact.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princ = new ControladorPrincipal();
                prin.iniciarPrincipal(4);
            }
        });
        buscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                nuevafact.setVisible(true);
                buscar.setVisible(false);
            }
        });

        detallefact.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                nuevafact.setVisible(true);
                detallefact.setVisible(false);
            }
        });
    }

    public void controlFacturaCompra() {
        prin.setVisible(false);
        nuevafact.setLocationRelativeTo(null);
        nuevafact.setTitle("Nueva Factura Compra");
        nuevafact.setVisible(true);
        buscar();
    }

    public void buscar() {
        buscar.getjTableBuscar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = buscar.getjTableBuscar().rowAtPoint(e.getPoint());
                int colum = buscar.getjTableBuscar().columnAtPoint(e.getPoint());

                if (buscar.getjLabelBuscar().getText().equals("Usuario")) {
                    modusu.setDoc(Integer.parseInt(buscar.getjTableBuscar().getValueAt(fila, 0).toString()));
                    if (colum == 9) {
                        buscar.setVisible(false);
                        nuevafact.setVisible(true);
                        Object idusua = modusu.getDoc();
                        nuevafact.getjTexIdentificacionUsuario().setText(idusua.toString());
                        JOptionPane.showMessageDialog(null, "Usuario Agregado");
                    }
                } else {
                    modprov.setDoc(Integer.parseInt(buscar.getjTableBuscar().getValueAt(fila, 0).toString()));
                    if (colum == 9) {
                        buscar.setVisible(false);
                        nuevafact.setVisible(true);
                        Object idprovee = modprov.getDocumento();
                        nuevafact.getjTexIdententificacionProveedor().setText(idprovee.toString());
                        JOptionPane.showMessageDialog(null, "Proveedor Agregado");
                    }
                }
            }
        });
        buscar.getjTexBuscar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscar.getjTexBuscar().setText("");
                buscar.getjTexBuscar().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevafact.getBtnBuscarIdentiUsuario())) {
            buscar.getjLabelBuscar().setText("Usuario");
            nuevafact.setVisible(false);
            buscar.setLocationRelativeTo(null);
            modusu.mostrarTablaUsuario(buscar.getjTableBuscar(), "", "Nueva Factura");
            buscar.setVisible(true);
            Border borde = BorderFactory.createTitledBorder(null, "Buscar Usuario",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Yu Gothic UI", 1, 36),
                    new java.awt.Color(204, 0, 204));
            buscar.getjPanelBuscar().setBorder(borde);
        }

        if (e.getSource().equals(nuevafact.getBtnBuscarIdentiProveedor())) {
            buscar.getjLabelBuscar().setText("Proveedor");
            nuevafact.setVisible(false);
            buscar.setLocationRelativeTo(null);
            modprov.mostrarTablaProveedor(buscar.getjTableBuscar(), "", "Nueva Factura");
            buscar.setVisible(true);
            Border borde = BorderFactory.createTitledBorder(null, "Buscar Proveedor",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Yu Gothic UI", 1, 36),
                    new java.awt.Color(204, 0, 204));
            buscar.getjTableBuscar().setBorder(borde);
        }

        if (e.getSource().equals(nuevafact.getBtnGuardarFactura())) {
            //validar campos vacios
            if ((nuevafact.getjTexIdententificacionProveedor().getText().isEmpty()) || (nuevafact.getjTexIdentificacionUsuario().getText().isEmpty()) || (nuevafact.getjTexNumerodeComprobante().getText().isEmpty())
                    || (nuevafact.getCmbxTipodePago().getSelectedItem().equals("Seleccione..."))) {
                JOptionPane.showMessageDialog(null, "Debe ingresar información en los campos de Nombre y Descripción");
            } else {
                modfac.Set<String> hashSet = new HashSet<String>();
                modfac.setDocprovee(Integer.parseInt(nuevafact.getjTexIdententificacionProveedor().getText()));
                modfac.setDocusu((Integer.parseInt(nuevafact.getjTexIdentificacionUsuario().getText())));
                modfac.setCompro(Integer.parseInt(nuevafact.getjTexNumerodeComprobante().getText()));
                modfac.setTipopag(nuevafact.getjComboBoxTipoPago().getSelectedItem().toString());

                if (nuevafact.getBtnGuardarFactura().getText().equals("Guardar")) {
                    modfac.insertarFactura();
                    modfac.limpiar(nuevafact.getjPanelFactura().getComponents());
                    nuevafact.setVisible(false);
                    nuevafact.dispose();
                } else {
                    modfac.actualizarFactcompra();
                    nuevafact.setVisible(false);
                    nuevafact.dispose();
                    nuevafact.mostrarTablaFactCompra(prin.getjTableFactura(), "", "Factura");
                }
            }
        }

        if (e.getSource().equals(nuevafact.getBtnCacelar())) {
            nuevafact.dispose();
        }
    }

    //Actualizar factura compra
    void actualizarFactcompra(int doc) {
        modfac.buscarFactcompra(doc);
        nuevafact.getjTexNumerodeComprobante().setEnabled(false);
        nuevafact.getjTexIdententificacionProveedor().setText(String.valueOf(modfac.getProve()));
        nuevafact.getjTexIdentificacionUsuario().setText(String.valueOf(modfac.getUsu()));
        nuevafact.getjTexNumerodeComprobante().setText(String.valueOf(modfac.getCompro()));

        //Llenar tipo de pago
        nuevafact.getjComboBoxTipoPago().setSelectedItem(modfac.getTipopag());

        //Cambiar Titulo
        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Factura Compra",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Yu Gothic UI", 1, 36),
                new java.awt.Color(204, 0, 204));
        nuevafact.getjPanelFactura().setBorder(borde);
        prin.setVisible(false);
        nuevafact.setLocationRelativeTo(null);
        nuevafact.getBtnGuardarFactura().setText("Actualizar");
        nuevafact.setVisible(true);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (buscar.getjLabelBuscar().getText().equals("Usuario")) {
            modusu.mostrarTablaUsuario(buscar.getjTableBuscar(), buscar.getjTexBuscar().getText(), "Nueva Factura");
        } else {
            modprov.mostrarTablaProveedor(buscar.getjTableBuscar(), buscar.getjTexBuscar().getText(), "Nueva Factura");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (buscar.getjLabelBuscar().getText().equals("Usuario")) {
            modusu.mostrarTablaUsuario(buscar.getjTableBuscar(), buscar.getjTexBuscar().getText(), "Nueva Factura");
        } else {
            modprov.mostrarTablaProveedor(buscar.getjTableBuscar(), buscar.getjTexBuscar().getText(), "Nueva Factura");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (buscar.getjLabelBuscar().getText().equals("Usuario")) {
            modusu.mostrarTablaUsuario(buscar.getjTableBuscar(), buscar.getjTexBuscar().getText(), "Nueva Factura");
        } else {
            modprov.mostrarTablaProveedor(buscar.getjTableBuscar(), buscar.getjTexBuscar().getText(), "Nueva Factura");
        }
    }

}
