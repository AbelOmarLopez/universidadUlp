/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JOptionPane;

/**
 *
 * @author aolopez
 */
public class UniversidadUlp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        try {            
           //driver de coneccion
           Class.forName("org.mariadb.jdbc.Driver");
           
           //establecemos la coneccion
            Connection conn =DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp","root","");
            
            //Sentencia SQL
            String sql= "select * from inscripcion where nota>= 8";
           
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery(); //para busqueda usar un resulset
            
            while (rs.next()) {
                System.out.println("id de inscripcion"+rs.getInt("idInscripto"));
                System.out.println("NOTA"+rs.getInt("nota"));
                System.out.println("ID del Alumno"+rs.getInt("idAlumno"));
                System.out.println("id de la materia"+rs.getInt("idMateria"));
            System.out.println("---------------------------------------");
                
            }
      
                        
            
            
        } catch (ClassNotFoundException ex) {
            
            JOptionPane.showInternalMessageDialog(null,"conectar los Drivers de coneccion");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error en la coneccion" );
        }
       
        
        
    }
    
}
