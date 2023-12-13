package Modelo;

import Controlador.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.PreparedStatement;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class ModeloProveedor {

    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();

    private int sex, doc;
    private String nom, dir, tele, cor, tipodedocumento, tipodepersona;
    private Date fec;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return cor;
    }

    public void setCorreo(String cor) {
        this.cor = cor;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getTipodedocumento() {
        return tipodedocumento;
    }

    public void setTipodedocumento(String tipodedocumento) {
        this.tipodedocumento = tipodedocumento;
    }

    public String getTipodepersona() {
        return tipodepersona;
    }

    public void setTipodepersona(String tipodepersona) {
        this.tipodepersona = tipodepersona;
    }

    public int getDocumento() {
        return doc;
    }

    public void setDocumento(int documento) {
        this.doc = documento;
    }

    public Map<String, Integer> llenarCombo(String sexo) {
        String sql = "Select * from mostrar_sexo";

        Map<String, Integer> llenar_combo = new HashMap<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                llenar_combo.put(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llenar_combo;
    }
    
    public void insertarProveedor() {
        //Llamamos a la clase conexión
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();//Instanciamos la conexion

        String sql = "Call proveedor_ins(?,?,?,?,?,?,?,?,?)";//Consulta a realizar a la base de datos
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getDocumento());
            ps.setString(2, getTipodedocumento());
            ps.setString(3, getNom());
            ps.setString(4, getTipodepersona());
            ps.setDate(5, getFec());
            ps.setInt(5, getSex());
            ps.setString(7, getTele());
            ps.setString(8, getCorreo());
            ps.setString(9, getDir());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Almacenado");
            cn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerrarConexion();
    }

    public void limpiar(Component[] panelprov) {
        for (Object limpie : panelprov) {
            if (limpie instanceof JTextField) {
                ((JTextField) limpie).setText("");
            }
            if (limpie instanceof JComboBox) {
                ((JComboBox) limpie).setSelectedItem("Seleccione...");
            }
            if (limpie instanceof JDateChooser) {
                ((JDateChooser) limpie).setDate(null);
            }
        }

    }
  public void mostrarTablaProveedor(JTable tabla, String valor, String nomPesta) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        //Personalizar Encabezado
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new GestionEncabezado());
        tabla.setTableHeader(encabezado);

        tabla.setDefaultRenderer(Object.class, new GestionCeldas());

        JButton editar = new JButton();
        JButton eliminar = new JButton();
        JButton agregar = new JButton();

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png")));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar_archivo.png")));
        String[] titulo = {"Tipo de Documento", "Documento", "Nombre", "Tipo Persona", "Dirección", "Telefono", "Sexo", "Correo", "Fecha de Nacimiento"};
        int total = titulo.length;

        if (nomPesta.equals("proveedor")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }

        DefaultTableModel tablaProveedor = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sqlCliente = valor.isEmpty() ? "SELECT * FROM mostrar_proveedor " : "call proveedor_cons('" + valor + "')";

        try {
            String[] dato = new String[titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlCliente);
            while (rs.next()) {
                for (int i = 0; i < total; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                Object[] fila = {dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6], dato[7], dato[8]};
                if (nomPesta.equals("proveedor")) {
                    fila = Arrays.copyOf(fila, fila.length + 2);
                    fila[fila.length - 2] = editar;
                    fila[fila.length - 1] = eliminar;
                } else {
                    fila = Arrays.copyOf(fila, fila.length + 1);
                    fila[fila.length - 1] = agregar;
                }
                tablaProveedor.addRow(fila);
            }
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaProveedor);
        //Darle tamaño a cada columna
        int numColumnas = tabla.getColumnCount();
        int[] tamanos = {150, 100, 150, 130, 150, 100, 100, 200, 150};

        if (nomPesta.equals("proveedor")) {
            tamanos = Arrays.copyOf(tamanos, tamanos.length + 2);
            tamanos[tamanos.length - 2] = 20;
            tamanos[tamanos.length - 1] = 20;
        } else {
            tamanos = Arrays.copyOf(tamanos, tamanos.length + 1);
            tamanos[tamanos.length - 1] = 20;
        }
        for (int i = 0; i < numColumnas; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(tamanos[i]);
        }
        conect.cerrarConexion();
    }
  public void buscarProveedor(int valor) {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();
        String sql = "call proveedor_bus(" + valor + ")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                setDocumento(rs.getInt(1));
                setTipodedocumento(rs.getString(2));
                setNom(rs.getString(3));
                setTipodepersona(rs.getString(4));
                setFec(rs.getDate(5));
                setSex(rs.getInt(6));
                setTele(rs.getString(7));
                setCorreo(rs.getString(8));
                setDir(rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String obtenerSeleccion(Map<String, Integer> dato, int valor) {
        for (Map.Entry<String, Integer> seleccion : dato.entrySet()) {
            if (seleccion.getValue() == valor) {
                return seleccion.getKey();
            }
        }
        return null;
    }

    public void actualizarProveedor() {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String actProveedor = "call proveedor_act(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(actProveedor);
            ps.setInt(1, getDocumento());
            ps.setString(2, getTipodedocumento());
            ps.setString(3, getNom());
            ps.setString(4, getTipodepersona());
            ps.setDate(5, getFec());
            ps.setInt(5, getSex());
            ps.setString(7, getTele());
            ps.setString(8, getCorreo());
            ps.setString(9, getDir());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Almacenado");
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(String sql) {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String eliProveedor = "Call proveedor_elim(?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getDocumento());
            ps.executeUpdate();
            Icon eliminar = new ImageIcon(getClass().getResource("/img/eliminar(2).png"));
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar Proveedor", JOptionPane.PLAIN_MESSAGE, (Icon) eliminar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

