
package Modelo;


import Controlador.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class ModeloProveedor {
    
   
    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();
    
  
    private int sex, tipodedocument, tipodeperson;
    private String nom, dir,tele,cor;
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
      public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public int getTipodedocument() {
        return tipodedocument;
    }

    public void setTipodedocument(int tipodedocument) {
        this.tipodedocument = tipodedocument;
    }

    public int getTipodeperson() {
        return tipodeperson;
    }

    public void setTipodeperson(int tipodeperson) {
        this.tipodeperson = tipodeperson;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    
 
    public Map<String,Integer> llenarCombo(String sexo){
        String sql="Select * from mostrar_sexo";
        
        Map<String,Integer> llenar_combo = new HashMap<>();
        try {
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                llenar_combo.put(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException e) { e.printStackTrace();
        }
        return llenar_combo;
    }
}