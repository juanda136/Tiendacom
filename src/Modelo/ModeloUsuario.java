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
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModeloUsuario {

    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();

    private int doc, sex, Tip, Cargo;

    public int getTip() {
        return Tip;
    }

    public int getCargo() {
        return Cargo;
    }

    public void setCargo(int Cargo) {
        this.Cargo = Cargo;
    }

    public void setTip(int Tip) {
        this.Tip = Tip;
    }
    private String nom, dir, tele, cor, log, clave;
    private Date fec;

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
        String sql = "CALL ins_usuario(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getDoc());
            ps.setString(2, getNom());
            ps.setString(3, getTele());
            ps.setString(4, getCorreo());
            ps.setString(5, getDir());
            ps.setDate(6, getFec());
            ps.setInt(7, getSex());
            ps.setInt(8, getCargo());
            ps.setString(9, getLog());
            ps.setString(10, getClave());
            ps.executeUpdate();  // Ejecutar la inserción
            JOptionPane.showMessageDialog(null, "Usuario insertado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    public void limpiarCampos(Component[] panel) {
        for (Object limpiar : panel) {
            if (limpiar instanceof JTextField) {
                ((JTextField) limpiar).setText("Campo de texto limpiado.");

            }
            if (limpiar instanceof JComboBox) { // Corregido el nombre de la clase
                ((JComboBox) limpiar).setSelectedItem("seleccione...");
                System.out.println("Selección del JComboBox restaurada a 'seleccione...'.");
            }
            if (limpiar instanceof JDateChooser) {
                ((JDateChooser) limpiar).setDate(null);
                System.out.println("Fecha del JDateChooser restablecida a nula.");

            }
        }
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
                setTip(rs.getInt(2));
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

}
