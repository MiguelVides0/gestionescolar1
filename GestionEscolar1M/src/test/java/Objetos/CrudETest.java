/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Objetos;

import javax.swing.JTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gilberto Alexander Ventura Hernández
 */
public class CrudETest {
    
    public CrudETest() {
    }
    
    @BeforeAll
    public static void setUpClass () {  }


    @Test
    public void testInsertar() {
        System.out.println("insertar");
        int Nie = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String sexo = "";
        String grado = "";
        String zona = "";
        CrudE instance = new CrudE();
        instance.insertar(Nie, nombre, apellido, edad, sexo, grado, zona);
    }


    @Test
    public void testMostrar_JTable() {
        System.out.println("mostrar");
        JTable tabla = null;
        CrudE instance = new CrudE();
        instance.mostrar(tabla);
    }


    @Test
    public void testEditar() {
        System.out.println("editar");
        int Nie = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String sexo = "";
        String grado = "";
        String zona = "";
        CrudE instance = new CrudE();
        instance.editar(Nie, nombre, apellido, edad, sexo, grado, zona);
    }
   
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int nie = 0;
        CrudE instance = new CrudE();
        instance.eliminar(nie);
    }
    
}
