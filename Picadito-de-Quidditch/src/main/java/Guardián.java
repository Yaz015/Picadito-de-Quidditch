package main.java;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;

    public Guardián(Integer skill, Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }

    public Integer habilidad(){
        return super.habilidad()+this.nivelDeReflejos+this.fuerza;
    }
}
