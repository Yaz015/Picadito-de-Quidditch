package main;

import java.util.List;

public abstract class Jugador {
    protected Double peso;
    protected Escoba escobaDelJugador;
    protected Double skill=100.0;
    protected MercadoDeEscobas mercadoDeEscobas;
    protected Equipo equipo;
    public List<Jugador> jugadores;
    Jugador(Double peso, Escoba escobaDelJugador){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
    }

    public Escoba escobaDelJugador() {
        return this.escobaDelJugador;
    }

    public Double nivelManejoDeEscoba() {
        return (this.skill / this.peso);
    }

    public Double velocidadDelJugador() {
        return velocidadEscoba() * nivelManejoDeEscoba();
    }

    public Double velocidadEscoba() {
        return escobaDelJugador.velocidadDeEscoba();
    }

    public Double habilidad(){return velocidadDelJugador()+ skill;}
   /** Si un jugador le pasa el trapo a otro; esto sucede si es por lo menos el doble de
    habilidoso que el otro jugador.**/

    public Boolean lePasaElTrapo(Jugador jugador){return jugador.habilidad()*2.0<=this.habilidad();}

    /**Si un jugador es groso, que se cumple si su habilidad es mayor al promedio de su
    equipo y su velocidad mayor a un valor arbitrario que a medida que el mercado de
    escobas mejora se actualiza para todos por igual.**/


    public Boolean esGroso() {
        return this.habilidad()>this.equipo.promedioDeHabilidades()
                && this.velocidadDelJugador()> this.mercadoDeEscobas.getNumeroAleatorio();
    }}



