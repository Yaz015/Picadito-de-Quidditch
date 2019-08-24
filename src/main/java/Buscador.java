import exceptions.ElJuegoHaTerminadoException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {

    private Integer nivelDeReflejos;
    private Integer nivelDeVision;
    private Double kilometros=0.0;
    private Boolean encontroSnitch=false;
    private Integer turnosBuscando=0;
    private Boolean estaAturdido=false;

    public Buscador(Integer skill, Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba,skill, equipo);
        this.setNivelDeReflejos(nivelDeReflejos);
        this.nivelDeVision=nivelDeVision;
    }
    /** Habilidad Buscador. skill+velocidadJugador + la multiplicacion del nivel de reflejos y nivel de vision**/
    public Integer habilidad(){
        return super.habilidad()+ this.getNivelDeReflejos() *this.nivelDeVision;
    }
    /** Buscador no bloquea**/
    public Boolean puedeBloquear(Jugador jugador) {
        return false;
    }

    /** Metodo sos Jugador X?**/
    public Boolean sosCazador(){ return false; }
    public Boolean sosBuscador(){ return true; }
    public Boolean sosGuardian(){return false;}
    public Boolean sosGolpeador(){ return false; }

    /** Una vez que encuentra snith, la atrapa**/
    public void persiguiendoLaSnitch() throws ElJuegoHaTerminadoException {
        this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;
        if (this.kilometros >= 5000.0) {
            this.atrapaSnitch();
        }
    }
    /** Comienza el juego buscando la snith con un numero random**/
    public void buscandoLaSnitch() {
        if (this.randomSnitch() < this.habilidad() + this.getTurnosBuscando()) {
            this.encontroSnitch = true;
        }
    }
    /** Buscador juega. Si queda aturdido, pierde un turno, si no encuentra snith sigue buscando en su prox turno. Y luego la persigue**/
    public void juega() throws ElJuegoHaTerminadoException {
        if (this.estaAturdido){
            System.out.println("Este jugador pierde su turno porque está aturdido");
            this.estaAturdido=false;
        }else if(!this.estaAturdido) {
            if (!this.encontroSnitch) {
                this.buscandoLaSnitch();
                this.setTurnosBuscando(this.getTurnosBuscando() + 1);
            } else if (this.encontroSnitch) {
                this.persiguiendoLaSnitch();
            }
        }
    }
    /** Si busca la snith o le faltan mil kilometros . ES blanco util**/
    public Boolean esBlancoUtil(){
        return !this.encontroSnitch || (this.kilometros>4000 && this.kilometros<5000);

    }
    /** Buscador atrapa snith, gana 10 de skill. Su equipo gana 150 puntos. Y da una excepcion que termina el juego**/
    public void  atrapaSnitch() throws ElJuegoHaTerminadoException {
        this.skill= this.skill+10;
        this.equipo.buscadorAtrapaSnitch();

    }
    /** El random es para metodo buscando snith**/
    public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    /** El buscador reinicia su busqueda, seteamos en cero los valores**/
    public void reiniciaLaBusqueda(){
        this.turnosBuscando=0;
        this.kilometros=0.0;
        this.encontroSnitch=false;
    }
    /** Es golpeado por bludger y todos los jugadores pierden 2 de skill y pierde porcentaje de salud si es Nimbus, seteado en clase padre. Ademas el buscador, reinicia busqueda**/
    public void golpeadoPorBludger(){
            super.golpeadoPorBludger();
            this.reiniciaLaBusqueda();
    }

    public Integer getTurnosBuscando() {
        return turnosBuscando;
    }

    public void setTurnosBuscando(Integer turnosBuscando) {
        this.turnosBuscando = turnosBuscando;
    }

    public Integer getNivelDeReflejos() {
        return nivelDeReflejos;
    }

    public void setNivelDeReflejos(Integer nivelDeReflejos) {
        this.nivelDeReflejos = nivelDeReflejos;
    }

    /** Asi quedaria con bonus...  **/
    /**  public void golpeadoPorBludger(){
           if(!this.esGroso()){
             super.golpeadoPorBludger();
               this.reiniciaLaBusqueda();
          }else if(this.esGroso()){this.estaAturdido=true;}
     }
     * public void juega() throws ElJuegoHaTerminadoException {
     *         if (this.estaAturdido){
     *             System.out.println("Este jugador pierde su turno porque está aturdido");
     *             this.estaAturdido=false;
     *         }else if(!this.estaAturdido) {
     *             if (!this.encontroSnitch) {
     *                 this.buscandoLaSnitch();
     *                 this.setTurnosBuscando(this.getTurnosBuscando() + 1);
     *             } else if (this.encontroSnitch) {
     *                 this.persiguiendoLaSnitch();
     *             }
     **/
}