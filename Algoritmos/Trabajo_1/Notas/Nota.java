public class Nota {
    int nota;
    String estudiante;

    public Nota(){
        this(0, "sin nombre");
    }

    public Nota(int nota, String estudiante){
        this.nota = nota;
        this.estudiante = estudiante;
    }
    
    //GETTERS
    public int getNota(){
        return this.nota;
    }
    public String getEstudiante(){
        return this.estudiante;
    }

    //SETTERS
    public void setNota(int nota){
        this.nota = nota;
    }
    public void setEstudiante(String estudiante){
        this.estudiante = estudiante;
    }
}
