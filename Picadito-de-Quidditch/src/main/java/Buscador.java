package main.java;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;

    public Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Double peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }
    public Double habilidad(){
        return super.skill+this.velocidadDelJugador()+this.nivelDeReflejos*this.nivelDeVision;
    }
    public Double velocidadDelJugador(){ return super.velocidadDeEscoba()*super.nivelManejoDeEscoba();}

    public Boolean puedeBloquear(Jugador jugador) {return false;}// aca va excepcion

    public Double kilometros=0.0;
    public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public Integer randomTurnos(){
        List<Integer>rango= IntStream.range(1,8).boxed().collect(Collectors.toList());
        Random rand=new Random();
        return  rango.get(rand.nextInt(rango.size()));}

    public Boolean encontroSnitch = false;
    public Boolean persigueSnitch() {
        if (this.randomTurnos() * (this.velocidadDelJugador() / 1.6) == 5000)
           return true; else return false;}

                   /*this.encontroSnitch = true;
        else return this.encontroSnitch=false;/*
        if (this.kilometros == 5000.0) { this.encontroSnitch = true;
        } else this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;}*/

    public Boolean buscandoSnitch() {
        if (this.randomSnitch() < this.habilidad() + this.randomTurnos()) //+los turnos{
            return true; else return false;
            //this.encontroSnitch = true;
    }

}
