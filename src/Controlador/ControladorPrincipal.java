package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloFacturaC;
import Modelo.ModeloProducto;
import Modelo.ModeloProveedor;
import Modelo.ModeloUsuario;
import Vista.NuevoProducto;
import Vista.NuevoProveedor;
import Vista.NuevoUsuario;
import Vista.Nuevocliente;
import Vista.Principal;
import Vista.AgregarDetalleProducto;
import Vista.BuscarProducto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.mostrartablacliente;

public class ControladorPrincipal implements ActionListener, ChangeListener, DocumentListener {

    Principal prin = new Principal();
    NuevoUsuario nuevo = new NuevoUsuario();
    controladorUsuario conusu = new controladorUsuario();
    controladorproveedor conprov = new controladorproveedor();
    ControladorCliente concli = new ControladorCliente();
    ControladorProducto conprod = new ControladorProducto();
    ControladorFacturaC confac = new ControladorFacturaC();
    
    
    BuscarProducto buscaproduc = new buscarProducto();
    NuevoProveedor nuevopro = new NuevoProveedor();
    Nuevocliente nuevocli = new Nuevocliente();
    NuevoProducto nuevoprod = new NuevoProducto();
    ModeloUsuario modUsu = new ModeloUsuario();
    ModeloProveedor modProv = new ModeloProveedor();
    ModeloCliente modCli = new ModeloCliente();
    ModeloProducto modProd = new ModeloProducto();
    ModeloFacturaC modfac= new ModeloFacturaC();

    public ControladorPrincipal() {//metodoconstructor 
        prin.getBtnNuevo().addActionListener(this);
        prin.getBtnBuscarUsuario().addActionListener(this);
        prin.getBtnProveedor().addActionListener(this);
        prin.getBtnCliente().addActionListener(this);
        prin.getBtnProducto().addActionListener(this);
        
        agredetaproducto.getBtnbuscarproducto().addActionListener(this);
        
        prin.getJtTienda().addChangeListener(this);

        prin.getjTexBuscarUsuario().getDocument().addDocumentListener(this);
        prin.getjTexBuscarProducto().getDocument().addDocumentListener(this);
        prin.getjTexBuscarFactura().getDocument().addDocumentListener(this);
        
        
        agredetaproduc.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                prin.setVisible(true);
                agredetaproduc.setVisible(false);
            }
        });

        mostradetalle.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                prin.setVisible(true);
                mostradetalle.setVisible(false);
            }
        });

    }
        
