public class Main {
    public static void main(String[] args) {
        UrnaElectoral urna = new UrnaElectoral();

        Candidato c1 = new Candidato(1, "Boric", "eso tilin");
        Candidato c2 = new Candidato(2, "Piñerin", "eso brad");

        urna.agregarCandidato(c1);
        urna.agregarCandidato(c2);

        Votante v1 = new Votante(101, "pepe");
        Votante v2 = new Votante(102, "sans");
        Votante v3 = new Votante(103, "josesito");

        System.out.println("< prueba dew analisis >\n");

        long start1 = System.nanoTime();
        urna.registrarVoto(v1, 1);
        long end1 = System.nanoTime();
        System.out.println("Tiempo registrarVoto (pepe → boric):" + (end1 - start1) + " ns");

        long start2 = System.nanoTime();
        urna.registrarVoto(v2, 2);
        long end2 = System.nanoTime();
        System.out.println("Tiempo registrarVoto (sans → piñerin):" + (end2 - start2) + " ns");


        long start3 = System.nanoTime();
        urna.reportarVoto(c1, 1); 
        long end3 = System.nanoTime();
        System.out.println("Tiempo reportarVoto (ID 1):" + (end3 - start3) + " ns");

        long start4 = System.nanoTime();
        String resultados = urna.obtenerResultados();
        long end4 = System.nanoTime();
        System.out.println("Tiempo obtenerResultados(): " + (end4 - start4) + " ns");

        System.out.println("\n< resultados >");
        System.out.println(resultados);

        System.out.println("\n< escala >");
        pruebaComplejidad();
    }

    public static void pruebaComplejidad() {
        UrnaElectoral urnaGrande = new UrnaElectoral();

        int numCandidatos = 1000;
        for (int i = 0; i < numCandidatos; i++) {
            urnaGrande.agregarCandidato(new Candidato(i, "candidato" + i, "partido" + i));
        }

        Votante votante = new Votante(99999, "dios");


        long start = System.nanoTime();
        urnaGrande.registrarVoto(votante, numCandidatos - 1);
        long end = System.nanoTime();

        System.out.println("Tiempo registrarVoto (escala " + numCandidatos + "): " + (end - start) + " ns");
    }
}