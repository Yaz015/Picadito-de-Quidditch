package main;
import exception.NoHayJugadoresEnEquipoException;
import exception.NoSePuedeAgregarJugadoresEnEquipoExepcion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    public List<Jugador> jugadores = new ArrayList<>();
    protected Integer puntos=0;
    public Jugador jugador;

    public Boolean tieneJugadorEstrellaContra(Equipo equipo) {
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    private Jugador mejorJugador() {
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador -> jugador.habilidad())).get();
    }

    public void agregarJugador(Jugador jugador) {
        if(this.jugadores.size()==7){
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("Equipo Completo no se puede agregar mas jugadores");
        } else if (jugador.sosCazador() && this.listaDeCazadores().size() == 3) {
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("No se puede agregar más cazadores");
        } else if (jugador.sosGuardian() && this.listaDeGuardianes().size() == 1) {
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("No se puede agregar mas guardianes");
        }else if(jugador.sosBuscador() && this.listaDeBuscadores().size()==1){
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("No se puede agregar mas buscador");
        } else if(jugador.sosGolpeador() && this.listaDeGolpeadores().size()==2){
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("No se puede agregar mas golpaores");
        }
        jugadores.add(jugador);
    }

    private Collection<Object> listaDeGolpeadores() {
        return jugadores.stream()
                .filter(jugador -> jugador.sosGolpeador()).collect(Collectors.toList());
    }

    private Collection<Object> listaDeBuscadores() {
        return jugadores.stream()
                .filter(jugador -> jugador.sosBuscador()).collect(Collectors.toList());
    }

    private Collection<Object> listaDeGuardianes() {
        return jugadores.stream()
                . filter(jugador -> jugador.sosGuardian()).collect(Collectors.toList());
    }

    private Collection<Object> listaDeCazadores() {
        return jugadores.stream()
                .filter(j->j.sosCazador()).collect(Collectors.toList());
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