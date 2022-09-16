

package Objetos;

/**
 *
 * @author Gilberto Alexander Ventura Hernandez
 */
//clase actualizada como abstracta ya que no se inicializo
public abstract class Estudiante implements Comparador {
    // atributos
    private static int nie;
    private static String nombre;
    private static String apellido;
    private static int edad;
    private static String sexo;
    private static String grado;
    private static String zona;
    
    
    // metodo modificador el NIE(Numero de Identifiacion Estudiantil)
    public void setNIE(int _nie)
    {
        this.nie = _nie;
    }
    public int getNIE()
    {
        return this.nie;
    }
    
     //metodo modificador el nombre
    public void setNombre(String _nombre)
    {
        this.nombre=_nombre;       
    }
    public String getNombre()
    {
        return this.nombre;
    }
    
    //metodo modificador el apellido
    public void setApellido(String _apellido)
    {
        this.apellido=_apellido;       
    }
    public String getApellido()
    {
        return this.apellido;
    }
    
    // metodo modificador la edad    
    public void setEdad(int _edad)
    {
        this.edad = _edad;
    }
    public int getEdad()
    {
        return this.edad;
    }
    
    // metodo modificador del sexo (M=masculino y F=femenino)
    public void setSexo(String _sexo)
    {
        this.sexo = _sexo;
    }
    public String getSexo()
    {
        return this.sexo;
    }
    
    // metodo modificador el grado academico
    public void setGrado(String _grado)
    {
        this.grado = _grado;
    }
    public String getGrado()
    {
        return this.grado;
    }    
    
     // metodo modificador la zona de residencia(R=rural y U=urbana)
    public void setZona(String _zona)
    {
        this.zona = _zona;
    }
    public String getZona()
    {
        return this.zona;
        
    }
    
    
    
    //metodos para busqueda y ordenamiento en arreglos
    @Override
    public String toString()
    {
       return this.edad+"";
    }

    @Override
    public boolean igualQue(Object r) {
        Estudiante estud = (Estudiante)r;
        return this.getEdad()==estud.getEdad();
    }

    @Override
    public boolean menorQue(Object r) {
         Estudiante estud = (Estudiante)r;
        return this.getEdad()<estud.getEdad();
    }

    @Override
    public boolean menorIgual(Object r) {
         Estudiante estud = (Estudiante)r;
        return this.getEdad()<=estud.getEdad();
    }

    @Override
    public boolean mayorQue(Object r) {
         Estudiante estud = (Estudiante)r;
        return this.getEdad()>estud.getEdad();
    }

    @Override
    public boolean mayorIgual(Object r) {
         Estudiante estud = (Estudiante)r;
        return this.getEdad()>=estud.getEdad();
    }
}
