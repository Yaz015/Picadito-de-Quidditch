package main;

public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;

    Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escoba){
        super(peso, escoba);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+this.skill+this.nivelDeReflejos*this.nivelDeVision;
    }
}
