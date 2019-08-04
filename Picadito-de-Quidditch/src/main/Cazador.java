package main;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;

    public Cazador( Integer punteria, Integer fuerza, Integer peso, Escoba escobaDelJugador,Equipo equipo){
        super(peso, escobaDelJugador,equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+ this.getSkill() +this.punteria*fuerza;
    }
}
