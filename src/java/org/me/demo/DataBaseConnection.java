package org.me.demo;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class DataBaseConnection {
 
    private Connection conexion;
    private Statement statemen;
    private final String base ="SOA";
    private final String usuario="root";
    private final String password="xxpesar";
    String Estado = "Exitoso";
    

    
    public DataBaseConnection(){
    
        
        try {
            
            Class.forName("org.gjt.mm.mysql.Driver"); //Colocamos e Driver
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+base, usuario, password);//Crea la conexion ala base de datos
            statemen = (Statement) conexion.createStatement(); //se crea al Statement
           System.out.println("Conexion "+Estado);
           
        } catch (ClassNotFoundException ex) {//En caso que no se encuentre la base de datos , se manejara una execepcion
            Estado = "Error de Driver";
            System.out.println("Conexion "+Estado);//Un mensaje del tipo de error
        }catch (SQLException ex) {
            Estado = "Error de Base de datos";
            System.out.println("Conexion "+Estado);//Un mensaje del tipo de error
        }
    }
    
       public ResultSet searchUser(String name){
        try{
            ResultSet result = this.statemen.executeQuery("SELECT * FROM usuarios WHERE nombre='"+name+"'");
            if(!result.next()){
                    System.out.println("No hay resultados que coincidan con la búsqueda.");
                    return null;
                }
                return result;
         
        }catch(SQLException ex){
            return null;
        }
     
     }
 
        public boolean actualizarProyecto(String proyect,String lenguaje,int integrantes,String descripcion) {
            try{
            this.statemen.executeUpdate("UPDATE proyecto SET integrantes='"+integrantes+"',lenguaje='"+lenguaje+"',descripcion='"+descripcion+"' WHERE nombre='"+proyect+"'"); //Ejecuta el comando de actualización SQL
            }catch(SQLException ex){
                System.out.println("Error "+ex.getMessage());
                return false;
            }
            //Mensaje exitoso

            return true;
        }
       
       //******************************************
       //Metodo que regresa un boolean para saber si se ejecuto de manera correcta y tiene comp parametro el nombre del royecto
        public boolean borrar(String nombre) {
            try{
              this.statemen.execute("DELETE FROM proyecto WHERE nombre='"+nombre+"'"); //metodo execute de statement con sentencia SQL
             }catch(SQLException ex){
                 //se maneja el excepcion con mensaje
                System.out.println("Mensaje de error: " + ex.getMessage());
                return false;
            }
            return true;
        }
      
   
        
     }
     

