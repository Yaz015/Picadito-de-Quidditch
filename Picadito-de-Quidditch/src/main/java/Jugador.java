package main.java;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    //public void setJugador(){}
    public Escoba escobaDelJugador() {
        return escobaDelJugador;
    }

    public Double nivelManejoDeEscoba() {
        return (this.skill / this.peso);
    }

    //public Double velocidadDelJugador;
    public abstract Double velocidadDelJugador(); /*{
        return this.velocidadDeEscoba() * this.nivelManejoDeEscoba();*/


    public Double velocidadDeEscoba() {
        return escobaDelJugador.velocidadDeLaEscoba();
    }

    public abstract Double habilidad();// {
        /*return this.skill + this.velocidadDelJugador()}*/ ;


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

    private Pelota pelota;

    public void setPelota(Pelota pelota) {
        this.pelota=pelota ;
    }
    public Pelota getPelota(){return pelota;}


        //this.agarraPelota(pelota).equals(false);
        //this.getEquipo().jugadorCazadorRapidoDelEquipo(equipo).agarraPelota(pelota);

        //this.agarraPelota(pelota).equals(false);
        //this.getEquipo().jugadorCazadorRapidoDelEquipo(equipo).agarraPelota(pelota);

    public Boolean sosCazador(){
        return this.sosCazador();
    }
    public String nombre;
    public void setNombre(String nombre){this.nombre= nombre;}
    public String getNombre(){ return nombre=nombre;}

}