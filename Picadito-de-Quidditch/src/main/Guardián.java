package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


    public Integer randomDeBloqueo(){
        List<Integer> rango = IntStream.range(1,4).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    // ver si hacer stactic el random

    public Boolean puedeBloquear(Cazador uncazador){
        return this.randomDeBloqueo().equals(3);


    }
}





