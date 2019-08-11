package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Equipo {

    protected Integer puntos=0;

    public Quaffle quaffle;

    private List<Jugador> jugadores = new ArrayList<>();

    public void agregarJugador(Jugador jugador) {
        getJugadores().add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo() {
        return getJugadores().size();
    }

    public Integer promedioDeHabilidades() {
        return this.sumaDeHabilidadesDeJugadores() / this.cantDeJugadoresEnEquipo();
    }

    public Integer sumaDeHabilidadesDeJugadores() {
        return this.getJugadores().stream()
                .map(j -> j.habilidad()).reduce(0, Integer::sum);

    }

    public Jugador jugadorRandom() {
        Random rand = new Random();
        return this.getJugadores().get(rand.nextInt(getJugadores().size()));
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }


    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public Boolean puedeBloquear(Jugador jugador){
        return   this.puedeBloquear(jugador);
    }
    public List<Jugador> listaDeCazadores(){
        return jugadores.stream()
                .filter(j->j.sosCazador()).collect(Collectors.toList());
    }

    public Boolean puedenBloquear(Jugador jugador){
        return jugadores.stream()
                .anyMatch(j -> j.puedeBloquear(jugador));
    }

    public Boolean seEvitaElBloqueo(Jugador jugador){
        return this.puedenBloquear(jugador);
    }

    public Boolean tieneJugadorEstrella(Equipo equipo){
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    public Jugador mejorJugador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }

    public Integer randomPelota(){
        List<Integer> rango = IntStream.range(1,3).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    public void setPelota(Quaffle laquaffle) {
        this.quaffle=laquaffle ;
    }
    public Boolean tenesQuaffle(){
        return this.randomPelota().equals(1);

    }
    public void buscadorAtrapoSnith(){
        this.puntos=+150;    }

    public void cazadorHaceGol(){
        this.puntos=+10;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}

