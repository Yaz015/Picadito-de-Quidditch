package main.java;

import main.java.exceptions.NoHayJugadoresEnEquipoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Equipo {
    public List<Jugador> jugadores= new ArrayList<>();

    public Boolean tieneJugadorEstrella(Equipo equipo){
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    public Jugador mejorJugador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo(){
        if(jugadores.isEmpty()) {
            throw new NoHayJugadoresEnEquipoException("No hay jugadores");
        }
        return jugadores.size();
    }

    public Double promedioDeHabilidades(){
        return (double)(this.sumaDeHabilidadesDeJugadores()/this.cantDeJugadoresEnEquipo());
    }

    public Integer sumaDeHabilidadesDeJugadores(){
        return this.jugadores.stream()
                .map( j -> j.habilidad()).reduce( 0, Integer::sum );
    }
}
