package main;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;

    Cazador(Integer punteria, Integer fuerza, Integer peso, Escoba escoba){
        super(peso, escoba);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+this.skill+this.punteria*fuerza;
    }
}
