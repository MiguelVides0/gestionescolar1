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
 * @author migue
 */
public class CrudDTest {
    
    public CrudDTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        int dui = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String asignatura = "";
        String sexo = "";
        CrudD instance = new CrudD();
        instance.insertar(dui, nombre, apellido, edad, asignatura, sexo);
    }
   
    @Test
    public void testMostrar_int() {
        System.out.println("mostrar");
        int dui = 0;
        CrudD instance = new CrudD();
        instance.mostrar(dui);
    }

    @Test
    public void testEditar() {
        System.out.println("editar");
        int dui = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String asignatura = "";
        String sexo = "";
        CrudD instance = new CrudD();
        instance.editar(dui, nombre, apellido, edad, asignatura, sexo);
    }

    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int dui = 0;
        CrudD instance = new CrudD();
        instance.eliminar(dui);
    }
    
}
