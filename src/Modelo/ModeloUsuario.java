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
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ModeloUsuario {

    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();

    private int doc, sex, TipoDocumento, Cargo;
    private String nom, dir, tele, cor, log, clave;
    private Date fec;

    public int getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(int TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public int getCargo() {
        return Cargo;
    }

    public void setCargo(int Cargo) {
        this.Cargo = Cargo;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

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

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Map<String, Integer> llenarCombo(String valor) {
        String sql = "Select * from mostrar_" + valor;

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

    public void insertarUsuario() {

        String sql = "CALL ins_usuario(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getTipoDocumento());
            ps.setInt(2, getDoc());
            ps.setString(3, getNom());
            ps.setString(4, getTele());
            ps.setString(5, getCorreo());
            ps.setString(6, getDir());
            ps.setDate(7, getFec());
            ps.setInt(8, getSex());
            ps.setInt(9, getCargo());
            ps.setString(10, getLog());
            ps.setString(11, getClave());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario insertado con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());

            conect.cerrarConexion();
        }
    }

    public void limpiarCampos(Component[] panelusu) {
        for (Object limpiar : panelusu) {
            if (limpiar instanceof JTextField) {
                ((JTextField) limpiar).setText("Campo de texto limpiado.");

            }
            if (limpiar instanceof JComboBox) {
                ((JComboBox) limpiar).setSelectedItem("seleccione...");
                System.out.println("Selección del JComboBox restaurada a 'seleccione...'.");
            }
            if (limpiar instanceof JDateChooser) {
                ((JDateChooser) limpiar).setDate(null);
                System.out.println("Fecha del JDateChooser restablecida a nula.");

            }
        }
    }

    public void mostrarTablaUsuario(JTable tabla, String valor, String nomPesta) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        //encabezado personalizado
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer((TableCellRenderer) new GestionEncabezado());
        tabla.setTableHeader(encabezado);

        tabla.setDefaultRenderer(Object.class, new GestionCeldas());

        JButton editar = new JButton();
        JButton eliminar = new JButton();
        JButton agregar = new JButton();

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png")));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar_archivo.png")));

        String[] titulo = {"Tipo de Documento", "Documento", "Nombre", "Correo", "Dirección", "Telefono", "Género", "Fecha de Nacimiento", "Rol"};
        int total = titulo.length;

        if (nomPesta.equals("usuario")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }

        DefaultTableModel tablaUsuario = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sqlUsuario;
        if (valor.equals("")) {
            sqlUsuario = " SELECT * FROM mostrar_usuario ";
        } else {
            sqlUsuario = "call usuario_cons('" + valor + "')";
        }
        try {
            String[] dato = new String[titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlUsuario);
            while (rs.next()) {
                for (int i = 0; i < total; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                Object[] fila = {dato[0], dato[1], dato[2], dato[6], dato[3], dato[4], dato[5], dato[7], dato[8]};
                if (nomPesta.equals("usuario")) {
                    fila = Arrays.copyOf(fila, fila.length + 2);
                    fila[fila.length - 2] = editar;
                    fila[fila.length - 1] = eliminar;
                } else {
                    fila = Arrays.copyOf(fila, fila.length + 1);
                    fila[fila.length - 1] = agregar;
                }
                tablaUsuario.addRow(fila);
            }
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaUsuario);
        //Darle tamaño a cada columna
        int numColumnas = tabla.getColumnCount();
        int[] tamanos = {150, 100, 180, 150, 100, 100, 200, 150, 100};

        if (nomPesta.equals("usuario")) {
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

    public void buscarUsuario(int valor) {

        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();
        String sql = "call bus_Usuario (" + valor + ")";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                setDoc(rs.getInt(1));
                setTipoDocumento(rs.getInt(2));
                setNom(rs.getString(3));
                setTele(rs.getString(4));
                setCor(rs.getString(5));
                setDir(rs.getString(6));
                setFec(rs.getDate(7));
                setSex(rs.getInt(8));
                setCargo(rs.getInt(9));
                setLog(rs.getString(10));
                setClave(rs.getString(11));

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

    public void actualizarUsuario() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();
        String actUsuario = "call usuario_act (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(actUsuario);
            ps.setInt(1, getDoc());
            ps.setString(2, getNom());
            ps.setString(3, getTele());
            ps.setString(4, getCorreo());
            ps.setString(5, getDir());
            ps.setDate(6, getFec());
            ps.setInt(7, getSex());
            ps.setInt(8, getCargo());
            ps.setString(9, getClave());
            ps.executeUpdate();  // Ejecutar la inserción
            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conect.cerrarConexion();
    }

    public void eliminarUsuario() {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String sql= "Call usuario_elim(?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getDoc());
            ps.executeUpdate();
            Icon eliminar = new ImageIcon(getClass().getResource("/img/eliminar(2).png"));
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar Usuario", JOptionPane.PLAIN_MESSAGE, (Icon) eliminar);
        cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conect.cerrarConexion();
    }

}
