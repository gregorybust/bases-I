/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.Date;
import java.text.DateFormat;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import javax.print.DocFlavor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class Controladora {
    JasperReport reporte;
    JasperPrint reporteLLeno;
    JasperViewer visor;
     public Controladora(){};

 /* manejo de bases de datos */
    String url = "jdbc:postgresql://localhost:5432/airucab";
    String usuario ="postgres";
    String contraseña = "1234";
 /* fin del manejo de bases de datos */
    
    public Connection conexion(){
       Connection conectar=null;
        try{
             Class.forName("org.postgresql.Driver");
              conectar = DriverManager.getConnection(url,usuario,contraseña);
        }
        catch(Exception e){
            System.out.println("error");
        }
        return conectar;
    }
 
    
    ////////////////////////// INICIO DE ALGORITMOS DE  GREGORY BUSTAMANTE //////////////////////////////////////////////////////////////////
 
    public void llenarComboAñoPedidoCliente(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("select distinct extract(year from fecha_pedido) from pedido_cliente");
 
        combo.addItem("Seleccione el  Año");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
    
    /* Manejo de Roles y Usuarios */
    public int devolverRolSinPermiso(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select rol.id\n" +
"from rol\n" +
"where rol.id not in (select fk_rol from permiso_rol where fk_rol=rol.id) and rol.nombre='"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
     public int devolverIdRol(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id\n" +
"from rol\n" +
"where nombre='"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
     
    public int agregarRol(String nombre){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO rol(\n" +
"	nombre)\n" +
"	VALUES ('"+nombre+"')";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
    public int buscarRol(String nombreRol){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id from rol where nombre='"+nombreRol+"';";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != "")
            encontre =1;
        else {
            if (id =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
     public int agregarPermiso_Rol(String nombreRol,int fk_permiso){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="insert into permiso_rol(fk_permiso,fk_rol)\n" +
"            select "+fk_permiso+",rol.id\n" +
"            from rol where rol.nombre='"+nombreRol+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
     public void llenarTablaAgregarRol(JTable tablaPermiso,String nombreRol)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
    String nombreEntidad="";
    String instruccion="";
  
        
    String sql="select per.id,per.nombre_entidad,per.instruccion\n" +
"from permiso per,permiso_rol per_rol,rol where per_rol.fk_permiso=per.id and per_rol.fk_rol=rol.id and rol.nombre='"+nombreRol+"' ";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del Permiso", "Nombre de la entidad","Nombre de la Instrucción"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               id = result.getString(1);
               nombreEntidad = result.getString(2);
               instruccion = result.getString(3);
               String[] row = {id,nombreEntidad,instruccion};
               dtm.addRow(row);
          }
         tablaPermiso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
     

       public void llenarTablaRol(JTable tablaRol)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
    String nombre_Rol="";

  
        
    String sql="select id,nombre from rol ";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del Rol", "Nombre del Rol"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               id = result.getString(1);
               nombre_Rol = result.getString(2);
             
               String[] row = {id,nombre_Rol};
               dtm.addRow(row);
          }
         tablaRol.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
public void llenarTablaUsuario(JTable tablaUsuario){
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
    String nombre_usuario="";
    String clave="";

  
        
    String sql="select id,nombre,clave from usuario ";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del Usuario", "Nombre de Usuario","Clave"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               id = result.getString(1);
               nombre_usuario = result.getString(2);
               clave = result.getString(3);
             
               String[] row = {id,nombre_usuario,clave};
               dtm.addRow(row);
          }
         tablaUsuario.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }

       
      public int eliminarRol(String nombreRol){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from rol where nombre='"+nombreRol+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
       public int eliminarUsuario(String nombreUsuario){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from usuario where nombre='"+nombreUsuario+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
       
    public int eliminarPermisoRol(int idPermiso,int idRol){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from permiso_rol\n" +
"where fk_permiso='"+idPermiso+"' and fk_rol='"+idRol+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
      public String devolverNombreRol(String nombre){
      try{
       String encontre = "0";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNueva = "";
        
    String sql="select nombre from rol  where nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNueva = result.getString(1);
          }
        if (nombreNueva != ""){
            encontre ="1";
     
          return nombreNueva;
        }
        else {
            if (nombreNueva =="")
                encontre ="0";
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return "0";
    }
    
 }
        public String devolverNombreRolId(int idRol){
      try{
       String encontre = "0";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNueva = "";
        
    String sql="select nombre from rol  where id = "+idRol+"";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNueva = result.getString(1);
          }
        if (nombreNueva != ""){
            encontre ="1";
     
          return nombreNueva;
        }
        else {
            if (nombreNueva =="")
                encontre ="0";
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return "0";
    }
    
 }
       public int modificarRol(String nombre,String nombreNuevo){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE rol\n" +
"	SET  nombre='"+nombreNuevo+"'\n" +
"	WHERE nombre='"+nombre+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
    
    
    
  
        public int agregarUsuario(String nombre,String clave,int fk_rol){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO usuario(\n" +
"	 nombre, clave, fk_rol)\n" +
"	VALUES ( '"+nombre+"', '"+clave+"', "+fk_rol+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
         public String devolverUsuario(String nombre,String clave){
      try{
       String encontre = "0";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String usuarioNueva = "";
        
    String sql="select nombre \n" +
"from usuario\n" +
"where nombre='"+nombre+"' and clave='"+clave+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               usuarioNueva = result.getString(1);
          }
        if (usuarioNueva != ""){
            encontre ="1";
     
          return usuarioNueva;
        }
        else {
            if (usuarioNueva =="")
                encontre ="0";
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return "0";
    }
    
 }
          public int buscarUsuario(String nombre,String clave){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String usuarioNueva = "";
        
    String sql="select id \n" +
"from usuario\n" +
"where nombre='"+nombre+"' and clave='"+clave+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               usuarioNueva = result.getString(1);
          }
        if (usuarioNueva != "")
            encontre =1;
        else {
            if (usuarioNueva =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public int buscarUsuarioPorNombre(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String usuarioNueva = "";
        
    String sql="select id \n" +
"from usuario\n" +
"where nombre='"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               usuarioNueva = result.getString(1);
          }
        if (usuarioNueva != "")
            encontre =1;
        else {
            if (usuarioNueva =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }

         public int buscarPermiso(String instruccion,String nombreEntidad,String  nombreUsuario){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String usuarioNueva = "";
        
    String sql="select permi.id\n" +
"from permiso permi,usuario usu,rol ,permiso_rol permi_rol\n" +
"where usu.fk_rol=rol.id and permi_rol.fk_permiso=permi.id \n" +
"      and permi_rol.fk_rol=rol.id and permi.instruccion='"+instruccion+"' and permi.nombre_entidad='"+nombreEntidad+"' and usu.nombre='"+nombreUsuario+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               usuarioNueva = result.getString(1);
          }
        if (usuarioNueva != "")
            encontre =1;
        else {
            if (usuarioNueva =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
  

public void llenarTablaPermiso(JTable tablaPermiso)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
    String nombreEntidad="";
    String instruccion="";
  
        
    String sql="select id,nombre_entidad,instruccion\n" +
"from permiso";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del Permiso", "Nombre de la entidad","Nombre de la Instrucción"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               id = result.getString(1);
               nombreEntidad = result.getString(2);
               instruccion = result.getString(3);
               String[] row = {id,nombreEntidad,instruccion};
               dtm.addRow(row);
          }
         tablaPermiso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }

 public void llenarVentaModificarUsuario( String nombreUsuario,JTextField txtUsuario,JTextField txtClave,JTextField txtRol){

      try{
      
       
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    
   
        
    String sql="select usu.nombre,usu.clave,rol.nombre\n" +
"from usuario usu,rol\n" +
"where usu.fk_rol=rol.id and usu.nombre='"+nombreUsuario+"'";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
               txtUsuario.setText(result.getString(1));
               txtClave.setText(result.getString(2));
               txtRol.setText(result.getString(3));
            
         }
    

        st.close();
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
 }
 
 public int modificarUsuario(String usuarioViejo,String usuarioNuevo,String clave,int fk_rol){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE usuario\n" +
"	SET  nombre='"+usuarioNuevo+"', clave='"+clave+"', fk_rol='"+fk_rol+"'\n" +
"	WHERE usuario.nombre='"+usuarioViejo+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
   /* fin del manejo de los Roles Y Usuarios*/



/* PERSONAL */
 public int agregarPersonal(int cedula,String nombre1,String nombre2,String apellido1,String apellido2,String fecha_contrato,String otro_dato){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO PERSONAL(CEDULA,NOMBRE_1,NOMBRE_2,APELLIDO_1,APELLIDO_2,FECHA_CONTRATO,OTRO_DATO) VALUES ('"+cedula+"','"+nombre1+"','"+nombre2+"', '"+apellido1+"',' "+apellido2+"','"+fecha_contrato+"','"+otro_dato+"')";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }

 public int buscarPersonal(int cedula){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cedulaNueva = "";
        
    String sql="select p.cedula from personal p where p.cedula = '"+cedula+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               cedulaNueva = result.getString(1);
          }
        if (cedulaNueva != "")
            encontre =1;
        else {
            if (cedulaNueva =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public int devolverCedula(int cedula){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cedulaNueva = "";
        
    String sql="select p.cedula from personal p where p.cedula = '"+cedula+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               cedulaNueva = result.getString(1);
          }
        if (cedulaNueva != ""){
            encontre =1;
     
          return Integer.parseInt(cedulaNueva);
        }
        else {
            if (cedulaNueva =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 
 public int modificarPersonal(int cedula,int cedula_nueva,String nombre1,String nombre2,String apellido1,String apellido2,String fecha_contrato,String otro_dato){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE personal SET cedula='"+cedula_nueva+"', nombre_1='"+nombre1+"', nombre_2='"+nombre2+"', apellido_1='"+apellido1+"', apellido_2='"+apellido2+"', fecha_contrato='"+fecha_contrato+"', otro_dato='"+otro_dato+"' WHERE cedula ='"+cedula+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
 public void llenarVentaModificar( int cedula,JTextField txtCedulaModificar,JTextField txtNombre1,JTextField txtNombre2,JTextField txtApellido1,JTextField txtApellido2,JTextField txtFechaContrato,JTextField txtOtroDato){

      try{
      
       
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    
   
        
    String sql="select p.cedula,p.nombre_1,p.nombre_2,p.apellido_1,p.apellido_2,p.fecha_contrato,p.otro_dato from personal p where p.cedula = '"+cedula+"'";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
               txtCedulaModificar.setText(result.getString(1));
               txtNombre1.setText(result.getString(2));
               txtNombre2.setText(result.getString(3));
               txtApellido1.setText(result.getString(4));
               txtApellido2.setText(result.getString(5));
               txtFechaContrato.setText(result.getString(6));
               txtOtroDato.setText(result.getString(7));
         }
    

        st.close();
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
 }
 
  public int eliminarPersonal(int cedula){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from personal p where p.cedula = '"+cedula+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
    
 
  public void llenarTablaPersona(JTable tablaPersona)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cedula = "";
    String nombre1="";
    String apellido1="";
    String planta ="";
    String zona="";
    String telefono ="";
        
    String sql="select p.cedula,p.nombre_1,p.apellido_1 from personal p ";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Cedula", "Nombre y Apellido","Telefono","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               cedula = result.getString(1);
               nombre1 = result.getString(2);
               apellido1 = result.getString(3);
               String[] row = {cedula, nombre1+ "  " +apellido1,telefono,planta,zona};
               dtm.addRow(row);
          }
         tablaPersona.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }

 /* FIN DE PERSONAL */
  
 
 
  
   
  
  
 
  
  /* inicio de modelo */
  public int agregarModelo( String nombre,String num_denasa,String num_estandar,String num_piloto,String num_copiloto,String num_auxiliar,String distancia_aiento_densa,String distancia_asiento_estandar,String ancho_asiento,String longitud,String envargadura,String altura,String flecha_alar,String ancho_fuselaje,String alto_fuselaje,String ancho_cabina,String ancho_cabina_pasajero,String peso_vacio,String peso_max_despegue,String peso_aterrizaje_max,String volumen_carga,String carrera_despegue_peso_max,String techo_servicio,String velocidad_crucero,String velecidad_max,String alcance_carga_max,String max_combustible,String empuje_max, String empuje_velociadad_crucero,String diametro_aspas,String longitud_motor,String empuje_unitario){
  

  
     try{
         Integer num_denasa_1;
   if ("".equals(num_denasa))
       num_denasa_1 =null;
   else
       num_denasa_1 = Integer.parseInt(num_denasa);
   
   
  Integer num_estandar_1;
  
     if ("".equals(num_estandar))
       num_estandar_1=null;
   else
       num_estandar_1 = Integer.parseInt(num_estandar);
  
  
  Integer num_piloto_1;
     if ("".equals(num_piloto))
       num_piloto_1 =null;
   else
       num_piloto_1 = Integer.parseInt(num_piloto);
  
  Integer num_copiloto_1;
  
     if ("".equals(num_copiloto))
       num_copiloto_1 =null;
   else
       num_copiloto_1 = Integer.parseInt(num_copiloto);
     
  Integer num_auxiliar_1;
     if ("".equals(num_auxiliar))
       num_auxiliar_1 =null;
   else
       num_auxiliar_1 = Integer.parseInt(num_auxiliar);
     
  Float distancia_aiento_densa_1;
     if ("".equals(distancia_aiento_densa))
       distancia_aiento_densa_1 =null;
   else
       distancia_aiento_densa_1 = Float.parseFloat(distancia_aiento_densa);
  
  Float distancia_asiento_estandar_1;
  
       if ("".equals(distancia_asiento_estandar))
       distancia_asiento_estandar_1 =null;
   else
       distancia_asiento_estandar_1 = Float.parseFloat(distancia_asiento_estandar);
       
  Float ancho_asiento_1;
       if ("".equals(ancho_asiento))
       ancho_asiento_1 =null;
   else
       ancho_asiento_1 = Float.parseFloat(ancho_asiento);
  
  Float longitud_1;
   if ("".equals(longitud))
       longitud_1 =null;
   else
       longitud_1 = Float.parseFloat(longitud);
  
  Float envargadura_1;
   if ("".equals(envargadura))
       envargadura_1 =null;
   else
       envargadura_1 = Float.parseFloat(envargadura);
  
  Float altura_1;
   if ("".equals(altura))
       altura_1 =null;
   else
       altura_1 = Float.parseFloat(altura);
  
  Float flecha_alar_1;
   if ("".equals(flecha_alar))
       flecha_alar_1 =null;
   else
       flecha_alar_1 = Float.parseFloat(flecha_alar);
  
  Float ancho_fuselaje_1;
   if ("".equals(ancho_fuselaje))
       ancho_fuselaje_1 =null;
   else
       ancho_fuselaje_1 = Float.parseFloat(ancho_fuselaje);
  
  Float alto_fuselaje_1;
   if ("".equals(alto_fuselaje))
       alto_fuselaje_1 =null;
   else
       alto_fuselaje_1 = Float.parseFloat(alto_fuselaje);
  
  Float ancho_cabina_1;
  
   if ("".equals(ancho_cabina))
       ancho_cabina_1 =null;
   else
       ancho_cabina_1 = Float.parseFloat(ancho_cabina);
  
  Float ancho_cabina_pasajero_1;
   if ("".equals(ancho_cabina_pasajero))
       ancho_cabina_pasajero_1 =null;
   else
       ancho_cabina_pasajero_1 = Float.parseFloat(ancho_cabina_pasajero);
  
  Float peso_vacio_1;
   if ("".equals(peso_vacio))
       peso_vacio_1 =null;
   else
       peso_vacio_1 = Float.parseFloat(peso_vacio);
  
  
  Float peso_max_despegue_1;
   if ("".equals(peso_max_despegue))
      peso_max_despegue_1 =null;
   else
       peso_max_despegue_1 = Float.parseFloat(peso_max_despegue);
  
   
  Float peso_aterrizaje_max_1;
   if ("".equals(peso_aterrizaje_max))
       peso_aterrizaje_max_1 =null;
   else
       peso_aterrizaje_max_1 = Float.parseFloat(peso_aterrizaje_max);
  
  Float volumen_carga_1;
   if ("".equals(volumen_carga))
       volumen_carga_1 =null;
   else
       volumen_carga_1 = Float.parseFloat(volumen_carga);
  
   
  Float carrera_despegue_peso_max_1;
   if ("".equals(carrera_despegue_peso_max))
       carrera_despegue_peso_max_1 =null;
   else
       carrera_despegue_peso_max_1 = Float.parseFloat(carrera_despegue_peso_max);
  
  Float techo_servicio_1;
   if ("".equals(techo_servicio))
       techo_servicio_1 =null;
   else
       techo_servicio_1 = Float.parseFloat(techo_servicio);
  
   
  Float velocidad_crucero_1;
   if ("".equals(velocidad_crucero))
       velocidad_crucero_1 =null;
   else
       velocidad_crucero_1 = Float.parseFloat(velocidad_crucero);
  
  Float velecidad_max_1;
  
   if ("".equals(velecidad_max))
       velecidad_max_1 =null;
   else
       velecidad_max_1 = Float.parseFloat(velecidad_max);
  
  Float alcance_carga_max_1;
   if ("".equals(alcance_carga_max))
       alcance_carga_max_1 =null;
   else
       alcance_carga_max_1 = Float.parseFloat(alcance_carga_max);
  
  Float max_combustible_1;
   if ("".equals(max_combustible))
       max_combustible_1 =null;
   else
       max_combustible_1 = Float.parseFloat(max_combustible);
  
  
  Float empuje_max_1;
   if ("".equals(empuje_max))
       empuje_max_1 =null;
   else
       empuje_max_1 = Float.parseFloat(empuje_max);
  
  
  Float empuje_velociadad_crucero_1;
   if ("".equals(empuje_velociadad_crucero))
       empuje_velociadad_crucero_1 =null;
   else
       empuje_velociadad_crucero_1 = Float.parseFloat(empuje_velociadad_crucero);
  
  Float diametro_aspas_1;
   if ("".equals(diametro_aspas))
       diametro_aspas_1 =null;
   else
       diametro_aspas_1 = Float.parseFloat(diametro_aspas);
  
  Float longitud_motor_1;
   if ("".equals(longitud_motor))
       longitud_motor_1 =null;
   else
       longitud_motor_1 = Float.parseFloat(longitud_motor);
  
  Float empuje_unitario_1;
  if ("".equals(empuje_unitario))
       empuje_unitario_1 =null;
   else
       empuje_unitario_1 = Float.parseFloat(empuje_unitario);
       
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();

   // String sql="INSERT INTO modelo(nombre, num_denasa, num_estandar, num_piloto, num_copiloto, num_auxiliar, distancia_aiento_densa, distancia_asiento_estandar, ancho_asiento, longitud, envargadura, altura, flecha_alar, ancho_fuselaje, alto_fuselaje, ancho_cabina, ancho_cabina_pasajero, peso_vacio, peso_max_despegue, peso_aterrizaje_max, volumen_carga, carrera_despegue_peso_max, techo_servicio, velocidad_crucero, velecidad_max, alcance_carga_max, max_combustible, empuje_max, empuje_velociadad_crucero, diametro_aspas, longitud_motor, empuje_unitario) VALUES ('"+nombre+"','"+ num_denasa+"','"+num_estandar+"','"+num_piloto+"','"+num_copiloto+"','"+num_auxiliar+"','"+distancia_aiento_densa+"','"+distancia_asiento_estandar+"','"+ancho_asiento+"','"+longitud+"','"+envargadura+"','"+altura+"','"+flecha_alar+"','"+ancho_fuselaje+"','"+alto_fuselaje+"','"+ancho_cabina+"','"+ancho_cabina_pasajero+"','"+peso_vacio+"','"+peso_max_despegue+"','"+peso_aterrizaje_max+"','"+volumen_carga+"','"+carrera_despegue_peso_max+"','"+techo_servicio+"','"+velocidad_crucero+"','"+velecidad_max+"','"+alcance_carga_max+"','"+max_combustible+"','"+empuje_max+"','"+empuje_velociadad_crucero+"','"+diametro_aspas+"','"+longitud_motor+"','"+empuje_unitario+"')";
   String sql ="INSERT INTO public.modelo(\n" +
"	 nombre, num_denasa, num_estandar, num_piloto, num_copiloto, num_auxiliar, distancia_aiento_densa, distancia_asiento_estandar, ancho_asiento, longitud, envargadura, altura, flecha_alar, ancho_fuselaje, alto_fuselaje, ancho_cabina, ancho_cabina_pasajero, peso_vacio, peso_max_despegue, peso_aterrizaje_max, volumen_carga, carrera_despegue_peso_max, techo_servicio, velocidad_crucero, velecidad_max, alcance_carga_max, max_combustible, empuje_max, empuje_velociadad_crucero, diametro_aspas, longitud_motor, empuje_unitario)\n" +
"	VALUES ('"+nombre+"',"+num_denasa_1+","+num_estandar_1+","+num_piloto_1+","+num_copiloto_1+","+num_auxiliar_1+","+distancia_aiento_densa_1+","+distancia_asiento_estandar_1+","+ancho_asiento_1+","+longitud_1+","+envargadura_1+", "+altura_1+", "+flecha_alar_1+","+ancho_fuselaje_1+","+alto_fuselaje_1+", "+alto_fuselaje_1+", "+ancho_cabina_1+", "+ancho_cabina_pasajero_1+", "+peso_vacio_1+", "+peso_max_despegue_1+", "+volumen_carga_1+", "+carrera_despegue_peso_max_1+", "+techo_servicio_1+", "+velocidad_crucero_1+", "+velecidad_max_1+", "+alcance_carga_max_1+", "+max_combustible_1+", "+empuje_max_1+", "+empuje_velociadad_crucero_1+", "+diametro_aspas_1+", "+longitud_motor_1+", "+empuje_unitario_1+")";
   int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
   public int eliminarModelo(String nombre){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from modelo m where m.nombre = '"+nombre+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
   public int buscarModelo(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNuevo = "";
        
    String sql="select m.nombre from modelo m where m.nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNuevo = result.getString(1);
          }
        if (nombreNuevo != "")
            encontre =1;
        else {
            if (nombreNuevo =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
   public String devolverModelo(String nombre){
      try{
       String encontre = "0";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String modeloNueva = "";
        
    String sql="select m.nombre from modelo m where m.nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               modeloNueva = result.getString(1);
          }
        if (modeloNueva != ""){
            encontre ="1";
     
          return modeloNueva;
        }
        else {
            if (modeloNueva =="")
                encontre ="0";
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return "0";
    }
    
 }
   public void llenarVentaModificarModelo( String nombreActual,JTextField nombre,JTextField num_denasa,JTextField num_estandar,JTextField num_piloto,JTextField num_copiloto,JTextField num_auxiliar,JTextField distancia_aiento_densa,JTextField distancia_asiento_estandar,JTextField ancho_asiento,JTextField longitud,JTextField envargadura,JTextField altura,JTextField flecha_alar,JTextField ancho_fuselaje,JTextField alto_fuselaje,JTextField ancho_cabina,JTextField ancho_cabina_pasajero,JTextField peso_vacio,JTextField peso_max_despegue,JTextField peso_aterrizaje_max,JTextField volumen_carga,JTextField carrera_despegue_peso_max,JTextField techo_servicio,JTextField velocidad_crucero,JTextField velecidad_max,JTextField alcance_carga_max,JTextField max_combustible,JTextField empuje_max, JTextField empuje_velociadad_crucero,JTextField diametro_aspas,JTextField longitud_motor,JTextField empuje_unitario){

      try{
      
       
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    
   
        
    String sql="SELECT  nombre, num_denasa, num_estandar, num_piloto, num_copiloto, num_auxiliar, distancia_aiento_densa, distancia_asiento_estandar, ancho_asiento, longitud, envargadura, altura, flecha_alar, ancho_fuselaje, alto_fuselaje, ancho_cabina, ancho_cabina_pasajero, peso_vacio, peso_max_despegue, peso_aterrizaje_max, volumen_carga, carrera_despegue_peso_max, techo_servicio, velocidad_crucero, velecidad_max, alcance_carga_max, max_combustible, empuje_max, empuje_velociadad_crucero, diametro_aspas, longitud_motor, empuje_unitario\n" +
"	FROM modelo where nombre = '"+nombreActual+"'";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
               nombre.setText(result.getString(1));
               num_denasa.setText(result.getString(2));
               num_estandar.setText(result.getString(3));
               num_piloto.setText(result.getString(4));
               num_copiloto.setText(result.getString(5));
               num_auxiliar.setText(result.getString(6));
               distancia_aiento_densa.setText(result.getString(7));
               distancia_asiento_estandar.setText(result.getString(8));
               ancho_asiento.setText(result.getString(9));
               longitud.setText(result.getString(10));
               envargadura.setText(result.getString(11));
               altura.setText(result.getString(12));
               flecha_alar.setText(result.getString(13));
               ancho_fuselaje.setText(result.getString(14));
               alto_fuselaje.setText(result.getString(15));
               ancho_cabina.setText(result.getString(16));
               ancho_cabina_pasajero.setText(result.getString(17));
               peso_vacio.setText(result.getString(18));
               peso_max_despegue.setText(result.getString(19));
               peso_aterrizaje_max.setText(result.getString(20));
               volumen_carga.setText(result.getString(21));
               carrera_despegue_peso_max.setText(result.getString(22));
               techo_servicio.setText(result.getString(23));
               velocidad_crucero.setText(result.getString(24));
               velecidad_max.setText(result.getString(25));
               alcance_carga_max.setText(result.getString(26));
               max_combustible.setText(result.getString(27));
               empuje_max.setText(result.getString(28));
               empuje_velociadad_crucero.setText(result.getString(29));
               diametro_aspas.setText(result.getString(30));
               longitud.setText(result.getString(31));
               empuje_unitario.setText(result.getString(32));
               
               
         }
    

        st.close();
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
    }
    }
   public int modificarModelo(String nombreActual,String nombre,String num_denasa,String num_estandar,String num_piloto,String num_copiloto,String num_auxiliar,String distancia_aiento_densa,String distancia_asiento_estandar,String ancho_asiento,String longitud,String envargadura,String altura,String flecha_alar,String ancho_fuselaje,String alto_fuselaje,String ancho_cabina,String ancho_cabina_pasajero,String peso_vacio,String peso_max_despegue,String peso_aterrizaje_max,String volumen_carga,String carrera_despegue_peso_max,String techo_servicio,String velocidad_crucero,String velecidad_max,String alcance_carga_max,String max_combustible,String empuje_max, String empuje_velociadad_crucero,String diametro_aspas,String longitud_motor,String empuje_unitario){
      try{
          Integer num_denasa_1;
   if ("".equals(num_denasa))
       num_denasa_1 =null;
   else
       num_denasa_1 = Integer.parseInt(num_denasa);
   
   
  Integer num_estandar_1;
  
     if ("".equals(num_estandar))
       num_estandar_1=null;
   else
       num_estandar_1 = Integer.parseInt(num_estandar);
  
  
  Integer num_piloto_1;
     if ("".equals(num_piloto))
       num_piloto_1 =null;
   else
       num_piloto_1 = Integer.parseInt(num_piloto);
  
  Integer num_copiloto_1;
  
     if ("".equals(num_copiloto))
       num_copiloto_1 =null;
   else
       num_copiloto_1 = Integer.parseInt(num_copiloto);
     
  Integer num_auxiliar_1;
     if ("".equals(num_auxiliar))
       num_auxiliar_1 =null;
   else
       num_auxiliar_1 = Integer.parseInt(num_auxiliar);
     
  Float distancia_aiento_densa_1;
     if ("".equals(distancia_aiento_densa))
       distancia_aiento_densa_1 =null;
   else
       distancia_aiento_densa_1 = Float.parseFloat(distancia_aiento_densa);
  
  Float distancia_asiento_estandar_1;
  
       if ("".equals(distancia_asiento_estandar))
       distancia_asiento_estandar_1 =null;
   else
       distancia_asiento_estandar_1 = Float.parseFloat(distancia_asiento_estandar);
       
  Float ancho_asiento_1;
       if ("".equals(ancho_asiento))
       ancho_asiento_1 =null;
   else
       ancho_asiento_1 = Float.parseFloat(ancho_asiento);
  
  Float longitud_1;
   if ("".equals(longitud))
       longitud_1 =null;
   else
       longitud_1 = Float.parseFloat(longitud);
  
  Float envargadura_1;
   if ("".equals(envargadura))
       envargadura_1 =null;
   else
       envargadura_1 = Float.parseFloat(envargadura);
  
  Float altura_1;
   if ("".equals(altura))
       altura_1 =null;
   else
       altura_1 = Float.parseFloat(altura);
  
  Float flecha_alar_1;
   if ("".equals(flecha_alar))
       flecha_alar_1 =null;
   else
       flecha_alar_1 = Float.parseFloat(flecha_alar);
  
  Float ancho_fuselaje_1;
   if ("".equals(ancho_fuselaje))
       ancho_fuselaje_1 =null;
   else
       ancho_fuselaje_1 = Float.parseFloat(ancho_fuselaje);
  
  Float alto_fuselaje_1;
   if ("".equals(alto_fuselaje))
       alto_fuselaje_1 =null;
   else
       alto_fuselaje_1 = Float.parseFloat(alto_fuselaje);
  
  Float ancho_cabina_1;
  
   if ("".equals(ancho_cabina))
       ancho_cabina_1 =null;
   else
       ancho_cabina_1 = Float.parseFloat(ancho_cabina);
  
  Float ancho_cabina_pasajero_1;
   if ("".equals(ancho_cabina_pasajero))
       ancho_cabina_pasajero_1 =null;
   else
       ancho_cabina_pasajero_1 = Float.parseFloat(ancho_cabina_pasajero);
  
  Float peso_vacio_1;
   if ("".equals(peso_vacio))
       peso_vacio_1 =null;
   else
       peso_vacio_1 = Float.parseFloat(peso_vacio);
  
  
  Float peso_max_despegue_1;
   if ("".equals(peso_max_despegue))
      peso_max_despegue_1 =null;
   else
       peso_max_despegue_1 = Float.parseFloat(peso_max_despegue);
  
   
  Float peso_aterrizaje_max_1;
   if ("".equals(peso_aterrizaje_max))
       peso_aterrizaje_max_1 =null;
   else
       peso_aterrizaje_max_1 = Float.parseFloat(peso_aterrizaje_max);
  
  Float volumen_carga_1;
   if ("".equals(volumen_carga))
       volumen_carga_1 =null;
   else
       volumen_carga_1 = Float.parseFloat(volumen_carga);
  
   
  Float carrera_despegue_peso_max_1;
   if ("".equals(carrera_despegue_peso_max))
       carrera_despegue_peso_max_1 =null;
   else
       carrera_despegue_peso_max_1 = Float.parseFloat(carrera_despegue_peso_max);
  
  Float techo_servicio_1;
   if ("".equals(techo_servicio))
       techo_servicio_1 =null;
   else
       techo_servicio_1 = Float.parseFloat(techo_servicio);
  
   
  Float velocidad_crucero_1;
   if ("".equals(velocidad_crucero))
       velocidad_crucero_1 =null;
   else
       velocidad_crucero_1 = Float.parseFloat(velocidad_crucero);
  
  Float velecidad_max_1;
  
   if ("".equals(velecidad_max))
       velecidad_max_1 =null;
   else
       velecidad_max_1 = Float.parseFloat(velecidad_max);
  
  Float alcance_carga_max_1;
   if ("".equals(alcance_carga_max))
       alcance_carga_max_1 =null;
   else
       alcance_carga_max_1 = Float.parseFloat(alcance_carga_max);
  
  Float max_combustible_1;
   if ("".equals(max_combustible))
       max_combustible_1 =null;
   else
       max_combustible_1 = Float.parseFloat(max_combustible);
  
  
  Float empuje_max_1;
   if ("".equals(empuje_max))
       empuje_max_1 =null;
   else
       empuje_max_1 = Float.parseFloat(empuje_max);
  
  
  Float empuje_velociadad_crucero_1;
   if ("".equals(empuje_velociadad_crucero))
       empuje_velociadad_crucero_1 =null;
   else
       empuje_velociadad_crucero_1 = Float.parseFloat(empuje_velociadad_crucero);
  
  Float diametro_aspas_1;
   if ("".equals(diametro_aspas))
       diametro_aspas_1 =null;
   else
       diametro_aspas_1 = Float.parseFloat(diametro_aspas);
  
  Float longitud_motor_1;
   if ("".equals(longitud_motor))
       longitud_motor_1 =null;
   else
       longitud_motor_1 = Float.parseFloat(longitud_motor);
  
  Float empuje_unitario_1;
  if ("".equals(empuje_unitario))
       empuje_unitario_1 =null;
   else
       empuje_unitario_1 = Float.parseFloat(empuje_unitario);
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE modelo\n" +
"	SET  nombre='"+nombre+"', num_denasa="+num_denasa_1+", num_estandar="+num_estandar_1+", num_piloto="+num_piloto_1+", num_copiloto="+num_copiloto_1+", num_auxiliar="+num_auxiliar_1+", distancia_aiento_densa="+distancia_aiento_densa_1+", distancia_asiento_estandar="+distancia_asiento_estandar_1+", ancho_asiento="+ancho_asiento_1+", longitud="+longitud_1+", envargadura="+envargadura_1+", altura="+altura_1+", flecha_alar="+flecha_alar_1+", ancho_fuselaje="+ancho_fuselaje_1+", alto_fuselaje="+alto_fuselaje_1+", ancho_cabina="+ancho_cabina_1+", ancho_cabina_pasajero="+ancho_cabina_pasajero_1+", peso_vacio="+peso_vacio_1+", peso_max_despegue="+peso_max_despegue_1+", peso_aterrizaje_max="+peso_aterrizaje_max_1+", volumen_carga="+volumen_carga_1+", carrera_despegue_peso_max="+carrera_despegue_peso_max_1+", techo_servicio="+techo_servicio_1+", velocidad_crucero="+velocidad_crucero_1+", velecidad_max="+velecidad_max_1+", alcance_carga_max="+alcance_carga_max_1+", max_combustible="+max_combustible_1+", empuje_max="+empuje_max_1+", empuje_velociadad_crucero="+empuje_velociadad_crucero_1+", diametro_aspas="+diametro_aspas_1+", longitud_motor="+longitud_motor_1+", empuje_unitario="+empuje_unitario_1+"\n" +
"	WHERE nombre = '"+nombreActual+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
  
  /* fin de modelo */
public void llenarComboModelo(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM modelo ");
 
        combo.addItem("Seleccione el  modelo");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
public void llenarComboCliente(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM cliente ");
 
        combo.addItem("Seleccione el  cliente");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
public void llenarComboClientePedido(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM cliente ");
 
        combo.addItem("Todos");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
//public void llenarComboCliente(JComboBox combo){
//  combo.removeAllItems();
//    try {
//            Class.forName("org.postgresql.Driver");
//     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
//           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//           ResultSet rs = st.executeQuery("SELECT nombre FROM cliente ");
// 
//        combo.addItem("Seleccione el  cliente");
//            while (rs.next()) {
//               combo.addItem(rs.getString(1));
//               
//            }
// 
//            st.close();
//        } catch (Exception e) {
//   System.err.println("error");
//        }
//    }
public void llenarComboEstatusPruebaDetalle(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM estatus ");
 
        combo.addItem("Seleccione");
            while (rs.next()) {
               if(rs.getString(1).equals("satisfactorio") || rs.getString(1).equals("insatisfactorio"))
                   combo.addItem(rs.getString(1));
             
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
public void llenarComboEstatusPruebaTodo(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM estatus ");
 
        combo.addItem("Todo");
            while (rs.next()) {
               if(rs.getString(1).equals("satisfactorio") || rs.getString(1).equals("insatisfactorio") ||  rs.getString(1).equals("proceso"))
                   combo.addItem(rs.getString(1));
             
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
public void llenarComboEstatusPiezaDetalle(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM estatus ");
 
        combo.addItem("Seleccione");
            while (rs.next()) {
               if(rs.getString(1).equals("finalizado"))
                   combo.addItem(rs.getString(1));
             
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
public void llenarComboEstatusPiezaTodo(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM estatus ");
 
        combo.addItem("Todo");
            while (rs.next()) {
               if(rs.getString(1).equals("finalizado") || rs.getString(1).equals("proceso"))
                   combo.addItem(rs.getString(1));
             
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }

public void llenarTablaModelo(JTable tablaModelo)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
String nombre="";
String id="";
String precio = "";
        
    String sql="select id,nombre from modelo ";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "ID", "Modelo","Precio"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               id = result.getString(1);
             nombre= result.getString(2);
        
            String[] row = {id,nombre,precio};
              dtm.addRow(row);
          }
         tablaModelo.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
 // metodos necesarios para generar el avion
public int devolverIdPedidoCliente(){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select p.id from pedido_cliente p where p.id  not in(select fk_pedido_cliente from avion)";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int devolverIdModelo(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id from modelo where nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int buscarAvion(int idAvion){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cedulaNueva = "";
        
    String sql="select a.id from avion a where a.id = '"+idAvion+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               cedulaNueva = result.getString(1);
          }
        if (cedulaNueva != "")
            encontre =1;
        else {
            if (cedulaNueva =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int agregarAvion(String nombre,int fk_modelo,int fk_pedido_cliente){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO avion(\n" +
"	nombre, fk_modelo, fk_pedido_cliente)\n" +
"	VALUES ('"+nombre+"', "+fk_modelo+", "+fk_pedido_cliente+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }

// fin de los metodos para geerar el avion


// metodos para generar el emsambalje del avion

public int devolverIdAvion(){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select a.id from avion a where a.id not in(select fk_avion from ensamblaje_avion)";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int devolverIdEstatus(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id from estatus where nombre='"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }


public int agregarEnsamblajeAvion(String fecha_i,String fecha_f,int fk_avion,int fk_estatus){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO ensamblaje_avion(\n" +
"	 fecha_i, fecha_f, fk_avion, fk_estatus)\n" +
"	VALUES ('"+fecha_i+"','"+fecha_f+"',"+fk_avion+", "+fk_estatus+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }

// fin de los metodos para generar el ensamsamblaje de la pieza

public int devolverIdEnsamblajeAvion(){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select ea.id from ensamblaje_avion ea where ea.id  not in (select fk_ensamblaje_avion from ensamblaje_pieza)";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int devolverIdEnsamblajeAvionApartirIdEnsamblaje(int idEnsamblajePieza){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="  select distinct ensa.id\n" +
"    from ensamblaje_avion ensa,ensamblaje_pieza ense\n" +
"    where ense.fk_ensamblaje_avion=ensa.id and ense.id="+idEnsamblajePieza+"";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int devolverIdEnsamblajeAvionApartirIdPruebaPieza(int idPruebaPieza){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="  select distinct ensa.id\n" +
"    from ensamblaje_avion ensa,prueba pru\n" +
"    where pru.fk_ensamblaje_avion=ensa.id and pru.id="+idPruebaPieza+"";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int modificarFechaFinalEnsamblajeAvion(int id_ensamblaje_avion){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE ensamblaje_avion set fecha_f=maxima.fecha_f \n" +
"from  (select maxima.fk_ensamblaje_avion,max(maxima.fecha_maxima) fecha_f\n" +
"       from(select fk_ensamblaje_avion,max(fecha_f) fecha_maxima from ensamblaje_pieza group by fk_ensamblaje_avion\n" +
"            union\n" +
"            select fk_ensamblaje_avion,max(fecha_f) fecha_maxima from prueba group by fk_ensamblaje_avion) as maxima\n" +
"group by maxima.fk_ensamblaje_avion) as maxima\n" +
"	WHERE ensamblaje_avion.id="+id_ensamblaje_avion+" and "+id_ensamblaje_avion+" = maxima.fk_ensamblaje_avion";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }

public int agregarEnsamblajePieza(String fecha_i,String fecha_f,int fk_avion_pieza,int fk_ensamblaje_avion,int fk_estatus){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO ensamblaje_pieza(\n" +
"	fecha_i, fecha_f, fk_avion_pieza, fk_ensamblaje_avion, fk_estatus)\n" +
"	VALUES ('"+fecha_i+"','"+fecha_f+"','"+fk_avion_pieza+"', '"+fk_ensamblaje_avion+"', '"+fk_estatus+"')";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         System.out.println("estoy aqui");
         return 0;
    }
    
    }

 
public int agregarPiezaArmada(int id_ensamblaje_pieza){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO public.pieza_armada(\n" +
"	 nombre, tipo, fecha_inventario, fk_ensamblaje_avion, fk_ensamblaje_pieza)\n" +
"	 select pie.nombre,pie.tipo,null,ensa.id,ense.id\n" +
"     from pieza pie,ensamblaje_pieza ense,ensamblaje_avion ensa,avion_pieza avp\n" +
"     where ense.fk_avion_pieza=avp.id and ense.fk_ensamblaje_avion=ensa.id and avp.fk_pieza=pie.id and ense.id="+id_ensamblaje_pieza+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }

public int agregarPruebaPieza(int idEnsamblajePieza){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO prueba(\n" +
"	 fecha_i, fecha_f, fk_material_pedido, fk_pieza_armada, fk_ensamblaje_avion, fk_estatus)\n" +
"      select ense.fecha_f ,ense.fecha_f+31,null,pier.id,ensa.id,s.id\n" +
"      from pieza_armada pier,ensamblaje_avion ensa,ensamblaje_pieza ense,estatus s\n" +
"      where pier.fk_ensamblaje_avion=ensa.id and pier.fk_ensamblaje_pieza=ense.id \n" +
"           and ense.fk_ensamblaje_avion=ensa.id and s.nombre='proceso' and ense.id="+idEnsamblajePieza+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
public int agregarPruebaPiezaInsatisfactorio(int idPruePieza){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO prueba(\n" +
"	 fecha_i, fecha_f, fk_material_pedido, fk_pieza_armada, fk_ensamblaje_avion, fk_estatus)\n" +
"      select pru.fecha_f ,pru.fecha_f+31,null,pier.id,ensa.id,s.id\n" +
"      from pieza_armada pier,ensamblaje_avion ensa,ensamblaje_pieza ense,estatus s,prueba  pru\n" +
"      where pier.fk_ensamblaje_avion=ensa.id and pier.fk_ensamblaje_pieza=ense.id \n" +
"      and ense.fk_ensamblaje_avion=ensa.id and s.nombre='proceso' and pru.fk_pieza_armada=pier.id\n" +
"      and pru.id="+idPruePieza+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
/// metodos necesario para inserta el pedido del cleinte
public int devolverIdCliente(String nombre){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id from cliente  where nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 
public int agregarPedidoCliente(String fecha_pedido,float monto,int fk_cliente){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO pedido_cliente(\n" +
"	 fecha_pedido, fecha_pago, monto, fk_cliente)\n" +
"	VALUES ('"+fecha_pedido+"', null,"+monto+", "+fk_cliente+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
// fin de los metodos para generar el pedido

 public void llenarTablaListaPedidosCliente(JTable tablaPersona)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idPedido= "";
    String nombre="";
    String monto="";
    String fecha_pedido ="";
    String estaus="";
    String estatusComra="";
        
    String sql="  select p.id,a.nombre,p.monto,p.fecha_pedido,s.nombre\n" +
"    from pedido_cliente p,avion a,estatus s,ensamblaje_avion ens\n" +
"    where p.id = a.fk_pedido_cliente and a.id=ens.fk_avion and s.id = ens.fk_estatus";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del pedidio", "Modelo","Precio","Fecha de pedido","Estatus del a Avión"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idPedido = result.getString(1);
               nombre = result.getString(2);
               monto = result.getString(3);
               fecha_pedido = result.getString(4);
               estaus = result.getString(5);
               String[] row = {idPedido,nombre,monto,fecha_pedido,estaus};
               dtm.addRow(row);
          }
         tablaPersona.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
 
 public void llenarTablaEnsamblajeAvion(JTable tablaPersona)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idAvion= "";
    String idPedido="";
    String cliente="";
    String fecha_i ="";
    String fecha_f="";
    String estatus="";
    String nombreModelo="";
        
    String sql=" select a.id,p.id,c.nombre,ens.fecha_i,ens.fecha_f,s.nombre,a.nombre\n" +
"    from avion a,pedido_cliente p,ensamblaje_avion ens,estatus s,cliente c\n" +
"    where p.id=a.fk_pedido_cliente and a.id=ens.fk_avion and s.id=ens.fk_estatus and c.id=p.fk_cliente order by a.id";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del Avion", "Id del Pedido","Cliente","Modelo","fecha inicio de ensamblaje","Fecha final de ensamblaje","Estatus"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idAvion = result.getString(1);
               idPedido = result.getString(2);
               cliente = result.getString(3);
               fecha_i= result.getString(4);
               fecha_f= result.getString(5);
               estatus= result.getString(6);
               nombreModelo= result.getString(7);
               String[] row = {idAvion,idPedido,cliente,nombreModelo,fecha_i,fecha_f,estatus};
               dtm.addRow(row);
          }
         tablaPersona.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
 public void llenarTablaEnsamblajeAvionCliente(JTable tablaPersona,String clienteIten)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idAvion= "";
    String idPedido="";
    String cliente="";
    String fecha_i ="";
    String fecha_f="";
    String estatus="";
    String nombreModelo="";
        
    String sql=" select a.id,p.id,c.nombre,ens.fecha_i,ens.fecha_f,s.nombre,a.nombre\n" +
"    from avion a,pedido_cliente p,ensamblaje_avion ens,estatus s,cliente c\n" +
"    where p.id=a.fk_pedido_cliente and a.id=ens.fk_avion and s.id=ens.fk_estatus and c.id=p.fk_cliente and c.nombre='"+clienteIten+"'";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id del Avion", "Id del Pedido","Cliente","Modelo","fecha inicio de ensamblaje","Fecha final de ensamblaje","Estatus"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idAvion = result.getString(1);
               idPedido = result.getString(2);
               cliente = result.getString(3);
               fecha_i= result.getString(4);
               fecha_f= result.getString(5);
               estatus= result.getString(6);
               nombreModelo= result.getString(7);
               String[] row = {idAvion,idPedido,cliente,nombreModelo,fecha_i,fecha_f,estatus};
               dtm.addRow(row);
          }
         tablaPersona.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
 public void llenarVentaEnsamblajePieza( JLabel lblIdAvion,int idAvion){  

       
               lblIdAvion.setText(String.valueOf(idAvion));   
    

   
    
 }
 public void llenarTabalaEnsamblajePrueba(int id_avion,JTable tablaProceso)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idEnsamblajePieza= "";
    String idProceso="";
    String fecha_i="";
    String fecha_f="";
    String estatus="";
    String planta="";
    String especialidad="";
    String nombrePieza="";
    String tipoPieza="";
        
    String sql="select distinct ense.id id ,ense.fecha_i,ense.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,\n" +
"     pieza pie,avion_pieza avp,ensamblaje_avion ensa\n" +
"where l.id=p.fk_lugar and p.id=z.fk_planta and p.id=pie.fk_planta and ensa.fk_avion="+id_avion+"\n" +
"      and ense.fk_ensamblaje_avion=ensa.id and ense.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id and z.tipo_especialidad='ensamblaje'\n" +
"union \n" +
"select distinct pru.id id ,pru.fecha_i,pru.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,pieza pie,avion_pieza avp,\n" +
"     ensamblaje_avion ensa,prueba pru,ubicacion_actual ubi,pieza_armada pier\n" +
"where ubi.fk_zona=z.id and z.fk_planta=p.id and p.fk_lugar=l.id and ubi.fk_pieza_armada=pier.id and pier.fk_ensamblaje_pieza=ense.id\n" +
"      and pier.fk_ensamblaje_avion=ensa.id and ense.fk_ensamblaje_avion=ensa.id and ensa.fk_avion="+id_avion+"\n" +
"      and pru.fk_pieza_armada=pier.id and pru.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id order by id,tipo";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Id del Proceso","Nombre","Tipo","fecha inicio ","Fecha final ","Estatus","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idProceso = result.getString(1);
               fecha_i = result.getString(2);
               fecha_f = result.getString(3);
               estatus= result.getString(4);
               planta= result.getString(5);
               especialidad= result.getString(6);
               nombrePieza= result.getString(7);
               tipoPieza= result.getString(8);
               
               String[] row = {idProceso,nombrePieza,tipoPieza,fecha_i,fecha_f,estatus,planta,especialidad};
               dtm.addRow(row);
          }
         tablaProceso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
 }
      public void llenarTabalaEnsamblajePruebaEstatus(int id_avion,JTable tablaProceso,String nombreEstatus)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idEnsamblajePieza= "";
    String idProceso="";
    String fecha_i="";
    String fecha_f="";
    String estatus="";
    String planta="";
    String especialidad="";
    String nombrePieza="";
    String tipoPieza="";
        
    String sql="select distinct ense.id id ,ense.fecha_i,ense.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,\n" +
"     pieza pie,avion_pieza avp,ensamblaje_avion ensa\n" +
"where l.id=p.fk_lugar and p.id=z.fk_planta and p.id=pie.fk_planta and ensa.fk_avion="+id_avion+"\n" +
"      and ense.fk_ensamblaje_avion=ensa.id and ense.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id and z.tipo_especialidad='ensamblaje'\n" +
"union \n" +
"select distinct pru.id id ,pru.fecha_i,pru.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,pieza pie,avion_pieza avp,\n" +
"     ensamblaje_avion ensa,prueba pru,ubicacion_actual ubi,pieza_armada pier\n" +
"where ubi.fk_zona=z.id and z.fk_planta=p.id and p.fk_lugar=l.id and ubi.fk_pieza_armada=pier.id and pier.fk_ensamblaje_pieza=ense.id\n" +
"      and pier.fk_ensamblaje_avion=ensa.id and ense.fk_ensamblaje_avion=ensa.id and ensa.fk_avion="+id_avion+"\n" +
"      and pru.fk_pieza_armada=pier.id and pru.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id  s.nombre='"+nombreEstatus+"'  order  by id,tipo";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Id del Proceso","Nombre","Tipo","fecha inicio ","Fecha final ","Estatus","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idProceso = result.getString(1);
               fecha_i = result.getString(2);
               fecha_f = result.getString(3);
               estatus= result.getString(4);
               planta= result.getString(5);
               especialidad= result.getString(6);
               nombrePieza= result.getString(7);
               tipoPieza= result.getString(8);
               
               String[] row = {idProceso,nombrePieza,tipoPieza,fecha_i,fecha_f,estatus,planta,especialidad};
               dtm.addRow(row);
          }
         tablaProceso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
  public void llenarTabalaPruebaPieza(int id_avion,JTable tablaProceso)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idEnsamblajePieza= "";
    String idProceso="";
    String fecha_i="";
    String fecha_f="";
    String estatus="";
    String planta="";
    String especialidad="";
    String nombrePieza="";
    String tipoPieza="";
        
    String sql="select distinct pru.id id ,pru.fecha_i,pru.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,pieza pie,avion_pieza avp,\n" +
"     ensamblaje_avion ensa,prueba pru,ubicacion_actual ubi,pieza_armada pier\n" +
"where ubi.fk_zona=z.id and z.fk_planta=p.id and p.fk_lugar=l.id and ubi.fk_pieza_armada=pier.id and pier.fk_ensamblaje_pieza=ense.id\n" +
"      and pier.fk_ensamblaje_avion=ensa.id and ense.fk_ensamblaje_avion=ensa.id and ensa.fk_avion="+id_avion+"\n" +
"      and pru.fk_pieza_armada=pier.id and pru.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id order by id,tipo";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Id del Proceso","Nombre","Tipo","fecha inicio ","Fecha final ","Estatus","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idProceso = result.getString(1);
               fecha_i = result.getString(2);
               fecha_f = result.getString(3);
               estatus= result.getString(4);
               planta= result.getString(5);
               especialidad= result.getString(6);
               nombrePieza= result.getString(7);
               tipoPieza= result.getString(8);
               
               String[] row = {idProceso,nombrePieza,tipoPieza,fecha_i,fecha_f,estatus,planta,especialidad};
               dtm.addRow(row);
          }
         tablaProceso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
   public void llenarTabalaPruebaPiezaEstatus(int id_avion,JTable tablaProceso,String nombreEstatus)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idEnsamblajePieza= "";
    String idProceso="";
    String fecha_i="";
    String fecha_f="";
    String estatus="";
    String planta="";
    String especialidad="";
    String nombrePieza="";
    String tipoPieza="";
        
    String sql="select distinct pru.id id ,pru.fecha_i,pru.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,pieza pie,avion_pieza avp,\n" +
"     ensamblaje_avion ensa,prueba pru,ubicacion_actual ubi,pieza_armada pier\n" +
"where ubi.fk_zona=z.id and z.fk_planta=p.id and p.fk_lugar=l.id and ubi.fk_pieza_armada=pier.id and pier.fk_ensamblaje_pieza=ense.id\n" +
"      and pier.fk_ensamblaje_avion=ensa.id and ense.fk_ensamblaje_avion=ensa.id and ensa.fk_avion="+id_avion+"\n" +
"      and pru.fk_pieza_armada=pier.id and pru.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id and s.nombre='"+nombreEstatus+"' order by id,tipo";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Id del Proceso","Nombre","Tipo","fecha inicio ","Fecha final ","Estatus","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idProceso = result.getString(1);
               fecha_i = result.getString(2);
               fecha_f = result.getString(3);
               estatus= result.getString(4);
               planta= result.getString(5);
               especialidad= result.getString(6);
               nombrePieza= result.getString(7);
               tipoPieza= result.getString(8);
               
               String[] row = {idProceso,nombrePieza,tipoPieza,fecha_i,fecha_f,estatus,planta,especialidad};
               dtm.addRow(row);
          }
         tablaProceso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
  public void llenarTabalaEnsamblajePieza(int id_avion,JTable tablaProceso)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idEnsamblajePieza= "";
    String idProceso="";
    String fecha_i="";
    String fecha_f="";
    String estatus="";
    String planta="";
    String especialidad="";
    String nombrePieza="";
    String tipoPieza="";
        
    String sql="select distinct ense.id id ,ense.fecha_i,ense.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,\n" +
"     pieza pie,avion_pieza avp,ensamblaje_avion ensa\n" +
"where l.id=p.fk_lugar and p.id=z.fk_planta and p.id=pie.fk_planta and ensa.fk_avion="+id_avion+"\n" +
"      and ense.fk_ensamblaje_avion=ensa.id and ense.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id and z.tipo_especialidad='ensamblaje' order by id,tipo";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Id del Proceso","Nombre","Tipo","fecha inicio ","Fecha final ","Estatus","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idProceso = result.getString(1);
               fecha_i = result.getString(2);
               fecha_f = result.getString(3);
               estatus= result.getString(4);
               planta= result.getString(5);
               especialidad= result.getString(6);
               nombrePieza= result.getString(7);
               tipoPieza= result.getString(8);
               
               String[] row = {idProceso,nombrePieza,tipoPieza,fecha_i,fecha_f,estatus,planta,especialidad};
               dtm.addRow(row);
          }
         tablaProceso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
  public void llenarTabalaEnsamblajePiezaEstatus(int id_avion,JTable tablaProceso,String nombreEstatus)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idEnsamblajePieza= "";
    String idProceso="";
    String fecha_i="";
    String fecha_f="";
    String estatus="";
    String planta="";
    String especialidad="";
    String nombrePieza="";
    String tipoPieza="";
        
    String sql="select distinct ense.id id ,ense.fecha_i,ense.fecha_f,s.nombre,l.nombre,\n" +
"                z.tipo_especialidad,pie.tipo tipo,pie.nombre\n" +
"from ensamblaje_pieza ense,estatus s,planta p,zona z,lugar l,\n" +
"     pieza pie,avion_pieza avp,ensamblaje_avion ensa\n" +
"where l.id=p.fk_lugar and p.id=z.fk_planta and p.id=pie.fk_planta and ensa.fk_avion="+id_avion+"\n" +
"      and ense.fk_ensamblaje_avion=ensa.id and ense.fk_estatus=s.id and ense.fk_avion_pieza=avp.id \n" +
"      and avp.fk_pieza=pie.id and z.tipo_especialidad='ensamblaje' and s.nombre='"+nombreEstatus+"' order by id,tipo";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Id del Proceso","Nombre","Tipo","fecha inicio ","Fecha final ","Estatus","Planta","Zona"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idProceso = result.getString(1);
               fecha_i = result.getString(2);
               fecha_f = result.getString(3);
               estatus= result.getString(4);
               planta= result.getString(5);
               especialidad= result.getString(6);
               nombrePieza= result.getString(7);
               tipoPieza= result.getString(8);
               
               String[] row = {idProceso,nombrePieza,tipoPieza,fecha_i,fecha_f,estatus,planta,especialidad};
               dtm.addRow(row);
          }
         tablaProceso.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
  
 public int buscarEnsamblajePieza(int idEnsamblajePieza){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id from ensamblaje_pieza where id = '"+idEnsamblajePieza+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != "")
            encontre =1;
        else {
            if (id =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
  public int buscarPruebaPieza(int idPrueba){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select id from prueba where id = '"+idPrueba+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != "")
            encontre =1;
        else {
            if (id =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public void llenarVentaDetallesEnsamblaPieza(int idProceso_1, JLabel idProceso,JLabel nombrePlanta,JLabel fecha_i,JLabel txtFecha_f,JLabel txtEstatus,JLabel nombreEncargado,JLabel cedulaEncargado,JLabel telefonoEncargado,JLabel nombrePieza,JLabel tipoPieza){

      try{    
       
          
        Class.forName("org.postgresql.Driver");   
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);      
      
    java.sql.Statement st = conexion.createStatement();   
        
    String sql="select ens.id,ens.fecha_i,ens.fecha_f,s.nombre,l.nombre,per.nombre_1   || ' ' || per.apellido_1 nombre_completo,per.cedula,tel.numero,pie.nombre,pie.tipo \n" +
"from ensamblaje_pieza ens,estatus s,avion_pieza avp,pieza pie,planta p,lugar l,personal per,\n" +
"      personal_ensamblaje per_ens,personal_zona pz,telefono tel\n" +
"where ens.fk_estatus=s.id  and ens.fk_avion_pieza=avp.id and avp.fk_pieza=pie.id and \n" +
"      pie.fk_planta=p.id and p.fk_lugar=l.id and per_ens.fk_ensamblaje_pieza=ens.id \n" +
"      and per_ens.fk_personal_zona=pz.id and pz.fk_personal=per.id and tel.fk_personal=per.id \n" +
"      and per_ens.encargado='si' and ens.id="+idProceso_1+"";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
               idProceso.setText(result.getString(1));
               fecha_i.setText(result.getString(2));
               txtFecha_f.setText(result.getString(3));
               txtEstatus.setText(result.getString(4));
               nombrePlanta.setText(result.getString(5));
               nombreEncargado.setText(result.getString(6));
               cedulaEncargado.setText(result.getString(7));
               telefonoEncargado.setText(result.getString(8));
               nombrePieza.setText(result.getString(9));
               tipoPieza.setText(result.getString(10));
              
            
            
         }
    

        st.close();
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
 }
 public void llenarVentaDetallesPruebaPieza(int idProceso_1, JLabel idProceso,JLabel nombrePlanta,JLabel fecha_i,JLabel txtFecha_f,JLabel txtEstatus,JLabel nombreEncargado,JLabel cedulaEncargado,JLabel telefonoEncargado,JLabel nombrePieza,JLabel tipoPieza){

      try{    
       
          
        Class.forName("org.postgresql.Driver");   
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);      
      
    java.sql.Statement st = conexion.createStatement();   
        
    String sql="select distinct pru.id,l.nombre,pru.fecha_i,pru.fecha_f,s.nombre,per.nombre_1 || ' ' || per.apellido_1 nombre,per.cedula,tel.numero,pier.nombre,pier.tipo\n" +
"from prueba pru,estatus s,lugar l,ubicacion_actual ubi,pieza_armada pier,zona z,planta p,personal per,personal_zona pz,\n" +
"      telefono tel,personal_prueba per_pru\n" +
"where pru.fk_pieza_armada=pier.id and ubi.fk_pieza_armada=pier.id and ubi.fk_zona=z.id and z.fk_planta=p.id\n" +
"      and p.fk_lugar=l.id and pz.fk_zona=z.id and pz.fk_personal=per.id and tel.fk_personal=per.id and \n" +
"      per_pru.fk_prueba=pru.id and per_pru.fk_personal_zona=pz.id and per_pru.encargado='si' \n" +
"      and pru.fk_estatus=s.id  and pru.id="+idProceso_1+"";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
               idProceso.setText(result.getString(1));
               nombrePlanta.setText(result.getString(2));
               fecha_i.setText(result.getString(3));
               txtFecha_f.setText(result.getString(4));
               txtEstatus.setText(result.getString(5));
               nombreEncargado.setText(result.getString(6));
               cedulaEncargado.setText(result.getString(7));
               telefonoEncargado.setText(result.getString(8));
               nombrePieza.setText(result.getString(9));
               tipoPieza.setText(result.getString(10));
               
          
            
            
         }
    

        st.close();
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
 }
 public int agregarPersonalEnsamblaje(int fk_ensamblaje_pieza,String encargado,int idPlanta){
  
     try{

        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO personal_ensamblaje(\n" +
"	 fk_personal_zona, fk_ensamblaje_pieza, encargado)\n" +
"	select    distinct pz.id,"+fk_ensamblaje_pieza+",'"+encargado+"'  from personal_zona pz,pieza pie, avion_pieza avp,planta p,zona z\n" +
"where z.tipo_especialidad='ensamblaje' and avp.fk_pieza=pie.id  and  pie.fk_planta=p.id and z.fk_planta="+idPlanta+" and pz.fk_zona=z.id";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
 public int agregarPersonalPruebaPieza(int fk_prueba,String encargado,int idEnsamblaje){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO personal_prueba(\n" +
"	fk_personal_zona, fk_prueba, encargado)\n" +
"select    distinct pz.id,pur.id,'"+encargado+"'  \n" +
"from personal_zona pz,prueba pur,ubicacion_actual ubi,zona z,pieza_armada pier\n" +
"where pur.fk_pieza_armada=pier.id and ubi.fk_pieza_armada=pier.id and ubi.fk_zona=z.id and pz.fk_zona=z.id \n" +
"and z.tipo_especialidad='prueba' and z.nombre='Zona de pruebas de piezas' and pier.fk_ensamblaje_pieza="+idEnsamblaje+" and pur.id="+fk_prueba+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
 public int devolverIdPlantaEnsambaje(int idAvionPieza){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String planta = "";
        
    String sql="select p.id\n" +
"from pieza pie, avion_pieza avp,planta p\n" +
"where avp.id="+idAvionPieza+" and avp.fk_pieza=pie.id  and  pie.fk_planta=p.id";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               planta = result.getString(1);
          }
        if (planta != ""){
            encontre =1;
     
          return Integer.parseInt(planta);
        }
        else {
            if (planta =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int devolverIdEnsamblajePieza(){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select ens.id\n" +
"from ensamblaje_pieza ens\n" +
"where ens.id not in (select fk_ensamblaje_pieza from personal_ensamblaje)";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
public int devolverIdPruebaPieza(){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select pur.id\n" +
"from prueba pur,pieza_armada pier\n" +
"where pur.id not in (select fk_prueba from personal_prueba) and pur.fk_pieza_armada=pier.id ";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public int modificarEncargadoEnsamblaje(int idEnsamblaje){
      try{

        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE personal_ensamblaje\n" +
"	SET encargado='si'\n" +
"	WHERE personal_ensamblaje.id = (select max(pe.id) from personal_ensamblaje pe,ensamblaje_pieza ens\n" +
"                                    where pe.fk_ensamblaje_pieza="+idEnsamblaje+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
 public int modificarEncargadoPruebaPieza(int idPrueba){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE personal_prueba\n" +
"	SET encargado='si'\n" +
"	WHERE personal_prueba.id = (select max(per_pru.id) from personal_prueba per_pru,prueba per\n" +
"                                    where per_pru.fk_prueba="+idPrueba+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
 
 
 
  public void llenarTablaPersonalEnsamblajePieza(JTable tablaPersona,int idProceso)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cedula = "";
    String nombre="";
    String telefono ="";
        
    String sql="select distinct per.nombre_1   || '  ' || per.apellido_1 nombre_completo,per.cedula,tel.numero \n" +
"from ensamblaje_pieza ens,estatus s,avion_pieza avp,pieza pie,planta p,lugar l,personal per,\n" +
"      personal_ensamblaje per_ens,personal_zona pz,telefono tel\n" +
"where ens.fk_estatus=s.id  and ens.fk_avion_pieza=avp.id and avp.fk_pieza=pie.id and \n" +
"      pie.fk_planta=p.id and p.fk_lugar=l.id and per_ens.fk_ensamblaje_pieza=ens.id \n" +
"      and per_ens.fk_personal_zona=pz.id and pz.fk_personal=per.id and tel.fk_personal=per.id \n" +
"      and per_ens.encargado='no' and ens.id="+idProceso+"";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Cedula", "Nombre y Apellido","Telefono"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               nombre = result.getString(1);
               cedula = result.getString(2);
               telefono = result.getString(3);
               String[] row = {cedula,nombre,telefono};
               dtm.addRow(row);
          }
         tablaPersona.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
  }
     
 public void llenarTablaPersonalPruebaPieza(JTable tablaPersona,int idProceso)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cedula = "";
    String nombre="";
    String telefono ="";
        
    String sql="select distinct per.nombre_1 || ' ' || per.apellido_1 nombre,per.cedula,tel.numero\n" +
"from prueba pru,ubicacion_actual ubi,pieza_armada pier,zona z,planta p,personal per,personal_zona pz,\n" +
"      telefono tel,personal_prueba per_pru\n" +
"where pru.fk_pieza_armada=pier.id and ubi.fk_pieza_armada=pier.id and ubi.fk_zona=z.id and z.fk_planta=p.id\n" +
"      and pz.fk_zona=z.id and pz.fk_personal=per.id and tel.fk_personal=per.id and \n" +
"      per_pru.fk_prueba=pru.id and per_pru.fk_personal_zona=pz.id and per_pru.encargado='no' \n" +
"      and pru.id="+idProceso+"";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Cedula", "Nombre y Apellido","Telefono"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               nombre = result.getString(1);
               cedula = result.getString(2);
               telefono = result.getString(3);
               String[] row = {cedula,nombre,telefono};
               dtm.addRow(row);
          }
         tablaPersona.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    } 
     
 
     
  }
  public int agregarUbicacionPiezas(int idEnsablajePieza){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO ubicacion_actual(\n" +
"	 traslado, fecha_i, fecha_f, fk_material_pedido, fk_pieza_armada, fk_zona)\n" +
"	  select null,ense.fecha_f ,ense.fecha_f+31,null,pier.id,z.id\n" +
"      from pieza_armada pier,ensamblaje_avion ensa,ensamblaje_pieza ense,avion_pieza avp, \n" +
"           pieza pie,zona z,planta p\n" +
"      where pier.fk_ensamblaje_avion=ensa.id and pier.fk_ensamblaje_pieza=ense.id \n" +
"           and ense.fk_ensamblaje_avion=ensa.id and ense.fk_avion_pieza=avp.id and avp.fk_pieza=pie.id \n" +
"           and pie.fk_planta=p.id and z.fk_planta=p.id and z.tipo_especialidad='prueba' \n" +
"           and z.nombre='Zona de pruebas de piezas' and ense.id="+idEnsablajePieza+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
  public int modificarEstatusEmsablajePieza(int idEnsamblaje,String nombreEstatus){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE ensamblaje_pieza\n" +
"	SEt fk_estatus=s.id from estatus s\n" +
"	WHERE s.nombre='"+nombreEstatus+"' and ensamblaje_pieza.id="+idEnsamblaje+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
   public int modificarEstatusPruebaPieza(int idPrueba,String nombreEstatus){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE prueba\n" +
"	SET  fk_estatus=s.id from estatus s\n" +
"	WHERE s.nombre='"+nombreEstatus+"' and prueba.id="+idPrueba+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
   public int modificarEstausAvion(int idAvion){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE ensamblaje_avion\n" +
"	SET fk_estatus=s.id from estatus s\n" +
"	WHERE ensamblaje_avion.fk_avion="+idAvion+" and s.nombre='finalizado' ";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
  public int devloverIdUbicacionActual(int idEnsambalajePieza){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select ubi.id from ubicacion_actual ubi,pieza_armada pier where ubi.fk_pieza_armada=pier.id and pier.fk_ensamblaje="+idEnsambalajePieza+"";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != "")
            encontre =1;
        else {
            if (id =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
   public int modificarEstatusFinalAvion(int idAvion){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
    
      
    java.sql.Statement st_ense = conexion.createStatement();

    java.sql.Statement st_pru = conexion.createStatement();
 
    String estatus_prueba = "";
    String estatus_ensamblaje="";
        
    String sqlPrueba="select s.nombre\n" +
"from estatus s,prueba pru,ensamblaje_avion ensa,avion a\n" +
"where pru.fk_ensamblaje_avion=ensa.id and pru.fk_estatus=s.id and ensa.fk_avion="+idAvion+"";
 
        String sqlEnsamblaje="select s.nombre\n" +
"from estatus s,ensamblaje_pieza ense,ensamblaje_avion ensa,pieza_armada pier,avion a\n" +
"where ense.fk_ensamblaje_avion=ensa.id and ense.fk_estatus=s.id and ensa.fk_avion="+idAvion+"";

        ResultSet result_ensamblaje = st_ense.executeQuery(sqlEnsamblaje);
     
        ResultSet result_prueba = st_pru.executeQuery(sqlPrueba);
     
          while (result_ensamblaje.next()){
               estatus_ensamblaje = result_ensamblaje.getString(1);
               if (estatus_ensamblaje.equals("proceso")){
                   return 0;
               }
          }

          while (result_prueba.next()){
               estatus_prueba = result_prueba.getString(1);
               if (estatus_prueba.equals("proceso")){
                   return 0;
               }
          }
          

       
        st_ense.close();
        st_pru.close();
        conexion.close();
        if((estatus_ensamblaje != "") && (estatus_prueba != ""))
          return 1;
        else
            return 0;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
   
 }
  public void llenarComboEstausTodo(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT  nombre\n" +
"	FROM estatus");
 
        combo.addItem("Todos");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }

public int devolverIdEnsamblaJeAvion_DeIdAvion(int idAvion){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select ensa.id \n" +
"    from ensamblaje_avion ensa,avion a\n" +
"    where ensa.fk_avion="+idAvion+"";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }

public int devolverIdAvion_Pieza(int idAvion){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select avi.id\n" +
"from pieza pie,pieza_armada pier,ensamblaje_pieza ense,avion_pieza avi,prueba pru\n" +
"where pru.fk_pieza_armada=pier.id and pier.fk_ensamblaje_pieza=ense.id and ense.fk_avion_pieza=avi.id";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }

 public int modificarFechaFinalEnsamblajePieza(int idEnsamblaje,String fecha_f){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE ensamblaje_pieza\n" +
"	SET  fecha_f='"+fecha_f+"'\n" +
"	WHERE id="+idEnsamblaje+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
 
  public int modificarFechaFinalPruebaPieza(int idPrueba,String fecha_f){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE prueba\n" +
"	SET  fecha_f='"+fecha_f+"'\n" +
"	WHERE id="+idPrueba+"";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
     
 }
  
   public int devolverIdEnsamblajePiezaApartirDePrueba(int idPrueba){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select ense.id\n" +
"from ensamblaje_pieza ense,prueba pru,pieza_armada pier\n" +
"where pru.fk_pieza_armada=pier.id  and pier.fk_ensamblaje_pieza=ense.id and pru.id='"+idPrueba+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
    public void llenarTablaListarPedidosClientes(JTable tablaPedidosCientes)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idPedido = "";
    String nombreCliente="";
    String nombreAvion="";
    String monto="";
    String fecha_pedido="";
    String estaus="";
    String fecha_pago="";
        
    String sql="select pe_cli.id,cli.nombre,a.nombre,pe_cli.monto,pe_cli.fecha_pedido,s.nombre,pe_cli.fecha_pago\n" +
"from pedido_cliente pe_cli,avion a,estatus s,ensamblaje_avion ensa,cliente cli\n" +
"where ensa.fk_estatus=s.id and ensa.fk_avion=a.id and a.fk_pedido_cliente=pe_cli.id \n" +
"and pe_cli.fk_cliente=cli.id";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id Pedido","Cliente","Modelo","Precico","Fecha Pedido","Estatus del Avion","Fecha de Pago"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idPedido = result.getString(1);
               nombreCliente= result.getString(2);
               nombreAvion= result.getString(3);
               monto= result.getString(4);
               fecha_pedido= result.getString(5);
               estaus= result.getString(6);
               fecha_pago= result.getString(7);
                   if (fecha_pago==null)  {
                       fecha_pago="No cancelado";
                   }
               String[] row = {idPedido,nombreCliente,nombreAvion,monto,fecha_pedido,estaus,fecha_pago};
               dtm.addRow(row);
          }
         tablaPedidosCientes.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
 
 public void llenarTablaListarPedidosClientesPorNombre(JTable tablaPedidosCientes,String nombre)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String idPedido = "";
    String nombreCliente="";
    String nombreAvion="";
    String monto="";
    String fecha_pedido="";
    String estaus="";
    String fecha_pago="";
        
    String sql="select pe_cli.id,cli.nombre,a.nombre,pe_cli.monto,pe_cli.fecha_pedido,s.nombre,pe_cli.fecha_pago\n" +
"from pedido_cliente pe_cli,avion a,estatus s,ensamblaje_avion ensa,cliente cli\n" +
"where ensa.fk_estatus=s.id and ensa.fk_avion=a.id and a.fk_pedido_cliente=pe_cli.id \n" +
"and pe_cli.fk_cliente=cli.id and cli.nombre='"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = { "Id Pedido","Cliente","Modelo","Precico","Fecha Pedido","Estatus del Avion","Fecha de Pago"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
               idPedido = result.getString(1);
               nombreCliente= result.getString(2);
               nombreAvion= result.getString(3);
               monto= result.getString(4);
               fecha_pedido= result.getString(5);
               estaus= result.getString(6);
               fecha_pago= result.getString(7);
                   if (fecha_pago==null)  {
                       fecha_pago="No cancelado";
                   }
               String[] row = {idPedido,nombreCliente,nombreAvion,monto,fecha_pedido,estaus,fecha_pago};
               dtm.addRow(row);
          }
         tablaPedidosCientes.setModel(dtm);
        
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
     
 
     
  }
  
  public int buscarPedidoClientePorPagar(int idPedidoCliente){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql="select ped_cli.id \n" +
"from pedido_cliente ped_cli,avion a,ensamblaje_avion ensa, estatus s\n" +
"where a.fk_pedido_cliente=ped_cli.id and ensa.fk_avion=a.id and\n" +
"      ensa.fk_estatus=s.id and s.nombre='finalizado' and ped_cli.id="+idPedidoCliente+" and ped_cli.fecha_pago is  null";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != "")
            encontre =1;
        else {
            if (id =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
  


 public String DevolvermontoPedidoCliente(int ID){
    try{
       String encontre = "";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNuevo = "";
        
    String sql="select monto from pedido_cliente where id='"+ID+"' " ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNuevo = result.getString(1);
          }
        if (nombreNuevo != ""){
          //  encontre ="1";
     
          return  nombreNuevo;
        }
        else {
            if (nombreNuevo =="")
  
                encontre = null;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error alla");
         return null;
    }
   
    
    }
public int agregarFormaDePagoAvion(int id,String tipo, int num_trans ,String banco,int num_cuenta,int num_tar,String fecha,String monto){  
     try{
         System.out.println(id+tipo+num_trans+banco+num_cuenta+num_tar+fecha+monto);
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      int result ;
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO forma_pago(monto, banco, num_cuenta, num_transferencia, tipo,fk_pedido_cliente) VALUES ('"+monto+"', '"+banco+"', '"+num_cuenta+"', '"+num_trans+"', '"+tipo+"', '"+id+"')";
 String sql2 ="INSERT INTO forma_pago(monto, banco, num_tarjeta , fecha_vence, tipo, fk_pedido_cliente) VALUES ('"+monto+"', '"+banco+"','"+num_tar+"' ,'"+fecha+"' , '"+tipo+"', '"+id+"')";
if (tipo.equals("transferencia")){
  result = st.executeUpdate(sql);   
}
else
   result = st.executeUpdate(sql2);   

    st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error2");
         return 0;
    }
    
    } 
public int modificarFechadePagoAvion(int id, String fecha){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
       
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE pedido_cliente SET fecha_pago='"+fecha+"' WHERE id = '"+id+"' ";
   
    int result = st.executeUpdate(sql);  
 
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error aqui ");
         return 0;
    }
    
     
 }
public int agregarPiezaModelo(int cantidad,int fk_pieza,int fk_modelo){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO avion_pieza(\n" +
"	 cantidad_necesaria, fk_pieza, fk_modelo)\n" +
"	VALUES ( "+cantidad+", "+fk_pieza+", "+fk_modelo+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
public int devolverIdModelo(){
      try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id = "";
        
    String sql=" select m.id \n" +
"   from modelo m\n" +
"   where m.id not in (select fk_modelo  from avion_pieza )";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               id = result.getString(1);
          }
        if (id != ""){
            encontre =1;
     
          return Integer.parseInt(id);
        }
        else {
            if (id =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public String devolverFechaFinalEnsamblajeAvionPago(int idPedido){
      try{
       String encontre = "0";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String fecha = "";
        
    String sql="select ensa.fecha_f\n" +
"from ensamblaje_avion ensa,avion a,pedido_cliente ped_cli\n" +
"where ensa.fk_avion=a.id and a.fk_pedido_cliente=ped_cli.id and ped_cli.id="+idPedido+"";
        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               fecha = result.getString(1);
          }
        if (fecha != ""){
            encontre ="1";
     
          return fecha;
        }
        else {
            if (fecha =="")
                encontre ="0";
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return "0";
    }
    
 }
/////////////////////////////////////////////////////
public int construirAvion(String cliente,String nombreModelo,Float monto){
      DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
      Date fechaActual = new Date();
      Date fechaFinal = new Date();
      Calendar cal = Calendar.getInstance(); 
      cal.setTime(fechaActual); 
      cal.add(Calendar.MONTH, 1);
      fechaFinal= cal.getTime();
      int i= 1;
      int a=1;
      Controladora control = new Controladora();
      int fk_cliente =control.devolverIdCliente(cliente);
      
      control.agregarPedidoCliente(formatoFecha.format(fechaActual),monto,fk_cliente);// insertar el pedido
      int fk_pedido_cliente=control.devolverIdPedidoCliente();
  
      int fk_modelo = control.devolverIdModelo(nombreModelo);
   
      control.agregarAvion(nombreModelo,fk_modelo,fk_pedido_cliente);// insertar el avion
      int fk_avion = control.devolverIdAvion();
       
      int fk_estatus_ens_avion = control.devolverIdEstatus("proceso");
   
      control.agregarEnsamblajeAvion(formatoFecha.format(fechaActual),formatoFecha.format(fechaActual),fk_avion,fk_estatus_ens_avion);// insertar el ensamblaje
      int fk_ensamblaje_avion = control.devolverIdEnsamblajeAvion();
  
      int fk_estatus_ens_piesa = control.devolverIdEstatus("proceso");

      try{       
          
        Class.forName("org.postgresql.Driver"); 
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);      
        java.sql.Statement st = conexion.createStatement();
        String id = ""; // fk_avion_pieza
        String cantidadNecesaria="";  
        String sql="select avi_pie.id,avi_pie.cantidad_necesaria from modelo m,avion_pieza avi_pie where avi_pie.fk_modelo = m.id and m.nombre='"+nombreModelo+"'";
        ResultSet result = st.executeQuery(sql);    
        while (result.next()){
               id = result.getString(1);
               cantidadNecesaria = result.getString(2);
            int nuevoIdPlanta = control.devolverIdPlantaEnsambaje(Integer.parseInt(id));
               while (i <= Integer.parseInt(cantidadNecesaria)){
                  control.agregarEnsamblajePieza(formatoFecha.format(fechaActual),formatoFecha.format(fechaFinal),Integer.parseInt(id),fk_ensamblaje_avion,fk_estatus_ens_piesa);// insertar ensamblaje de la pieza, falta buscar los materiales en el inventario
                  int fk_ensamblaje_pieza = control.devolverIdEnsamblajePieza();

                  control.agregarPersonalEnsamblaje(fk_ensamblaje_pieza,"no",nuevoIdPlanta);
                  control.modificarEncargadoEnsamblaje(fk_ensamblaje_pieza);
                  //
                  
                  //
                  i = i+1;
               }
                 i =1;      
            }
            st.close();
            conexion.close();
   
         }catch(Exception e){
           System.err.println("error");
         }
      control.modificarFechaFinalEnsamblajeAvion(fk_ensamblaje_avion); // asignar la fecha final de ensamblaje del avion   
  

     return fk_avion;
           
    
}

///////////////////////////////////////////// FIN DE ALGORITMOS DE GREGORY BUSTAMANTE ///////////////////////////////////////////////////////////







///////////////////////////////////Inicio de los algoritmos de Michel ////////////////////////////////////////////////

  public void llenarInventario(JTable tabla,int ID)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String Nombre ="";
      String cantD= "";
    String cantM = ""; 
    String id ="";
    String planta="";
    String sql="select m.id,m.nombre,l.nombre, sum(mp.cantidad_disponible), m.cantidad_minima from lugar l, material_pedido mp, material m, material_proveedor mpr, planta pl,pedido_proveedor pp \n" +
"where  mp.fecha_inventario is not null and mp.fk_material_proveedor=mpr.id and mpr.fk_material = m.id \n" +
"and mp.cantidad_disponible is not null and pl.fk_lugar=l.id and pp.fk_planta= pl.id and mp.fk_pedido_proveedor = pp.id and pp.fk_planta= '"+ID+"' group by m.id,m.nombre, l.nombre, m.cantidad_minima";

        ResultSet result = st.executeQuery(sql);
       
        /* tabla */
         String[] columna = {"ID","Nombre","Planta","Cantidad Disponible" , "Cantidad Minima"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
             id= result.getString(1);
             Nombre= result.getString(2);
              planta= result.getString(3);
             cantD=result.getString(4);
            cantM = result.getString(5);
       
            String[] row = {id,Nombre,planta,cantD,cantM};
              dtm.addRow(row);
           
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
 
     
  }

       
    public int BuscaPlantaID (String nombre){
    try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String pk = "";
       
    String sql="select p.id from planta p,lugar l where l.nombre = '"+nombre+"' and p.fk_lugar=l.id";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
     
     
 }
    
    public void llenarPlantaBox(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT l.nombre FROM lugar l, planta p where p.fk_lugar=l.id");
 
        combo.addItem("Seleccione Planta");
            while (rs.next()) {
             
               if (rs.getString(1).equals("GIRARDOT"))
                    combo.addItem(rs.getString(1).replaceAll("GIRARDOT", "MARACAY"));   
               else
                     combo.addItem(rs.getString(1));
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
    
      public int agregarPedidoProveedor(String fecha,String monto,int planta,int id){  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO pedido_proveedor( fecha_pedido, fecha_pago, monto, fk_planta, fk_material )VALUES ('"+fecha+"', null ,'"+monto+"', '"+planta+"', '"+id+"')" ;
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error2");
         return 0;
    }
    
    }
      public int agregarPedidoMaterial(int Cantidad, String precio,int materialProveedor, int pedido){
  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
         System.out.println(Cantidad);
         System.out.println(precio);
         System.out.println(materialProveedor);
         System.out.println(pedido);
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO material_pedido( cantidad, precio, fecha_inventario, fk_material_proveedor, fk_pedido_proveedor,cantidad_disponible) VALUES ('"+Cantidad+"','"+precio+"' ,null , '"+materialProveedor+"', '"+pedido+"','"+Cantidad+"')";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error1");
         return 0;
    }
    
    } 
      public int DevolverMaterialProvedorId(int ID){
   try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String pk = "";
        
    String sql="select distinct z.id from proveedor p, material m, material_proveedor z where  z.fk_material=m.id and m.id='"+ID+"' and z.precio_unitario_actual = (select min(za.precio_unitario_actual) from material m, material_proveedor za where m.id= '"+ID+"' and za.fk_material=m.id  )" ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }

    }
      public int DevolverPedidoId(int ID){    
         try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String pk = "";
        
    String sql="select distinct  z.id from planta p, material m, pedido_proveedor z where  z.fk_planta= '"+ID+"' and z.monto= '0'  " ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }

    } 
 public int buscarProveedorID(String nombre){
       try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String pk = "";
        
    String sql="select p.id from proveedor p where p.nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
     
     
 }
  public String DevolverPrecio(int ID){
    try{
       String encontre = "";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNuevo = "";
        
    String sql="select distinct z.precio_unitario_actual from proveedor p, material m, material_proveedor z where  z.fk_material=m.id and m.id='"+ID+"' and z.precio_unitario_actual = (select min(za.precio_unitario_actual) from material m, material_proveedor za where m.id= '"+ID+"' and za.fk_material=m.id  )" ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNuevo = result.getString(1);
          }
        if (nombreNuevo != ""){
          //  encontre ="1";
     
          return  nombreNuevo;
        }
        else {
            if (nombreNuevo =="")
  
                encontre = null;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error alla");
         return null;
    }
   
    
    } 
  public String sumarMonto(){
  try{
      
     
        Class.forName("org.postgresql.Driver");

        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
  String monto ="";
    java.sql.Statement st = conexion.createStatement();
   
    String sql="select Sum(z.precio_unitario_actual* j.cantidad)from proveedor p, material m, material_proveedor z, material_pedido j, pedido_proveedor o where z.fk_proveedor=p.id and z.fk_material=m.id and j.fk_material_proveedor=z.id and fk_pedido_proveedor=o.id and o.monto='0'";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
             monto=(result.getString(1));
              
         }
      st.close();
        conexion.close();
        return  monto;

    }catch(Exception e){
         System.err.println("error");
         return null;
      
    }
    
    }
  public int modificarMontoPedido(String montoNuevo){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
       
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE pedido_proveedor SET monto='"+montoNuevo+"' WHERE monto = '0' ";
   
    int result = st.executeUpdate(sql);  
 
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error aqui ");
         return 0;
    }
    
     
 }   
  
  public int agregarProveedor(String nombre,String pgWeb,String fecha_contrato,int montoAcreditado,int lugar){
  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO proveedor(nombre, paginaweb, fecha_operacion, monto_acreditado ,fk_lugar, otro_dato ) VALUES ('"+nombre+"','"+pgWeb+"','"+fecha_contrato+"','"+montoAcreditado+"','"+lugar+"',null)";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error1");
         return 0;
    }
    
    } 
  public int buscarProveedor(String nombre){
      
      try{
       int encontre = 0;
//          
        Class.forName("org.postgresql.Driver");
//    
       Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
//      
//      
    java.sql.Statement st = conexion.createStatement();
    String cedulaNueva = "";
        
    String sql="select p.nombre from proveedor p where p.nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               cedulaNueva = result.getString(1);
          }
        if (cedulaNueva != "")
            encontre =1;
        else {
            if (cedulaNueva =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
  
public void llenarTablaProveedor(JTable tabla)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id ="";
    String nombre = "";
    String fecha = "";
   String telefono ="";
           
    String sql="select p.id, p.nombre, p.fecha_operacion, t.numero from proveedor p, telefono t where t.fk_proveedor=p.id";

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"ID", "Nombre","Fecha de contrato","Teléfono"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
             id= result.getString(1);
            nombre = result.getString(2);
            fecha = result.getString(3);
            telefono = result.getString(4);
            String[] row = {id,nombre,fecha,telefono};
              dtm.addRow(row);
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
 
     
 
     
  }
 public int eliminarProveedor(String nombre){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from proveedor p where p.nombre = '"+nombre+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }
 public String devolverNombre(String nombre){
      try{
       String encontre = "";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNuevo = "";
        
    String sql="select p.nombre from proveedor p where p.nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNuevo = result.getString(1);
          }
        if (nombreNuevo != ""){
          //  encontre ="1";
     
          return  nombreNuevo;
        }
        else {
            if (nombreNuevo =="")
  
                encontre = null;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error alla");
         return null;
    }
    
 }
 public void llenarVentaProveedor(String nombre, JTextField NombreTxt,JTextField pagWebTxt,JTextField Tlf1Txt,JTextField MontoAcreditadoTxt,JDateChooser fecha, JTextField correoTxt,JTextField Parrocombo,JTextField Municombo,JTextField Estcombo,JTextField Paiscombo){

      try{
      
       
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    
   
        
    String sql="select p.nombre, p.paginaweb, p.fecha_operacion, p.otro_dato, p.monto_acreditado from proveedor p where p.nombre = '"+nombre+"'";
  String sql2= "SELECT t.numero from telefono t, proveedor p where t.fk_proveedor = p.id and p.nombre = '"+nombre+"' ";
    String sql3= "SELECT c.nombre from correo c, proveedor p where c.fk_proveedor = p.id and p.nombre = '"+nombre+"' ";
    String sql4= "SELECT l.nombre,l2.nombre, l3.nombre,l4.nombre from lugar l, lugar l2,lugar l3,lugar l4, proveedor p where p.fk_lugar = l.id and p.nombre = '"+nombre+"' and l2.id=l.fk_lugar and l3.id=l2.fk_lugar and l4.id=l3.fk_lugar";

    ResultSet result = st.executeQuery(sql);
    
        while (result.next()){
               
               NombreTxt.setText(result.getString(1));
               pagWebTxt.setText(result.getString(2));
               MontoAcreditadoTxt.setText(result.getString(5));
               fecha.setDate(result.getDate(3));
     }
  ResultSet  result2 = st.executeQuery(sql2);
   while (result2.next()){
               
               Tlf1Txt.setText(result2.getString(1));
              
             
         }
    
        
     ResultSet  result3 = st.executeQuery(sql3);
          
   while (result3.next()){
               
               correoTxt.setText(result3.getString(1));
              
             
         }
    
   
        ResultSet  result4 = st.executeQuery(sql4);
         
   while (result4.next()){
               Parrocombo.setText(result4.getString(1));
               Municombo.setText(result4.getString(2));
                 Estcombo.setText(result4.getString(3));
               Paiscombo.setText(result4.getString(4));
          
  
         }

        st.close();     
       
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
 }
 public int modificarProveedor(String nombre,String nombreNuevo,String pgWeb,String fecha_contrato,int montoAcreditado, String Telefono,String Correo, int lugar){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
       
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE proveedor SET nombre='"+nombreNuevo+"',paginaweb='"+pgWeb+"', fecha_operacion='"+fecha_contrato+"',monto_acreditado='"+montoAcreditado+"',fk_lugar='"+lugar+"' WHERE nombre ='"+nombre+"'";
        String sql2="UPDATE telefono SET numero='"+Telefono+"' where fk_proveedor = (Select p.id from proveedor p where p.nombre = '"+nombre+"' ) ";
        String sql3="UPDATE correo SET nombre='"+Correo+"' where fk_proveedor = (Select p.id from proveedor p where p.nombre = '"+nombre+"' ) ";
    int result = st.executeUpdate(sql);  
    int result2 = st.executeUpdate(sql2);
     int result3 = st.executeUpdate(sql3);
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error aqui ");
         return 0;
    }
    
     
 }
 public int agregarTelefono(String numero,int proveedor){
  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql= "INSERT INTO telefono(numero,fk_personal, fk_proveedor, fk_cliente) VALUES ('"+numero+"',null,'"+proveedor+"',null)";

    int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error3");
         return 0;
    }
    
    }          
 public int buscarTelefono(String numero){
      
      try{
       int encontre = 0;
//          
        Class.forName("org.postgresql.Driver");
//    
       Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
//      
//      
    java.sql.Statement st = conexion.createStatement();
    String tlf = "";
        
    String sql="select numero from telefono where numero = '"+numero+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               tlf = result.getString(1);
          }
        if (tlf != "")
            encontre =1;
        else {
            if (tlf =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public int devolverTelefono(String nombre){
     try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String tlf = "";
        
    String sql="select t.numero from proveedor p, telefono t where p.nombre = '"+nombre+"' and t.fk_proveedor=p.id  ";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               tlf = result.getString(1);
          }
        if (tlf != ""){
            encontre =1;
     
          return Integer.parseInt(tlf);
        }
        else {
            if (tlf =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
 }
 public int agregarCorreo(String correo,int proveedor){
  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql= "INSERT INTO correo (nombre,fk_personal, fk_proveedor, fk_cliente) VALUES ('"+correo+"',null,'"+proveedor+"',null)";

    int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }  
 public void llenar_pais(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM Lugar where tipo='Pais'");
 
        combo.addItem("Seleccione País");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
 public void llenar_est(JComboBox combo,int Pais)  {
       combo.removeAllItems();
    try {
        
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM Lugar where fk_lugar= '"+Pais+"' and tipo='Estado'");
  combo.addItem("Seleccione Estado");
        
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
 public void llenar_muni(JComboBox combo,int Estado){

         combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM Lugar where fk_lugar= '"+Estado+"' and tipo='Municipio'");
   
           combo.addItem("Seleccione Municipio");
        
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
}
 public void llenar_parro(JComboBox combo,int muni){

         combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM Lugar where fk_lugar= '"+muni+"' and tipo='Parroquia'");
  
           combo.addItem("Seleccione Parroquia");
        
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
}
 public int BuscarLugarID (String nombre,String Tipo)
{
    try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String pk = "";
       
    String sql="select id from lugar p where nombre = '"+nombre+"' and tipo= '"+Tipo+"' ";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
     
     
 }
public void llenarProveedorBox(JComboBox combo){
  combo.removeAllItems();
    try {
            Class.forName("org.postgresql.Driver");
     Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
           java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = st.executeQuery("SELECT nombre FROM proveedor");
 
        combo.addItem("Seleccione Proveedor");
            while (rs.next()) {
               combo.addItem(rs.getString(1));
               
            }
 
            st.close();
        } catch (Exception e) {
   System.err.println("error");
        }
    }
public void llenarTablaProveedorMaterial(JTable tabla, String Nombre)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id ="";
    String nombre = "";
    String precio= "";
           
    String sql="select m.id, m.nombre, z.precio_unitario_actual from proveedor p, material m, material_proveedor z where z.fk_proveedor=p.id and z.fk_material=m.id and p.nombre= '"+Nombre+"'" ;

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"ID", "Nombre","Precio Unitario"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
             id= result.getString(1);
            nombre = result.getString(2);
       precio= result.getString(3);
            String[] row = {id,nombre,precio};
              dtm.addRow(row);
           
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
 
     
 
     
  }
public int agregarPedidoProveedor(String fecha,String monto,int planta){  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO pedido_proveedor( fecha_pedido, fecha_pago, monto, fk_planta, fk_material )VALUES ('"+fecha+"', null ,'"+monto+"', '"+planta+"', null)" ;
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error2");
         return 0;
    }
    
    } 
public int eliminarPedido(int pk){
    try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="delete from pedido_proveedor p where p.id = '"+pk+"'";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    }

public void llenarTablarMaterialPedido(JTable tabla,String nombre)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String cant ="";
    String Nombre = "";
    String precioU= "";
           
    String sql="select m.nombre, z.precio_unitario_actual, j.cantidad from proveedor p, material m, material_proveedor z, material_pedido j, pedido_proveedor o where z.fk_proveedor=p.id and z.fk_material=m.id and p.nombre= '"+nombre+"'  and j.fk_material_proveedor=z.id and fk_pedido_proveedor=o.id and o.monto='0'" ;

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"Nombre","Precio Unitario","Cantidad"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
            
            Nombre = result.getString(1);
       precioU= result.getString(2);
       cant=result.getString(3); ;
            String[] row = {Nombre,precioU,cant};
              dtm.addRow(row);
           
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
      
 
     
 
     
  }
public int DevolverMaterialProvedorId(String Nombre,int ID){
   try{
       int encontre = 0;
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String pk = "";
        
    String sql="select z.id from proveedor p, material m, material_proveedor z where z.fk_proveedor=p.id and z.fk_material=m.id and p.nombre= '"+Nombre+"' and m.id='"+ID+"'" ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }

    } 
public String DevolverPrecio(String Nombre,int ID){
    try{
       String encontre = "";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNuevo = "";
        
    String sql="select z.precio_unitario_actual from proveedor p, material m, material_proveedor z where z.fk_proveedor=p.id and z.fk_material=m.id and p.nombre= '"+Nombre+"' and m.id='"+ID+"'" ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNuevo = result.getString(1);
          }
        if (nombreNuevo != ""){
          //  encontre ="1";
     
          return  nombreNuevo;
        }
        else {
            if (nombreNuevo =="")
  
                encontre = null;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error alla");
         return null;
    }
   
    
    } 
public void sumarMonto(JTextField monto, String nombre){
  try{
      
     
        Class.forName("org.postgresql.Driver");

        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
  
    java.sql.Statement st = conexion.createStatement();
   
    String sql="select Sum(z.precio_unitario_actual* j.cantidad)from proveedor p, material m, material_proveedor z, material_pedido j, pedido_proveedor o where z.fk_proveedor=p.id and z.fk_material=m.id and p.nombre= '"+nombre+"'   and j.fk_material_proveedor=z.id and fk_pedido_proveedor=o.id and o.monto='0'";

        ResultSet result = st.executeQuery(sql);
        while (result.next()){
               
               monto.setText(result.getString(1));
              
         }
      st.close();
        conexion.close();

    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
    }
public void llenarFechaPedido( JTextField fecha,int ID){

      try{
      
       
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    
   String sql="select  z.fecha_pedido from planta p, material m, pedido_proveedor z where  z.fk_planta= '"+ID+"' and z.monto= '0'  " ;
        
 
    ResultSet result = st.executeQuery(sql);
    
        while (result.next()){
               

               fecha.setText(result.getString(1));
     }

        st.close();     
       
        conexion.close();
        
    
    }catch(Exception e){
         System.err.println("error");
         
      
    }
    
 }
public void llenarTablaPedidos(JTable tabla)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id ="";
    String id2= "";
    String nombre = "";
    String nombreM= "";
    String fecha1= "";
    String fecha2  = ""; 
   String monto ="";
    String sql="select  o.id, j.id ,p.nombre, m.nombre, o.fecha_pedido, o.fecha_pago, o.monto from proveedor p, material m, material_proveedor z , material_pedido j, pedido_proveedor o where  p.id= z.fk_proveedor and m.id=z.fk_material and j.fk_pedido_proveedor = o.id and j.fk_material_proveedor= z.id order by o.id "  ;

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"ID Pedido","ID material" ,"Nombre","Material","Fecha de pedido","Fecha de entrega","Monto"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
             id= result.getString(1);
             id2=result.getString(2);
            nombre = result.getString(3);
       nombreM= result.getString(4);
       fecha1= result.getString(5);
               fecha2= result.getString(6);
                  monto= result.getString(7);
            String[] row = {id,id2,nombre,nombreM,fecha1,fecha2,monto};
              dtm.addRow(row);
           
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
 }  
public void llenarTablaPedidos(JTable tabla,String name)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String id ="";
      String id2= "";
    String nombre = "";
    String nombreM= "";
    String fecha1= "";
    String fecha2  = "";  
    String monto = "";
    String sql="select  o.id,j.id , p.nombre, m.nombre, o.fecha_pedido, o.fecha_pago,o.monto from proveedor p, material m, material_proveedor z , material_pedido j, pedido_proveedor o where  p.id= z.fk_proveedor and m.id=z.fk_material and j.fk_pedido_proveedor = o.id and j.fk_material_proveedor= z.id and p.nombre = '"+name+"' order by o.id asc"  ;

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"ID Pedido","ID material" , "Nombre","Material","Fecha de pedido","Fecha de entrega ","Monto"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
             id= result.getString(1);
             id2=result.getString(2);
            nombre = result.getString(3);
       nombreM= result.getString(4);
       fecha1= result.getString(5);
               fecha2= result.getString(6);
               monto=result.getString(7);
            String[] row = {id,id2,nombre,nombreM,fecha1,fecha2,monto};
              dtm.addRow(row);
           
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
 
     
  }

public int agregarPruebaMaterial(int id,String fecha,String fechaF){  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO prueba( fecha_i, fecha_f, fk_material_pedido, fk_pieza_armada, fk_ensamblaje_avion, fk_estatus)VALUES ('"+fecha+"', '"+fechaF+"' ,'"+id+"', null ,null, 3);" ;
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error2");
         return 0;
    }
    
    } 
public void llenarTablaPago(JTable tabla)/*throws ClassNotFoundException, SQLException*/{
   
 try{
          
  
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String Id ="";

    String nombre = "";
    
    String fecha1= "";
     
    String monto = "";
    String sql="select distinct o.id, p.nombre, o.fecha_pedido,o.monto from proveedor p, material m, material_proveedor z , material_pedido j, pedido_proveedor o, prueba pru where  p.id= z.fk_proveedor and m.id=z.fk_material and j.fk_pedido_proveedor = o.id and j.fk_material_proveedor= z.id and o.fecha_pago is null and j.id=pru.fk_material_pedido order by o.id asc "  ;

        ResultSet result = st.executeQuery(sql);
        
        /* tabla */
         String[] columna = {"ID Pedido", "Nombre","Fecha de pedido","Monto"};
         DefaultTableModel dtm = new DefaultTableModel(null,columna);
         /* tabla */

          while (result.next()){
             Id= result.getString(1);
           
            nombre = result.getString(2);
       fecha1= result.getString(3);      
        monto=result.getString(4);
            String[] row = {Id,nombre,fecha1,monto};
              dtm.addRow(row);
           
          }
         tabla.setModel(dtm);
       

        st.close();
        conexion.close();
   
    }catch(Exception e){
         System.err.println("error");
         
    }
 
     
  }
public int modificarFechadePago(int id, String fecha){
      try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
       
    java.sql.Statement st = conexion.createStatement();
    String sql="UPDATE pedido_proveedor SET fecha_pago='"+fecha+"' WHERE id = '"+id+"' ";
   
    int result = st.executeUpdate(sql);  
 
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error aqui ");
         return 0;
    }
    
     
 }
public int agregarFormaDePagomaterial(int id,String tipo, int num_trans ,String banco,int num_cuenta,int num_tar,String fecha,String monto){  
     try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      int result ;
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO forma_pago(monto, banco, num_cuenta, num_transferencia, tipo,fk_pedido_proveedor) VALUES ('"+monto+"', '"+banco+"', '"+num_cuenta+"', '"+num_trans+"', '"+tipo+"', '"+id+"')";
 String sql2 ="INSERT INTO forma_pago(monto, banco, num_tarjeta , fecha_vence, tipo, fk_pedido_proveedor) VALUES ('"+monto+"', '"+banco+"','"+num_tar+"' ,'"+fecha+"' , '"+tipo+"', '"+id+"')";
if (tipo.equals("transferencia")){
  result = st.executeUpdate(sql);   
}
else
   result = st.executeUpdate(sql2);   

    st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error2");
         return 0;
    }
    
    } 
public String Devolvermonto(int ID){
    try{
       String encontre = "";
          
        Class.forName("org.postgresql.Driver");
    
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
      
    java.sql.Statement st = conexion.createStatement();
    String nombreNuevo = "";
        
    String sql="select monto from pedido_proveedor where id='"+ID+"' " ;


        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               nombreNuevo = result.getString(1);
          }
        if (nombreNuevo != ""){
          //  encontre ="1";
     
          return  nombreNuevo;
        }
        else {
            if (nombreNuevo =="")
  
                encontre = null;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error alla");
         return null;
    }
   
    
    }



////////////////////////////Fin de los algoritmos de Michel ////////////////////////////////////////////////////


////////////////////////////////Inicio de los algoritmos de fabian /////////////////////////////////////////////


 public int eliminarCliente(String nombre){
     try{
         Class.forName("org.postgresql.Driver");  
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);   
         java.sql.Statement st = conexion.createStatement();
         String sql= "DELETE FROM cliente WHERE nombre='"+nombre+"'";
         int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
     }catch(Exception e){      
         System.err.println("error");
         return 0;
     }
 }
  public int buscarCliente(String nombre){
    try{
       int encontre = 0;         
          Class.forName("org.postgresql.Driver");
          Connection conexion = DriverManager.getConnection(url,usuario,contraseña); 
          java.sql.Statement st = conexion.createStatement();
          String resultado = "";
        
         String sql="select nombre from cliente where nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               resultado = result.getString(1);
          }
        if (resultado != "")
            encontre =1;
        else {
            if (resultado =="")
                encontre =2;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
  }
  public int buscarClienteID(String nombre){
     try{
         int encontre = 0;         
        Class.forName("org.postgresql.Driver");        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);     
    java.sql.Statement st = conexion.createStatement();
    String pk = "";    
    String sql="select id from cliente where nombre = '"+nombre+"'";

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
     
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
         
     }catch(Exception e){
         System.err.println("error,no se encontro cliente");
         return 0;
 }
 }
 public int agregarCliente(String nombre,String pagina,String otro,String fecha,int monto,int lugar){
     try{
         
         Connection conexion = DriverManager.getConnection(url,usuario,contraseña);  
         java.sql.Statement st = conexion.createStatement();
         String sql = "INSERT INTO cliente(nombre, paginaweb, fecha_operacion, monto_acreditado ,fk_lugar, otro_dato ) VALUES('"+nombre+"','"+pagina+"','"+fecha+"','"+monto+"','"+lugar+"','"+otro+"')";
         int result=st.executeUpdate(sql);
         st.close();
         conexion.close(); 
         return 1;
     }
     catch(SQLException sqle){
            while(sqle!=null){
             System.err.println("mensaje: "+sqle.getMessage());
             System.err.println("sqlstate: "+ sqle.getSQLState());
             System.err.println("codigo de error" + sqle.getErrorCode());
             sqle=sqle.getNextException();
             }
         System.err.println("error, no se pudo insertar cliente");
         return 0;
     }
 }
 public void llenarCliente(String nombre,JTextField Nombre_t,JTextField pagina,JDateChooser fecha,JTextField monto,JTextField telf,JTextField correo,JTextField otro,JTextField pais,JTextField est,JTextField muni,JTextField par){
     try{
         Class.forName("org.postgresql.Driver");
         
         Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
         java.sql.Statement st = conexion.createStatement();
         
         String sql="select c.nombre,c.paginaweb,c.fecha_operacion,c.otro_dato,c.monto_acreditado,t.numero,co.nombre from cliente c,correo co,telefono t where c.nombre='"+nombre+"' and t.fk_cliente=c.id and co.fk_cliente=c.id";
         ResultSet result = st.executeQuery(sql);
         if(result.next()){
            Nombre_t.setText(result.getString(1));
            pagina.setText(result.getString(2));
            fecha.setDate(result.getDate(3));
            otro.setText(result.getString(4));
            monto.setText(result.getString(5));
            telf.setText(result.getString(6));
            correo.setText(result.getString(7));
         }
         sql="select pa.nombre,e.nombre,m.nombre,p.nombre from cliente c,lugar p,lugar e,lugar m,lugar pa where c.nombre='"+nombre+"' and c.fk_lugar=p.id and p.fk_lugar=m.id and m.fk_lugar=e.id and e.fk_lugar=pa.id";
         result = st.executeQuery(sql);
         if(result.next()){
            pais.setText(result.getString(1));
            est.setText(result.getString(2));
            muni.setText(result.getString(3));
            par.setText(result.getString(4));
         }
         st.close();     
         conexion.close();
     }catch(Exception e){
         System.out.println("error");
     }
    
        
        
 }
 public void llenarTablaCliente(JTable tabla){
    try{
        Class.forName("org.postgresql.Driver");      
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
        java.sql.Statement st = conexion.createStatement();
       
        String sql="select c.id as id, c.nombre as nombre,c.monto_acreditado, t.numero as numero, c.fecha_operacion as fecha from cliente c, telefono t where t.fk_cliente=c.id";
        ResultSet result = st.executeQuery(sql);
        
        ResultSetMetaData data= result.getMetaData();
        int columnas = data.getColumnCount();
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        for (int i =1;i<=columnas;i++){
            modelo.addColumn(data.getColumnLabel(i));
        }
        while(result.next()){
            Object[] fila = new Object[columnas];
            for (int i = 0;i< columnas;i++){
                fila[i]=result.getObject(i+1);
            }
            modelo.addRow(fila);
        }
        result.close();
        conexion.close();
        
    }catch(Exception e){
        System.err.println("error");  
    }
}
 public int modificarCliente(String nombre,String nombret,String pagina,String otro,String fecha,int monto,int lugar,String numero,String correo){
    try{
             
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
        java.sql.Statement st = conexion.createStatement();    
        String sql="update cliente set nombre='"+nombret+"',paginaweb='"+pagina+"',otro_dato='"+otro+"',fecha_operacion='"+fecha+"',monto_acreditado='"+monto+"',fk_lugar='"+lugar+"' where nombre='"+nombre+"'";
        int result = st.executeUpdate(sql);
        sql="update telefono set numero='"+numero+"' where fk_cliente='"+this.buscarClienteID(nombret)+"'";
        result = st.executeUpdate(sql);
        sql="update correo set nombre='"+correo+"' where fk_cliente='"+this.buscarClienteID(nombret)+"'";
        result = st.executeUpdate(sql);
        st.close();
        conexion.close();
        return 1;        
    }catch(SQLException sqle){
            while(sqle!=null){
             System.err.println("mensaje: "+sqle.getMessage());
             System.err.println("sqlstate: "+ sqle.getSQLState());
             System.err.println("codigo de error" + sqle.getErrorCode());
             sqle=sqle.getNextException();
             }
        System.out.println("error al modificar cliente");
        return 0;
    }
}

  public int agregarTelefonocliente(String numero,int cliente){
     try{
       
    Class.forName("org.postgresql.Driver");
    Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
    java.sql.Statement st = conexion.createStatement();
    String sql= "INSERT INTO telefono(numero,fk_personal, fk_proveedor, fk_cliente) VALUES ('"+numero+"',null,null,'"+cliente+"')";

    int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    
    } 
 public int agregarCorreocliente(String correo,int cliente){
  
     try{
       
        
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql= "INSERT INTO correo (nombre,fk_personal, fk_proveedor, fk_cliente) VALUES ('"+correo+"',null,null,'"+cliente+"')";

    int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(SQLException sqle){
            while(sqle!=null){
             System.err.println("mensaje: "+sqle.getMessage());
             System.err.println("sqlstate: "+ sqle.getSQLState());
             System.err.println("codigo de error" + sqle.getErrorCode());
             sqle=sqle.getNextException();
             }
         System.err.println("error");
         return 0;
    }
    
    }
 
 public int modificarEncargadoPruebaMaterial(int idPrueba){
      try{
       
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
        java.sql.Statement st = conexion.createStatement();
        String sql="UPDATE personal_prueba \n" +
"	SET encargado='si' \n" +
"	WHERE personal_prueba.id = (select max(per_pru.id) from personal_prueba per_pru,prueba per\n" +
"                                    where per_pru.fk_prueba="+idPrueba+")";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
}
  public int devolverUltimaPrueba(){
     try{
       int encontre=0;
       String idp="";
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="select max(id) from prueba ";
    ResultSet result = st.executeQuery(sql);
          while (result.next()){
               idp = result.getString(1);
          }
        if (idp != ""){
            encontre =1;
     
          return Integer.parseInt(idp);
        }
        else {
            if (idp =="")
                encontre =0;
        }
        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    } 
 public int agregarPersonalPrueba(int prueba,String encargado,int idPlanta){
  
     try{
       
        Class.forName("org.postgresql.Driver");
    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
      
    java.sql.Statement st = conexion.createStatement();
    String sql="INSERT INTO personal_prueba " +
    "  (fk_personal_zona, fk_prueba, encargado)\n" +
    "	select    distinct pz.id,"+prueba+",'"+encargado+"'  from personal_zona pz,planta p,zona z\n" +
    " where z.tipo_especialidad='prueba' and z.nombre='Zona de pruebas de material' and pz.fk_zona=z.id and z.fk_planta="+idPlanta+" ";
        int result = st.executeUpdate(sql);   
        st.close();
        conexion.close();
           return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
    }
 public void llenarTablaPruebas(JTable tabla,String planta,String estatus){
    try{
        Class.forName("org.postgresql.Driver");    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
        java.sql.Statement st = conexion.createStatement();

      String sql="select p.id as ID,l.nombre as lugar,m.nombre as material,p.fecha_i as fecha_i,p.fecha_f as fecha_f,e.nombre estatus "
              + " from prueba p,estatus e,material_pedido mp,material_proveedor ma,material m,ubicacion_actual u,zona z,planta pl,lugar l\n" +
" where p.fk_estatus=e.id and p.fk_material_pedido=mp.id and mp.fk_material_proveedor=ma.id and ma.fk_material=m.id and u.fk_material_pedido=mp.id and u.fk_zona=z.id and p.fecha_i=u.fecha_i and z.fk_planta=pl.id and z.nombre='Zona de pruebas de material' and pl.fk_lugar=l.id ";
              
        if (!(planta.equalsIgnoreCase("Todas")))
            sql=sql + " and l.nombre='"+planta+"'";
        if (!(estatus.equalsIgnoreCase("todos")))
            sql=sql + " and e.nombre='"+estatus+"'";
        sql=sql +" order by p.id,e.nombre ";
        ResultSet result = st.executeQuery(sql);
        
        ResultSetMetaData data= result.getMetaData();
        int columnas = data.getColumnCount();
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
       
        for (int i =1;i<=columnas;i++){
            modelo.addColumn(data.getColumnLabel(i));
        }
        while(result.next()){
            Object[] fila = new Object[columnas];
            for (int i = 0;i< columnas;i++){
                if (result.getObject(i+1).equals("GIRARDOT"))
                    fila[i]="MARACAY";
                else
                fila[i]=result.getObject(i+1);
            }
            modelo.addRow(fila);
        }

        result.close();
        conexion.close();
        
    }catch(Exception e){
         System.err.println("error"); 
    }
    
}
public void llenarPruebaMaterial(int idped,JLabel id,JLabel nombre,JLabel fechai,JLabel fechaf,JComboBox estatus,JLabel planta,JLabel encargado,JLabel cedula,JLabel telf){
    try{
         Class.forName("org.postgresql.Driver");
         
         Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
         java.sql.Statement st = conexion.createStatement();
         
         String sql="select p.id,m.nombre,p.fecha_i,p.fecha_f,e.nombre,l.nombre "
                 + " from prueba p,material m,estatus e,lugar l,planta pl,material_pedido mp,material_proveedor mpr,ubicacion_actual u,zona z "
                 + " where p.id='"+idped+"' and p.fk_estatus=e.id and p.fk_material_pedido=mp.id and u.fk_material_pedido=mp.id and p.fecha_i=u.fecha_i and u.fk_zona=z.id and z.fk_planta=pl.id and pl.fk_lugar=l.id and mp.fk_material_proveedor=mpr.id and mpr.fk_material=m.id";
         ResultSet result = st.executeQuery(sql);
         if(result.next()){
            id.setText(result.getString(1));
            nombre.setText(result.getString(2));
            fechai.setText(result.getString(3));
            fechaf.setText(result.getString(4));
            estatus.setSelectedItem(result.getString(5));
            if(result.getString(6).equals("GIRARDOT"))
                planta.setText("MARACAY");
            else
                planta.setText(result.getString(6));
         }
         
         sql="select p.nombre_1||' '||p.apellido_1 as nombre,p.cedula,t.numero as telefono "
              +" from personal_prueba pp,personal_zona pz, personal p,telefono t "
              +" where pp.encargado='si' and pp.fk_prueba='"+idped+"' and pp.fk_personal_zona=pz.id and pz.fk_personal=p.id and t.fk_personal=p.id";
         result = st.executeQuery(sql);
         if(result.next()){
            encargado.setText(result.getString(1));
            cedula.setText(result.getString(2));
            telf.setText(result.getString(3));
         }
         st.close();     
         conexion.close();
     }catch(Exception e){
         System.out.println("error");
     }
}
public void llenarPersonalPrueba(int id,JTable tabla){
    try{
        Class.forName("org.postgresql.Driver");    
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
        java.sql.Statement st = conexion.createStatement();
       
        String sql="select p.nombre_1||' '||p.apellido_1 as nombre,p.cedula,t.numero as telefono "
                + " from personal_prueba pp,personal_zona pz, personal p,telefono t "
                + " where pp.encargado='no' and pp.fk_prueba='"+id+"' and pp.fk_personal_zona=pz.id and pz.fk_personal=p.id and t.fk_personal=p.id";
        ResultSet result = st.executeQuery(sql);
        ResultSetMetaData data= result.getMetaData();
        int columnas = data.getColumnCount();
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        for (int i =1;i<=columnas;i++){
            modelo.addColumn(data.getColumnLabel(i));
        }
        while(result.next()){
            Object[] fila = new Object[columnas];
            for (int i = 0;i< columnas;i++){
                fila[i]=result.getObject(i+1);
            }
            modelo.addRow(fila);
        }
        
        result.close();
        conexion.close();
        
    }catch(Exception e){   
         System.err.println("error"); 
    }
}
public int actualizarUbicacionMaterial(int id,String ubicacion){
    try{
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
        java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int result = st.executeUpdate("update ubicacion_actual set fk_zona=(select z.id from zona z,planta pl,lugar l where z.nombre='Zona de pruebas de material' and z.fk_planta=pl.id and pl.fk_lugar=l.id and l.nombre='"+ubicacion+"')"
                + " where id=(select u.id from ubicacion_actual u,prueba p,material_pedido mp where p.id='"+id+"' and p.fk_material_pedido=mp.id and u.fk_material_pedido=mp.id)");
        
        st.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
}
public void IngresarInventario(int id,String fechaf){
    try{
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
        java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int result = st.executeUpdate("update material_pedido set fecha_inventario='"+fechaf+"' where id=(select fk_material_pedido from prueba p where p.id='"+id+"')");
        
        st.close();
    }catch(Exception e){
         System.err.println("error");
    }
}
 public int buscarZonaID(String muni,String tipo){
    try{
      int encontre=0;
      Class.forName("org.postgresql.Driver");
      Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
      java.sql.Statement st = conexion.createStatement();
      String pk="";
      String sql="select z.id from zona z where z.nombre='"+tipo+"' and z.fk_planta='"+this.BuscaPlantaID(muni)+"'" ;
      ResultSet result = st.executeQuery(sql);
      result = st.executeQuery(sql);
          
      while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
          return Integer.parseInt(pk);
        }
        else {
            if (pk =="")
                encontre =0;
        }
       st.close();
       conexion.close();
       return Integer.parseInt(result.getString(1));
    }catch(Exception e){
         System.err.println("error de zona");
         return 0;
    }
}

public void insertarUbicacionPrueba(int id,String fecha,String fecha2,String muni){
    try{
       
      Class.forName("org.postgresql.Driver");
      Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
      java.sql.Statement st = conexion.createStatement();
      
      String tipo="Zona de pruebas de material";
      int zona=this.buscarZonaID(muni,tipo);
      String sql="INSERT INTO ubicacion_actual(fecha_i,fecha_f,fk_material_pedido,fk_zona) values('"+fecha+"','"+fecha2+"','"+id+"','"+zona+"')";
      int result = st.executeUpdate(sql);   
       st.close();
       conexion.close();
    }catch(Exception e){
         System.err.println("error");
    }
}
public String obternetUbicacionPedido(int id){
    try{
      int encontre=0;
      Connection conexion = DriverManager.getConnection(url,usuario,contraseña);    
      java.sql.Statement st = conexion.createStatement();
      String pk="";
      String sql="select l.nombre from prueba p,material_pedido mp,pedido_proveedor pp,planta pl,lugar l"
              + " where p.id='"+id+"' and p.fk_material_pedido=mp.id and mp.fk_pedido_proveedor=pp.id and pp.fk_planta=pl.id and pl.fk_lugar=l.id" ;
      ResultSet result = st.executeQuery(sql);        
      while (result.next()){
               pk = result.getString(1);
          }
        if (pk != ""){
            encontre =1;
          return pk;
        }
        else {
            if (pk =="")
                encontre =0;
        }
       st.close();
       conexion.close();
       return pk;
    }catch(SQLException sqle){
            while(sqle!=null){
             System.err.println("mensaje: "+sqle.getMessage());
             System.err.println("sqlstate: "+ sqle.getSQLState());
             System.err.println("codigo de error" + sqle.getErrorCode());
             sqle=sqle.getNextException();
             }
         System.err.println("error3");
         return "";
    }
}
public int devolverMaterialPedido(int id){
    try{
       int encontre = 0;        
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
    java.sql.Statement st = conexion.createStatement();
    String idp = "";
        
    String sql="select m.id from material_pedido m,prueba p where p.id='"+id+"' and p.fk_material_pedido=m.id" ;

        ResultSet result = st.executeQuery(sql);
          while (result.next()){
               idp = result.getString(1);
          }
        if (idp != ""){
            encontre =1;
     
          return Integer.parseInt(idp);
        }
        else {
            if (idp =="")
                encontre =0;
        }

        st.close();
        conexion.close();
        return encontre;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
}
public int actualizarEstatusMaterial(int id,String estatus){
    try{
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
        java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int result = st.executeUpdate("update prueba set fk_estatus=(select id from estatus where nombre ='"+estatus+"') where id='"+id+"'");
        
        st.close();
        return 1;
    }catch(Exception e){
         System.err.println("error");
         return 0;
    }
}
public void llenarEstatusBox(JComboBox combo){
    try{
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
        java.sql.Statement  st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = st.executeQuery("select nombre from estatus");
        combo.removeAllItems();
        combo.addItem("Seleccione un estatus");
        while(result.next()){
            combo.addItem(result.getString(1));
        }
        combo.addItem("Todos");
        st.close();
    }catch(Exception e){
         System.err.println("error");
        
    }
}


/////////////////////////////////fin de los algoritmos de fabiana //////////////////////////////////


}


