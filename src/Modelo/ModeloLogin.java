
package Modelo;

import Controlador.Conexion;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloLogin {

    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();
    private String usu, contra;
    Tiendacom lg = new Tiendacom();

    public ModeloLogin() {

    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean validar(String usuario, String pass) {
        boolean result = false;

        String sql = "call login(?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
          
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
            if(result==true){
                cn.close();
                conect.cerrarConexion();
            }
            
            
        }catch (SQLException e) {
        e.printStackTrace();}
        
        
        return result;
    }

}
