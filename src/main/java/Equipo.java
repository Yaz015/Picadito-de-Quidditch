import exceptions.ElJuegoHaTerminadoException;
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
    protected Integer puntos=0;
    private List<Integer> rango = IntStream.range(1, jugadores.size()).boxed().collect(Collectors.toList());
    private Pelota quaffle;
    protected Equipo equipoContrario;

    public void getJugadorDelTurno(){
        this.jugadores.get(getRandomElement(this.rango));
    }

    public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();                //preguntar
        return list.get(rand.nextInt(list.size()));
    }

    public Boolean puedenBloquear(Jugador jugador){
        return this.jugadores.stream()
                .anyMatch(j -> j.puedeBloquear(jugador));
    }

    public List<Jugador> jugadoresQueBloquean(Jugador jugador){
       return this.getEquipoContrario().jugadores.stream().
                filter(j->j.puedeBloquear(jugador)).collect(Collectors.toList());
    }

    public Jugador primerJugadorQueBloquea(Jugador jugador){
        return this.jugadoresQueBloquean(jugador).get(0);
    }

    public Boolean intentanBloquear(Jugador jugador){
        return this.puedenBloquear(jugador);
    }

    public Boolean equipoContrarioEvitaBloqueo(Jugador jugador){
        return this.getEquipoContrario().intentanBloquear(jugador);
    }

    public Boolean tieneJugadorEstrella(Equipo equipo){
        return this.mejorJugador().lePasaElTrapo(equipo.mejorJugador());
    }

    public Jugador mejorJugador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
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

    public Jugador jugadorCazadorMasRapidoDelEquipo(){
        return jugadores.stream()
                .max(Comparator.comparing(j->j.velocidadDelJugador())).get();
    }

    public List<Jugador> listaDeCazadores(){
        return jugadores.stream()
                .filter(j->j.sosCazador()).collect(Collectors.toList());
    }

    public Jugador cazadorMasRapido(){
        return this.listaDeCazadores().stream()
                .max(Comparator.comparing(jugador->jugador.habilidad())).get();
    }

    public Jugador jugadorRandom()
    {        Random rand = new Random();
        return this.jugadores.get(rand.nextInt(jugadores.size()));
    }

    public Boolean tenesQuaffle(){
        return this.randomPelota().equals(1); //hicimos este
    }

    public Integer randomPelota(){
        List<Integer> rango = IntStream.range(1,2).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public List<Jugador> listadeBlancosUtiles(){
        return this.jugadores.stream()
                .filter(j->j.esBlancoUtil()).collect(Collectors.toList());
    }

    public Jugador getRandomBlancoUtil(){
        Random rand = new Random();
        return this.listadeBlancosUtiles().get(rand.nextInt(this.listadeBlancosUtiles().size()));
    }

    public Jugador getRandomBlancoUtilEquipoContrario(){
        return this.getEquipoContrario().getRandomBlancoUtil();
    }

    public void buscadorAtrapaSnitch() throws ElJuegoHaTerminadoException {
        this.setPuntos(this.getPuntos() +150);
        throw new ElJuegoHaTerminadoException("El buscador ha atrapado la Snitch, el juego ha terminado");
    }

    public void setPelota(Pelota quaffle) {
        this.quaffle=quaffle ;
    }

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

    public Jugador jugadorCazadorMasRapidoEquipoContrario(){
       return this.getEquipoContrario().jugadorCazadorMasRapidoDelEquipo();
    }

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
}
