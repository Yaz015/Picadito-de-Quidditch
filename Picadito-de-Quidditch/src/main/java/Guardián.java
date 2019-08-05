package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;
    private Integer randomNumber = 3;


    public Guardián(Integer skill, Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo) {
        super(peso, escoba, skill, equipo);
        this.nivelDeReflejos = nivelDeReflejos;
        this.fuerza = fuerza;
    }

    public Integer habilidad() {
        return super.habilidad() + this.nivelDeReflejos + this.fuerza;
    }

    public Boolean puedeBloquear(Jugador jugador) {
     return 3 = getRandomNumber();
    }

    public Integer getRandomNumber(){
        Random ran=new Random();
     return this.randomNumber=  (int)(ran.nextDouble()*3)+1;
    }


}

