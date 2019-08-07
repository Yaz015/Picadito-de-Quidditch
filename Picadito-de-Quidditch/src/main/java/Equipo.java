import main.java.exceptions.NoHayJugadoresEnEquipoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    private List<Jugador> jugadores= new ArrayList<>();
    private Integer skill;
    List<Integer> rango = IntStream.range(1, jugadores.size()).boxed().collect(Collectors.toList());

    public void getJugadorDelTurno(){
        this.jugadores.get(getRandomElement(this.rango));
    }

    public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();                    //preguntar
        return list.get(rand.nextInt(list.size()));
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

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public Integer cantDeJugadoresEnEquipo(){
        if(jugadores.isEmpty()) {
            throw new NoHayJugadoresEnEquipoException("No hay jugadores en el Equipo");
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

    public void cazadorMeteGol(Cazador cazador){
        cazador.skill=cazador.skill+5;
        this.skill= skill+10;
    }

    public Jugador jugadorCazadorRapidoDelEquipo(){
        return jugadores.stream()
                .max(Comparator.comparing(j->j.velocidadDelJugador())).get();
    }

    public List<Jugador> listaDeCazadores(){
        return jugadores.stream()
                .filter(j->j.getClass().equals());
    }

    public Jugador jugadorRandom()
    {        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }
}
