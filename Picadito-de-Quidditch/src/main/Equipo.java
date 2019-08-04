package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {

        public List<Jugador> jugadores = new ArrayList<>();

        public void agregarJugador(Jugador jugador) {
            jugadores.add(jugador);
        }

        public Integer cantDeJugadoresEnEquipo() {
            return jugadores.size();
        }

        public Integer promedioDeHabilidades() {
            return this.sumaDeHabilidadesDeJugadores() / this.cantDeJugadoresEnEquipo();
        }

        public Integer sumaDeHabilidadesDeJugadores() {
            return this.jugadores.stream()
                    .map(j -> j.habilidad()).reduce(0, Integer::sum);

        }
    public Jugador getRandomElement(List<Jugador> jugadores)
    {
        Random rand = new Random();
                          return jugadores.get(rand.nextInt(jugadores.size()));
    }

    //Los intervalos de números (rangos) son colecciones que pueden crearse como:
       // List<Integer> rango = IntStream.range(1,getRandomElement()).boxed().collect(Collectors.toList());



        }
