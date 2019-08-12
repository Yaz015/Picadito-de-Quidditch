package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    protected Integer puntos=0;
    public Pelota quaffle;

  public List<Jugador> jugadores = new ArrayList<>();

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo() {
        return jugadores.size();
    }

    public Double promedioDeHabilidades() {
        return this.sumaDeHabilidadesDeJugadores() / this.cantDeJugadoresEnEquipo();
    }

   public Double sumaDeHabilidadesDeJugadores() {
        return this.jugadores.stream()
                .map(j -> j.habilidad()).reduce(0.0, Double::sum);
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