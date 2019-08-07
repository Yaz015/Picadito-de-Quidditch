package main;

import java.util.Calendar;
import java.util.List;

public abstract class Jugador {
    private Integer peso;
    private Escoba escobaDelJugador;
    private Integer skill=100;
    private MercadoDeEscobas mercadoDeEscobas;
    private Equipo equipo;

    private List<Jugador> jugadores;

    public Jugador(Integer peso, Escoba escobaDelJugador,Equipo equipo){
        this.setPeso(peso);
        this.setEscobaDelJugador(escobaDelJugador);
        this.setSkill(100);
        this.setEquipo(equipo);
    }

    public Escoba escobaDelJugador() {
        return this.getEscobaDelJugador();
    }

    public Integer nivelManejoDeEscoba() {
        return (this.getSkill() / this.getPeso());
    }

    public Integer velocidadDelJugador() {
        return this.velocidadDeEscoba() * this.nivelManejoDeEscoba();
    }

    public Integer velocidadDeEscoba() {
        return this.getEscobaDelJugador().velocidadEscoba();
    }
    
    public Integer habilidad(){return velocidadDelJugador()+ getSkill();}
    /** Si un jugador le pasa el trapo a otro; esto sucede si es por lo menos el doble de
     habilidoso que el otro jugador.**/

    public Boolean lePasaElTrapo(Jugador jugador) { 
        return jugador.habilidad()<this.habilidad()/2;}

    /**Si un jugador es groso, que se cumple si su habilidad es mayor al promedio de su
     equipo y su velocidad mayor a un valor arbitrario que a medida que el mercado de
     escobas mejora se actualiza para todos por igual.**/


   // public Boolean esGroso() {
       // return this.habilidad()> this.getEquipo().promedioDeHabilidades()
               // && this.velocidadDelJugador()> this.getMercadoDeEscobas().getNumeroAleatorio();
   // }
    public Integer añoActual(){
        return Calendar.getInstance().get(Calendar.YEAR);}

       //intento de es groso
    public Boolean esGroso() {
        return this.habilidad()> (this.getEquipo().promedioDeHabilidades())
                && (this.velocidadDelJugador())>this.getMercadoDeEscobas().actualizarMercadoDeEscobas(); }


      public Integer getPeso() {
        return peso;
    }


    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Escoba getEscobaDelJugador() {
        return escobaDelJugador;
    }

    public void setEscobaDelJugador(Escoba escobaDelJugador) {
        this.escobaDelJugador = escobaDelJugador;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public MercadoDeEscobas getMercadoDeEscobas() {
        return mercadoDeEscobas;
    }

    public void setMercadoDeEscobas(MercadoDeEscobas mercadoDeEscobas) {
        this.mercadoDeEscobas = mercadoDeEscobas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public Boolean turnoJugador(){
        return this.getEquipo().jugadorRandom().equals(this);
    }
}



