
package Objetos;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.ResultSet;
/**
 *
 * @author Gilberto Alexander Ventura Hernandez
 */
public class CrudE extends Estudiante {
    //incializamos la clase conxion sql
    ConexionSql con =new ConexionSql();
    
    //metodo para insertar los archivos
    public void insertar(int Nie, String nombre, String apellido, int edad, String sexo, String grado, String zona)
    {
        setNIE(Nie);
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setSexo(sexo);
        setGrado(grado);
        setZona(zona);
        try
        {
            Connection conexion = con.conectar();
            java.sql.Statement at= conexion.createStatement();
            String sql="insert into estudiantes(nie, nombre, apellido, edad, sexo, grado, zona) values('"+this.getNIE()+"','"+getNombre()+"','"+this.getApellido()+"','"+this.getEdad()+"','"+this.getSexo()+"','"+this.getGrado()+"','"+this.getZona()+"');";
            at.execute(sql);
            at.close();
            conexion.close();
            String mensajeBueno="El registro se guardo correctamente";
            JOptionPane.showMessageDialog(null, mensajeBueno ,"Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "El registro no se guardo correctamente \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Metodo para mostrar los elementos de la base de datos en la tabla estudiante
    public void mostrar(javax.swing.JTable tabla)
    {
        try
        {
        Connection conexion = con.conectar();
        String sql="select * from estudiantes";
        java.sql.Statement at= conexion.createStatement();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("nie");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("sexo");
        model.addColumn("grado");
        model.addColumn("zona");
        tabla.setModel(model);
        //varibale polimorfica nueva
        Object info [] = new Object[7];
        ResultSet rs = at.executeQuery(sql);
        while(rs.next())
        {
            info[0]= (Integer)rs.getInt(1);
            info[1]= (String)rs.getString(2);
            info[2]= (String)rs.getString(3);
            info[3]= (String)rs.getString(4);
            info[4]= (String)rs.getString(5);
            info[5]= (String)rs.getString(6);
            info[6]= (String)rs.getString(7);
            model.addRow(info);
        }
        at.close();
        conexion.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar la información \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodo para editar un registro en la tabla estudiantes
    public void editar(int Nie, String nombre, String apellido, int edad, String sexo, String grado, String zona)
    {
        setNIE(Nie);
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setSexo(sexo);
        setGrado(grado);
        setZona(zona);
        try
        {
        Connection conexion = con.conectar();
        java.sql.Statement at= conexion.createStatement();
        String sql= "update estudiantes set nombre='"+this.getNombre()+"',apellido='"+this.getApellido()+"',edad='"+this.getEdad()+"',sexo='"+this.getSexo()+"',grado='"+this.getGrado()+"',zona='"+this.getZona()+"' where nie='"+this.getNIE()+"';";
        at.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        at.close();
        conexion.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "El registro no se actualizo correctamente \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodo para mostrar un registro de la tabla estudiantes dato a dato
    public void mostrar(int nie)
    {
        this.setNIE(nie);
        try
        {
        Connection conexion = con.conectar();
        java.sql.Statement at= conexion.createStatement();
        String sql ="select * from estudiantes where nie='"+this.getNIE()+"';";
        ResultSet rs = at.executeQuery(sql);
        if(rs.next())
        {
            this.setNIE(rs.getInt("nie"));
            this.setNombre(rs.getString("nombre"));
            this.setApellido(rs.getString("apellido"));
            this.setEdad(rs.getInt("edad"));
            this.setSexo(rs.getString("sexo"));
            this.setGrado(rs.getString("grado"));
            this.setZona(rs.getString("zona"));
        }else
        {
            this.setNIE(0);
            this.setNombre(" ");
            this.setApellido(" ");
            this.setEdad(0);
            this.setSexo(" ");
            this.setGrado(" ");
            this.setZona(" ");
            JOptionPane.showMessageDialog(null, "No se encontró el registro \n","Sin registro",JOptionPane.INFORMATION_MESSAGE);
        }
        at.close();
        conexion.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodo para eliminar un registro en la tabla de estudiantes
    public void eliminar(int nie)
    {
        setNIE(nie);
        try
        {
        Connection conexion = con.conectar();
        java.sql.Statement at= conexion.createStatement();
        String sql="delete from estudiantes where nie='"+this.getNIE()+"';";
        at.execute(sql);
        at.close();
        conexion.close();
        JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se pudo borrar la información \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
