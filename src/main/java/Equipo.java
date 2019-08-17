import exceptions.NoHayJugadoresEnEquipoException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    private List<Jugador> jugadores= new ArrayList<>();
    public Integer puntosEquipo=0;
    private List<Integer> rango = IntStream.range(1, jugadores.size()).boxed().collect(Collectors.toList());
    private Pelota quaffle;
    public Equipo equipoContrario;
    public Jugador jugador;

    public void getJugadorDelTurno(){
        this.jugadores.get(getRandomElement(this.rango));
    }
    public void setPelota(Pelota quaffle) {
        this.quaffle = quaffle;
    }
    public Pelota getPelota() {
        return quaffle;
    }

    public int getRandomElement(List<Integer> list)
    { Random rand = new Random();                //preguntar
        return list.get(rand.nextInt(list.size())); }
    /** Si los jugadores del equipo, hay uno que pueda bloquear al jugador contrario**/
    public Boolean puedenBloquear(Jugador jugador){
        return this.jugadores.stream()
                .anyMatch(j -> j.puedeBloquear(jugador));
    }
    /** SI el equipo tiene jugador estrella, le pasa el trapo a al mejor jugador del otro equipo**/
    public Boolean tieneJugadorEstrella(Equipo equipo){
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }
    /** El mejor jugador es el de mayor habilidad de un equipo**/
    public Jugador mejorJugador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }
    /** Agrega los jugadores al equipo**/
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
    /** Excepcion si el quipo no tiene jugadores**/
    public Integer cantDeJugadoresEnEquipo(){
        if(jugadores.isEmpty()) {
            throw new NoHayJugadoresEnEquipoException("No hay jugadores en el Equipo");
        }
        return jugadores.size();
    }
    /** suma habilidades y saca promedio**/
    public Double promedioDeHabilidades(){
        return (double)(this.sumaDeHabilidadesDeJugadores()/this.cantDeJugadoresEnEquipo());
    }
    public Integer sumaDeHabilidadesDeJugadores(){
        return this.jugadores.stream()
                .map( j -> j.habilidad()).reduce( 0, Integer::sum );
    }
    /** Listado de cazadores, por eso el metodo abstracto sos cazador en Jugador**/
    public List<Jugador> listaDeCazadores(){
        return jugadores.stream()
                .filter(j->j.sosCazador())
                .collect(Collectors.toList());
    }
    /** Comparar de la lista de jugadores, al mas rapido**/
    public Jugador jugadorCazadorRapidoDelEquipo(){
        return this.listaDeCazadores().stream()
                .max(Comparator.comparing(j->j.velocidadDelJugador())).get();
    }

    public Jugador jugadorRandom()
    {        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }

    //hacer que salga sorteado que tiene la pelota
    public Boolean tenesQuaffle(){
        return true; //this.randomPelota().equals(1);
    }

    public Integer randomPelota(){
        List<Integer> rango = IntStream.range(1,2).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    /** Listado de blanco utiles, para metodo en golpeador**/
    public List<Jugador> listadeBlancosUtiles(){
        return this.jugadores.stream()
                .filter(j->j.esBlancoUtil()).collect(Collectors.toList());
    }
    public Jugador getRandomBlancoUtil(){
        Random rand = new Random();
        return this.listadeBlancosUtiles().get(rand.nextInt(this.listadeBlancosUtiles().size()));
    }
    public Jugador blancoUtilDelRandom(){ return this.getRandomBlancoUtil();}

    public Jugador getRandomBlancoUtilEquipoContrario(){
        return equipoContrario.getRandomBlancoUtil();
    }
    /** Jugador que bloquea, es el cazador mas rapid, gana 10 de skill**/
    public void jugadorQueBloquea(Jugador jugador) {
        this.jugadorCazadorRapidoDelEquipo().skill =
                this.jugadorCazadorRapidoDelEquipo().skill + 10;
    }
}

