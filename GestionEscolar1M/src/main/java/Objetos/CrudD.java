/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Miguel Angel Vides Deras
 */
//Hereda la clase Docente
public class CrudD extends Docente{
    ConexionSql con =new ConexionSql();
    
    //metodo para insertar datos
    public void insertar(int dui, String nombre, String apellido,int edad, String asignatura, String sexo)
    {
        setDui(dui);
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setAsignatura(asignatura);
        setSexo(sexo);
        
        try
        {
            Connection conexion = con.conectar();
            java.sql.Statement at= conexion.createStatement();
            String sql="insert into docentes(dui, nombre, apellido, edad, asignatura, sexo) values('"+this.getDui()+"','"+getNombre()+"','"+this.getApellido()+"','"+this.getEdad()+"','"+this.getAsignatura()+"','"+this.getSexo()+"');";
            at.execute(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodo para mostrar todos los datos en la tabla Docente
    public void mostrar(javax.swing.JTable tabla)
    {
        try
        {
        Connection conexion = con.conectar();
        String sql="select * from docentes";
        java.sql.Statement at= conexion.createStatement();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("dui");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("asignatura");
        model.addColumn("sexo");
        tabla.setModel(model);
        //variable polimorfica nueva
        Object info [] = new Object[6];
        ResultSet rs = at.executeQuery(sql);
        while(rs.next())
        {
            info[0]=(Integer)rs.getInt(1);
            info[1]=(String) rs.getString(2);
            info[2]=(String)rs.getString(3);
            info[3]=(String)rs.getString(4);
            info[4]=(String) rs.getString(5);
            info[5]=(String) rs.getString(6);
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
    //metodo para mostrar un solo registro dato a dato
    public void mostrar(int dui)
    {
        this.setDui(dui);
        try
        {
        Connection conexion = con.conectar();
        java.sql.Statement at= conexion.createStatement();
        String sql ="select * from docentes where dui='"+this.getDui()+"';";
        ResultSet rs = at.executeQuery(sql);
        if(rs.next())
        {
            this.setDui(rs.getInt("dui"));
            this.setNombre(rs.getString("nombre"));
            this.setApellido(rs.getString("apellido"));
            this.setEdad(rs.getInt("edad"));
            this.setAsignatura(rs.getString("asignatura"));
            this.setSexo(rs.getString("sexo"));
        }else
        {
            this.setDui(0);
            this.setNombre("");
            this.setApellido("");
            this.setEdad(0);
            this.setAsignatura("");
            this.setSexo(rs.getString(""));
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
    //metodo para actualizar datos de un registro
    public void editar(int dui, String nombre, String apellido,int edad, String asignatura, String sexo)
    {
        setDui(dui);
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setAsignatura(asignatura);
        setSexo(sexo);
        try
        {
            Connection conexion = con.conectar();
            java.sql.Statement at= conexion.createStatement();
            String sql="update docentes set nombre='"+getNombre()+"',apellido='"+this.getApellido()+"',edad='"+this.getEdad()+"',asignatura='"+this.getAsignatura()+"',sexo='"+this.getSexo()+"' where dui='"+this.getDui()+"';";
            at.execute(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            at.close();
            conexion.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la información \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void eliminar(int dui)
    {
        setDui(dui);
        try
        {
        Connection conexion = con.conectar();
        java.sql.Statement at= conexion.createStatement();
        String sql="delete from docentes where dui='"+this.getDui()+"';";
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
