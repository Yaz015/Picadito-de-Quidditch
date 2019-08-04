package main;

public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;

    Buscador( Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escobaDelJugador,Equipo equipo){
        super(peso, escobaDelJugador,equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+ this.getSkill() +this.nivelDeReflejos*this.nivelDeVision;
    }
}
