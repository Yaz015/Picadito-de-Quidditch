package main;

public class Guardián extends Jugador {
    protected Integer nivelDeReflejos;
    protected Integer fuerza;

    Guardián(Integer skill, Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+this.skill+this.nivelDeReflejos+this.fuerza;
    }
}
