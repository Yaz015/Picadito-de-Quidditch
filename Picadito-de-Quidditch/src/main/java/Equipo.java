
package main.java;

import main.java.exceptions.NoHayJugadoresEnEquipoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Equipo {
    public List<Jugador> jugadores= new ArrayList<>();
    public Jugador jugador;
    public Pelota pelota;

    /**Si un equipo tiene un jugador estrella para jugar contra otro equipo. Un jugador es
     estrella si le pasa el trapo a todos los jugadores del equipo contrario.**/

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

    public Double sumaDeHabilidadesDeJugadores(){
        return this.jugadores.stream()
                .map( j -> j.habilidad()).reduce( 0.0, Double::sum );
    }
    public Jugador jugadorRandom()
    {        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }
/** El cazador cuando juega, si tiene la quaffle debe intentar meter gol, que implica:
 ● Evitar bloqueos: cada uno de los jugadores contrarios intenta bloquear el tiro del cazador, y en
 caso de poder bloquearlo (ver 4.a) se interrumpe el tiro. Lógicamente en cuanto uno bloquea,
 los jugadores restantes no deben seguir bloqueando.
 ● El equipo gana 10 puntos por meter gol.
 ● El cazador gana 5 puntos de skills
 Si el tiro se interrumpe por un bloqueo, el cazador pierde 2 puntos de skills y el que bloqueó gana 10.
 Independientemente de si pudo meter gol o si fue bloqueado, el cazador pierde la quaffle.
 Siempre que un cazador pierde la quaffle, ésta es atrapada por el cazador rival más rápido.
 * @return**/

    public Double puntosEquipo=100.0;

    public void turnoCazador(Cazador cazador){ if (
        cazador.tenesPelota().equals(true)&& cazador.esBloqueado().equals(false)) {
        cazador.skill=cazador.skill+5.0;
        this.puntosEquipo=this.puntosEquipo+10.0;
        cazador.tenesPelota().equals(false);}
        else if (cazador.esBloqueado().equals(true)) {
        cazador.skill = cazador.skill - 2;
        jugador.jugadorQueBloquea(cazador);
        cazador.tenesPelota().equals(false);
        cazador.cazadorMasRapido().agarraPelota(pelota);//falta hacer q el jugador mas rapido la agarre// }
    }}
    public void turnoBuscador(Buscador buscador){if(
            buscador.buscandoSnitch().equals(true) && buscador.encontroSnitch.equals(true)) {
        buscador.skill = buscador.skill + 10;
        this.puntosEquipo = this.puntosEquipo + 150.0; }
    }}
    //public void turnoGolpeador(Golpeador golpeador;)
