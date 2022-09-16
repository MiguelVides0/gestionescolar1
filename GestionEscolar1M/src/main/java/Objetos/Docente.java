

package Objetos;

/**
 *
 * @author Miguel Vides
 */
//Clase actualizada como abstracta (no se inicializa)
public abstract class Docente implements Comparador {
    private int dui;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String asignatura;
    
    //modificador del Dui
    public void setDui(int _dui){
        this.dui=_dui;
    }
    
    public int getDui(){
        return this.dui;
    }
    
    //modificador del nombre
    public void setNombre(String _nombre){
        this.nombre=_nombre;
    }
    public String getNombre(){
       return this.nombre; 
    }
    
    //modificador del apellido
     public void setApellido(String _apellido){
        this.apellido=_apellido;
    }
    public String getApellido(){
       return this.apellido; 
    }
    
    //modificador de la edad
    public void setEdad(int _edad){
        this.edad=_edad;
    }
    public int getEdad(){
        return this.edad;
    }
    
    //modificador de sexo 
    public void setSexo(String _sexo){
        this.sexo=_sexo;
    }
    public String getSexo(){
    return this.sexo;
    }
    
    //modificador de asignatura
    public void setAsignatura(String _asignatura){
     this.asignatura=_asignatura;
    }
    public String getAsignatura(){
        return this.asignatura;
    }
    
   
    
    //metodos que funcionan para busqueda y ordenamiento en arreglos
    @Override
    public String toString()
    {
    return this.edad+"";
    }

    @Override
    public boolean igualQue(Object r) {
        Docente doc = (Docente)r;
        return this.getEdad()==doc.getEdad();
    }

    @Override
    public boolean menorQue(Object r) {
        Docente doc = (Docente)r;
        return this.getEdad()<doc.getEdad();
    }

    @Override
    public boolean menorIgual(Object r) {
       Docente doc = (Docente)r;
        return this.getEdad()<=doc.getEdad();
    }

    @Override
    public boolean mayorQue(Object r) {
      Docente doc = (Docente)r;
        return this.getEdad()>doc.getEdad();
    }

    @Override
    public boolean mayorIgual(Object r) {
        Docente doc = (Docente)r;
        return this.getEdad()>=doc.getEdad();
    }

   
    
}