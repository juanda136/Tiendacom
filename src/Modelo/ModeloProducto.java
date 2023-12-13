package Modelo;

import Controlador.Conexion;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import static java.util.Locale.filter;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author JUAN DAVID SEPULVEDA
 */
public class ModeloProducto {

    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();

    private String nom, des, ruta;
    private byte imagen[];
    private int doc;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public void buscarImangen() {
        JFileChooser archivos = new JFileChooser();

        archivos = new JFileChooser();
        String rutacarpeta = getClass().getClassLoader().getResource("producto").getPath();
        File carpeta = new File(rutacarpeta);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        archivos.setFileFilter(filtro);
        if (archivos.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            setRuta(archivos.getSelectedFile().getAbsolutePath());

        }
    }

    public byte[] obtenerimagen(String ruta) {
        try {
            File archivo = new File(ruta);
            byte[] foto = new byte[(int) archivo.length()];
            InputStream img = new FileInputStream(archivo);
            img.read(foto);

            return foto;

        } catch (IOException e) {
            return null;
        }

    }

    public void insertarProducto() {

        String insProducto = "call producto_ins(?,?,?,?,)";
        try {

        } catch (Exception e) {
        }
        try {
            PreparedStatement ps = cn.prepareStatement(insProducto);
            ps.setString(1, getNom());
            ps.setString(2, getDes());
            ps.setBytes(3, getImagen());
            ps.setString(4, getRuta());
            ps.executeUpdate();
            JOptionPane.showInputDialog(null, "registro Guardado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void limpiar(Component[] panelprod) {
        for (Object limpie : panelprod) {
            if (limpie instanceof JTextField) {
               ( (JTextField)limpie).setText("");
            }
            if (limpie instanceof JScrollPane) {
                Component[] limpiando = ((JScrollPane)limpie).getViewport().getComponents();
                for (Object controltText : limpiando) {
                    if (controltText instanceof JTextArea ) {
                        ((JTextArea)controltText).setText("");
                    }
                }
            }
        }
    }
  public void mostrarTablaProducto(JTable tabla, String valor, String nomPesta) {
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
         String[] titulo = {"Código", "Imagen", "Producto", "Descripción", "Existencia", "Precio"};

        int total = titulo.length;//Para gardar el tamaño del cector titulo original
//        agregarBoton(nomPesta, titulo, "", "", "");
        if (nomPesta.equals("producto")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }
        DefaultTableModel tablaProducto = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sqlProducto = valor.isEmpty() ? "select * from mostrar_producto" : "call producto_cons('" + valor + "')";

        try {
            String datos[] = new String[total];
            Object dato[] = new Object[total];
        
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlProducto);

            while (rs.next()) {
                dato[0] = rs.getString(1);
                try {
                    byte[] imag = rs.getBytes(2);
                    BufferedImage bfImag = null;
                    InputStream inStr = new ByteArrayInputStream(imag);
                    bfImag = ImageIO.read(inStr);
                    ImageIcon imagen = new ImageIcon(bfImag.getScaledInstance(60, 60, 0));
                    dato[1] = new JLabel(imagen);
                } catch (Exception e) {
                    dato[1] = new JLabel("No Imagenes");
                }

                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getInt(5);
                dato[5] = rs.getInt(6);

                Object[] fila = {dato[0], dato[1], dato[2], dato[3], dato[4], dato[5]};
                if (nomPesta.equals("producto")) {
                    fila = Arrays.copyOf(fila, fila.length + 2);
                    fila[fila.length - 2] = editar;
                    fila[fila.length - 1] = eliminar;
                } else {
                    fila = Arrays.copyOf(fila, fila.length + 1);
                    fila[fila.length - 1] = agregar;
                }
                tablaProducto.addRow(fila);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaProducto);
        //Darle tamaño a cada columna
        int numColumnas = tabla.getColumnCount();
        int[] tamanos = {50, 300, 250, 300, 100, 100};

        if (nomPesta.equals("producto")) {
            tamanos = Arrays.copyOf(tamanos, tamanos.length + 2);
            tamanos[tamanos.length - 2] = 15;
            tamanos[tamanos.length - 1] = 15;
        } else {
            tamanos = Arrays.copyOf(tamanos, tamanos.length + 1);
            tamanos[tamanos.length - 1] = 15;
        }
        for (int i = 0; i < numColumnas; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(tamanos[i]);
        }
        conect.cerrarConexion();
    }
 public void buscarProducto(int valor) {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();
        String sql = "call buscar_producto(" + valor + ")";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                setDoc(rs.getInt(1));
                setNom(rs.getString(2));
                setDes(rs.getString(3));
                setImagen(rs.getBytes(5));
                setRuta(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //ACTUALIZAR Producto
    public void actualizarProducto() {
        Conexion conect = new Conexion();
        Connection con = conect.iniciarConexion();
        String sql = "call actualizar_producto(?,?,?,?,?)";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getDoc());
            ps.setString(2, getNom());
            ps.setString(3, getDes());
            ps.setBytes(4, getImagen());
            ps.setString(5, getRuta());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Información Actualizada");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conect.cerrarConexion();
    }
    
     //ELIMINAR PRODUCTO
    public void eliminarProducto() {
        Conexion conect = new Conexion();
        Connection con = conect.iniciarConexion();
        String sql = "call eliminar_producto(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getDoc());
            ps.executeUpdate();
            Icon elimina = new ImageIcon(getClass().getResource("/img/basura.png"));
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar Usuario", JOptionPane.PLAIN_MESSAGE, (Icon) elimina);
//            JOptionPane.showMessageDialog(null, "¿Desea Eliminar el Registro?");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conect.cerrarConexion();
    }
}


