import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {

    private Integer nivelDeReflejos;
    private Integer nivelDeVision;
    private Double kilometros;
    private Boolean encontroSnitch = false;
    private Integer turnosBuscando = 0;

    public Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escoba, Equipo equipo) {
        super(peso, escoba, equipo);
        this.nivelDeReflejos = nivelDeReflejos;
        this.nivelDeVision = nivelDeVision;
    }

    public Integer habilidad() {
        return (super.skill + this.velocidadDelJugador()) + this.nivelDeReflejos * this.nivelDeVision;
    }

    public Integer velocidadDelJugador() {
        return (int) (this.velocidadDeEscoba() * this.nivelManejoDeEscoba());
    }
    /** El buscador no bloquea**/
    public Boolean puedeBloquear(Jugador jugador) {
        return false;
    }
    /** No es cazador para metodo en Equipo cazador mas rápido**/
    public Boolean sosCazador() {
        return false;
    }
    public Integer nivelDeReflejos() {
        return this.nivelDeReflejos;
    }
    /** Si atraps snith**/
    public void atrapaSnitch() {
        super.skill = super.skill + 10;
        super.equipo.puntosEquipo= super.equipo.puntosEquipo +150;
    }
    /** una vez que la encuentra la persigue**/
    public void persiguiendoLaSnitch() {
        this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;
        if (this.kilometros >= 5000.0) {
            this.atrapaSnitch();
        }
    }
    /** Comienza el juego buscando snith hasta encontrarla **/
    public void buscandoLaSnitch() {
        if (this.randomSnitch() < this.habilidad() + this.getTurnosBuscando()) {
            this.persiguiendoLaSnitch();
            this.encontroSnitch = true;
        }
    }
    /** Juega contra el equipo contrario. Tiene que buscarla primero, y luego perseguirla, si la encuentra atrapa la snith**/
    public void juegaContra(Equipo equipoContrario) {
        if (this.encontroSnitch == false) {
            this.buscandoLaSnitch();
            this.setTurnosBuscando(this.getTurnosBuscando() + 1);
        } else if (this.encontroSnitch == true) {
            this.buscandoLaSnitch();
        }
    }
    /** Si busca la snith es blanco util o si sus km son menores a mil**/
    public Boolean esBlancoUtil() {
        //this.buscandoLaSnitch();
        return this.encontroSnitch == false || this.kilometros < 1000;
    }
    /** El ramdom es para el metodo buscando la snitch**/
    public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    /** turnos que le toca al buscador**/
    public Integer getTurnosBuscando() {
        return turnosBuscando;
    }
    public void setTurnosBuscando(Integer turnosBuscando) {
        this.turnosBuscando = turnosBuscando;
    }
    /** Todos los jugadores pierdes 2 de skill, y %de salud si tienen nimbus, en clase padre. El buscador tmb reinica busqueda**/
    public void golpeadoPorBludger() {
        super.golpeadoPorBludger();
            this.buscadorReiniciaBusqueda();
        }
    public void buscadorReiniciaBusqueda() {
        this.kilometros=0.0;
        this.turnosBuscando=0;
    }
    /**BONUS! Cuando un buscador groso es golpeado por una bludger, el mismo queda aturdido un
     turno y en el siguiente puede retomar su actividad tal cual estaba. Un buscador aturdido es
     blanco útil si la actividad a retomar lo llevaría a ser útil en el siguiente turno. No cambiar lo
     hecho en el punto 3 para agregar esta lógica.**/

    /** Si pierde turno no juega, lo seteo como que no encuentra la snith porque queda aturdido**/
    public Boolean noJuegaQuedaAturdido(){ return
            this.encontroSnitch==false;
    }
    /** Retoma su actividad si en el siguiente turno es blanco util**/
    public void retomaActividad() {
        if(this.randomSnitch() < this.habilidad() + this.getTurnosBuscando()){
            this.esBlancoUtil();
        }}

    /** Si es groso y es golpeado x blugger queda aturdido, y trata de retomar actividad**/
    public void  bonusBuscador(){if (this.esGroso()){
    this.golpeadoPorBludger();
    this.noJuegaQuedaAturdido();
    this.retomaActividad();}
    }// Tengo que arreglarlo

}
