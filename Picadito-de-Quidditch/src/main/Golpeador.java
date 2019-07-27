package main;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    Golpeador(Integer fuerza, Integer punteria, Integer peso, Escoba escoba){
        super(peso, escoba);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return super.velocidadDelJugador()+this.skill+this.punteria+this.fuerza;
    }
}
