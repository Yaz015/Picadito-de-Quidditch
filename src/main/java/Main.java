public class Main {
    public static void main(String[] args){

        SaetaDeFuego saeta = new SaetaDeFuego();
        Equipo griffindor = new Equipo();
        Equipo slytheren= new Equipo();

        Guardián guardián= new Guardián(100,10,80,saeta,griffindor);
        Cazador cazador1 = new Cazador(34, 54, 80, saeta, griffindor);
        Buscador buscador = new Buscador(32, 49, 75, saeta, griffindor);
        Golpeador golpeador = new Golpeador(18, 19, 70, saeta, slytheren);

        griffindor.agregarJugador(cazador1);
        griffindor.agregarJugador(buscador);
        slytheren.agregarJugador(guardián);

        System.out.println(griffindor.cantDeJugadoresEnEquipo()+ "cant de jugadores en equipo");
        System.out.println(griffindor.promedioDeHabilidades()+" promedio de jugadores en equipo");
        System.out.println(buscador.nivelManejoDeEscoba()+" nivel de manejo de escoba");
        System.out.println(buscador.velocidadDelJugador()+" velocidad del jugador");
        System.out.println(cazador1.skill);
        System.out.println(cazador1.nivelManejoDeEscoba());
        System.out.println(cazador1.lePasaElTrapo(buscador)+" le pasa el trapo");
        System.out.println(guardián.puedeBloquear(cazador1));
        System.out.println(griffindor.listaDeCazadores());
        System.out.println(griffindor.jugadorCazadorRapidoDelEquipo());
        slytheren.agregarJugador(golpeador);
        System.out.println(guardián.puedeBloquear(buscador));
        System.out.println(buscador.sosCazador());


        buscador.juegaContra(slytheren);
        buscador.buscandoLaSnitch();
        System.out.println(buscador.skill);
    }
}
