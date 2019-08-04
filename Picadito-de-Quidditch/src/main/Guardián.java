package main;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;

    public Guardián( Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escobaDelJugador, Equipo equipo){
        super( peso,escobaDelJugador, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+ this.getSkill() +this.nivelDeReflejos+this.fuerza;
    }
}
