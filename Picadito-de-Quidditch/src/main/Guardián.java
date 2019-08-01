package main;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;

    Guardián(Integer nivelDeReflejos, Integer fuerza, Double peso, Escoba escoba){
        super(peso, escoba);
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }

    public Double habilidad(){
        return super.habilidad()+this.nivelDeReflejos+this.fuerza;
    }
}
