package main;

public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;

    Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Double peso, Escoba escoba, Double skill){
        super(peso, escoba, skill);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }

    public Double habilidad(){
        return super.habilidad()+this.nivelDeReflejos*this.nivelDeVision;
    }
}
