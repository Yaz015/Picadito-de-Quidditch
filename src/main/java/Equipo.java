import exceptions.ElJuegoHaTerminadoException;
import exceptions.NoHayJugadoresEnEquipoException;
import exceptions.NoSePuedeAgregarJugadoresEnEquipoExcepcion;
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
    private Equipo equipoContrario;

    /** get y set de puntos y equipo contrario**/
    public Integer getPuntos() {
        return puntos;
    }
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    public Equipo getEquipoContrario() {
        return equipoContrario;
    }
    public void setEquipoContrario(Equipo equipoContrario) {
        this.equipoContrario = equipoContrario;
    }
    public void getJugadorDelTurno(){
        this.jugadores.get(getRandomElement(this.rango));
    }

    public int getRandomElement(List<Integer> list)
    { Random rand = new Random();
        return list.get(rand.nextInt(list.size())); }

    /** Si hay un jugador en el equipo que pueda bloquear a un jugador contrario**/
    public Boolean puedenBloquear(Jugador jugador){
        return this.jugadores.stream()
                .anyMatch(j -> j.puedeBloquear(jugador));
    }
    /** Si hay del equipo contrario un jugador que bloquee**/
    public List<Jugador> jugadoresQueBloquean(Jugador jugador){
       return this.equipoContrario.jugadores.stream().
                filter(j->j.puedeBloquear(jugador)).collect(Collectors.toList());
    }
    /** Para que en metodo cazador juega, el primer jugador que bloquea gana 10**/
    public Jugador primerJugadorQueBloquea(Jugador jugador){
        return this.jugadoresQueBloquean(jugador).get(0);
    }

    /** Boolean si el equipo puede bloquear a un jugador**/
    public Boolean intentanBloquear(Jugador jugador){
        return this.puedenBloquear(jugador);
    }

    /** Boolean del equipo contrario que bloquea a un jugador**/
    public Boolean equipoContrarioEvitaBloqueo(Jugador jugador){
        return this.equipoContrario.intentanBloquear(jugador);
    }
    /** Si en el equipo hay jugador estrella, le pasa el trapo al mejor jugador del equipo contrario**/
    public Boolean tieneJugadorEstrella(Equipo equipo){
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }
    /**  Mejor jugador es el que tiene mas habilidad**/
    public Jugador mejorJugador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }
    /** Agrego jugadores con excepciones**/
    public void agregarJugador(Jugador jugador) {
        if(this.jugadores.size()==7){
            throw new NoSePuedeAgregarJugadoresEnEquipoExcepcion("Equipo Completo no se puede agregar mas jugadores");
        } else if (jugador.sosCazador() && this.listaDeCazadores().size() == 3) {
            throw new NoSePuedeAgregarJugadoresEnEquipoExcepcion("No se puede agregar más cazadores");
        } else if (jugador.sosGuardian() && this.listaDeGuardianes().size() == 1) {
            throw new NoSePuedeAgregarJugadoresEnEquipoExcepcion("No se puede agregar mas guardianes");
        }else if(jugador.sosBuscador() && this.listaDeBuscadores().size()==1){
            throw new NoSePuedeAgregarJugadoresEnEquipoExcepcion("No se puede agregar mas buscador");
        } else if(jugador.sosGolpeador() && this.listaDeGolpeadores().size()==2){
            throw new NoSePuedeAgregarJugadoresEnEquipoExcepcion("No se puede agregar mas golpaores");
        }
        jugadores.add(jugador);
    }
    /** Excepcion si la lista de jugadores en un equipo esta vacia**/
    public Integer cantDeJugadoresEnEquipo(){
        if(jugadores.isEmpty()) {
            throw new NoHayJugadoresEnEquipoException("No hay jugadores en el Equipo");
        }
        return jugadores.size();
    }
    /** Suma la habilidades y la divide por los jugadores del equipo**/
    public Double promedioDeHabilidades(){
        return (double)(this.sumaDeHabilidadesDeJugadores()/this.cantDeJugadoresEnEquipo());
    }
    /** SUma las habilidades de todos los jugadores**/
    public Integer sumaDeHabilidadesDeJugadores(){
        return this.jugadores.stream()
                .map( j -> j.habilidad()).reduce( 0, Integer::sum );
    }
    /** ELije el jugador cazador mas rapido del equipo, para metodo cazador juega, el mas rapido tiene la pelota**/
    public Jugador jugadorCazadorMasRapidoDelEquipo(){
        return this.listaDeCazadores().stream()
                .max(Comparator.comparing(j->j.velocidadDelJugador())).get();
    }
    public Jugador jugadorCazadorMasRapidoEquipoContrario(){
        return this.equipoContrario.jugadorCazadorMasRapidoDelEquipo();
    }
    /** Lista de cazadores, por eso el metodo sosCazador**/
    public List<Jugador> listaDeCazadores(){
        return jugadores.stream()
                .filter(j->j.sosCazador()).collect(Collectors.toList());
    }
    /** No aplicado TODAVIA. Para que jueguen y empiece un jugador random**/
    public Jugador jugadorRandom()
    {        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }

    public Boolean pierdeQuaffle(){ return false;}
    public Boolean tenesQuafflee(){ return true;}

    /** Lista de blancos utiles en el quipo**/
    public List<Jugador> listadeBlancosUtiles(){
        return this.jugadores.stream()
                .filter(j->j.esBlancoUtil()).collect(Collectors.toList());
    }
    /** Elije un random de blanco util**/
    public Jugador getRandomBlancoUtil(){
        Random rand = new Random();
        return this.listadeBlancosUtiles().get(rand.nextInt(this.listadeBlancosUtiles().size()));
    }
    public Jugador getRandomBlancoUtilEquipoContrario(){
        return this.equipoContrario.getRandomBlancoUtil();
    }
    /** Metodo para sumar 150 puntos al equipo, si su buscador encuentra snith y termina el juego con una excepcion**/
    public void buscadorAtrapaSnitch() throws ElJuegoHaTerminadoException {
        this.setPuntos(this.getPuntos() +150);
        throw new ElJuegoHaTerminadoException("El buscador ha atrapado la Snitch, el juego ha terminado");
    }
    /** Listas de Jugadores**/
    public List<Jugador> listaDeGuardianes(){
        return jugadores.stream()
                .filter(j->j.sosGuardian()).collect(Collectors.toList());
    }
    public List<Jugador> listaDeBuscadores(){
        return jugadores.stream()
                .filter(j->j.sosBuscador()).collect(Collectors.toList());
    }
    public List<Jugador> listaDeGolpeadores(){
        return jugadores.stream()
                .filter(j->j.sosGolpeador()).collect(Collectors.toList());
    }

    /** El primer jugador que bloquea, gana 10, para metodo Cazador Juega**/
    public void jugadorQueBloqueaGana10(Jugador jugador){
        this.primerJugadorQueBloquea(jugador).skill=+10;
    }

}
