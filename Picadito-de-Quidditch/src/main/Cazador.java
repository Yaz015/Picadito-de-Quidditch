package main;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;

    Cazador(Integer skill, Integer punteria, Integer fuerza, Integer peso, Escoba escoba){
        super(peso, escoba, skill);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+this.skill+this.punteria*fuerza;
    }
}
