package main;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;

    Cazador(Integer punteria, Integer fuerza, Double peso, Escoba escoba){
        super(peso, escoba);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Double habilidad(){
        return super.habilidad()+(this.punteria*this.fuerza);
    }
}
