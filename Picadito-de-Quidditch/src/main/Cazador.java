package main;

import main.jugador.exception.SinHabilidadException;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;

    Cazador(Integer skill, Integer punteria, Integer fuerza, Integer peso, Escoba escoba){
        super(peso, escoba, skill);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        if(skill==0)
            throw new SinHabilidadException("No existe");
        return this.velocidadDelJugador()+this.skill+this.punteria*fuerza;
    }
}
