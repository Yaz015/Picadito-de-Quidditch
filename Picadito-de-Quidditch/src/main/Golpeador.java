package main;

import java.util.Random;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    Golpeador( Integer fuerza, Integer punteria, Integer peso, Escoba escobaDelJugador,Equipo equipo){
        super(peso,escobaDelJugador,equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return super.velocidadDelJugador()+ this.getSkill() +this.punteria+this.fuerza;
    }
    public Boolean puedeBloquear(Cazador uncazador){
        return this.esGroso();

    }

    public Jugador elegirBlancoUtil() {
        Random rand = new Random();
        return this.getJugadores().get(rand.nextInt(getJugadores().size()));
    }

    public void juega(){}

    //hago el metodo en todas las subclases o la meto en Jugador y fue?

    public Boolean turnoGolpeador(){
        return this.getEquipo().jugadorRandom().equals(this);
    }

    public Boolean golpeadorBlancoUtil(){
        return  false;
    }
}
