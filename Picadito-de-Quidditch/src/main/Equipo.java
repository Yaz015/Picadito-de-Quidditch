package main;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    public List<Jugador> jugadores= new ArrayList<>();

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo(){
        return jugadores.size();
    }

    public Integer promedioDeHabilidades(){
        return this.sumaDeHabilidadesDeJugadores()/this.cantDeJugadoresEnEquipo();
    }

    public Integer sumaDeHabilidadesDeJugadores(){
        return this.jugadores.stream()
                .map( j -> j.habilidad()).reduce( 0, Integer::sum );
    }
}
