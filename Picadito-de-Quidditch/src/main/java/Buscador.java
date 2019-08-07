
public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;
    private Double kilometros;
    private Boolean encontroSnitch=false;

    public Buscador(Integer skill, Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba,skill, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }

    public Integer habilidad(){
        return super.habilidad()+this.nivelDeReflejos*this.nivelDeVision;
    }

    public Boolean puedeBloquear(){
        return false;
    }

    public Boolean sosCazador(){
        return false;
    }

    public void tuTurnoBuscador() {
            this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;
        if (this.kilometros == 5000.0) {
            this.encontroSnitch = true;
        }
    }
}
