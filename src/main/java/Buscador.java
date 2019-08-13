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

    public Buscador(Integer skill, Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba,skill, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }

    public Integer habilidad(){
        return super.habilidad()+this.nivelDeReflejos*this.nivelDeVision;
    }

    public Boolean puedeBloquear(Jugador jugador) {
        return false;
    }

    ///Metodos Sos
    public Boolean sosCazador(){
        return false;
    }
    public Boolean sosGuardian(){return false;}
    ///

    public void persiguiendoLaSnitch() {
        this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;
        if (this.kilometros >= 5000.0) {
                this.atrapaSnitch();
        }
    }

    public void buscandoLaSnitch() {
        if (this.randomSnitch() < this.habilidad() + this.getTurnosBuscando()) {
                this.persiguiendoLaSnitch();
                this.encontroSnitch = true;
        }
    }

    public void juega(){
        if(this.encontroSnitch==false) {
            this.buscandoLaSnitch();
            this.setTurnosBuscando(this.getTurnosBuscando() + 1);}
        else if(this.encontroSnitch==true){
            this.buscandoLaSnitch();
        }
    }

    public Boolean esBlancoUtil(){
        return this.encontroSnitch==false || this.kilometros<1000;
        //buscador si está buscando la snitch o le faltan menos de 1000 kilómetros
    }

   public void  atrapaSnitch(){
        this.skill= this.skill+10;
        this.equipo.buscadorAtrapaSnitch();
   }

   public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public Integer getTurnosBuscando() {
        return turnosBuscando;
    }

    public void setTurnosBuscando(Integer turnosBuscando) {
        this.turnosBuscando = turnosBuscando;
    }
}
