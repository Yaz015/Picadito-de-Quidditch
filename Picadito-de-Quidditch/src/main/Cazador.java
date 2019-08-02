package main;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;

    public Cazador(Integer punteria, Integer fuerza, Double peso, Escoba escoba, Double skill){
        super(peso, escoba, skill);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Double habilidad(){
        return super.habilidad()+(this.punteria*this.fuerza);
    }
}
