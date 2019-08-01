package main;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    Golpeador(Integer fuerza, Integer punteria, Double peso, Escoba escoba){
        super(peso, escoba);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Double habilidad(){
        return super.habilidad()+this.punteria+this.fuerza;
    }
}