//        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        nuevopro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        nuevocli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        nuevoprod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    

    public void Iniciar() {
        prin.setLocationRelativeTo(null);
        prin.setTitle("Principal");
        prin.setVisible(true);
            gestionUsuario();//llamo al metodo de Gestion usuario
    }
    //modificar correo   
   public boolean validarCorreo(String correo) {
        String valor = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Z|a-z]{2,}$";
        Pattern validar = Pattern.compile(valor);
        Matcher cor = validar.matcher(correo);
        return cor.matches();
    }

    public void gestionUsuario() {

        modUsu.mostrarTablaUsuario(prin.getjTableUsuario(), "", "usuario");

        prin.getjTableUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prin.getjTableUsuario().setText("");
                prin.getjTableUsuario().setForeground(new java.awt.Color(0, 0, 0));
            }

        });

        prin.getjTableUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getjTableUsuario().rowAtPoint(e.getPoint());
                int columna = prin.getjTableUsuario().columnAtPoint(e.getPoint());
                modUsu.setDoc(Integer.parseInt(prin.getjTableUsuario().getValueAt(fila, 0).toString()));

                if (columna == 9) {
                    prin.setVisible(false);
                    conusu.actualizarUsuario(modUsu.getDoc());
                }
                if (columna == 10) {
                    conusu.eliminarUsuario(modUsu.getDoc());
                    modUsu.mostrarTablaUsuario(prin.getjTableUsuario(), "", "usuario");
                }
            }
        });
    }

    public void gestionCliente() {
        modCli.mostrarTablaCliente(prin.getjTableCliente(), "", "Cliente");
        prin.getJtexBuscarCli().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prin.getJtexBuscarCli().setText("");
                    prin.getjTableCliente().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
        //Para darle clic al boton de editar
        prin.getjTableCliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getjTableCliente().rowAtPoint(e.getPoint());
                int colum = prin.getjTableCliente().columnAtPoint(e.getPoint());
                modCli.setCedu(Integer.parseInt(prin.getjTableCliente().getValueAt(fila, 0).toString()));

                if (colum == 8) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    concli.actualizarCliente(modCli.getCedu());
                }
                if (colum == 9) {
                    concli.eliminarCliente(modCli.getCedu());
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    modCli.mostrarTablaCliente(prin.getjTableCliente(), "", "Cliente");
                }
            }
        });
    }

    public void gestionProveedor() {
        modProv.mostrarTablaProveedor(prin.getjTableProveedor(), "", "Proveedor");
        prin.getjTableProveedor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prin.getjTableProveedor().setText("");
                prin.getjTableProveedor().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
        //Para darle clic al boton de editar
        prin.getjTableProveedor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getjTableProveedor().rowAtPoint(e.getPoint());
                int colum = prin.getjTableProveedor().columnAtPoint(e.getPoint());
                modProv.setDoc(Integer.parseInt(prin.getjTableProveedor().getValueAt(fila, 0).toString()));

                if (colum == 9) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    conprov.actualizarProveedor(modProv.getDoc());
                }
                if (colum == 10) {
                    conprov.eliminarProveedor(modProv.getDoc());
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    modProv.mostrarTablaProveedor(prin.getjTableProveedor(), "", "Proveedor");
                }
            }
        });
    }

    public void gestionProducto() {
        modProd.mostrarTablaProducto(prin.getjTableProducto(), "", "Producto");
        prin.getjTexBuscarProducto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prin.getjTexBuscarProducto().setText("");
                prin.getjTexBuscarProducto().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
        //Para darle clic al boton de editar
        prin.getjTableProducto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getjTableProducto().rowAtPoint(e.getPoint());
                int colum = prin.getjTableProducto().columnAtPoint(e.getPoint());
                modProd.setDoc(Integer.parseInt(prin.getjTableProducto().getValueAt(fila, 0).toString()));

                if (colum == 6) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    conprod.actualizarProducto(modProd.getDoc());
                }
                if (colum == 7) {
                    conprod.eliminarProducto(modProd.getDoc());
                    JOptionPane.showMessageDialog(null, "Producto Eliminado");
                    modProd.mostrarTablaProducto(prin.getjTableProducto(), "", "Producto");
                }
            }
        });
    }
    public void gestionFacturaC() {
        modfac.mostrarTablaFactCompra(prin.getjTableFactura(), "", "Factura");
        prin.getjTexBuscarFactura().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prin.getjTexBuscarFactura().setText("");
                prin.getjTexBuscarFactura().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
        //Para darle clic al boton de editar
        prin.getjTableFactura().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getjTableFactura().rowAtPoint(e.getPoint());
                int colum = prin.getjTableFactura().columnAtPoint(e.getPoint());
                modfac.setIdfact(Integer.parseInt(prin.getjTableFactura().getValueAt(fila, 0).toString()));

                if (colum == 8) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    confac.actualizarFactcompra(modfac.getIdfact());
                    confac.buscar();
                }
                if (colum == 9) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    agredetaproduc.setVisible(true);
                    agredetaproduc.setLocationRelativeTo(null);
                    agredetaproduc.setTitle("Agregar Detalle");
                    conprod.modproduc.mostrarTablaProducto(agredetaproduc.getJTablaagragarproducto(), "", "Producto");

