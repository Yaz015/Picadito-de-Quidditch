package main;
import exception.DemasiadosJugadoresEnEquipoException;
import exception.NoHayJugadoresEnEquipoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    public List<Jugador> jugadores = new ArrayList<>();
    protected Integer puntos=0;
    public Pelota pelota;
    public Jugador jugador;

    public Boolean tieneJugadorEstrellaContra(Equipo equipo) {
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    private Jugador mejorJugador() {
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador -> jugador.habilidad())).get();
    }

    public void agregarJugador(Jugador jugador) {
        if(cantDeJugadoresEnEquipo()>7)
            throw new DemasiadosJugadoresEnEquipoException("No se pueden sumar mas jugadores, equipo lleno");
        //excepcion de no poder agregar?. demasiados jugadores no se permiten mas
        jugadores.add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo() {
        if (jugadores.isEmpty()) {
            throw new NoHayJugadoresEnEquipoException("No hay jugadores");
        }
        return jugadores.size();
    }

    public Double promedioDeHabilidades() {
        return this.sumaDeHabilidadesDeJugadores() / this.cantDeJugadoresEnEquipo();
    }

   public Double sumaDeHabilidadesDeJugadores() {
        return this.jugadores.stream()
                .map(j -> j.habilidad()).reduce(0.0, Double::sum);
    }
    public Jugador jugadorRandom() {
        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }


    public boolean tenesQuaffle() {
        return this.randomPelota().equals(1);
    }

    private Object randomPelota() {
        List<Integer> rango = IntStream.range(1,3).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

}