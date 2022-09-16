
package Objetos;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author migue
 */
public class ConexionSql {
    Connection conn = null;
    String url="jdbc:postgresql://localhost:5432/gestionEscolar";
    String usuario="adminEscuela";
    String clave="#20Ab50";
    
    public Connection conectar()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url, usuario, clave);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al conectar en la base"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