//                    controfact.modfactnuev.mostrarTablaDetalleFactCompra(agredetaproduc.getJTablaagragarproducto(), "", "Agregarfact");
                }
                if (colum == 10) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mostradetalle.setVisible(true);
                    mostradetalle.setLocationRelativeTo(null);
                    confac.modfactnuev.mostrarTablaDetalleFactCompra(mostradetalle.getJTablaMostrarDetalleFactura(), "", "Mostrarfact");
                    //Activar el txt de la vista mostrar detalle
                    mostradetalle.getTxtbuscardetalle().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            mostradetalle.getTxtbuscardetalle().setText("");
                            mostradetalle.getTxtbuscardetalle().setForeground(new java.awt.Color(0, 0, 0));
                        }
                    });
                }
                if (colum == 11) {
                    prin.setVisible(false);
                    prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(prin.getBtnNuevo())) {
            System.out.println("Lo escuchó");
        }

        if (e.getSource() == (prin.getBtnNuevo())) {
            conusu.InicioUsuario();
            prin.setVisible(false);
        }

        if (e.getSource() == (prin.getBtnProveedor())) {
            conprov.InicioProveedor();
            prin.setVisible(false);
        }

        if (e.getSource() == (prin.getBtnCliente())) {
            concli.InicioCliente();
            prin.setVisible(false);
        }
        if (e.getSource() == (prin.getBtnProducto())) {
            conprod.InicioProducto();
            prin.setVisible(false);
        }
 if (e.getSource().equals(prin.getBtnFactura())) {
            prin.setVisible(false);
            confac.controlFacturaCompra();

        }
        if (e.getSource().equals(agreDeProd.getBtnBuscarProducto())) {
            buscaproduc.setVisible(true);
            buscaproduc.setLocationRelativeTo(null);
            modProd.mostrarTablaProducto(buscaproduc.getJTablaBuscarproducto(), "", "Produ");
//Activar el TXTbuscar producto
            buscaproduc.getTxtbuscarproducto().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buscaproduc.getTxtbuscarproducto().setText("");
                    buscaproduc.getTxtbuscarproducto().setForeground(new java.awt.Color(0, 0, 0));
                }
            });
//boton agregar en la caja de texto el producto             
            buscaproduc.getJTablaBuscarproducto().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int fila = buscaproduc.getJTablaBuscarproducto().rowAtPoint(e.getPoint());
                    int colum = buscaproduc.getJTablaBuscarproducto().columnAtPoint(e.getPoint());

//Activar el boton de agregar producto
                    modProd.setDoc(Integer.parseInt(buscaproduc.getJTablaBuscarproducto().getValueAt(fila, 0).toString()));
                    if (colum == 6) {
//                        buscaproduc.setVisible(false);
//                        agredetaproduc.setVisible(true);
                        int nom = modProd.getDoc();
                        modProd.buscarProducto(nom);
                        agredetaproduc.getTxtnomproduc().setText(modProd.getNom());
//                        JOptionPane.showMessageDialog(null, "Producto Agregado");
                    }
                }
            });
        }
    }


    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getJtTienda().getSelectedIndex();
        if (seleccion == 0) {
            gestionUsuario();
        }
        if (seleccion == 1) {
            gestionCliente();
        }
        if (seleccion == 2) {
            gestionProveedor();
        }
        if (seleccion == 3) {
            gestionProducto();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getjTableUsuario(), prin.getjTableUsuario().getText(), "Usuario");
        modCli.mostrarTablaCliente(prin.getjTableCliente(), prin.getjTableCliente().getText(), "Cliente");
        modProv.mostrarTablaProveedor(prin.getjTableProveedor(), prin.getjTableProveedor().getText(), "Proveedor");
        modProd.mostrarTablaProducto(prin.getjTableProducto(), prin.getjTableProducto().getText(), "Producto");

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getjTableUsuario(), prin.getjTableUsuario().getText(), "Usuario");
        modCli.mostrarTablaCliente(prin.getjTableCliente(), prin.getjTableCliente().getText(), "Cliente");
        modProv.mostrarTablaProveedor(prin.getjTableProveedor(), prin.getjTableProveedor().getText(), "Proveedor");
        modProd.mostrarTablaProducto(prin.getjTableProducto(), prin.getjTableProducto().getText(), "Producto");

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getjTableUsuario(), prin.getjTableUsuario().getText(), "Usuario");
        modCli.mostrarTablaCliente(prin.getjTableCliente(), prin.getjTableCliente().getText(), "Cliente");
        modProv.mostrarTablaProveedor(prin.getjTableProveedor(), prin.getjTableProveedor().getText(), "Proveedor");
        modProd.mostrarTablaProducto(prin.getjTableProducto(), prin.getjTableProducto().getText(), "Producto");

    }

}
