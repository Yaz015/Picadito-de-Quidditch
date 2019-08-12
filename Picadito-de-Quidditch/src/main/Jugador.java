package main;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    public Integer skill=100;
    protected MercadoDeEscobas mercadoDeEscobas;
   protected Equipo equipo;
    protected Integer turno=0;

    protected List<Jugador> jugadores;

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
    
    public Integer habilidad()
    {return velocidadDelJugador()+ getSkill();}


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



    public Boolean turnoJugador(){
        return this.getEquipo().jugadorRandom().equals(this);
    }

    public Boolean puedeBloquear(Jugador jugador){
        return   this.puedeBloquear(jugador);
    }
     public void esGolpeadoPorBludger(Jugador unJugador){
        this.skill=-2 ;
        this.getEscobaDelJugador().escobaGolpeada();
     }


    public Jugador jugadorCazadorRapidoDelEquipo(){
        return jugadores.stream()
                .max(Comparator.comparing(j->j.velocidadDelJugador())).get();
    }
    public Boolean sosCazador(){
        return this.sosCazador();

    }
    public abstract Boolean esBlancoUtil();

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

    public Integer getPeso() {
        return peso;
    }


    public void setPeso(Integer peso) {
        this.peso = peso;
    }


    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }


    /*public void turnoCazador(Cazador cazador){
        if (
            cazador.tenesPelota()&& !cazador.esBloqueado()&& this.turnoJugador(); {
        cazador.skill=cazador.skill+5.0;
        this.puntosEquipo=this.puntosEquipo+10.0;
        cazador.tenesPelota().equals(false);}
    else if (cazador.esBloqueado().equals(true)) {
        cazador.skill = cazador.skill - 2;
        jugador.jugadorQueBloquea(cazador);
        cazador.tenesPelota().equals(false);
        cazador.cazadorMasRapido().agarraPelota(pelota); //falta hacer q el jugador mas rapido la agarre// }*/

}



