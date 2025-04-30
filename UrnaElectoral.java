import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class UrnaElectoral 
{
    
    private LinkedList<Candidato> listaCandidatos;
    private Stack<Voto> historialVotos;
    private Queue<Voto> votosReportados;
    private int idCounter;

    public UrnaElectoral() {
        this.listaCandidatos = new LinkedList<>();
        this.historialVotos = new Stack<>();
        this.votosReportados = new LinkedList<>();
        this.idCounter = 1;
    }

    public void agregarCandidato(Candidato candidato){
        listaCandidatos.add(candidato);//con esto se colocan candidatos a la lista, para poder votar por ellos en el main
    }

    public boolean verificarVotante(Votante votante){
        return votante.getYaVoto();
    }

    public boolean registrarVoto(Votante votante, int candidatoId){
        if (verificarVotante(votante)) {
            System.out.println("Este votante ya voto.");
            return false;
        }
        Voto nuevovoto = new Voto(idCounter++, votante.getId(), candidatoId);

        for (int i = 0; i < listaCandidatos.size(); i++){
           Candidato candidato = listaCandidatos.get(i);
             if (candidato.getId() == candidatoId) {
                candidato.agregarVoto(nuevovoto);
                historialVotos.push(nuevovoto);
                votante.marcarVotado();
             return true;
    }
}

        System.out.println("no se encontro el id del candidato.");
        return false;
    }

    public boolean reportarVoto(Candidato candidato, int idVoto) {
        Queue<Voto> cola = new LinkedList<>();
        boolean e = false;

        for (Voto v : candidato.getVotosRecibidos()){
            if (v.getId() == idVoto) {
                votosReportados.add(v);
                e = true;
            } else {
                cola.add(v);
            }
        }

        if (e){
            candidato.getVotosRecibidos().clear();
            candidato.getVotosRecibidos().addAll(cola);
            System.out.println("Voto reportdo correctamente");
            return true;
        } else {
            System.out.println("no se encontro el voto a reportar");
            return false;
        }
    }

    public String obtenerResultados(){
        Map<String, Integer> resultados = new HashMap<>();

        for (Candidato candidato : listaCandidatos) {
            resultados.put(candidato.getNombre(), candidato.getVotosRecibidos().size());
        }

        StringBuilder s = new StringBuilder();
        for (String nombre : resultados.keySet()){
            s.append(nombre).append(": ").append(resultados.get(nombre)).append(" votos\n");
        }

        return s.toString();
    }
}
