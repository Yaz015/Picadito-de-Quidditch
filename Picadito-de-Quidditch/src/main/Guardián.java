package main;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;

    public Guardián(Integer nivelDeReflejos, Integer fuerza, Double peso, Escoba escoba, Double skill){
        super(peso, escoba,skill );
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }

    public Double habilidad(){
        return super.habilidad()+this.nivelDeReflejos+this.fuerza;
    }
}
