package main;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;

    Guardián(Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba){
        super(peso, escoba);
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+this.skill+this.nivelDeReflejos+this.fuerza;
    }
}
