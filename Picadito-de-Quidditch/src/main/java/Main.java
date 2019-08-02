package main.java;

public class Main {
    public static void main(String[] args){

        SaetaDeFuego saeta = new SaetaDeFuego();
        Equipo griffindor = new Equipo();

        Cazador cazador1 = new Cazador(63, 34, 54, 80, saeta, griffindor);

        Buscador buscador = new Buscador(30, 32, 49, 75, saeta, griffindor);
        griffindor.agregarJugador(cazador1);
        griffindor.agregarJugador(buscador);
        System.out.println(griffindor.cantDeJugadoresEnEquipo());
        System.out.println(griffindor.promedioDeHabilidades());


        System.out.println(buscador.nivelManejoDeEscoba()+" nivel de manejo de escoba");
        System.out.println(buscador.velocidadDelJugador()+" velocidad del jugador");
    }
}
