package Modelo;

import Controlador.Conexion;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 *
 * @author HP
 */
public class ModeloFacturaC {

    private int fact, usu, prove;

    public int getFac() {
        return fact;
    }

    public void setFac(int fac) {
        this.fact = fac;
    }

    public int getUsu() {
        return usu;
    }

    public void setUsu(int usu) {
        this.usu = usu;
    }

    public int getProve() {
        return prove;
    }

    public void setProve(int prove) {
        this.prove = prove;
    }

    public ModeloFacturaC() {
    }

    public void insertarFactura() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        String sql = "call factura_compra_ins(?, ?)";//Consulta a la base de datos
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getProve());
            ps.setInt(2, getUsu());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Almacenado");
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void limpiar(Component[] panel) {
        for (Object limpie : panel) {
            if (limpie instanceof JTextField) {
                ((JTextField) limpie).setText("");
            }

        }

    }

    public void mostrarTablaFactura(JTable tabla, String valor) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        //Personalizar Encabezado
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new GestionEncabezado());
        tabla.setTableHeader(encabezado);

        tabla.setDefaultRenderer(Object.class, new GestionCeldas());

        JButton ver = new JButton();
        JButton agregar = new JButton();

        ver.setToolTipText("Ver Detalle Factura");
        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png")));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png")));
        agregar.setToolTipText("Agregar Detalle Factura");
//        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-usuario.png")));

        Object[] titulo = {"Factura", "Proveedor", "Usuario", "Fecha", "Tipo de Comprobante ", "Numero de Comprobante", "Total"};

        int total = titulo.length;//Para gardar el tamaño del cector titulo original
        titulo = Arrays.copyOf(titulo, titulo.length + 2);
        titulo[titulo.length - 2] = "";
        titulo[titulo.length - 1] = "";

        DefaultTableModel tablaFactura = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String sqlFactura = valor.isEmpty() ? "SELECT * FROM mostrar_factura_compra" : "call factura_compra('" + valor + "')";
        try {
            String[] dato = new String[titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlFactura);
            while (rs.next()) {
                for (int i = 0; i < total; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                Object[] fila = {dato[0], dato[1], dato[2], dato[5], dato[3], dato[4], dato[6]};
                fila = Arrays.copyOf(fila, fila.length + 2);
                fila[fila.length - 2] = ver;
                fila[fila.length - 1] = agregar;

                tablaFactura.addRow(fila);
            }
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaFactura);
        //Darle tamaño a cada columna
        int numColumnas = tabla.getColumnCount();
        int[] tamanos = {80, 200, 200, 120, 140, 150, 130, 20, 20};

        for (int i = 0; i < numColumnas; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(tamanos[i]);
        }
       
        conect.cerrarConexion();

    }

}
