package main.java;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;


    public Guardián(Integer nivelDeReflejos, Integer fuerza, Double peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo );
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }
    public Double habilidad(){
        return super.skill+ this.velocidadDelJugador()*this.nivelDeReflejos+this.fuerza;
    }
    public Double velocidadDelJugador(){ return super.velocidadDeEscoba()+super.nivelManejoDeEscoba();}
    public Integer randomDeBloqueo(){
        List<Integer> rango = IntStream.range(1,4).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public Boolean puedeBloquear(Jugador jugador){return this.randomDeBloqueo()==3;}}
    //public Double velJugador(){return velocidadDelJugador();}
