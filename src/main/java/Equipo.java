import exceptions.NoHayJugadoresEnEquipoException;
import exceptions.NoSePuedeAgregarJugadoresEnEquipoExepcion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Equipo {
    private List<Jugador> jugadores= new ArrayList<>();
    private Integer puntos=0;
    private List<Integer> rango = IntStream.range(1, jugadores.size()).boxed().collect(Collectors.toList());
    private Pelota quaffle;
    private Equipo equipoContrario;



    public Boolean puedenBloquear(Jugador jugador){
        return this.jugadores.stream()
                .anyMatch(j -> j.puedeBloquear(jugador));
    }

    public Boolean intentanBloquear(Jugador jugador){
        return this.puedenBloquear(jugador);
    }

    public Boolean equipoContrarioEvitaBloqueo(Jugador jugador){
        return this.equipoContrario.intentanBloquear(jugador);
    }

    public Boolean tieneJugadorEstrella(Equipo equipo){
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    public Jugador mejorJugador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }

    public void agregarJugador(Jugador jugador) {
        if(jugador.sosCazador() && this.listaDeCazadores().size()==3){
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("No se puede agregar más cazadores");
        }else if(jugador.sosGuardian() && this.listaDeGuardianes().size()==1)
            throw new NoSePuedeAgregarJugadoresEnEquipoExepcion("No se puede agregar mas guardianes");
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

    public Jugador jugadorCazadorRapidoDelEquipo(){
        return jugadores.stream()
                .max(Comparator.comparing(j->j.velocidadDelJugador())).get();
    }

    public Jugador cazadorMasRapido(){
        return this.listaDeCazadores().stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }

    public Boolean tenesQuaffle(){
        return this.randomPelota().equals(1);
    }
    public void buscadorAtrapaSnitch(){
        this.puntos=this.puntos+150;
    }

    ///// randoms ////
    public Integer randomPelota(){
        List<Integer> rango = IntStream.range(1,2).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public Jugador jugadorRandom()
    {        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }


    ///// listas /////
    public List<Jugador> listadeBlancosUtiles(){
        return this.jugadores.stream()
                .filter(j->j.esBlancoUtil()).collect(Collectors.toList());
    }
    public List<Jugador> listaDeGuardianes(){
        return jugadores.stream()
                .filter(j->j.sosGuardian()).collect(Collectors.toList());
    }
    public List<Jugador> listaDeCazadores(){
        return jugadores.stream()
                .filter(j->j.sosCazador()).collect(Collectors.toList());
    }
    ///// ///// ////// ///// ///// ////

    /// get y set ///
    public void setPelota(Pelota quaffle) {
        this.quaffle=quaffle ;
    }
    public Jugador getRandomBlancoUtil(){
        Random rand = new Random();
        return this.listadeBlancosUtiles().get(rand.nextInt(this.listadeBlancosUtiles().size()));
    }

    public Jugador getRandomBlancoUtilEquipoContrario(){
        return this.equipoContrario.getRandomBlancoUtil();
    }

    public void getJugadorDelTurno(){
        this.jugadores.get(getRandomElement(this.rango));
    }

    public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();                //preguntar
        return list.get(rand.nextInt(list.size()));
    }
}
