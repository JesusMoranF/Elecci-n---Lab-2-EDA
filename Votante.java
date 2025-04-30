

public class Votante 
{
    
    private int id;
    private String nombre;
    private boolean yaVoto;

    public Votante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.yaVoto = false; //btw false es que no ha votado, y el true seria que ya voto
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public boolean getYaVoto() {return yaVoto;}

    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setYaVoto(boolean yaVoto) {this.yaVoto = yaVoto;}

    public void marcarVotado() {
        this.yaVoto = true;
    }
}
