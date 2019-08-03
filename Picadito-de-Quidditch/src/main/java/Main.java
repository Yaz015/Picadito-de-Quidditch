package main.java;

public class Main {
    public static void main(String[] args){

        SaetaDeFuego saeta = new SaetaDeFuego();
        Equipo griffindor = new Equipo();

        Cazador cazador1 = new Cazador(63, 34, 54, 80, saeta, griffindor);
        Buscador buscador = new Buscador(30, 32, 49, 75, saeta, griffindor);

        griffindor.agregarJugador(cazador1);
        griffindor.agregarJugador(buscador);
        System.out.println(griffindor.cantDeJugadoresEnEquipo()+ "cant de jugadores en equipo");
        System.out.println(griffindor.promedioDeHabilidades()+" promedio de jugadores en equipo");


        System.out.println(buscador.nivelManejoDeEscoba()+" nivel de manejo de escoba");
        System.out.println(buscador.velocidadDelJugador()+" velocidad del jugador");
        System.out.println(cazador1.skill);
        System.out.println(cazador1.nivelManejoDeEscoba());
    }
}
