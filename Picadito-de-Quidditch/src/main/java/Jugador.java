package main.java;

import java.util.Calendar;
import java.util.List;

public abstract class Jugador {
    protected Double peso;
    protected Escoba escobaDelJugador;
    public Double skill;
    protected MercadoDeEscobas mercadoDeEscobas;
    protected Equipo equipo;
    //public abstract Jugador puedeBloquear(Jugador jugador);

    Jugador(Double peso, Escoba escobaDelJugador, Equipo equipo) {
        this.peso = peso;
        this.escobaDelJugador = escobaDelJugador;
        this.skill = 200.0;
        this.equipo = equipo;
    }

    public Escoba escobaDelJugador() {
        return escobaDelJugador;
    }

    public Double nivelManejoDeEscoba() {
        return (this.skill / this.peso);
    }

    //public Double velocidadDelJugador;
    public Double velocidadDelJugador() {
        return this.velocidadDeEscoba() * this.nivelManejoDeEscoba();
    }

    public Double velocidadDeEscoba() {
        return escobaDelJugador.velocidadDeLaEscoba();
    }

    public Double habilidad() {
        return this.skill + this.velocidadDelJugador();
    }

    /**
     * Si un jugador le pasa el trapo a otro; esto sucede si es por lo menos el doble de
     * habilidoso que el otro jugador.
     **/

    public Boolean lePasaElTrapo(Jugador jugador) {
        return jugador.habilidad() * 2.0 < this.habilidad();
    }

    /**
     * Si un jugador es groso, que se cumple si su habilidad es mayor al promedio de su
     * equipo y su velocidad mayor a un valor arbitrario que a medida que el mercado de
     * escobas mejora se actualiza para todos por igual.
     **/

    public MercadoDeEscobas getMercadoDeEscobas() {
        return mercadoDeEscobas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Integer añoActual() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    //intento de es groso
    public Boolean esGroso() {
        return this.habilidad()> (this.getEquipo().promedioDeHabilidades())
                && (this.velocidadDelJugador())>this.getMercadoDeEscobas().actualizarMercadoDeEscobas(); }

    /**
     * Saber si un jugador puede bloquear el tiro de un cazador. Esto se cumple para los
     * golpeadores si son grosos, para los guardianes si sacan 3 en un random de 1 a 3, y para
     * los cazadores si le pasan el trapo al cazador que tiró. Los buscadores no bloquean.
     **/
    public abstract  Boolean puedeBloquear(Jugador jugador);

    public void jugadorQueBloquea(Jugador jugador){if(
            this.puedeBloquear(jugador).equals(true)){
        this.skill=this.skill+10;
    }}
    private Pelota pelota;
    public void agarraPelota(Pelota pelota){this.pelota=pelota;}

    public Boolean sosCazador(){
        return this.sosCazador();
    }


}