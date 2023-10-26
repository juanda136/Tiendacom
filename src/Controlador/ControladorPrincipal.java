package Controlador;

import Modelo.ModeloUsuario;
import Vista.NuevoProveedor;
import Vista.NuevoUsuario;
import Vista.Nuevocliente;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorPrincipal implements ActionListener {

    Principal prin = new Principal();
    NuevoUsuario nuevo = new NuevoUsuario();
    controladorUsuario conusu = new controladorUsuario();
    controladorproveedor conpro = new controladorproveedor();
    NuevoProveedor nuevopro = new NuevoProveedor();
    Nuevocliente nuevocli = new Nuevocliente();
    ControladorCliente concli = new ControladorCliente();

    
    public ControladorPrincipal() {

        prin.getBtnuevo().addActionListener(this);
        prin.getBtnProveedor().addActionListener(this);
        prin.getjBnCliente().addActionListener(this);
        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevopro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevocli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void iniciar() {
        prin.setLocationRelativeTo(null);
        prin.setTitle("Principal");
        prin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == (prin.getBtnuevo())) {
            conusu.Inicio();
            prin.setVisible(false);
        }
        
        if (e.getSource() == (prin.getBtnProveedor())) {
            conpro.Inicio();
            prin.setVisible(false);
        }
        
        if (e.getSource() == (prin.getjBnCliente())) {
            concli.Inicio();
            prin.setVisible(false);
        }
    }   
} 
    
/*@Override
   public void stateChanged(ChangeEvent e){
   int seleccion = prin.getJtprincipal().getSelectedIndex()==0){}
   if (seleccion ==0){
   gestion pestanas();
   }
   if seleccion==1){
   ModeloUsuario modUsu = ModeloUsuario();
   ModeloUsuario.mostrarTablaUsuario(prin.getTbUsuario(), valor "");

   prin.getTxtBuscar().addMouseListener)(new MouseAdappter)(){
    @Override
    public void mouseClicked(MouseEvent e){
    prin.getTxtBuscar(). SetTex("");
    prin.getTxtBuscar(). SetForeground(Color.BLACK);
    }
});
   prin.getTxtBuscar().addMouseListener)(new MouseAdappter)(){
    @Override
     public void insertUpdate(DocumentEvent e){
    modUsu.MostrarTablaUsuario(prin.getTbUsuario(), prin.getTxtBuscar().getText());
   }
    @Override
     public void removeUpdate(DocumentEvent e){
    modUsu.MostrarTablaUsuario(prin.getTbUsuario(), prin.getTxtBuscar().getText());
   }
    @Override
     public void changedUpdate(DocumentEvent e){
    modUsu.MostrarTablaUsuario(prin.getTbUsuario(), prin.getTxtBuscar().getText());
   }
});*/
