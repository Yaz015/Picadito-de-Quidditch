package main.java;


import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    private List<Cazador>cazadores;

    public Cazador(Integer punteria, Integer fuerza, Double peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;}

    public Double habilidad(){
        return (this.punteria*this.fuerza)+super.skill+ this.velocidadDelJugador(); }

    public Double velocidadDelJugador(){
        return super.velocidadDeEscoba()*super.nivelManejoDeEscoba();}

        public Pelota pelota;

    public Boolean puedeBloquear(Jugador jugador) {return this.lePasaElTrapo(jugador);}

    public Pelota quaffle;
    public void meteGol() {
        this.skill = this.skill + 5.0;
        this.equipo.puntosEquipo = equipo.puntosEquipo + 10.0;}

    public void noMeteGol() {
        this.skill = this.skill - 2.0;
    }

    public void jugaContra(Equipo equipoContrario){
        this.getPelota();
        if(this.equipo.tenesQuaffle().equals(true) && !equipoContrario.puedenBloquear(this)){
            this.meteGol();
            equipoContrario.getPelota();
        } else
            this.noMeteGol();
        equipoContrario.getPelota();
        equipoContrario.jugadorQueBloquea(this);} }


    /*public Boolean blancoUtil(){
        return  this.tenesPelota();
    }
    public Boolean haceGol() {
        if (!puedeBloquear(this)) {
            return true;}
        else return false;}*/


