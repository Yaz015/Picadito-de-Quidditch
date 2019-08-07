package main.java;

import main.java.Equipo;
import main.java.Escoba;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    Golpeador(Integer fuerza, Integer punteria, Double peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Double habilidad(){
        return super.habilidad()+this.punteria+this.fuerza;
    }

    public Boolean puedeBloquear(Jugador jugador) {return this.esGroso().equals(true);}}
