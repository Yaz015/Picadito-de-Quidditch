package main.java;

import main.java.Equipo;
import main.java.Escoba;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    public Golpeador(Integer fuerza, Integer punteria, Double peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Double habilidad(){
        return super.skill+ this.velocidadDelJugador()+this.punteria+this.fuerza;
    }
    public Double velocidadDelJugador(){ return super.velocidadDeEscoba()*super.nivelManejoDeEscoba();}

    public Boolean puedeBloquear(Jugador jugador) {return this.esGroso().equals(true);}}
