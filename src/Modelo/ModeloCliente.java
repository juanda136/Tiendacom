package Modelo;

import Controlador.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
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
import javax.swing.table.TableColumn;

public class ModeloCliente {

    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();

    private int sex, cedu;
    private String nom, dir, tele, cor, tipod;
    private Date fec;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getCedu() {
        return cedu;
    }

    public String getTipod() {
        return tipod;
    }

    public void setTipod(String tipod) {
        this.tipod = tipod;
    }

    public void setCedu(int cedu) {
        this.cedu = cedu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
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

    public void insertarCliente() {
        //Llamamos a la clase conexión
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();//Instanciamos la conexion

        String sql = "Call cliente_ins(?,?,?,?,?,?,?,?)";//Consulta a realizar a la base de datos
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, getTipod());
            ps.setInt(2, getCedu());
            ps.setString(3, getNom());
            ps.setString(4, getTele());
            ps.setDate(5, getFec());
            ps.setInt(6, getSex());
            ps.setString(9, getCor());
            ps.setString(10, getDir());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rgistro Insertado");
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerrarConexion();
    }

public void limpiar(Component[] panelCli) {
        for (Object limpiar : panelCli) {
            if (limpiar instanceof JTextField) {
                ((JTextField) limpiar).setText("");
            }
            if (limpiar instanceof JComboBox) {
                ((JComboBox) limpiar).setSelectedItem("Seleccione...");
            }
            if (limpiar instanceof JDateChooser) {
                ((JDateChooser) limpiar).setDate(null);
            }
}
}
 public void mostrarTablaCliente(JTable tabla, String valor, String nomPes) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        //Personalizar Encabezado
        JTableHeader encabez = tabla.getTableHeader();
        encabez.setDefaultRenderer(new GestionEncabezado());
        tabla.setTableHeader(encabez);

        tabla

.setDefaultRenderer(Object.class  

, new GestionCeldas());

        JButton editar = new JButton();
        JButton eliminar = new JButton();
        JButton agregar = new JButton();

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png")));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar_archivo.png")));

        String[] titulo = {"Tipo de Documento", "Documento", "Nombre", "Dirección", "Celular", "Género", "Correo", "Fecha de Nacimiento"};
        int total = titulo.length;

        if (nomPes.equals("cliente")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }

        DefaultTableModel tablaCliente = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sqlCliente = valor.isEmpty() ? "SELECT * FROM mostrar_cliente " : "call cliente_cons('" + valor + "')";

        try {
            String[] dato = new String[titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlCliente);
            while (rs.next()) {
                for (int i = 0; i < total; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                Object[] fila = {dato[1], dato[0], dato[2], dato[7], dato[3], dato[5], dato[6], dato[4]};
                if (nomPes.equals("cliente")) {
                    fila = Arrays.copyOf(fila, fila.length + 2);
                    fila[fila.length - 2] = editar;
                    fila[fila.length - 1] = eliminar;
                } else {
                    fila = Arrays.copyOf(fila, fila.length + 1);
                    fila[fila.length - 1] = agregar;
                }
                tablaCliente.addRow(fila);
            }
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaCliente);
        //Darle tamaño a cada columna
        int numColumnas = tabla.getColumnCount();
        int[] tamanos = {150, 150, 150, 150, 100, 100, 200, 130};

        if (nomPes.equals("cliente")) {
            tamanos = Arrays.copyOf(tamanos, tamanos.length + 2);
            tamanos[tamanos.length - 2] = 30;
            tamanos[tamanos.length - 1] = 30;
        } else {
            tamanos = Arrays.copyOf(tamanos, tamanos.length + 1);
            tamanos[tamanos.length - 1] = 30;
        }
        for (int i = 0; i < numColumnas; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(tamanos[i]);

        }
        conect.cerrarConexion();
 }
   public void buscarCliente(int valor) {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();
        String sql = "call cliente_bus(" + valor + ")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                setTipod(rs.getString(1));
                setCedu(rs.getInt(2));
                setNom(rs.getString(3));
                setTele(rs.getString(4));
                setFec(rs.getDate(5));
                setSex(rs.getInt(6));
                setCor(rs.getString(7));
                setDir(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String obtenerSeleccion(Map<String, Integer> datocli, int valor) {
        for (Map.Entry<String, Integer> seleccion : datocli.entrySet()) {
            if (seleccion.getValue() == valor) {
                return seleccion.getKey();
            }
        }
        return null;
}
public void actualizarCliente() {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String actCliente = "call cliente_act(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(actCliente);
            ps.setString(1, getTipod());
            ps.setInt(2, getCedu());
            ps.setString(3, getNom());
            ps.setString(4, getTele());
            ps.setDate(5, getFec());
            ps.setInt(6, getSex());
            ps.setString(7, getCor());
            ps.setString(8, getDir());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void eliminarCliente(String sql) {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String eliCliente = "Call cliente_elim(?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getCedu());
            ps.executeUpdate();
            Icon eliminar = new ImageIcon(getClass().getResource("/img/eliminar(2).png"));
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar Cliente", JOptionPane.PLAIN_MESSAGE, (Icon) eliminar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}