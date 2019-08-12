
package main.java;

import main.java.exceptions.NoHayJugadoresEnEquipoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    public List<Jugador> jugadores = new ArrayList<>();
    public Jugador jugador;
    public Pelota pelota;


    /**
     * Si un equipo tiene un jugador estrella para jugar contra otro equipo. Un jugador es
     * estrella si le pasa el trapo a todos los jugadores del equipo contrario.
     **/

    public Boolean tieneJugadorEstrellaContra(Equipo equipo) {
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    public Jugador mejorJugador() {
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador -> jugador.habilidad())).get();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregarJugadores(List<Jugador> jugadores) {
        jugadores.add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo() {
        if (jugadores.isEmpty()) {
            throw new NoHayJugadoresEnEquipoException("No hay jugadores");
        }
        return jugadores.size();
    }

    public Double promedioDeHabilidades() {
        return (double) (this.sumaDeHabilidadesDeJugadores() / this.cantDeJugadoresEnEquipo());
    }

    public Double sumaDeHabilidadesDeJugadores() {
        return this.jugadores.stream()
                .map(j -> j.habilidad()).reduce(0.0, Double::sum);
    }

    public Jugador jugadorRandom() {
        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }

    /**
     * El cazador cuando juega, si tiene la quaffle debe intentar meter gol, que implica:
     * ● Evitar bloqueos: cada uno de los jugadores contrarios intenta bloquear el tiro del cazador, y en
     * caso de poder bloquearlo (ver 4.a) se interrumpe el tiro. Lógicamente en cuanto uno bloquea,
     * los jugadores restantes no deben seguir bloqueando.
     * ● El equipo gana 10 puntos por meter gol.
     * ● El cazador gana 5 puntos de skills
     * Si el tiro se interrumpe por un bloqueo, el cazador pierde 2 puntos de skills y el que bloqueó gana 10.
     * Independientemente de si pudo meter gol o si fue bloqueado, el cazador pierde la quaffle.
     * Siempre que un cazador pierde la quaffle, ésta es atrapada por el cazador rival más rápido.
     *
     * @return
     **/
    public Equipo equipo;
    public Double puntosEquipo = 100.0;
    public List<Cazador> cazadores;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Boolean turnoJugador() {
        return this.getEquipo().jugadorRandom().equals(this);
    }

    public List<Jugador> listaDeCazadores() {
        return jugadores.stream()
                .filter(j -> j.sosCazador()).collect(Collectors.toList());
    }

    public Jugador jugadorCazadorRapidoDelEquipo() {
        return jugadores.stream()
                .max(Comparator.comparing(j -> j.velocidadDelJugador())).get();
    }

    public Boolean puedenBloquear(Jugador jugador) {
        return jugadores.stream()
                        .anyMatch(j -> j.puedeBloquear(jugador));
    }
    public void jugadorQueBloquea(Jugador jugador) {
        this.jugadorCazadorRapidoDelEquipo().skill =
                this.jugadorCazadorRapidoDelEquipo().skill + 10;
    }

    public Boolean tenesQuaffle() { return this.randomPelota()==1;
    }

    /*public Boolean caraCruz;
    public Boolean caraCruz() {
        boolean caraCruz;
        if (Math.random() < 0.5) {
            caraCruz = true;
        } else {
            caraCruz = false;
        }
        return caraCruz;
    }*/ //metodo que no se usa

    public Integer randomPelota() {
        List<Integer> rango = IntStream.range(1, 2).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    public void setPelota(Pelota pelota) {
        this.pelota = pelota;
    }
    public Pelota getPelota() {
        return pelota;
    }
    public void turnoBuscador(Buscador buscador) {
        if (buscador.buscandoSnitch() && buscador.persigueSnitch()) {
            buscador.skill = buscador.skill + 10;
            this.puntosEquipo = this.puntosEquipo + 150.0;
        }
    }
}

    //public void turnoGolpeador(Golpeador golpeador;)
