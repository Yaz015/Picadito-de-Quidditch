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
    private Boolean reinicioLaBusqueda=false;

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

    public void persiguiendoLaSnitch() {
        this.setKilometros(this.getKilometros() + velocidadDelJugador() / 1.6);
        if (this.getKilometros() >= 5000.0) {
                this.atrapaSnitch();
        }
    }

    public void buscandoLaSnitch() {
        if (this.randonNumeroSnitch() < this.habilidad() + this.getTurnosBuscando()) {
                this.persiguiendoLaSnitch();
                this.setEncontroSnitch(true);
        }
    }

    public void juega(){
        if(this.esGroso() && this.reinicioLaBusqueda){
            this.reinicioLaBusqueda=false;
            System.out.println("El  buscador está aturdido este turno no hace nada");///dejame commitear
        }
        if(this.getEncontroSnitch() ==false) {
            this.buscandoLaSnitch();
            this.setTurnosBuscando(this.getTurnosBuscando() + 1);}
        else if(this.getEncontroSnitch() ==true){
            this.buscandoLaSnitch();
        }
    }

    public Boolean esBlancoUtil(){
        return !this.getEncontroSnitch() || this.getKilometros() <1000;
        //buscador si está buscando la snitch o le faltan menos de 1000 kilómetros
    }

    public void  atrapaSnitch(){
        this.skill= this.skill+10;
        this.equipo.buscadorAtrapaSnitch();
   }

   public Integer randonNumeroSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public void reinicaBusqueda(){
        this.kilometros=0.0;
        this.turnosBuscando=0;
        this.reinicioLaBusqueda=true;
    }

    public void golpeadoPorBludger(){
        super.golpeadoPorBludger();
        this.reinicaBusqueda();
    }

    ///// Metodos Sos /////
    public Boolean sosCazador(){ return false; }
    public Boolean sosGuardian(){return false;}
    public Boolean sosBuscador(){return true;}
    public Boolean sosGolpeador(){return false;}
    ///// //// /// ///

    /// get y set ////
    public Double getKilometros() { return kilometros; }
    public void setKilometros(Double kilometros) { this.kilometros = kilometros; }
    public Boolean getEncontroSnitch() { return encontroSnitch; }
    public void setEncontroSnitch(Boolean encontroSnitch) { this.encontroSnitch = encontroSnitch; }
    public Integer getTurnosBuscando() { return turnosBuscando; }
    public void setTurnosBuscando(Integer turnosBuscando) { this.turnosBuscando = turnosBuscando; }
    public Integer getNivelDeReflejos() { return null; }
    ///// //// //// ////
}
