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

    public Integer habilidad(){
        return super.habilidad()+ this.getNivelDeReflejos() *this.nivelDeVision;
    }

    public Boolean puedeBloquear(Jugador jugador) {
        return false;
    }

    ///Metodos Sos
    public Boolean sosCazador(){ return false; }
    public Boolean sosBuscador(){ return true; }
    public Boolean sosGuardian(){return false;}
    public Boolean sosGolpeador(){ return false; }
    ///

    public void persiguiendoLaSnitch() throws ElJuegoHaTerminadoException {
        this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;
        if (this.kilometros >= 5000.0) {
                this.atrapaSnitch();
        }
    }

    public void buscandoLaSnitch() {
        if (this.randomSnitch() < this.habilidad() + this.getTurnosBuscando()) {
                this.encontroSnitch = true;
        }
    }

    public void juega() throws ElJuegoHaTerminadoException {
        if(this.estaAturdido){
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

    public Boolean esBlancoUtil(){
        return !this.encontroSnitch || this.kilometros<1000;
        //buscador si está buscando la snitch o le faltan menos de 1000 kilómetros
    }

   public void  atrapaSnitch() throws ElJuegoHaTerminadoException {
        this.skill= this.skill+10;
        this.equipo.buscadorAtrapaSnitch();
        //termina el partido y suma 150 puntos para su equipo
    }

   public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public void reiniciaLaBusqueda(){
        this.turnosBuscando=0;
        this.kilometros=0.0;
    }

    public void golpeadoPorBludger(){
        if(!this.esGroso()){
            super.golpeadoPorBludger();
            this.reiniciaLaBusqueda();
        }else if(this.esGroso()){this.estaAturdido=true;}
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


}
